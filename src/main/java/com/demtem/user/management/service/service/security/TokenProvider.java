package com.demtem.user.management.service.service.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * CREATED BY Demilade.Oladugba ON 25/12/2019
 */
@Service
@Slf4j
public class TokenProvider {

    private final String tokenSecret;
    private final long timeExpirationMsec;

    public TokenProvider(@Value("${app.auth.tokenSecret}") String tokenSecret, @Value("${app.auth.tokenExpirationMsec}")long timeExpirationMsec) {
        this.tokenSecret = tokenSecret;
        this.timeExpirationMsec = timeExpirationMsec;
    }

    public String createToken(Authentication authentication){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + timeExpirationMsec);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try {
            Jwts
                    .parser()
                    .setSigningKey(tokenSecret)
                    .parseClaimsJws(authToken);
            return true;
        }catch (SignatureException ex){
            log.error("Invalid JWT signature");
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT token");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            log.error("JWT claims string is empty");
        }catch (Exception ex){
            log.error("Unknown error ",ex);
        }
        return false;
    }
}
