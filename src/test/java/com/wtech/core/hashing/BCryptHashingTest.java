package com.wtech.core.hashing;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BCryptHashingTest {

    @Test
    public void testHashPassword() {
        String originalPassword = "TestPassword123";
        String hashedPassword = BCryptHashing.hashPassword(originalPassword);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        assertThat(hashedPassword).isNotNull();
        assertThat(hashedPassword).isNotBlank();
        assertTrue(encoder.matches(originalPassword, hashedPassword), "Hashed password must match original");
    }

    @Test
    public void testHashPasswordReturnsNonNullNonEmptyString() {
        String password = "TestPassword123";
        String hashedPassword = BCryptHashing.hashPassword(password);

        assertNotNull(hashedPassword, "Hashed password should not be null");
        assertFalse(hashedPassword.isEmpty(), "Hashed password should not be empty");
    }

    @Test
    public void testHashPasswordReturnsConsistentLength() {
        String password = "TestPassword123";
        String hashedPassword = BCryptHashing.hashPassword(password);

        // Length of Base64-encoded 43-byte hash
        int expectedLength = Base64.getEncoder().encode(new byte[43]).length; // length equals to 60 in average
        assertEquals(expectedLength, hashedPassword.length(), "Hashed password should have a consistent length");
    }

    @Test
    public void testHashPasswordGeneratesUniqueHashes() {
        String password = "TestPassword123";
        String hashedPassword1 = BCryptHashing.hashPassword(password);
        String hashedPassword2 = BCryptHashing.hashPassword(password);

        assertNotEquals(hashedPassword1, hashedPassword2, "Hashes of the same password should be unique due to different salts");
    }
}

