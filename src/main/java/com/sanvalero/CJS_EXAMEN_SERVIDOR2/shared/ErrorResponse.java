package com.sanvalero.CJS_EXAMEN_SERVIDOR2.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String message;
}
