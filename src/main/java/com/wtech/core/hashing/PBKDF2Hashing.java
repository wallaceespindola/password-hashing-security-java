package com.wtech.core.hashing;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PBKDF2Hashing {

    public static String hashPassword(String password) throws Exception {

        // Securely generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        return hashPasswordWithSalt(password, salt);
    }

    public static String hashPasswordWithSalt(String password, byte[] salt) throws Exception {

        // Set realistic values for parameters
        int iterationCount = 65536; // How many iterations to use
        int keyLength = 256; // Derived key length

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterationCount, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPassword(String inputPassword, String storedHash, byte[] salt) throws Exception {
        String newHash = hashPasswordWithSalt(inputPassword, salt);
        return newHash.equals(storedHash);
    }
}

