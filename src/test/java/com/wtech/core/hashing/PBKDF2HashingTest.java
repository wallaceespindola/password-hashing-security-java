package com.wtech.core.hashing;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class PBKDF2HashingTest {

    public static final String TEST_PASSWORD = "TestPassword123";

    @Test
    public void testHashPasswordWithSaltReturnsConsistentResult() throws Exception {

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        String hashedPassword1 = PBKDF2Hashing.hashPasswordWithSalt(TEST_PASSWORD, salt);
        String hashedPassword2 = PBKDF2Hashing.hashPasswordWithSalt(TEST_PASSWORD, salt);

        assertEquals(hashedPassword1, hashedPassword2, "Hashing the same password with the same salt should return consistent results");
    }

    @Test
    public void testHashPasswordWithRandomSaltReturnsNonNullNonEmptyString() throws Exception {

        String hashedPassword = PBKDF2Hashing.hashPassword(TEST_PASSWORD);

        assertNotNull(hashedPassword, "Hashed password should not be null");
        assertFalse(hashedPassword.isEmpty(), "Hashed password should not be empty");
    }

    @Test
    public void testHashPasswordWithRandomSaltReturnsExpectedLength() throws Exception {

        String hashedPassword = PBKDF2Hashing.hashPassword(TEST_PASSWORD);

        // Length of Base64-encoded 32-byte hash
        int expectedLength = Base64.getEncoder().encode(new byte[32]).length;
        assertEquals(expectedLength, hashedPassword.length(), "Hashed password should have a consistent length");
    }

    @Test
    public void testHashPasswordGeneratesUniqueHashes() throws Exception {

        String hashedPassword1 = PBKDF2Hashing.hashPassword(TEST_PASSWORD);
        String hashedPassword2 = PBKDF2Hashing.hashPassword(TEST_PASSWORD);

        assertNotEquals(hashedPassword1, hashedPassword2, "Hashes of the same password should be unique due to different salts");
    }

    @Test
    public void testVerifyHashedPassword() throws Exception {

        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        String storedHash = PBKDF2Hashing.hashPasswordWithSalt(TEST_PASSWORD, salt);
        boolean isVerified = PBKDF2Hashing.verifyPassword(TEST_PASSWORD, storedHash, salt);

        assertTrue(isVerified, "Hashes of the same password should be valid");
    }
}
