package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_calcularEcuacionRecta {

    @Test
    public void testCalcularEcuacionRecta_PuntosDiferentes() {
        double x1 = 1.0;
        double y1 = 2.0;
        double x2 = 3.0;
        double y2 = 4.0;

        double[] ecuacionRecta = Main.calcularEcuacionRecta(x1, y1, x2, y2);

        // Verifica que la pendiente sea 1
        assertEquals(1.0, ecuacionRecta[0], 0.0);

        // Verifica que la ordenada al origen sea 1
        assertEquals(1.0, ecuacionRecta[1], 0.0);
    }

    @Test
    public void testCalcularEcuacionRecta_MismoPunto() {
        // Prueba con el mismo punto
        double x1 = 2.0;
        double y1 = 3.0;
        double x2 = 2.0;
        double y2 = 3.0;

        double[] ecuacionRecta = Main.calcularEcuacionRecta(x1, y1, x2, y2);

        // Verifica que la pendiente sea NaN (debido a que los puntos son iguales)
        assertTrue(Double.isNaN(ecuacionRecta[0]));

        // Verifica que la ordenada al origen sea NaN (debido a que los puntos son iguales)
        assertTrue(Double.isNaN(ecuacionRecta[1]));
    }
}