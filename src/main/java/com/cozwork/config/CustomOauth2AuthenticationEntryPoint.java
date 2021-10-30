package com.cozwork.config;

import com.cozwork.application.exceptions.ExceptionCode;
import com.cozwork.application.exceptions.UnauthorizedException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

public class CustomOauth2AuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public ResponseEntity enhanceResponse(ResponseEntity response, Exception exception) {
        if (exception instanceof BadCredentialsException) {
            UnauthorizedException unauthorizedException = new UnauthorizedException(ExceptionCode.INVALID_PASSWORD);
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(unauthorizedException.bodyBuild());
        }
        if (exception instanceof InternalAuthenticationServiceException) {
            InternalAuthenticationServiceException exception1 = (InternalAuthenticationServiceException) exception;
            UnauthorizedException unauthorizedException = (UnauthorizedException) exception1.getCause();
            return ResponseEntity.status(response.getStatusCode())
                    .body(unauthorizedException.bodyBuild());
        }
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}