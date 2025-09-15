package com.wtech.core.hashing;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import java.security.SecureRandom;
import java.util.Base64;

public class Argon2Hashing {
    public static String hashPassword(String password) {

        // Securely generate a random salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes salt
        random.nextBytes(salt);

        return hashPasswordWithSalt(password, salt);
    }

    public static String hashPasswordWithSalt(String password, byte[] salt) {

        // Set realistic values for Argon2 parameters
        int parallelism = 2; // Use 2 threads
        int memory = 65536; // Use 64 MB of memory
        int iterations = 3; // Run 3 iterations
        int hashLength = 32; // Generate a 32 byte (256 bit) hash

        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withSalt(salt)
                .withParallelism(parallelism)
                .withMemoryAsKB(memory)
                .withIterations(iterations);

        generator.init(builder.build());
        byte[] result = new byte[hashLength];
        generator.generateBytes(password.toCharArray(), result);
        return Base64.getEncoder().encodeToString(result);
    }

    public static boolean verifyPassword(String inputPassword, String storedHash, byte[] salt) {
        String newHash = hashPasswordWithSalt(inputPassword, salt);
        return newHash.equals(storedHash);
    }
}
