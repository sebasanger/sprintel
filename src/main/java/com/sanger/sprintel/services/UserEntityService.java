package com.sanger.sprintel.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sanger.sprintel.controllers.FilesController;
import com.sanger.sprintel.dto.auth.ChangeUserPassword;
import com.sanger.sprintel.dto.user.ChangeImageResponseDto;
import com.sanger.sprintel.dto.user.CheckEmailIsValidDto;
import com.sanger.sprintel.dto.user.CreateUserDto;
import com.sanger.sprintel.dto.user.UpdateAcountDto;
import com.sanger.sprintel.dto.user.UpdateUserDto;
import com.sanger.sprintel.dto.user.UserDtoConverter;
import com.sanger.sprintel.error.exceptions.PasswordNotMismatch;
import com.sanger.sprintel.error.exceptions.UserNotFoundException;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.UserEntityRepository;
import com.sanger.sprintel.services.base.BaseService;
import com.sanger.sprintel.utils.upload.StorageException;
import com.sanger.sprintel.utils.upload.StorageService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

	private final UserDtoConverter userDtoConverter;

	private final PasswordEncoder passwordEncoder;

	private final VerificationTokenService verificationTokenService;

	private final StorageService storageService;

	private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");

	/**
	 * Nos permite buscar un usuario por su nombre de usuario
	 * 
	 * @param username
	 * @return
	 */
	public Optional<UserEntity> findUserByUsername(String username) {
		return this.repository.findByUsername(username);
	}

	public Page<UserEntity> filterUser(String filter, Pageable pageable) {
		return this.repository.findByUsernameIgnoreCaseContainingOrFullNameIgnoreCaseContaining(filter, filter,
				pageable);
	}

	/**
	 * Nos permite crear un nuevo UserEntity con rol USER
	 * 
	 * @param newUser
	 * @return
	 */
	public UserEntity newUser(CreateUserDto newUser) {

		UserEntity userEntity = userDtoConverter.convertCreateUserDtoToUserEntity(newUser);
		UserEntity userSaved = save(userEntity);
		verificationTokenService.sendEmailVerification(userSaved, newUser.getUrlRedirect());

		return userSaved;

	}

	public UserEntity updateUser(UpdateUserDto updateUserDto) {

		try {
			UserEntity userEntity = findById(updateUserDto.getId())
					.orElseThrow(() -> new UserNotFoundException(updateUserDto.getId()));

			userEntity.setFullName(updateUserDto.getFullName());
			userEntity.setAvatar(updateUserDto.getEmail());
			userEntity.setEmail(updateUserDto.getEmail());
			userEntity.setRoles(updateUserDto.getRoles());
			return update(userEntity);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
		}

	}

	public UserEntity updateAcount(UpdateAcountDto updateAcountDto) {

		try {
			UserEntity userEntity = findById(updateAcountDto.getId()).orElseThrow(() -> new UserNotFoundException());

			userEntity.setEmail(updateAcountDto.getEmail());
			userEntity.setUsername(updateAcountDto.getEmail());
			userEntity.setAvatar(updateAcountDto.getAvatar());
			return update(userEntity);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}

	}

	public UserEntity updatePassword(ChangeUserPassword user) throws UserNotFoundException {
		UserEntity userEntity = findById(user.getId()).orElseThrow(() -> new UserNotFoundException(user.getId()));

		if (!passwordEncoder.matches(user.getOldPassword(), userEntity.getPassword())) {
			throw new PasswordNotMismatch(true);
		} else if (!user.getPassword().equals(user.getPassword2())) {
			throw new PasswordNotMismatch();
		} else {
			userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
			return update(userEntity);
		}

	}

	public boolean changeUserStatus(Long id) throws UserNotFoundException {
		UserEntity userEntity = findById(id).orElseThrow(() -> new UserNotFoundException(id));

		userEntity.setEnabled(!userEntity.isEnabled());
		this.repository.save(userEntity);

		return userEntity.isEnabled();
	}

	public ChangeImageResponseDto uploadAvatarAndDeleteOld(MultipartFile file, Long id) {
		System.out.println(file.getContentType());
		if (file.isEmpty()) {
			throw new StorageException("Image not found");
		}
		String fileContentType = file.getContentType();
		if (!contentTypes.contains(fileContentType)) {
			throw new StorageException("Image type error");
		}

		String urlImage = null;

		String image = storageService.store(file);
		urlImage = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "serveFile", image, null).build()
				.toUriString();

		UserEntity user = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException());

		deleteUserAvatarIfExist(user);

		user.setAvatar(urlImage);

		this.save(user);

		return new ChangeImageResponseDto(user.getId(), urlImage);

	}

	public void deleteUserAvatarIfExist(UserEntity user) {
		if (user.getAvatar() != null) {
			try {
				storageService.delete(user.getAvatar());
			} catch (Exception e) {

			}

		}
	}

	public boolean checkEmailIsValid(CheckEmailIsValidDto checkEmailIsValidDto) {
		return this.repository.findByEmailAndIdNot(checkEmailIsValidDto.getEmail(), checkEmailIsValidDto.getId())
				.isPresent();

	}

}
