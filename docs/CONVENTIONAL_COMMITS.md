# Guia de Conventional Commits — Aula 09 (IQS)

Este documento atende à **Tarefa de Encerramento da Aula 09**: *"Estudar Conventional Commits"* e aplicar a especificação nos commits do repositório.

---

## 1. O que é o Conventional Commits?

O **Conventional Commits** (v1.0.0) é uma convenção leve sobre mensagens de commit que estabelece um conjunto explícito de regras para criar um histórico de versionamento legível, padronizado e automatizável (geração automática de `CHANGELOG.md` e cálculo de versões **SemVer**).

### Formato Padrão

```text
<tipo>[escopo opcional]: <descrição curta no imperativo>

[corpo opcional detalhando o contexto e motivação]

[rodapé(s) opcional(is), ex: Refs #123, BREAKING CHANGE: ...]
```

---

## 2. Principais Tipos de Commit

| Tipo | Finalidade | Impacto SemVer | Exemplo neste Repositório |
| :--- | :--- | :---: | :--- |
| `feat` | Nova funcionalidade para o usuário/sistema | `MINOR` (`1.x.0`) | `feat(notificacoes): implementa versao inicial de NotificacaoService` |
| `fix` | Correção de bug em produção ou desenvolvimento | `PATCH` (`1.0.x`) | `fix(header): corrige NullPointerException ao receber header nulo` |
| `refactor` | Refatoração sem alterar comportamento externo nem corrigir bug direto | — | `refactor(calculadora): trata divisao por zero conforme code review do PR #123` |
| `test` | Adição ou ajuste em testes automatizados | — | `test(ci): simula teste quebrado para validar falha na GitHub Action de PR` |
| `docs` | Alterações exclusivas de documentação (`README`, Javadoc, guias) | — | `docs: documenta fluxo completo da Aula 09 e guia de Conventional Commits` |
| `ci` | Mudanças em pipelines de CI/CD (`.github/workflows/`) | — | `ci(javadoc): adiciona workflow para geracao automatica de Javadoc` |
| `chore` | Tarefas de manutenção, build, dependências ou preparação de release | — | `chore(release): prepara versao v1.0.0` |
| `style` | Formatação, indentação, ponto e vírgula (sem mudança de lógica) | — | `style: padroniza indentacao com 4 espacos` |
| `perf` | Melhoria específica de desempenho | `PATCH` | `perf(notificacoes): pre-compila Pattern de regex de email` |

---

## 3. Breaking Changes (Mudanças Quebradoras)

Mudanças incompatíveis com a API pública anterior disparam incremento `MAJOR` (`x.0.0`) no Versionamento Semântico e podem ser indicadas de duas formas:

1. **Sinal `!` após o tipo/escopo:**
   ```text
   feat(auth)!: altera retorno de autenticar para objeto TokenSessao
   ```
2. **Rodapé `BREAKING CHANGE:`:**
   ```text
   feat(auth): altera contrato do servico de autenticacao

   BREAKING CHANGE: o metodo autenticar agora exige autenticacao multifator.
   ```

---

## 4. Boas Práticas Aplicadas na Aula 09

1. **Verbo no imperativo / presente:** use `"adiciona"`, `"corrige"`, `"trata"`, `"configura"` (em vez de `"adicionado"` ou `"corrigindo"`).
2. **Primeira linha concisa (até ~72 caracteres):** facilita leitura em `git log --oneline` e na aba de Pull Requests do GitHub.
3. **Commits atômicos:** cada commit representa uma única mudança lógica coesa, facilitando `git revert`, `git bisect` e o **Code Review**.
4. **Integração com Git Flow:**
   - Branches `feature/*` concentram commits `feat`, `refactor` e `test`.
   - Branches `hotfix/*` concentram commits `fix` e `test`.
   - Branches `release/*` concentram commits `chore(release)` e `docs`.
