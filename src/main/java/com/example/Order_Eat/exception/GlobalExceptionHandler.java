package com.example.Order_Eat.exception;


import com.example.Order_Eat.domain.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    ResponseEntity<ApiResponse> exceptionHandler(Exception exception) {
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
//        apiResponse.setMessage(exception.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
    @ExceptionHandler(AppException.class)
    ResponseEntity<ApiResponse> appExceptionHandler(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
//        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.status(errorCode.getHttpStatus()).body(apiResponse);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handleMissingParameter(MissingServletRequestParameterException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(-10);
        apiResponse.setMessage("Không có tham số " + ex.getParameterName());
        return ResponseEntity.badRequest().body(apiResponse);
    }
//    @ExceptionHandler(AuthorizationDeniedException.class)
//    public ResponseEntity handleAccessDeniedException(AuthorizationDeniedException ex) {
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(ErrorCode.UNAUTHORIZED.getCode());
//        apiResponse.setMessage(ErrorCode.UNAUTHORIZED.getMessage());
//        return ResponseEntity.status(ErrorCode.UNAUTHORIZED.getHttpStatus()).body(apiResponse);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.USERNAME_INVALID.getCode());
        apiResponse.setMessage(ErrorCode.USERNAME_INVALID.getMessage());
        String enumKey = ex.getFieldError().getDefaultMessage();
//        try {
            ErrorCode errorCode = ErrorCode.valueOf(enumKey);
            apiResponse.setCode(errorCode.getCode());
            apiResponse.setMessage(errorCode.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
//        }
//        catch (IllegalArgumentException e) {
//            enumKey = ex.getBindingResult().getFieldError().getDefaultMessage();
//        }
//        return ResponseEntity.badRequest().body(apiResponse);
    }


//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity handleIllegalArgument(IllegalArgumentException ex) {
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(-10);
//        apiResponse.setMessage(ex.getMessage());
//        return ResponseEntity.badRequest().body(apiResponse);
//    }
}
