package com.lino.security.service;

import com.lino.security.entity.User;
import com.lino.security.model.RegistrationRequest;
import com.lino.security.model.RegistrationResponse;
import com.lino.security.model.UserDetailsResponse;
import com.lino.security.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public RegistrationResponse addUser(RegistrationRequest request){
        User user = User.builder()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .password(encoder.encode(request.password()))
                .role(request.role())
                .build();

        user = repository.save(user);

        if(user.getUserId() > 0){
            return RegistrationResponse.builder().statusCode("60001").message("The user "+user.getFirstName()+" "+user.getLastName()+" is successfully registered").build();
        }else{
            return RegistrationResponse.builder().statusCode("50000").message("The user "+user.getFirstName()+" "+user.getLastName()+" is not registered").build();
        }
    }

    public UserDetailsResponse getUserById(Integer id){
        User user = repository.findById(id.intValue()).orElseThrow(() ->new EntityNotFoundException("User details not found"));
        return UserDetailsResponse.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
