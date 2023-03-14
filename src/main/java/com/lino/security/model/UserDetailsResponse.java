package com.lino.security.model;

import lombok.Builder;

@Builder
public record UserDetailsResponse(
        Integer userId,
        String firstName,
        String lastName,
        String email,
        Role role
) {
}
