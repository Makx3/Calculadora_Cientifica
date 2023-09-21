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
                        calcularSolucionEcuaciones(scanner);
                        break;
                    case 2:
                        calcularEcuacionDeRecta(scanner);
                        break;
                    case 3:
                        realizarOperacion("Suma", (a, b) -> a + b, scanner);
                        break;
                    case 4:
                        realizarOperacion("Resta", (a, b) -> a - b, scanner);
                        break;
                    case 5:
                        realizarOperacion("Multiplicación", (a, b) -> a * b, scanner);
                        break;
                    case 6:
                        realizarOperacion("División", (a, b) -> a / b, scanner);
                        break;
                    case 7:
                        encontrarMayor(scanner);
                        break;
                    case 8:
                        encontrarMenor(scanner);
                        break;
                    case 9:
                        calcularPotencia(scanner);
                        break;
                    case 10:
                        calcularPorcentaje(scanner);
                        break;
                    case 11:
                        resolverEcuacionCuadratica(scanner);
                        break;
                    case 12:
                        calcularCuadrado(scanner);
                        break;
                    case 13:
                        calcularRectangulo(scanner);
                        break;
                    case 14:
                        calcularCirculo(scanner);
                        break;
                    case 15:
                        calcularEsfera(scanner);
                        break;
                    case 16:
                        calcularCubo(scanner);
                        break;
                    case 17:
                        calcularCono(scanner);
                        break;
                    case 18:
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    public static void mostrarMenu() {
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

    public static void realizarOperacion(String nombreOperacion, Operacion operacion, Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = operacion.aplicar(num1, num2);
        System.out.println("Resultado de " + nombreOperacion + ": " + resultado);
    }

    public static void encontrarMayor(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double mayor = Math.max(num1, num2);
        System.out.println("El número mayor es: " + mayor);
    }

    public static void encontrarMenor(Scanner scanner) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        double menor = Math.min(num1, num2);
        System.out.println("El número menor es: " + menor);
    }

    public static void calcularPotencia(Scanner scanner) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        double exponente = scanner.nextDouble();

        double resultado = Math.pow(base, exponente);
        System.out.println(base + " elevado a la " + exponente + " es igual a " + resultado);
    }

    public static void calcularPorcentaje(Scanner scanner) {
        System.out.print("Ingrese el número: ");
        double numero = scanner.nextDouble();
        System.out.print("Ingrese el porcentaje a calcular (0-100): ");
        double porcentaje = scanner.nextDouble();

        double resultado = (porcentaje / 100) * numero;
        System.out.println(porcentaje + "% de " + numero + " es igual a " + resultado);
    }

    public static void resolverEcuacionCuadratica(Scanner scanner) {
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

    public static double[] calcularSolucion(double A, double B, double C, double D, double E, double F) {
        double determinante = A * E - B * D;
        double x = (C * E - B * F) / determinante;
        double y = (A * F - C * D) / determinante;
        double[] solucion = { x, y };
        return solucion;
    }

    public static double[] calcularEcuacionRecta(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        double[] ecuacionRecta = { m, b };
        return ecuacionRecta;
    }

    public static void mostrarResultadoSolucion(double[] resultado) {
        System.out.println("El resultado del sistema de ecuaciones es:");
        System.out.println("x = " + resultado[0]);
        System.out.println("y = " + resultado[1]);
    }

    public static void mostrarResultadoRecta(double[] ecuacionRecta) {
        System.out.println("La ecuación de la recta es:");
        System.out.println("Y = " + ecuacionRecta[0] + "X + " + ecuacionRecta[1]);
    }

    public static void calcularCuadrado(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularRectangulo(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar valores numéricos.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularCirculo(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularEsfera(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularCubo(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor numérico.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularCono(Scanner scanner) {
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
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar valores numéricos.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void calcularSolucionEcuaciones(Scanner scanner) {
        System.out.print("Ingrese el valor de A: ");
        double A = scanner.nextDouble();
        System.out.print("Ingrese el valor de B: ");
        double B = scanner.nextDouble();
        System.out.print("Ingrese el valor de C: ");
        double C = scanner.nextDouble();
        System.out.print("Ingrese el valor de D: ");
        double D = scanner.nextDouble();
        System.out.print("Ingrese el valor de E: ");
        double E = scanner.nextDouble();
        System.out.print("Ingrese el valor de F: ");
        double F = scanner.nextDouble();

        double[] solucion = calcularSolucion(A, B, C, D, E, F);
        mostrarResultadoSolucion(solucion);
    }

    public static void calcularEcuacionDeRecta(Scanner scanner) {
        System.out.print("Ingrese el valor de x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Ingrese el valor de y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Ingrese el valor de x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Ingrese el valor de y2: ");
        double y2 = scanner.nextDouble();

        double[] ecuacionRecta = calcularEcuacionRecta(x1, y1, x2, y2);
        mostrarResultadoRecta(ecuacionRecta);
    }
}
