package br.edu.iqs.aula09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teste intencionalmente quebrado apenas na branch {@code test/pr-com-erro}
 * para demonstrar a GitHub Action "PR Validation" bloqueando um Pull Request com erro
 * (Atividade 2 - Página 3 da Aula 09).
 */
class FalhaSimuladaCiTest {

    @Test
    void deveFalharPropositalmenteParaValidarBloqueioDePullRequestNaAction() {
        Calculadora calc = new Calculadora();
        // Valor esperado incorreto de propósito para simular falha no pipeline de PR
        assertEquals(999, calc.somar(2, 2), "Falha intencional para demonstrar PR Validation falhando!");
    }
}
