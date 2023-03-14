package com.lino.security.model;

import lombok.Builder;

@Builder
public record RegistrationResponse(
        String statusCode,
        String message
        ) {
}
