package org.example;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculadoraGeometricaTest {

    @Test
    public void calcularCuadrado_NumeroNegativo() {
        ScannerMock scannerMock = new ScannerMock("-5\n");
        boolean resultado = CalculadoraGeometrica.calcularCuadrado(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCuadrado_Cero() {
        ScannerMock scannerMock = new ScannerMock("0\n");
        boolean resultado = CalculadoraGeometrica.calcularCuadrado(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularRectangulo_LongitudNegativa() {
        ScannerMock scannerMock = new ScannerMock("-5\n5\n");
        boolean resultado = CalculadoraGeometrica.calcularRectangulo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularRectangulo_AlturaNegativa() {
        ScannerMock scannerMock = new ScannerMock("5\n-5\n");
        boolean resultado = CalculadoraGeometrica.calcularRectangulo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularRectangulo_LongitudCero() {
        ScannerMock scannerMock = new ScannerMock("0\n5\n");
        boolean resultado = CalculadoraGeometrica.calcularRectangulo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularRectangulo_AlturaCero() {
        ScannerMock scannerMock = new ScannerMock("5\n0\n");
        boolean resultado = CalculadoraGeometrica.calcularRectangulo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCirculo_RadioNegativo() {
        ScannerMock scannerMock = new ScannerMock("-5\n");
        boolean resultado = CalculadoraGeometrica.calcularCirculo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCirculo_RadioCero() {
        ScannerMock scannerMock = new ScannerMock("0\n");
        boolean resultado = CalculadoraGeometrica.calcularCirculo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularEsfera_RadioNegativo() {
        ScannerMock scannerMock = new ScannerMock("-5\n");
        boolean resultado = CalculadoraGeometrica.calcularEsfera(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularEsfera_RadioCero() {
        ScannerMock scannerMock = new ScannerMock("0\n");
        boolean resultado = CalculadoraGeometrica.calcularEsfera(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCubo_LadoNegativo() {
        ScannerMock scannerMock = new ScannerMock("-5\n");
        boolean resultado = CalculadoraGeometrica.calcularCubo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCubo_LadoCero() {
        ScannerMock scannerMock = new ScannerMock("0\n");
        boolean resultado = CalculadoraGeometrica.calcularCubo(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCono_RadioNegativo() {
        ScannerMock scannerMock = new ScannerMock("-5\n5\n");
        boolean resultado = CalculadoraGeometrica.calcularCono(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCono_AlturaNegativa() {
        ScannerMock scannerMock = new ScannerMock("5\n-5\n");
        boolean resultado = CalculadoraGeometrica.calcularCono(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCono_RadioCero() {
        ScannerMock scannerMock = new ScannerMock("0\n5\n");
        boolean resultado = CalculadoraGeometrica.calcularCono(scannerMock.getScanner());
        assertFalse(resultado);
    }

    @Test
    public void calcularCono_AlturaCero() {
        ScannerMock scannerMock = new ScannerMock("5\n0\n");
        boolean resultado = CalculadoraGeometrica.calcularCono(scannerMock.getScanner());
        assertFalse(resultado);
    }

    private static class ScannerMock {
        private Scanner scanner;

        ScannerMock(String input) {
            scanner = new Scanner(input);
        }

        Scanner getScanner() {
            return scanner;
        }
    }
}

