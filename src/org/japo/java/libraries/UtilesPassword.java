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
public class UtilesPassword {

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

    public static final String generarPassword(int longitud) {
        // Semáforos
        boolean minOK = false;      // Cat 0
        boolean mayOK = false;      // Cat 1
        boolean numOK = false;      // Cat 2
        boolean punOK = false;      // Cat 3

        // Password a generar
        String password = "";

        // Bucle generador
        for (int posAct = 0; posAct < longitud; posAct++) {
            // Generar categoria
//            int catActual = generarCategoria(longitud, posAct, minOK, mayOK, numOK, punOK);
            int catActual = generarCategoria();

            // Caracter actual
            char carActual;

            // Analizar categoria actual 
            switch (catActual) {
                case CAT_MIN:
                    minOK = true;
                    carActual = generarCaracter(CAR_MIN_STR);
                    password += carActual;
                    break;
                case CAT_MAY:
                    mayOK = true;
                    carActual = generarCaracter(CAR_MAY_STR);
                    password += carActual;
                    break;
                case CAT_NUM:
                    numOK = true;
                    carActual = generarCaracter(CAR_NUM_STR);
                    password += carActual;
                    break;
                case CAT_PUN:
                    punOK = true;
                    carActual = generarCaracter(CAR_PUN_STR);
                    password += carActual;
            }
        }

        // Devolver password
        return password;
    }

    public static final void generarPassword(char[] pass) {
        // Manual
        pass[0] = generarCaracter(CAR_MIN_STR);
        pass[1] = generarCaracter(CAR_MAY_STR);
        pass[2] = generarCaracter(CAR_NUM_STR);
        pass[3] = generarCaracter(CAR_PUN_STR);

        // Bucle generador
        for (int posAct = NUM_CAT; posAct < pass.length; posAct++) {
            // Generar categoria
            int catAct = generarCategoria();

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
        desordenar(pass);
    }

    public static final char generarCaracter(String lista) {
        return lista.charAt(RND.nextInt(lista.length()));
    }

    public static final char generarCaracter(char[] lista) {
        return lista[RND.nextInt(lista.length)];
    }

    public static final int generarCategoria() {
        return RND.nextInt(NUM_CAT);
    }

    public static final void desordenar(char[] a) {
        for (int i = 0; i < a.length; i++) {
            int posRnd = RND.nextInt(a.length);

            char aux = a[posRnd];
            a[posRnd] = a[i];
            a[i] = aux;
        }
    }
}
