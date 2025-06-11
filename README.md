![Java](https://cdn.icon-icons.com/icons2/2699/PNG/512/java_logo_icon_168609.png)

# Password Hashing Security in Java

![Apache 2.0 License](https://img.shields.io/badge/License-Apache2.0-orange)
![Java](https://img.shields.io/badge/Built_with-Java-blue)
![Maven](https://img.shields.io/badge/Powered_by-Maven-green)

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

## How to Run

1. Clone the repository:

```bash
git clone git@github.com:wallaceespindola/password-hashing-security-java.git

cd password-hashing-security-java
```

2. Build the project with Maven:

```bash
mvn clean install
```

3. Running the main examples:

```bash
java -jar ./target/password-hashing-security.jar
```

4. This project is using Java 21, if you want to run it with a previous version, modify the pom.xml and compile to your preferred version:

```bash
<maven.compiler.source>21</maven.compiler.source>
<maven.compiler.target>21</maven.compiler.target>
```

5. You can also run the unit tests for each algorithm on your IDE at the path 'src/test/java'.

## Article published

* Dzone, December/2023: https://dzone.com/articles/secure-password-hashing-in-java

## Author

- Wallace Espindola, Sr. Software Engineer / Solution Architect / Java & Python Dev
- **LinkedIn:** [linkedin.com/in/wallaceespindola/](https://www.linkedin.com/in/wallaceespindola/)
- **GitHub:** [github.com/wallaceespindola](https://github.com/wallaceespindola)
- **E-mail:** [wallace.espindola@gmail.com](mailto:wallace.espindola@gmail.com)
- **Twitter:** [@wsespindola](https://twitter.com/wsespindola)
- **Gravatar:** [gravatar.com/wallacese](https://gravatar.com/wallacese)
- **Dev Community:** [dev.to/wallaceespindola](https://dev.to/wallaceespindola)
- **DZone Articles:** [DZone Profile](https://dzone.com/users/1254611/wallacese.html)
- **Pulse Articles:** [LinkedIn Articles](https://www.linkedin.com/in/wallaceespindola/recent-activity/articles/)
- **Website:** [W-Tech IT Solutions](https://www.wtechitsolutions.com/)
- **Presentation Slides:** [Speakerdeck](https://speakerdeck.com/wallacese)

## License

- This project is released under the Apache 2.0 License.
- See the [LICENSE](LICENSE) file for details.
- Copyright © 2024 [Wallace Espindola](https://github.com/wallaceespindola/).
