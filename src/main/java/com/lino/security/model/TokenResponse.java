package com.lino.security.model;

import lombok.Builder;

@Builder
public record TokenResponse(String token) {
}
