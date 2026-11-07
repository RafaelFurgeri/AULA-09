package br.edu.iqs.aula09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void deveDividirDoisNumerosCorretamente() {
        assertEquals(5, calculadora.divide(10, 2));
        assertEquals(-4, calculadora.divide(-12, 3));
    }

    @Test
    void deveLancarArithmeticExceptionComMensagemClaraAoDividirPorZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculadora.divide(10, 0)
        );
        assertEquals("Divisor não pode ser zero", exception.getMessage());
    }

    @Test
    void deveSomarDoisNumerosCorretamente() {
        assertEquals(15, calculadora.somar(7, 8));
    }
}
