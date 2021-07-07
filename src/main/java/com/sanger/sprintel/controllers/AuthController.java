package com.sanger.sprintel.controllers;

import javax.validation.Valid;

import com.sanger.sprintel.dto.auth.AuthenticationResponse;
import com.sanger.sprintel.dto.auth.LoginRequestDto;
import com.sanger.sprintel.dto.auth.RefreshTokenRequestDto;
import com.sanger.sprintel.dto.auth.RefreshTokenResponse;
import com.sanger.sprintel.dto.auth.ValidateUserDto;
import com.sanger.sprintel.dto.auth.ValidateUserTokenDto;
import com.sanger.sprintel.dto.user.GetUsersDto;
import com.sanger.sprintel.dto.user.ResendEmailVerificationDto;
import com.sanger.sprintel.jwt.JwtProvider;
import com.sanger.sprintel.model.UserEntity;
import com.sanger.sprintel.services.AuthService;
import com.sanger.sprintel.services.RefreshTokenService;
import com.sanger.sprintel.services.VerificationTokenService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtProvider jwtProvider;
    private final com.sanger.sprintel.dto.user.UserDtoConverter converter;
    private final VerificationTokenService verificationTokenService;
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequestDto loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    public RefreshTokenResponse refreshTokens(@Valid @RequestBody RefreshTokenRequestDto refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequestDto refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public GetUsersDto me(@AuthenticationPrincipal UserEntity user) {
        return converter.convertUserEntityToGetUserDto(user);
    }

    @GetMapping("/validate-token")
    public boolean validateUserToken(@Valid ValidateUserTokenDto userToken) {
        return jwtProvider.validateToken(userToken.getToken());
    }

    @PutMapping("/validate-acount")
    public ResponseEntity<Boolean> updateUser(@Valid @RequestBody ValidateUserDto validation) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(verificationTokenService.validateVerificationToken(validation));

    }

    @PutMapping("/resend-email")
    public ResponseEntity<Void> resendVerification(
            @Valid @RequestBody ResendEmailVerificationDto resendEmailVerificationDto) {
        authService.resendEmailVerification(resendEmailVerificationDto);
        return ResponseEntity.noContent().build();
    }

}
