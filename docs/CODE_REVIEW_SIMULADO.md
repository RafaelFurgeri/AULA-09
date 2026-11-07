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
