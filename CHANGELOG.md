# Changelog

Todas as mudanças relevantes deste projeto são documentadas neste arquivo, seguindo boas práticas de versionamento semântico e Git Flow.

## [1.0.1] - 2026-11-07
### Corrigido
- `HeaderUtils`: corrige `NullPointerException` quando o cabeçalho HTTP recebido é `null` (`hotfix/header-null`).

## [1.0.0] - 2026-11-07
### Adicionado
- Estrutura inicial Maven (Java 17 + JUnit 5 + JaCoCo + Javadoc).
- Workflows de integração contínua (`.github/workflows/pr-validation.yml` e `.github/workflows/javadoc.yml`).
- `LoginService` com validação de senha forte e autenticação (`feature/login`).
- `HeaderUtils` para normalização de cabeçalhos HTTP.
