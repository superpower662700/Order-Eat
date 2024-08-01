package com.example.Order_Eat.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(1001, "User existed", HttpStatus.INTERNAL_SERVER_ERROR),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Exception", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1002, "User Name must be least 5 characters", HttpStatus.BAD_REQUEST),
    LOGIN_USER_FAILED(1003, "Login User Failed", HttpStatus.UNAUTHORIZED),
    EMPLOYEE_NOT_EXISTED(1005, "Login User Failed", HttpStatus.NOT_FOUND),
    LOGIN_PASSWORD_FAILED(1004, "Login Password Failed", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1006, "You don't have permission", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(1007, "You are not authenticated", HttpStatus.UNAUTHORIZED),
    ;
    private int code;
    private String message;
    private HttpStatus httpStatus;

}
