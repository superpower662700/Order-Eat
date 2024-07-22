package com.example.Order_Eat.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // Null not display
public class ApiResponse<T> {
     int code = 1000;
     String message;
     T result;
}
