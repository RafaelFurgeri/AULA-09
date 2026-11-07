package br.edu.iqs.aula09;

// Implementação inicial (Dev 1) com falhas propositais para revisão no Desafio Colaborativo
public class NotificacaoService {

    public boolean enviarEmail(String email) {
        // Erro 1: NullPointerException se email for null
        // Erro 2: Regex permissiva demais (aceita "@@" ou domínio sem TLD)
        if (!email.matches(".+@.+")) {
            return false;
        }
        return true;
    }
}
