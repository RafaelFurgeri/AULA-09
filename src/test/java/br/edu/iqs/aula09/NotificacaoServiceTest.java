package br.edu.iqs.aula09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificacaoServiceTest {

    private NotificacaoService service;

    @BeforeEach
    void setUp() {
        service = new NotificacaoService();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "rafael@iqs.edu.br",
            "usuario.teste+tag@empresa.com",
            "dev_01@sub.dominio.org",
            "  contato@exemplo.com  "
    })
    void deveValidarEmailsComFormatoCorreto(String emailValido) {
        assertTrue(service.validarEmail(emailValido));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "   ",
            "email-sem-arroba.com",
            "@dominio.com",
            "usuario@",
            "usuario@dominio",
            "usuario@@dominio.com",
            "usuario@dominio.c"
    })
    void deveRejeitarEmailsComFormatoInvalido(String emailInvalido) {
        assertFalse(service.validarEmail(emailInvalido));
    }

    @Test
    void deveRejeitarEmailNulo() {
        assertFalse(service.validarEmail(null));
    }

    @Test
    void deveEnviarEmailPadraoComSucesso() {
        String resposta = service.enviarEmail("rafael@iqs.edu.br");
        assertEquals("E-mail enviado para rafael@iqs.edu.br: Notificação padrão do sistema", resposta);
    }

    @Test
    void deveEnviarEmailPersonalizadoComSucesso() {
        String resposta = service.enviarEmail("  rafael@iqs.edu.br  ", "  Build aprovado!  ");
        assertEquals("E-mail enviado para rafael@iqs.edu.br: Build aprovado!", resposta);
    }

    @Test
    void deveLancarExcecaoAoEnviarParaEmailInvalidoOuNulo() {
        assertThrows(IllegalArgumentException.class, () -> service.enviarEmail("invalido@", "Olá"));
        assertThrows(IllegalArgumentException.class, () -> service.enviarEmail(null));
    }

    @Test
    void deveLancarExcecaoQuandoMensagemForNulaOuVazia() {
        assertThrows(IllegalArgumentException.class, () -> service.enviarEmail("rafael@iqs.edu.br", null));
        assertThrows(IllegalArgumentException.class, () -> service.enviarEmail("rafael@iqs.edu.br", "   "));
    }
}
