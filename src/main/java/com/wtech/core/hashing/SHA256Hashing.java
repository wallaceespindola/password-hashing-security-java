package com.wtech.core.hashing;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256Hashing {

    public static String hashPassword(String password) throws Exception {

        // Securely generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return hashPasswordWithSalt(password, salt);
    }

    public static String hashPasswordWithSalt(String password, byte[] salt) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);

        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
}

