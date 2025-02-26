package com.sethu.backend.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    @JsonView(value = {ResponseDTO.View.Public.class})
    private boolean status;
    @JsonView(value = {ResponseDTO.View.Public.class})
    private String message;
    @JsonView(value = {ResponseDTO.View.Public.class})
    private T data;
}
