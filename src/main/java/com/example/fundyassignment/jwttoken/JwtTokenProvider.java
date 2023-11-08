package com.example.fundyassignment.jwttoken;

import com.example.fundyassignment.common.exception.GlobalExceptionHandler;
import com.example.fundyassignment.common.exception.GlobalExceptionResponse;
import com.example.fundyassignment.common.exception.NoAuthorityException;
import io.jsonwebtoken.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Setter
@Component
public class JwtTokenProvider {
    /* 서명에 사용할 secretKey 설정은 xml에서 property로 직접등록 */
    @Value(value = "${jwt.secret}")
    private String secretKey;

    /*
     * 토큰 생성 메소드 jwt에 저장할 회원정보를 파라미터로 전달
     */
    public String createToken(String email, String authority) {
        Date now = new Date(System.currentTimeMillis());
        Long expiration = 1000 * 60 * 60L;

        return Jwts.builder().setHeaderParam("typ", "JWT") // 토큰 타입 지정
                .setSubject("accessToken") // 토큰 제목
                .setIssuedAt(now) // 발급시간
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // 만료시간
                .claim("email", email)          //이메일 저장
                .claim("authority", authority)  //권한 저장
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

    /* 토큰 해석 메소드 */
    public Claims getUserInfo(String token) throws NoAuthorityException {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token);
        return claims.getBody();
    }

    /* 유효성 확인 */
    public boolean vaildToken(String token) throws NoAuthorityException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(token) //토큰 파싱
                    .getBody();
            return true;  //유효하다면 true 반환
        } catch (NoAuthorityException e) {
            try {
                throw new GlobalExceptionHandler().handleNoAuthorityException(e);
            } catch (GlobalExceptionResponse ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}