package com.example.Order_Eat.domain.request;

import com.example.Order_Eat.common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusRequest {

    private Status status;
}