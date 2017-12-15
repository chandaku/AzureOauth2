package com.spring.azure.oauth2.service;

import com.microsoft.aad.adal4j.AuthenticationResult;
import com.spring.azure.oauth2.response.AuthServerResponse;

public interface TokenService {

    AuthenticationResult getAccessTokenFromAuthorizationCode(String authorizationCode, String redirectUri) throws Exception;

    AuthenticationResult getAccessTokenFromRefreshToken(String refreshToken, String redirectUri);

    AuthServerResponse getServerDetails();

}
