package com.spring.azure.oauth2.resource;

import com.spring.azure.oauth2.response.AuthServerResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserResource {

    @GetMapping("/email")
    public String email(){
        OAuth2Authentication authentication = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                (UsernamePasswordAuthenticationToken) authentication.getUserAuthentication();
        return (String)((Map) usernamePasswordAuthenticationToken.getDetails())
                .getOrDefault("userPrincipalName","Result Not Found");
    }

}
