/*
package jwttoken;

import com.example.fundyassignment.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Base64;

@RequiredArgsConstructor
public class TokenProvider{
    private final UserRepository userRepository;

    static Long EXPIRE_TIME = 60L * 60L * 1000L;

    @Value("${jwt.secret}")
    private String secretKey;

    private Algorithm getSign(){
        return Algorithm.HMAC512(secretKey);
    }
    //객체 초기화, secretKey를 Base64로 인코딩한다.
    @PostConstruct
    protected void init() {
        this.secretKey = Base64.getEncoder().encodeToString(this.secretKey.getBytes());
    }


    // Jwt 토큰 생성
    public String generateJwtToken(Long id, String email, String username){

        Date tokenExpiration = new Date(System.currentTimeMillis() + (EXPIRE_TIME));


        String jwtToken = JWT.create()
                .withSubject(email) //토큰 이름
                .withExpiresAt(tokenExpiration)
                .withClaim("id", id)
                .withClaim("email", email)
                .withClaim("username", username)
                .sign(this.getSign());

        return jwtToken;
    }
}
*/