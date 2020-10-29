package mx.password;

import java.security.MessageDigest;

public class EncriptarPassword {

    public static String sha512(String cadena) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(cadena.getBytes());
            byte[] mb = md.digest();
            for (int i = 0; i < mb.length; i++) {
                sb.append(Integer.toString((mb[i] & 0xFF) + 256, 16).substring(1));
            }
        } catch (java.security.NoSuchAlgorithmException localNoSuchAlgorithmException) {
        }

        return sb.toString();
    }
}
