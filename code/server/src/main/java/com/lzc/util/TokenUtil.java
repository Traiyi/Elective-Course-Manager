package com.lzc.util;

import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


public class TokenUtil {
    /**
     * ��Чʱ��
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
    /**
     * ��Կ
     */
    private static final String TOKEN_SECRET = "ben";

    /**
     * ǩ������
     *
     * @param username
     * @return
     */
    public static String sign(String username) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", username)
                    .withExpiresAt(expiresAt)
                    //ʹ��HMAC256�㷨����
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(token);
        return token;
    }

    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256((TOKEN_SECRET)))
                    .withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("verify pass");
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("���� Time: " + jwt.getExpiresAt());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
