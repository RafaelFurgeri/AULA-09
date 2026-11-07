# Changelog

Todas as mudanças relevantes deste projeto são documentadas neste arquivo, seguindo boas práticas de versionamento semântico e Git Flow.

## [1.1.0] - 2026-11-07
### Adicionado
- `Calculadora`: operações aritméticas refatoradas pós-Code Review com tratamento explícito de divisão por zero (`feature/calculadora`).
- `NotificacaoService`: envio de e-mail com validação de formato por expressão regular e **100% de cobertura** de linhas e branches no JaCoCo (`feature/notificacoes`).
- `docs/CODE_REVIEW_SIMULADO.md`: registro detalhado das revisões de código (Atividade 3 e Desafio Colaborativo).
- `docs/CONVENTIONAL_COMMITS.md`: guia de estudo e referência de Conventional Commits (Tarefa da Aula 09).
- Documentação completa no `README.md`.

## [1.0.1] - 2026-11-07
### Corrigido
- `HeaderUtils`: corrige `NullPointerException` quando o cabeçalho HTTP recebido é `null` (`hotfix/header-null`).

## [1.0.0] - 2026-11-07
### Adicionado
- Estrutura inicial Maven (Java 17 + JUnit 5 + JaCoCo + Javadoc).
- Workflows de integração contínua (`.github/workflows/pr-validation.yml` e `.github/workflows/javadoc.yml`).
- `LoginService` com validação de senha forte e autenticação (`feature/login`).
- `HeaderUtils` para normalização de cabeçalhos HTTP.
