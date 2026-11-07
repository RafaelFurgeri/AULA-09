package br.edu.iqs.aula09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderUtilsTest {

    @Test
    void deveNormalizarHeaderRemovendoEspacosExtras() {
        HeaderUtils utils = new HeaderUtils();
        assertEquals("Bearer abc123", utils.normalizarHeader("  Bearer abc123  "));
    }

    @Test
    void deveRetornarVazioQuandoHeaderForNulo() {
        HeaderUtils utils = new HeaderUtils();
        assertEquals("", utils.normalizarHeader(null));
    }
}
