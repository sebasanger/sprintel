package com.sanger.sprintel.services;

import java.util.Calendar;
import java.util.Date;

import com.sanger.sprintel.dto.auth.ResetUserPasswordDto;
import com.sanger.sprintel.error.exceptions.PasswordNotMismatch;
import com.sanger.sprintel.error.exceptions.TokenExpiredException;
import com.sanger.sprintel.error.exceptions.TokenInvalidException;
import com.sanger.sprintel.error.exceptions.UserNotFoundException;
import com.sanger.sprintel.model.PasswordResetToken;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.repository.PasswordResetTokenRepository;
import com.sanger.sprintel.repository.UserEntityRepository;
import com.sanger.sprintel.services.base.BaseService;
import com.sanger.sprintel.utils.mail.EmailService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
@RequiredArgsConstructor
public class ResetPasswordTokenService extends BaseService<PasswordResetToken, Long, PasswordResetTokenRepository> {

    private final EmailService emailService;

    private final UserEntityRepository userEntityRepository;

    private final PasswordEncoder passwordEncoder;

    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";

    /**
     * sirve para generar el mail que se le envia al usuario resetear la contraseña
     * 
     * @param email
     * @param urlRedirect
     * @return
     */
    public void sendEmailResetToken(String email, String urlRedirect) {
        UserEntity user = userEntityRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
        String token = createVerificationTokenForUser(user);
        emailService.sendMail(user.getEmail(), user.getFullName(), "Welcome " + user.getFullName()
                + " follow this link to reset your password " + urlRedirect + "?tokenuid=" + token);
    }

    public String createVerificationTokenForUser(UserEntity user) {
        String token = RandomString.make(45);
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUser(user);
        passwordResetToken.setToken(token);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();

        passwordResetToken.setExpiryDate(dt);
        this.save(passwordResetToken);

        return token;
    }

    public boolean validateVerificationToken(ResetUserPasswordDto resetPasswordTokenDto) {
        final PasswordResetToken verificationToken = this.repository.findByToken(resetPasswordTokenDto.getToken());
        if (verificationToken == null) {
            throw new TokenInvalidException();
        }
        final UserEntity user = verificationToken.getUser();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            this.repository.delete(verificationToken);
            throw new TokenExpiredException();
        } else if (resetPasswordTokenDto.getPassword().equals(resetPasswordTokenDto.getPassword2())) {
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(resetPasswordTokenDto.getPassword()));
            userEntityRepository.save(user);
            this.repository.delete(verificationToken);
            return true;
        } else {
            throw new PasswordNotMismatch();
        }

    }

}
