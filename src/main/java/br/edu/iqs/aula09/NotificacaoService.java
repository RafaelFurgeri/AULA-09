package br.edu.iqs.aula09;

import java.util.regex.Pattern;

/**
 * Serviço responsável pelo envio de notificações por e-mail com validação via expressão regular.
 */
public class NotificacaoService {

    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$"
    );

    /**
     * Construtor padrão do serviço de notificações.
     */
    public NotificacaoService() {
    }

    /**
     * Valida o formato de um endereço de e-mail por meio de expressão regular (Regex).
     *
     * @param email endereço de e-mail a validar
     * @return {@code true} se o formato for válido; {@code false} caso contrário
     */
    public boolean validarEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return EMAIL_REGEX.matcher(email.trim()).matches();
    }

    /**
     * Envia uma notificação padrão para o e-mail informado.
     *
     * @param destinatario endereço de e-mail do destinatário
     * @return confirmação textual do envio
     * @throws IllegalArgumentException caso o formato do e-mail seja inválido
     */
    public String enviarEmail(String destinatario) {
        return enviarEmail(destinatario, "Notificação padrão do sistema");
    }

    /**
     * Envia uma mensagem personalizada para o endereço de e-mail informado após validação.
     *
     * @param destinatario endereço de e-mail do destinatário
     * @param mensagem conteúdo da mensagem
     * @return confirmação textual do envio
     * @throws IllegalArgumentException caso o e-mail seja inválido ou a mensagem seja nula/vazia
     */
    public String enviarEmail(String destinatario, String mensagem) {
        if (!validarEmail(destinatario)) {
            throw new IllegalArgumentException("E-mail inválido: " + destinatario);
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("A mensagem não pode ser nula ou vazia");
        }
        return "E-mail enviado para " + destinatario.trim() + ": " + mensagem.trim();
    }
}
