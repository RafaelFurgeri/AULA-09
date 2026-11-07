package br.edu.iqs.aula09;

/**
 * Utilitário para leitura e normalização segura de cabeçalhos HTTP.
 */
public class HeaderUtils {

    /**
     * Construtor padrão do utilitário de cabeçalhos.
     */
    public HeaderUtils() {
    }

    /**
     * Normaliza o valor de um cabeçalho HTTP removendo espaços nas extremidades.
     * Retorna string vazia caso o cabeçalho seja {@code null} (correção hotfix/header-null).
     *
     * @param headerValor valor bruto do cabeçalho (pode ser {@code null})
     * @return valor normalizado ou string vazia se {@code null}
     */
    public String normalizarHeader(String headerValor) {
        if (headerValor == null) {
            return "";
        }
        return headerValor.trim();
    }
}
