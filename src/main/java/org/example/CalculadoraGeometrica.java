package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        calcularCuadrado(scanner);
                        break;
                    case 2:
                        calcularRectangulo(scanner);
                        break;
                    case 3:
                        calcularCirculo(scanner);
                        break;
                    case 4:
                        calcularEsfera(scanner);
                        break;
                    case 5:
                        calcularCubo(scanner);
                        break;
                    case 6:
                        calcularCono(scanner);
                        break;
                    case 7:
                        System.out.println("Cerrado exitosamente");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine(); // Limpiar el búfer de entrada
            } catch (ArithmeticException e) {
                System.out.println("No se puede dividir por cero.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Calculadora Geométrica");
        System.out.println("1. Calcular el perímetro de un cuadrado");
        System.out.println("2. Calcular el área de un rectángulo");
        System.out.println("3. Calcular el área de un círculo");
        System.out.println("4. Calcular el volumen de una esfera");
        System.out.println("5. Calcular el volumen de un cubo");
        System.out.println("6. Calcular el volumen de un cono");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static boolean calcularCuadrado(Scanner scanner) {
        double lado;
        do {
            try {
                System.out.print("Ingrese el lado del cuadrado: ");
                lado = scanner.nextDouble();
                if (lado <= 0) {
                    throw new IllegalArgumentException("El lado debe ser mayor que cero.");
                }
                double perimetro = 4 * lado;
                System.out.println("El perímetro del cuadrado es: " + perimetro);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static boolean calcularRectangulo(Scanner scanner) {
        double longitud;
        double anchura;
        do {
            try {
                System.out.print("Ingrese la longitud del rectángulo: ");
                longitud = scanner.nextDouble();
                System.out.print("Ingrese la anchura del rectángulo: ");
                anchura = scanner.nextDouble();
                if (longitud <= 0 || anchura <= 0) {
                    throw new IllegalArgumentException("Tanto la longitud como la anchura deben ser mayores que cero.");
                }
                double area = longitud * anchura;
                System.out.println("El área del rectángulo es: " + area);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar valores numéricos.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static boolean calcularCirculo(Scanner scanner) {
        double radio;
        do {
            try {
                System.out.print("Ingrese el radio del círculo: ");
                radio = scanner.nextDouble();
                if (radio <= 0) {
                    throw new IllegalArgumentException("El radio debe ser mayor que cero.");
                }
                double area = Math.PI * Math.pow(radio, 2);
                System.out.println("El área del círculo es: " + area);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static boolean calcularEsfera(Scanner scanner) {
        double radio;
        do {
            try {
                System.out.print("Ingrese el radio de la esfera: ");
                radio = scanner.nextDouble();
                if (radio <= 0) {
                    throw new IllegalArgumentException("El radio debe ser mayor que cero.");
                }
                double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
                System.out.println("El volumen de la esfera es: " + volumen);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static boolean calcularCubo(Scanner scanner) {
        double lado;
        do {
            try {
                System.out.print("Ingrese la longitud de un lado del cubo: ");
                lado = scanner.nextDouble();
                if (lado <= 0) {
                    throw new IllegalArgumentException("El lado debe ser mayor que cero.");
                }
                double volumen = Math.pow(lado, 3);
                System.out.println("El volumen del cubo es: " + volumen);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static boolean calcularCono(Scanner scanner) {
        double radio;
        double altura;
        do {
            try {
                System.out.print("Ingrese el radio de la base del cono: ");
                radio = scanner.nextDouble();
                System.out.print("Ingrese la altura del cono: ");
                altura = scanner.nextDouble();
                if (radio <= 0 || altura <= 0) {
                    throw new IllegalArgumentException("El radio y la altura deben ser positivas.");
                }
                double volumen = (1.0 / 3.0) * Math.PI * Math.pow(radio, 2) * altura;
                System.out.println("El volumen del cono es: " + volumen);
                return false;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar valores numéricos.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
