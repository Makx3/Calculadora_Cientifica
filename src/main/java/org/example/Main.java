package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ejecutarCalculadora();
    }

    public static void ejecutarCalculadora() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Calcular la solución de un sistema de ecuaciones");
            System.out.println("2. Calcular la ecuación de una recta");
            System.out.println("3. Salir");
            System.out.print("Opción: ");

            opcion = obtenerOpcionValidaMenu();

            switch (opcion) {
                case 1:
                    double[] solucionSistema = calcularSolucionEcuaciones();
                    mostrarResultadoSolucion(solucionSistema);
                    break;
                case 2:
                    double[] ecuacionRecta = calcularEcuacionDeRecta();
                    mostrarResultadoRecta(ecuacionRecta);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 3);
    }

    public static int obtenerOpcionValidaMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 3) {
                    break; // Salir del bucle si se ingresó una opción válida
                } else {
                    System.out.println("Opción no válida, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida, intente de nuevo.");
                scanner.nextLine();
            }
        } while (true);

        return opcion;
    }

    public static double[] calcularSolucionEcuaciones() {
        System.out.println("Para calcular la solución de un sistema de ecuaciones de la forma:");
        System.out.println("Ax + By = C");
        System.out.println("Dx + Ey = F");

        double[] valoresSistema = obtenerValoresSistemaEcuaciones();

        return calcularSolucion(valoresSistema[0], valoresSistema[1], valoresSistema[2], valoresSistema[3], valoresSistema[4], valoresSistema[5]);
    }

    public static double[] calcularEcuacionDeRecta() {
        System.out.println("Para calcular la ecuación de una recta dada por dos puntos (x1, y1) y (x2, y2).");

        double[] puntosRecta = obtenerPuntosRecta();

        return calcularEcuacionRecta(puntosRecta[0], puntosRecta[1], puntosRecta[2], puntosRecta[3]);
    }

    public static double[] obtenerValoresSistemaEcuaciones() {
        double A = obtenerValorValidoMetodos("Ingrese el valor de A: ");
        double B = obtenerValorValidoMetodos("Ingrese el valor de B: ");
        double C = obtenerValorValidoMetodos("Ingrese el valor de C: ");
        double D = obtenerValorValidoMetodos("Ingrese el valor de D: ");
        double E = obtenerValorValidoMetodos("Ingrese el valor de E: ");
        double F = obtenerValorValidoMetodos("Ingrese el valor de F: ");

        return new double[]{A, B, C, D, E, F};
    }

    public static double[] obtenerPuntosRecta() {
        double x1 = obtenerValorValidoMetodos("Ingrese el valor de x1: ");
        double y1 = obtenerValorValidoMetodos("Ingrese el valor de y1: ");
        double x2 = obtenerValorValidoMetodos("Ingrese el valor de x2: ");
        double y2 = obtenerValorValidoMetodos("Ingrese el valor de y2: ");

        return new double[]{x1, y1, x2, y2};
    }

    public static double obtenerValorValidoMetodos(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        double valor;

        do {
            try {
                System.out.print(mensaje);
                valor = scanner.nextDouble();
                break; // Sale del bucle si se ingresó un valor válido
            } catch (InputMismatchException e) {
                System.out.println("Valor no valido, intente de nuevo.");
                scanner.nextLine();
            }
        } while (true);

        return valor;
    }

    public static void mostrarResultadoSolucion(double[] resultado) {
        System.out.println("El resultado del sistema de ecuaciones es:");
        System.out.println("x = " + resultado[0]);
        System.out.println("y = " + resultado[1]);
    }

    public static void mostrarResultadoRecta(double[] ecuacionRecta) {
        System.out.println("La ecuacion de la recta es:");
        System.out.println("Y = " + ecuacionRecta[0] + "X + " + ecuacionRecta[1]);
    }

    public static double[] calcularSolucion(double A, double B, double C, double D, double E, double F) {
        double determinante = A * E - B * D;
        double x = (C * E - B * F) / determinante;
        double y = (A * F - C * D) / determinante;
        double[] solucion = {x, y};
        return solucion;
    }

    public static double[] calcularEcuacionRecta(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        double[] ecuacionRecta = {m, b};
        return ecuacionRecta;
    }
}



