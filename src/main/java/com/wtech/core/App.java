package com.wtech.core;

import com.wtech.core.hashing.Argon2Hashing;
import com.wtech.core.hashing.BCryptHashing;
import com.wtech.core.hashing.PBKDF2Hashing;
import com.wtech.core.hashing.SHA256Hashing;
import com.wtech.core.hashing.SHA512Hashing;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Running tests...");

        long startTime;
        String myTestPassword = "My password";
        String timeTaken = "Time taken in milliseconds: ";

        startTime = System.currentTimeMillis();
        System.out.println("\nSHA-256 hashing test:");
        System.out.println(SHA256Hashing.hashPassword(myTestPassword));
        System.out.println(timeTaken + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\nSHA-512 hashing test:");
        System.out.println(SHA512Hashing.hashPassword(myTestPassword));
        System.out.println(timeTaken + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\nBCryptHashing test:");
        System.out.println(BCryptHashing.hashPassword(myTestPassword));
        System.out.println(timeTaken + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\nArgon2Hashing test:");
        System.out.println(Argon2Hashing.hashPassword(myTestPassword));
        System.out.println(timeTaken + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("\nPBKDF2Hashing test:");
        System.out.println(PBKDF2Hashing.hashPassword(myTestPassword));
        System.out.println(timeTaken + (System.currentTimeMillis() - startTime));
    }
}