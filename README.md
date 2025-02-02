# 🛠 Sistema de Gerenciamento de Clientes

## 📌 Descrição

Este projeto é um **sistema simples de gerenciamento de clientes**, desenvolvido em **Java** , permitindo a **adição, edição, atualização e exclusão de clientes** em uma base de dados.

## 🚀 Funcionalidades

- 📌 **Adicionar clientes** à base de dados.
- ✏ **Editar informações** de clientes cadastrados.
- 🔄 **Atualizar registros** existentes.
- ❌ **Remover clientes** do sistema.
- 📄 **Listar todos os clientes cadastrados**.

## 🖥️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot
- **Banco de Dados:** PostgreSQL / MySQL / H2 (dependendo da configuração)
- **Gerenciador de Dependências:** Maven
- **Ferramenta de Construção:** Spring Boot DevTools

## 📥 Como Utilizar

### Passo 1: Configurar o Ambiente

Antes de iniciar, certifique-se de ter instalado:
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL/MySQL](https://www.postgresql.org/download/) (caso utilize banco relacional)
- [Git](https://git-scm.com/)

### Passo 2: Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### Passo 3: Configurar o Banco de Dados

Atualize o arquivo `application.properties` conforme o banco de dados escolhido:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Passo 4: Executar o Projeto

```sh
mvn spring-boot:run
```

O servidor será iniciado em `http://localhost:8080`.

## 📡 Endpoints da API

### Criar um Cliente
```sh
POST /clientes
```
**Body:**
```json
{
  "nome": "João Silva",
  "email": "joao@email.com"
}
```

### Listar Clientes
```sh
GET /clientes
```

### Atualizar Cliente
```sh
PUT /clientes/{id}
```

### Deletar Cliente
```sh
DELETE /clientes/{id}
```

## ⚙ Possíveis Melhorias

- 📊 Implementação de interface gráfica com React ou Angular.
- 🔐 Controle de acesso com autenticação JWT.
- 📡 Integração com APIs externas.

## ⚠ Aviso Legal

Este projeto foi criado para fins educacionais e demonstração. O autor **não se responsabiliza** por qualquer uso indevido. O uso deve estar em conformidade com as leis e boas práticas de desenvolvimento de software.

---

📌 **Desenvolvido para aprendizado e otimização de processos** 🚀


