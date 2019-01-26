/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesPassword {

    // Longitud Contraseña
    public static final int LONG_PASS_MIN = 6;
    public static final int LONG_PASS_MAX = 24;

    // Categorias de caracteres
    public static final int CAT_MIN = 0;
    public static final int CAT_MAY = 1;
    public static final int CAT_NUM = 2;
    public static final int CAT_PUN = 3;

    // Número de Categorias
    public static final int NUM_CAT = 4;

    // Símbolos categoria - Strings
    public static final String CAR_MIN_STR = "abcçdefghijklmnñopqrstuvwxyz";
    public static final String CAR_MAY_STR = "ABCÇDEFGHYJKLMNÑOPQRSTUVWXYZ";
    public static final String CAR_NUM_STR = "0123456789";
    public static final String CAR_PUN_STR = "$%&/()=?¿[]{}-_:.*+";

    // Símbolos categoria - Arrays
    public static final char[] CAR_MIN = CAR_MIN_STR.toCharArray();
    public static final char[] CAR_MAY = CAR_MAY_STR.toCharArray();
    public static final char[] CAR_NUM = CAR_NUM_STR.toCharArray();
    public static final char[] CAR_PUN = CAR_PUN_STR.toCharArray();

    // Sistema aleatorio
    public static final Random RND = new Random();

    public static final char[] generarPassword(int longPass) {
        return validarLongPass(longPass) ? generarPassword(new char[longPass]) : null;
    }

    // Genera Password (min + may + num + pun)
    public static final char[] generarPassword(char[] pass) {
        if (validarLongPass(pass.length)) {
            // Diferentes Categorias - Manual
            pass[CAT_MIN] = generarCaracter(CAR_MIN_STR);
            pass[CAT_MAY] = generarCaracter(CAR_MAY_STR);
            pass[CAT_NUM] = generarCaracter(CAR_NUM_STR);
            pass[CAT_PUN] = generarCaracter(CAR_PUN_STR);

            // Bucle generador - A partir de Posicion 5
            for (int posAct = NUM_CAT; posAct < pass.length; posAct++) {
                // Generar categoria
                int catAct = RND.nextInt(NUM_CAT);

                // Analizar categoria actual 
                switch (catAct) {
                    case CAT_MIN:
                        pass[posAct] = generarCaracter(CAR_MIN);
                        break;
                    case CAT_MAY:
                        pass[posAct] = generarCaracter(CAR_MAY);
                        break;
                    case CAT_NUM:
                        pass[posAct] = generarCaracter(CAR_NUM);
                        break;
                    case CAT_PUN:
                        pass[posAct] = generarCaracter(CAR_PUN);
                }
            }

            // Desordenar Array
            UtilesArrays.desordenar(pass);
        } else {
            pass = null;
        }

        // Devuelve el array
        return pass;
    }

    public static final char generarCaracter(String lista) {
        return lista.charAt(RND.nextInt(lista.length()));
    }

    public static final char generarCaracter(char[] lista) {
        return lista[RND.nextInt(lista.length)];
    }

    public static final boolean validarLongPass(int longPass) {
        return longPass >= LONG_PASS_MIN && longPass <= LONG_PASS_MAX;
    }
}
