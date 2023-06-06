package miu.edu.lab.service;

import miu.edu.lab.dto.request.LoginRequest;
import miu.edu.lab.dto.request.RefreshTokenRequest;
import miu.edu.lab.dto.response.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
