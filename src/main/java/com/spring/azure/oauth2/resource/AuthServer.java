package com.spring.azure.oauth2.resource;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.spring.azure.oauth2.request.AuthorizationRequest;
import com.spring.azure.oauth2.response.AuthServerResponse;
import com.spring.azure.oauth2.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthServer {

    TokenService tokenService;

    @Autowired
    public AuthServer(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/auth_server/config")
    public AuthServerResponse configurations(){
       return tokenService.getServerDetails();
    }


    @PostMapping("/access_token")
    public AuthenticationResult authorizeToken(@RequestBody @Valid AuthorizationRequest authorizationCode) throws Exception {
        return tokenService.getAccessTokenFromAuthorizationCode(authorizationCode.getCode(), authorizationCode.getRedirectUri());
    }

    @PostMapping("/refresh/access_token")
    public AuthenticationResult refreshToken(@RequestBody @Valid AuthorizationRequest authorizationCode) throws Exception {
        return tokenService.getAccessTokenFromRefreshToken(authorizationCode.getRefreshToken(), authorizationCode.getRedirectUri());
    }

}
