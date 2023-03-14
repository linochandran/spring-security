package com.lino.security.controllers.token;

import com.lino.security.model.TokenResponse;
import com.lino.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/token")
public class TokenController {

    private final AuthenticationService service;

    @GetMapping(path = "/generate")
    public TokenResponse generateToken(@RequestHeader("Authorization") String authentication){
        return service.generateToken(authentication);
    }
}
