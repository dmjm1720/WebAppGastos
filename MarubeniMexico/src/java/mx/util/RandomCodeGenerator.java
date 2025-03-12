package mx.util;

import java.util.Random;

public class RandomCodeGenerator {

    public static String generaCodigo() {
        Random ramdom = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char letra = (char) ('A' + ramdom.nextInt(26));
            code.append(letra);
        }
        for (int i = 0; i < 3; i++) {
            int numero = ramdom.nextInt(10);
            code.append(numero);
        }

        return code.toString();
    }
}
