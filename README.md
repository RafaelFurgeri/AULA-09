# Aula 09 — Versionamento e Git Avançado (IQS)

[![PR Validation](https://github.com/RafaelFurgeri/AULA-09/actions/workflows/pr-validation.yml/badge.svg)](https://github.com/RafaelFurgeri/AULA-09/actions/workflows/pr-validation.yml)
[![Generate Javadoc](https://github.com/RafaelFurgeri/AULA-09/actions/workflows/javadoc.yml/badge.svg)](https://github.com/RafaelFurgeri/AULA-09/actions/workflows/javadoc.yml)

Projeto prático completo desenvolvido para a **Aula 09 — Versionamento e Git Avançado**, contemplando estratégias de branching com **Git Flow**, automação de pipelines CI/CD com **GitHub Actions**, boas práticas de **Code Review**, cobertura de testes de **100% com JaCoCo**, geração automatizada de **Javadoc** e padronização com **Conventional Commits**.

---

## Sumário das Entregas (PDF da Aula 09)

| Etapa da Aula | Entrega Implementada | Arquivos / Branches Principais |
| :--- | :--- | :--- |
| **Atividade 1: Git Flow na Prática** | Branch `feature/login` criada a partir de `develop`, commit `"Implementa validação de senha"` e merge em `develop` + `release/v1.0` | `LoginService.java`, `LoginServiceTest.java`, branch `feature/login`, `release/v1.0` |
| **Exercício (Atividade 1)** | Branch `hotfix/header-null` criada a partir de `main` corrigindo `NullPointerException` em cabeçalhos nulos, integrada em `main` (`v1.0.1`) e `develop` | `HeaderUtils.java`, `HeaderUtilsTest.java`, branch `hotfix/header-null` |
| **Atividade 2: GitHub Actions** | Workflow `PR Validation` com JDK 17 (`mvn clean test` + verificação JaCoCo 100%) e branch `test/pr-com-erro` pronta para testar falha em PR | `.github/workflows/pr-validation.yml`, branch `test/pr-com-erro` |
| **Atividade 3: Code Review Simulado** | Simulação do PR #123 na classe `Calculadora` (commit inicial sem tratamento -> refatoração *Fail Fast* tratando divisão por zero + testes) | `Calculadora.java`, `CalculadoraTest.java`, `docs/CODE_REVIEW_SIMULADO.md`, branch `feature/calculadora` |
| **Desafio Colaborativo** | Classe `NotificacaoService` com método `enviarEmail()`, validação de e-mail via Regex, revisão simulada e **100% de cobertura** (linhas e branches) | `NotificacaoService.java`, `NotificacaoServiceTest.java`, branch `feature/notificacoes` |
| **Tarefa 1 (Encerramento)** | Workflow GitHub Actions que gera o **Javadoc** automaticamente e publica o artefato HTML (`javadoc-apidocs`) | `.github/workflows/javadoc.yml` |
| **Tarefa 2 (Encerramento)** | Estudo e aplicação prática de **Conventional Commits** no histórico Git e guia dedicado | `docs/CONVENTIONAL_COMMITS.md` |

---

## Estrutura do Projeto

```text
AULA-09/
├── .github/
│   ├── pull_request_template.md       # Checklist oficial de Code Review Eficaz
│   └── workflows/
│       ├── pr-validation.yml          # Atividade 2: Build, Testes e Cobertura 100%
│       └── javadoc.yml                # Tarefa: Geração automática de Javadoc
├── docs/
│   ├── CODE_REVIEW_SIMULADO.md        # Registro dos Code Reviews (Atividade 3 e Desafio)
│   └── CONVENTIONAL_COMMITS.md        # Guia completo de Conventional Commits (Tarefa)
├── src/
│   ├── main/java/br/edu/iqs/aula09/
│   │   ├── Calculadora.java           # Atividade 3 (tratamento de divisão por zero)
│   │   ├── HeaderUtils.java           # Exercício Hotfix (tratamento de header nulo)
│   │   ├── LoginService.java          # Atividade 1 (validação de senha forte e login)
│   │   └── NotificacaoService.java    # Desafio Colaborativo (envio e regex de e-mail)
│   └── test/java/br/edu/iqs/aula09/
│       ├── CalculadoraTest.java
│       ├── HeaderUtilsTest.java
│       ├── LoginServiceTest.java
│       └── NotificacaoServiceTest.java
├── CHANGELOG.md
├── pom.xml                            # Java 17, JUnit 5, Surefire, JaCoCo (100%) e Javadoc
└── README.md
```

---

## Estratégia de Branching (Git Flow)

Todas as branches e tags do ciclo Git Flow foram versionadas e enviadas ao GitHub (visíveis em **Branches** e **Insights -> Network**):

- `main`: código estável de produção (tags `v1.0.0`, `v1.0.1`, `v1.1.0`).
- `develop`: branch de integração contínua de novas funcionalidades.
- `feature/login`: implementação de validação de senha e autenticação.
- `release/v1.0`: preparação da primeira entrega produtiva.
- `hotfix/header-null`: correção urgente criada a partir de `main` e integrada em `main` e `develop`.
- `feature/calculadora`: ciclo de código problemático -> revisão de código -> refatoração.
- `feature/notificacoes`: ciclo colaborativo do serviço de e-mail com Regex e 100% de cobertura.
- `release/v1.1`: consolidação de todas as funcionalidades, revisões e documentações para `main`.
- `test/pr-com-erro`: branch **não mergeada** contendo uma falha proposital de teste para demonstrar o bloqueio automático da GitHub Action `PR Validation` ao abrir um Pull Request.

---

## Configuração de Branch Protection e Teste de Falha (Atividade 2)

### 1. Configurar Regra de Proteção de Branch no GitHub
1. No repositório GitHub, acesse **Settings** -> **Branches** -> **Add branch ruleset** / **Add branch protection rule**.
2. Em **Branch name pattern**, informe `main` (e repita para `develop`, se desejar).
3. Marque **Require a pull request before merging**:
   - Ative **Require approvals** e selecione **2** revisores (conforme roteiro da aula; em repositórios individuais de estudo, você pode manter `1` ou permitir bypass do administrador para conseguir aprovar seus próprios PRs).
4. Marque **Require status checks to pass before merging**:
   - Busque e adicione o check **`build`** (do workflow `PR Validation`).
5. Clique em **Create** / **Save changes**.

### 2. Testar a GitHub Action Falhando em um PR
Para realizar o teste pedido na **Atividade 2** (*"Faça um PR com erro para ver a ação falhar"*):
1. Acesse a aba **Pull requests** -> **New pull request** no GitHub.
2. Selecione `base: develop` <- `compare: test/pr-com-erro`.
3. Crie o Pull Request: o workflow **PR Validation** será disparado automaticamente e **falhará** no passo `Build and Test`, demonstrando o bloqueio de código defeituoso antes do merge!

---

## Como Executar Localmente

Pré-requisitos: **JDK 17+** e **Apache Maven 3.8+**.

```bash
# 1. Executar compilação e todos os testes unitários
mvn clean test

# 2. Verificar 100% de cobertura de linhas e branches (JaCoCo)
mvn verify

# 3. Gerar documentação HTML Javadoc (saída em target/reports/apidocs/index.html)
mvn javadoc:javadoc
```
