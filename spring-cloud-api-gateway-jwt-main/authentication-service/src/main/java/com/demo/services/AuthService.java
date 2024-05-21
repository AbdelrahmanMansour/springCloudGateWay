package com.demo.services;

import com.demo.entities.AuthRequest;
import com.demo.entities.AuthResponse;
import com.demo.entities.UserVO;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    public AuthResponse register(AuthRequest request) {
        String accessToken = jwtUtil.generate(request.getEmail(), request.getName(), "ACCESS");
        String refreshToken = jwtUtil.generate(request.getEmail(), request.getName(),"REFRESH");
        return new AuthResponse(accessToken, refreshToken);
    }

}
