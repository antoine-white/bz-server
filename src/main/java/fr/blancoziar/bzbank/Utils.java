package fr.blancoziar.bzbank;

import java.security.SecureRandom;

public final class Utils {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static String randomString(int len){
       StringBuilder sb = new StringBuilder(len);
       for(int i = 0; i < len; i++)
          sb.append(AB.charAt(rnd.nextInt(AB.length())));
       return sb.toString();
    }
}
