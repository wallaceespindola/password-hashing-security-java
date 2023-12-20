![Java](https://seeklogo.com/images/J/java-logo-CE0198242E-seeklogo.com.png)

# Password Hashing Security in Java

## Introduction

This project is dedicated to testing and validating various password hashing security implementations in Java. It
showcases different algorithms and their usage, providing a practical insight into modern password security in Java
applications.

## Examples

* [SHA256Hashing.java](src%2Fmain%2Fjava%2Fcom%2Fwtech%2Fcore%2Fhashing%2FSHA256Hashing.java): Utilizes the SHA-256
  algorithm for hashing passwords. It's a part of the SHA-2 family of cryptographic hash functions but is generally not
  recommended for password hashing due to its speed and susceptibility to brute-force attacks.
* [SHA512Hashing.java](src%2Fmain%2Fjava%2Fcom%2Fwtech%2Fcore%2Fhashing%2FSHA512Hashing.java): Employs the SHA-512
  algorithm. While more secure than SHA-256 due to a larger hash size, it shares similar limitations for password
  security.
* [Argon2Hashing.java](src%2Fmain%2Fjava%2Fcom%2Fwtech%2Fcore%2Fhashing%2FArgon2Hashing.java): Implements the Argon2
  algorithm, the winner of the Password Hashing Competition. It is designed to be resistant to GPU cracking attacks and
  is recommended for new applications.
* [BCryptHashing.java](src%2Fmain%2Fjava%2Fcom%2Fwtech%2Fcore%2Fhashing%2FBCryptHashing.java): Uses the BCrypt
  algorithm, which is widely regarded for its security features, including built-in salting and adaptive hash functions.
* [PBKDF2Hashing.java](src%2Fmain%2Fjava%2Fcom%2Fwtech%2Fcore%2Fhashing%2FPBKDF2Hashing.java): Hashes passwords using
  the PBKDF2 (Password-Based Key Derivation Function 2) algorithm. It's a part of RSA Laboratories' PKCS series and is
  known for its customizability in terms of iterations.

## Prerequisites

* Java Development Kit (JDK) - Version 21 or higher.
* Maven - For managing dependencies and running the project.
* An IDE like IntelliJ IDEA, Eclipse, or VSCode for editing and running the Java
  files.
* Or simply run it in command line.

## Author

* Wallace Espindola, Sr. Software Engineer / Java & Python Dev (wallace.espindola@gmail.com)

## License

**Free Software, Apache 2.0**