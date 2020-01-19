package com.yusufalicezik.OPSapi.config.auth.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenManager {

    private static final String secretKey = "OPSApiSecretKeyridvanyusuf123keyasdasdasdasddsadasd";
    private static final int validity = 5 * 60 * 1000; //5 dk

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String mail){
        String jwt = Jwts.builder()
                .setSubject(mail)
                .setIssuer("yac")
                .setIssuedAt(new Date((System.currentTimeMillis())))
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return "Bearer " + jwt;
    }




    public static void validateToken(String token) {
        try {
            Map<String, Object> icerik = Jwts.parser()
                    .setSigningKey(secretKey.trim())
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();
        } catch (Exception e) {
            throw new IllegalStateException("Token yanlış");
        }
    }

    //olds.
    public static boolean tokenValidate(String token){
        if(getEmailFromToken(token) != null && isExpired(token)){
            return true;
        }
        return false;
    }

    public static String getEmailFromToken(String token){
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    public static Boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public static Claims getClaims(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}
