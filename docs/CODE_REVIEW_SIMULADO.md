# Registro de Code Reviews Simulados — Aula 09 (IQS)

Este documento registra as revisões de código realizadas seguindo o **Modelo GitHub de Code Review Eficaz** (Atividade 3 e Desafio Colaborativo).

---

## 1. Atividade 3: Revisão do PR #123 (`feature/calculadora`)

### Código Original Submetido
```java
public class Calculadora {
    public int divide(int a, int b) {
        return a / b; // Falta tratamento explícito de divisão por zero!
    }
}
```

### Comentários de Revisão (Boas Práticas)
> **Revisor:** Em `Calculadora.java` (linha 5):  
> O método `divide(int a, int b)` não valida `b == 0` explicitamente, delegando uma falha genérica da JVM (`/ by zero`) sem mensagem de domínio em português e sem cobertura de testes unitários ou Javadoc.  
>
> **Sugestão de alteração (Fail Fast):**
> ```suggestion
>     public int divide(int a, int b) {
>         if (b == 0) {
>             throw new ArithmeticException("Divisor não pode ser zero");
>         }
>         return a / b;
>     }
> ```

### Avaliação do Checklist
- [x] Funcionalidade implementada conforme requisitos
- [x] Código legível e com boas práticas (`Fail Fast` com mensagem clara)
- [x] Testes unitários e cobertura adequada (`CalculadoraTest` com 100% no JaCoCo)
- [x] Documentação atualizada (Javadoc completo)

**Status:** Comentários resolvidos e PR aprovado para merge em `develop`.

---

## 2. Desafio Colaborativo: Revisão do PR #4 (`feature/notificacoes`)

### Fluxo Simulado
1. **Dev 1:** Criou a branch `feature/notificacoes` e implementou `NotificacaoService` com falhas intencionais (`email.matches(".+@.+")` sem tratamento de `null`, recompilando regex a cada chamada e aceitando domínios inválidos).
2. **Dev 2:** Abriu o Pull Request para `develop` e solicitou revisão.
3. **Dev 3 (Revisor):** Revisou e solicitou alterações específicas com snippets.

### Comentários de Revisão (Dev 3)
> **Dev 3 (Changes Requested):** Em `NotificacaoService.java`:
> 1. **Null Safety:** Chamar `email.matches(...)` diretamente causa `NullPointerException` quando `email == null`.
> 2. **Performance e Precisão da Regex:** Pré-compile `Pattern.compile(...)` em uma constante `private static final` exigindo usuário, domínio e TLD válido (`^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$`).
> 3. **Testes e Cobertura:** Adicionar `NotificacaoServiceTest` cobrindo cenários válidos e inválidos até atingir **100% de cobertura** (linhas e branches) no JaCoCo.

### Critérios de Sucesso Verificados
- [x] Todos os comentários de revisão resolvidos
- [x] Build passando (`mvn clean test`)
- [x] **100% de cobertura** para `NotificacaoService` validado automaticamente pelo `jacoco-maven-plugin`
- [x] Javadoc completo gerado sem alertas

**Status:** PR aprovado e integrado em `develop`.
