package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

// a
import java.util.InputMismatchException;
import java.util.Scanner;
public static void Main() {
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




        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        realizarOperacion("Suma", (a, b) -> a + b, scanner);
                        break;
                    case 2:
                        realizarOperacion("Resta", (a, b) -> a - b, scanner);
                        break;
                    case 3:
                        realizarOperacion("Multiplicación", (a, b) -> a * b, scanner);
                        break;
                    case 4:
                        realizarOperacion("División", (a, b) -> a / b, scanner);
                        break;
                    case 5:
                        encontrarMayor(scanner);
                        break;
                    case 6:
                        encontrarMenor(scanner);
                        break;
                    case 7:
                        calcularPotencia(scanner);
                        break;
                    case 8:
                        calcularPorcentaje(scanner);
                        break;
                    case 9:
                        resolverEcuacionCuadratica(scanner);
                        break;
                    case 10:
                        System.out.println("¡Hasta luego!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine(); // Limpiar el búfer del teclado
            } catch (ArithmeticException e) {
                System.out.println("Error: No se puede dividir por cero.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Calculadora");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Mayor de 2 números");
        System.out.println("6. Menor de 2 números");
        System.out.println("7. Potencia de un número");
        System.out.println("8. Porcentaje de un número");
        System.out.println("9. Resolver Ecuación Cuadrática");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void realizarOperacion(String nombreOperacion, Operacion operacion, Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = operacion.aplicar(num1, num2);
        System.out.println("Resultado de " + nombreOperacion + ": " + resultado);
    }

    private static void encontrarMayor(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double mayor = Math.max(num1, num2);
        System.out.println("El número mayor es: " + mayor);
    }

    private static void encontrarMenor(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double menor = Math.min(num1, num2);
        System.out.println("El número menor es: " + menor);
    }

    private static void calcularPotencia(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        double exponente = scanner.nextDouble();

        double resultado = Math.pow(base, exponente);
        System.out.println(base + " elevado a la " + exponente + " es igual a " + resultado);
    }

    private static void calcularPorcentaje(Scanner scanner) {
        System.out.print("Ingrese el número: ");
        double numero = scanner.nextDouble();
        System.out.print("Ingrese el porcentaje a calcular (0-100): ");
        double porcentaje = scanner.nextDouble();

        double resultado = (porcentaje / 100) * numero;
        System.out.println(porcentaje + "% de " + numero + " es igual a " + resultado);
    }

    private static void resolverEcuacionCuadratica(Scanner scanner) {
        System.out.print("Ingrese el coeficiente A: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el coeficiente B: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el coeficiente C: ");
        double c = scanner.nextDouble();

        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Las soluciones son x1 = " + x1 + " y x2 = " + x2);
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            System.out.println("La solución única es x = " + x);
        } else {
            System.out.println("La ecuación no tiene soluciones reales.");
        }
    }

    interface Operacion {
        double aplicar(double a, double b);
    }
}
