/*
package com.example.fundyassignment.jwttoken;

import com.example.fundyassignment.service.UserService;
import com.example.fundyassignment.service.UserServiceImp;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenProvider {
    @Value("$secret.key")
    private String secretKey;

    private final long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L;
    private final long REFRESH_TOKEN_VALID_TIME = 30 * 60 * 24 * 12 * 1000L;
    
    private final UserServiceImp UserServiceImp;
    
    //초기화, 인코딩방식 설정
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    
    //토큰 생성
    public String createRefreshToken(String value) {
        Claims claims = Jwts.claims();
        claims.put("value", value);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createRefreshToken(String value) {
        Claims claims = Jwts.claims();
        claims.put("value", value);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserInfoServiceResponse userInfoServiceResponse = UserServiceImp.findById(this.getUserPk(token));
        return new UserName//시발
    }

    

}

*/
