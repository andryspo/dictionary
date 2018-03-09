package com.andryspo.controller.exception_handler;

import com.andryspo.domain.dto.ErrorMessageDto;
import com.andryspo.exception.InvalidPasswordException;
import com.andryspo.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessageDto handleInvalidPassword(InvalidPasswordException e) {
        return new ErrorMessageDto(e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = UserNotExistException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessageDto handleUserNotExist(UserNotExistException e) {
        return new ErrorMessageDto(e.getMessage());
    }
}
