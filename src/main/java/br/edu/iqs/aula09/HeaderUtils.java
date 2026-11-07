package br.edu.iqs.aula09;

/**
 * Utilitário para leitura e normalização de cabeçalhos HTTP.
 */
public class HeaderUtils {

    /**
     * Construtor padrão do utilitário de cabeçalhos.
     */
    public HeaderUtils() {
    }

    /**
     * Normaliza o valor de um cabeçalho HTTP removendo espaços nas extremidades.
     *
     * @param headerValor valor bruto do cabeçalho
     * @return valor normalizado
     */
    public String normalizarHeader(String headerValor) {
        return headerValor.trim();
    }
}
