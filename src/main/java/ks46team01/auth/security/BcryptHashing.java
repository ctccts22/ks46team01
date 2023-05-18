package ks46team01.auth.security;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptHashing {

    public static String hash(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }

    public static boolean verify(String plainText, String hashedPassword) {
        return BCrypt.checkpw(plainText, hashedPassword);
    }
}