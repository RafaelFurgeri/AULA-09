package br.edu.iqs.aula09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginServiceTest {

    private LoginService loginService;

    @BeforeEach
    void setUp() {
        loginService = new LoginService();
    }

    @Test
    void deveAceitarSenhaForteValida() {
        assertTrue(loginService.validarSenha("SenhaForte123"));
    }

    @Test
    void deveRejeitarSenhasInvalidasOuNulas() {
        assertFalse(loginService.validarSenha(null));
        assertFalse(loginService.validarSenha("Curta1"));
        assertFalse(loginService.validarSenha("semmaiuscula123"));
        assertFalse(loginService.validarSenha("SEMMINUSCULA123"));
        assertFalse(loginService.validarSenha("SemDigitoAlgum"));
    }

    @Test
    void deveAutenticarUsuarioComCredenciaisValidas() {
        assertTrue(loginService.autenticar("rafael.furgeri", "SenhaForte123"));
    }

    @Test
    void deveRejeitarAutenticacaoComUsuarioOuSenhaInvalidos() {
        assertFalse(loginService.autenticar(null, "SenhaForte123"));
        assertFalse(loginService.autenticar("   ", "SenhaForte123"));
        assertFalse(loginService.autenticar("rafael.furgeri", "fraca"));
    }
}
