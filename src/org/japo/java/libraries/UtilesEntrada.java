/*
 * Copyright 2016 José A. Pacheco Ondoño - joanpaon@gmail.com.
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

import java.util.Scanner;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesEntrada {

    // Scanner + Codificación Windows
    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    // Consola >> Entero
    public static final int leerEntero(String msgUsr, String msgErr) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Entero [min .. max]
    public static final int leerEntero(String msgUsr, String msgErr, int min, int max) {
        // Numero a devolver
        int dato;

        // Semaforo validacion
        boolean rangoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = leerEntero(msgUsr, msgErr);

            // Validar Entero
            rangoOK = dato >= min && dato <= max;

            // Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Entero [Lista posibles Valores]
    public static final int leerEntero(String msgUsr, String msgErr, int lista[]) {
        // Numero a devolver
        int dato;

        // Semaforo validacion
        boolean datoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);

            // Validar Entero
            datoOK = UtilesArrays.buscar(lista, dato) > -1;

            // Mensaje de error
            if (!datoOK) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Real
    public static final double leerReal(String msgUsr, String msgErr) {
        // Dato a introducir
        double dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextDouble();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Real [min .. max]
    public static final double leerReal(String msgUsr, String msgErr, double min, double max) {
        // Numero a devolver
        double dato;

        // Semaforo validacion
        boolean rangoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = leerReal(msgUsr, msgErr);

            // Validar Entero
            rangoOK = dato >= min && dato <= max;

            // Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Real [Lista posibles Valores]
    public static final double leerReal(String msgUsr, String msgErr, double lista[]) {
        // Numero a devolver
        double dato;

        // Semaforo validacion
        boolean datoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);

            // Validar Entero
            datoOK = UtilesArrays.buscar(lista, dato) > -1;

            // Mensaje de error
            if (!datoOK) {
                System.out.println(msgErr);
            }
        } while (!datoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Carácter
    public static final char leerCaracter(String msgUsr, String msgErr) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Carácter [Lista posibles Opciones]
    public static final char leerCaracter(String msgUsr, String msgErr, String opciones) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);

                // Analisis Dato
                if (opciones.contains(dato + "")) {
                    lecturaOK = true;
                } else {
                    System.out.println(msgErr);
                }
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Consola >> Carácter [min .. max]
    public static final char leerCaracter(String msgUsr, String msgErr, char min, char max) {
        // Dato a introducir
        char dato;

        // Semaforo validacion
        boolean rangoOK;

        // Bucle Validacion
        do {
            // Introducir Entero
            dato = leerCaracter(msgUsr, msgErr);

            // Validar Entero
            rangoOK = dato >= min && dato <= max;

            // Mensaje de error
            if (!rangoOK) {
                System.out.println(msgErr);
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Consola >> Texto
    public static final String leerTexto(String msgUsr) {
        System.out.print(msgUsr);
        return SCN.nextLine();
    }
}
