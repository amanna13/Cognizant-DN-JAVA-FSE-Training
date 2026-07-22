package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start of Authenticate");
        logger.debug("Authentication Header : {}", authHeader);

        String user = getUser(authHeader);
        logger.debug("User - {}", user);
        Map<String, String> map = new HashMap<>();

        String token = generateJWT(user);
        map.put("token", token);
        logger.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        logger.debug("Encoded Credentials - {}", encodedCredentials);

        byte[] decodedBytes  = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes, StandardCharsets.UTF_8);

        logger.debug("Decoded Credentials -{}", decodedCredentials);

        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));
        logger.debug("Username : {}", user);

        logger.debug("End of getUser()");
        return user;
    }

    private String generateJWT(String user) {
        logger.info("Start of JWT ");
        JwtBuilder builder = Jwts.builder();
        builder.subject(user);

        builder.issuedAt(new Date());

        builder.expiration(new Date(new Date().getTime() + 1200000));

        String secret = "your-very-long-secret-key-at-least-32-bytes";

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        String token = builder.signWith(key, Jwts.SIG.HS256).compact();


        logger.debug("Generate Token - {}", token);
        logger.info("End of JWT ");

        return  token;
    }

}
