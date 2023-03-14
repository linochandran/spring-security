package com.lino.security.service;

import com.lino.security.config.service.JwtService;
import com.lino.security.model.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public TokenResponse generateToken(String authHeader){
        String[] credentials=getCredentials(authHeader);
        String userName = credentials[0];
        String password = credentials[1];
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userName, password
                )
        );

        if(authentication.isAuthenticated()){
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return TokenResponse.builder()
                    .token(jwtService.generateToken(userDetails))
                    .build();
        }

        return null;
    }

    private String[] getCredentials(String authHeader){
        String credentials = new String(Base64.decodeBase64(authHeader.substring(6)));
        return credentials.split(":");
    }
}
