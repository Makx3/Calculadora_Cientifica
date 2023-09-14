package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
