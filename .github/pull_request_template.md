## Descrição das Alterações

Descreva de forma objetiva o que este Pull Request implementa, corrige ou refatora.

### Branch de Origem / Tipo
- [ ] `feature/*` — Nova funcionalidade
- [ ] `hotfix/*` — Correção urgente em produção
- [ ] `release/*` — Preparação de versão
- [ ] `refactor/*` / `docs/*` — Melhoria de código ou documentação

---

## Checklist de Code Review Eficaz (Aula 09 - IQS)

- [ ] **Funcionalidade implementada conforme requisitos**
- [ ] **Código legível e com boas práticas** (tratamento adequado de exceções e entradas nulas)
- [ ] **Testes unitários e cobertura adequada** (100% de cobertura JaCoCo nas novas classes)
- [ ] **Documentação atualizada** (Javadoc e README/docs atualizados)

---

## Como Testar

```bash
mvn clean verify
mvn javadoc:javadoc
```
