# 🎲 Toy API - Cadastro de Brinquedos

API RESTful desenvolvida com Spring Boot para gerenciamento de brinquedos. Permite operações de **criação**, **listagem**, **atualização**, **exclusão** e **detalhamento** de brinquedos cadastrados no banco de dados.

---

## 📦 Funcionalidades

- ✅ Cadastrar um brinquedo
- 🔍 Listar todos os brinquedos com paginação
- ✏️ Atualizar um brinquedo existente
- ❌ Deletar brinquedo por ID
- 🔎 Buscar brinquedo por ID

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Bean Validation (Jakarta)
- Lombok
- Banco de Dados (Oracle SQL)
- Maven

---

## 🔗 Endpoints

### ▶️ POST `/toys` - Cadastrar brinquedo

- **Request body (JSON):**

```json
{
  "name": "Detetive",
  "type": "Board Game",
  "classification": "+8",
  "size": "LARGE",
  "price": 79.9
}
```

- **Possíveis valores para `size`:**
  - `SMALL`
  - `MEDIUM`
  - `LARGE`
  - `EXTRA_LARGE`

---

### 📄 GET `/toys` - Listar brinquedos

- Com paginação e ordenação por nome:
  ```
  GET /toys?page=0&size=10&sort=name
  ```

---

### 🔍 GET `/toys/{id}` - Buscar brinquedo por ID

---

### ✏️ PUT `/toys` - Atualizar brinquedo

```json
{
  "id": 1,
  "name": "Jogo da Vida",
  "type": "Board Game",
  "classification": "+10",
  "size": "MEDIUM",
  "price": 99.9
}
```

---

### ❌ DELETE `/toys/{id}` - Deletar brinquedo por ID

---

## ✅ Validações

- `name`, `type` e `classification` não podem estar vazios ou nulos.
- `size` deve ser informado com um dos valores válidos.
- `price` deve ser um número com até 2 casas decimais, e não pode ser nulo.

---

## 📂 Estrutura do Projeto

```
src/
├── controller
│   └── ToyController.java
├── dto
│   ├── ToyDTO.java
│   └── ToyDetailsDTO.java
├── entity
│   ├── Toy.java
│   └── ToySize.java
├── repository
│   └── ToyRepository.java
```
