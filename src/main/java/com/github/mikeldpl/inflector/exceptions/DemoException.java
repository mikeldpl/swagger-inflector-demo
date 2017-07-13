package com.github.mikeldpl.inflector.exceptions;

import io.swagger.inflector.models.ApiError;
import io.swagger.inflector.utils.ApiException;

public class DemoException extends ApiException {
    public DemoException(String message) {
        super(new ApiError().code(403).message(message));
    }
}
