package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_calcularSolucion {

    @Test
    public void testCalcularSolucion_SolucionUnica() {
        double A = 2;
        double B = 3;
        double C = 8;
        double D = 1;
        double E = 2;
        double F = 5;

        double[] resultado = Main.calcularSolucion(A, B, C, D, E, F);

        // Verifica que el resultado sea correcto con un margen de error pequeño
        double epsilon = 1e-6;
        assertEquals(1.0, resultado[0], epsilon);
        assertEquals(2.0, resultado[1], epsilon);

    }

    @Test
    public void testCalcularSolucion_SinSolucion() {
        double A = 2.0;
        double B = 3.0;
        double C = 4.0;
        double D = 2.0;
        double E = 3.0;
        double F = 4.0;

        double[] resultado = Main.calcularSolucion(A, B, C, D, E, F);

        // Verifica que el resultado sea NaN en ambas coordenadas
        assertTrue(Double.isNaN(resultado[0]));
        assertTrue(Double.isNaN(resultado[1]));
    }

    @Test
    public void testCalcularSolucion_InfinitasSoluciones() {
        double A = 2.0;
        double B = 3.0;
        double C = 4.0;
        double D = 4.0;
        double E = 6.0;
        double F = 8.0;

        double[] resultado = Main.calcularSolucion(A, B, C, D, E, F);

        // Verifica que el resultado sea NaN en ambas coordenadas
        assertTrue(Double.isNaN(resultado[0]));
        assertTrue(Double.isNaN(resultado[1]));
    }
}