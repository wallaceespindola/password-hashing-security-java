package com.wtech.core.hashing;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class PBKDF2HashingTest {

    @Test
    public void testHashPasswordWithSaltReturnsConsistentResult() throws Exception {
        String password = "TestPassword123";
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        String hashedPassword1 = PBKDF2Hashing.hashPasswordWithSalt(password, salt);
        String hashedPassword2 = PBKDF2Hashing.hashPasswordWithSalt(password, salt);

        assertEquals(hashedPassword1, hashedPassword2, "Hashing the same password with the same salt should return consistent results");
    }

    @Test
    public void testHashPasswordWithRandomSaltReturnsNonNullNonEmptyString() throws Exception {
        String password = "TestPassword123";

        String hashedPassword = PBKDF2Hashing.hashPassword(password);

        assertNotNull(hashedPassword, "Hashed password should not be null");
        assertFalse(hashedPassword.isEmpty(), "Hashed password should not be empty");
    }

    @Test
    public void testHashPasswordWithRandomSaltReturnsExpectedLength() throws Exception {
        String password = "TestPassword123";

        String hashedPassword = PBKDF2Hashing.hashPassword(password);

        // Length of Base64-encoded 32-byte hash
        int expectedLength = Base64.getEncoder().encode(new byte[32]).length;
        assertEquals(expectedLength, hashedPassword.length(), "Hashed password should have a consistent length");
    }

    @Test
    public void testHashPasswordGeneratesUniqueHashes() throws Exception {
        String password = "TestPassword123";
        String hashedPassword1 = PBKDF2Hashing.hashPassword(password);
        String hashedPassword2 = PBKDF2Hashing.hashPassword(password);

        assertNotEquals(hashedPassword1, hashedPassword2, "Hashes of the same password should be unique due to different salts");
    }
}
