package com.wtech.core.hashing;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BCryptHashingTest {

    public static final String TEST_PASSWORD = "TestPassword123";

    @Test
    public void testHashPassword() {

        String hashedPassword = BCryptHashing.hashPassword(TEST_PASSWORD);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        assertThat(hashedPassword).isNotNull();
        assertThat(hashedPassword).isNotBlank();
        assertTrue(encoder.matches(TEST_PASSWORD, hashedPassword), "Hashed password must match original");
    }

    @Test
    public void testHashPasswordReturnsNonNullNonEmptyString() {

        String hashedPassword = BCryptHashing.hashPassword(TEST_PASSWORD);

        assertNotNull(hashedPassword, "Hashed password should not be null");
        assertFalse(hashedPassword.isEmpty(), "Hashed password should not be empty");
    }

    @Test
    public void testHashPasswordReturnsConsistentLength() {

        String hashedPassword = BCryptHashing.hashPassword(TEST_PASSWORD);

        // Length of Base64-encoded 43-byte hash
        int expectedLength = Base64.getEncoder().encode(new byte[43]).length; // length equals to 60 in average
        assertEquals(expectedLength, hashedPassword.length(), "Hashed password should have a consistent length");
    }

    @Test
    public void testHashPasswordGeneratesUniqueHashes() {

        String hashedPassword1 = BCryptHashing.hashPassword(TEST_PASSWORD);
        String hashedPassword2 = BCryptHashing.hashPassword(TEST_PASSWORD);

        assertNotEquals(hashedPassword1, hashedPassword2, "Hashes of the same password should be unique due to different salts");
    }

    @Test
    public void testVerifyHashedPassword() {

        String storedHash = BCryptHashing.hashPassword(TEST_PASSWORD);

        boolean isVerified = BCryptHashing.verifyPassword(TEST_PASSWORD, storedHash);

        assertTrue(isVerified, "Hashes of the same password should be valid");
    }
}

