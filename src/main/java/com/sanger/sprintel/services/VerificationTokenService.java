package com.sanger.sprintel.services;

import java.util.Calendar;
import java.util.Date;

import com.sanger.sprintel.dto.auth.ValidateUserDto;
import com.sanger.sprintel.error.exceptions.PasswordNotMismatch;
import com.sanger.sprintel.error.exceptions.TokenExpiredException;
import com.sanger.sprintel.error.exceptions.TokenInvalidException;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.model.VerificationToken;
import com.sanger.sprintel.repository.UserEntityRepository;
import com.sanger.sprintel.repository.VerificationTokenRepository;
import com.sanger.sprintel.services.base.BaseService;
import com.sanger.sprintel.utils.mail.EmailService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;

@Service
@RequiredArgsConstructor
public class VerificationTokenService extends BaseService<VerificationToken, Long, VerificationTokenRepository> {

    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";

    private final EmailService emailService;

    private final UserEntityRepository userEntityRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * sirve para generar el mail que se le envia al usuario para activar su cuenta
     * y ponerle una contraseña
     * 
     * @param newUser
     * @param urlRedirect
     * @return
     */
    public void sendEmailVerification(UserEntity user, String urlRedirect) {
        String token = createVerificationTokenForUser(user);
        emailService.sendMail(user.getEmail(), user.getFullName(),
                "Welcome " + user.getFullName() + " follow this link to activate your acount " + urlRedirect + token);
    }

    public String createVerificationTokenForUser(UserEntity user) {
        String token = RandomString.make(45);
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user);
        verificationToken.setToken(token);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();

        verificationToken.setExpiryDate(dt);
        this.save(verificationToken);

        return token;
    }

    public boolean validateVerificationToken(ValidateUserDto validation) {
        final VerificationToken verificationToken = this.repository.findByToken(validation.getToken());
        if (verificationToken == null) {
            throw new TokenInvalidException();
        }
        final UserEntity user = verificationToken.getUser();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            this.repository.delete(verificationToken);
            throw new TokenExpiredException();

        } else if (validation.getPassword().equals(validation.getPassword2())) {
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(validation.getPassword()));
            userEntityRepository.save(user);
            this.repository.delete(verificationToken);
            return true;
        } else {
            throw new PasswordNotMismatch();
        }

    }
}
