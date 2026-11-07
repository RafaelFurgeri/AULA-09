package br.edu.iqs.aula09;

import java.util.regex.Pattern;

/**
 * Serviço de autenticação e validação de senhas da funcionalidade de login (Atividade 1).
 */
public class LoginService {

    private static final Pattern SENHA_FORTE_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"
    );

    /**
     * Construtor padrão do serviço de login.
     */
    public LoginService() {
    }

    /**
     * Valida se uma senha atende aos requisitos mínimos de segurança:
     * pelo menos 8 caracteres, uma letra maiúscula, uma minúscula e um dígito.
     *
     * @param senha senha a ser validada
     * @return {@code true} se a senha for válida; {@code false} caso contrário
     */
    public boolean validarSenha(String senha) {
        if (senha == null) {
            return false;
        }
        return SENHA_FORTE_PATTERN.matcher(senha).matches();
    }

    /**
     * Autentica um usuário verificando se o identificador e a senha são válidos.
     *
     * @param usuario nome de usuário
     * @param senha senha do usuário
     * @return {@code true} se usuário e senha forem válidos; {@code false} caso contrário
     */
    public boolean autenticar(String usuario, String senha) {
        if (usuario == null || usuario.isBlank()) {
            return false;
        }
        return validarSenha(senha);
    }
}
