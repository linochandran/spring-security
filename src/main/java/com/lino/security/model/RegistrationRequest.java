package com.lino.security.model;

import java.util.List;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        Role role
) {
}
