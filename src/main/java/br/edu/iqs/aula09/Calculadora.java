package br.edu.iqs.aula09;

/**
 * Calculadora aritmética revisada e refatorada na Atividade 3 (Code Review Simulado).
 */
public class Calculadora {

    /**
     * Construtor padrão da calculadora.
     */
    public Calculadora() {
    }

    /**
     * Realiza a divisão inteira entre dois números, validando explicitamente divisor zero (Fail Fast).
     *
     * @param a dividendo
     * @param b divisor (não pode ser zero)
     * @return quociente inteiro da divisão {@code a / b}
     * @throws ArithmeticException caso {@code b == 0}
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisor não pode ser zero"); // Fail fast
        }
        return a / b;
    }

    /**
     * Realiza a soma entre dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return resultado de {@code a + b}
     */
    public int somar(int a, int b) {
        return a + b;
    }
}
