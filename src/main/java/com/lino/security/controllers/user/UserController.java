package com.lino.security.controllers.user;

import com.lino.security.entity.User;
import com.lino.security.model.RegistrationRequest;
import com.lino.security.model.RegistrationResponse;
import com.lino.security.model.UserDetailsResponse;
import com.lino.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService service;

    @PostMapping(path = "/register")
    public RegistrationResponse register(@RequestBody RegistrationRequest request){
        return service.addUser(request);
    }

    @GetMapping(path = "/get/{id}")
    public UserDetailsResponse getUserById(@PathVariable Integer id){
        return service.getUserById(id);
    }
}
