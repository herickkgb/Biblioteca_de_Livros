# README - Biblioteca de Livros API

## Visão Geral
A Biblioteca de Livros API é um sistema de gerenciamento de bibliotecas construído com Spring Boot em Java. Este sistema permite que os usuários gerenciem categorias de livros e informações de livros individuais.

## Endpoints da API

### Categorias
- **GET `/categorias`** - Lista todas as categorias.
- **GET `/categorias/{id}`** - Busca uma categoria por ID.
- **POST `/categorias`** - Cria uma nova categoria.
- **DELETE `/categorias/{id}`** - Exclui uma categoria por ID.
- **PUT `/categorias/{id}`** - Atualiza uma categoria existente.
Claro, aqui estão exemplos de saídas JSON para os métodos GET, GET ALL, POST e UPDATE em uma API REST que gerencia categorias de livros, como a Biblioteca de Livros.

### GET (Buscar uma Categoria por ID)
Quando você faz uma solicitação GET para buscar uma categoria específica por ID, por exemplo, com o ID 1, a saída será:

**Endpoint:** `GET /categorias/1`

```json
{
  "id": 1,
  "nome": "Informática",
  "descricao": "Livros de TI"
}
```

### GET ALL (Listar Todas as Categorias)
Para uma solicitação GET que lista todas as categorias, a saída poderia ser uma lista de objetos de categoria:

**Endpoint:** `GET /categorias`

```json
[
  {
    "id": 1,
    "nome": "Informática",
    "descricao": "Livros de TI"
  },
  {
    "id": 2,
    "nome": "Literatura",
    "descricao": "Livros de literatura clássica e moderna"
  }
  // ... mais categorias
]
```

### POST (Criar uma Nova Categoria)
Quando uma nova categoria é criada com uma solicitação POST, você geralmente envia um corpo de solicitação e a resposta inclui os detalhes da categoria criada, incluindo seu ID gerado:

**Endpoint:** `POST /categorias`

**Corpo da Solicitação:**
```json
{
  "nome": "Ciência",
  "descricao": "Livros de Ciência e Tecnologia"
}
```

**Resposta:**
```json
{
  "id": 3,
  "nome": "Ciência",
  "descricao": "Livros de Ciência e Tecnologia"
}
```

### UPDATE (Atualizar uma Categoria Existente)
Para atualizar uma categoria existente, você envia uma solicitação PUT com o ID da categoria e os detalhes atualizados. A resposta geralmente reflete a categoria após a atualização.

**Endpoint:** `PUT /categorias/1`

**Corpo da Solicitação:**
```json
{
  "nome": "Informática Avançada",
  "descricao": "Livros avançados de TI"
}
```

**Resposta:**
```json
{
  "id": 1,
  "nome": "Informática Avançada",
  "descricao": "Livros avançados de TI"
}
```

### Livros
- **GET `/livros`** - Lista todos os livros.
- **GET `/livros/{id}`** - Busca um livro por ID.
- **POST `/livros`** - Cria um novo livro.
- **DELETE `/livros/{id}`** - Exclui um livro por ID.
- **PUT `/livros/{id}`** - Atualiza um livro existente.

Claro, aqui estão exemplos de saídas JSON para os métodos GET, GET ALL, POST e UPDATE em uma API REST que gerencia livros, como a Biblioteca de Livros.

### GET (Buscar um Livro por ID)
Quando você faz uma solicitação GET para buscar um livro específico por ID, por exemplo, com o ID 1, a saída será:

**Endpoint:** `GET /livros/1`

```json
{
  "id": 1,
  "titulo": "Clean Code",
  "nomeAutor": "Robert Martin",
  "texto": "Lorem Ipsum"
}
```

### GET ALL (Listar Todos os Livros)
Para uma solicitação GET que lista todos os livros, a saída poderia ser uma lista de objetos livro:

**Endpoint:** `GET /livros`

```json
[
  {
    "id": 1,
    "titulo": "Clean Code",
    "nomeAutor": "Robert Martin",
    "texto": "Lorem Ipsum"
  },
  {
    "id": 2,
    "titulo": "Outro Livro",
    "nomeAutor": "Outro Autor",
    "texto": "Texto do outro livro"
  }
  // ... mais livros
]
```

### POST (Criar um Novo Livro)
Quando um novo livro é criado com uma solicitação POST, você geralmente envia um corpo de solicitação e a resposta inclui os detalhes do livro criado, incluindo seu ID gerado:

**Endpoint:** `POST /livros`

**Corpo da Solicitação:**
```json
{
  "titulo": "Novo Livro",
  "nomeAutor": "Novo Autor",
  "texto": "Texto do novo livro"
}
```

**Resposta:**
```json
{
  "id": 3,
  "titulo": "Novo Livro",
  "nomeAutor": "Novo Autor",
  "texto": "Texto do novo livro"
}
```

### UPDATE (Atualizar um Livro Existente)
Para atualizar um livro existente, você envia uma solicitação PUT com o ID do livro e os detalhes atualizados. A resposta geralmente reflete o livro após a atualização.

**Endpoint:** `PUT /livros/1`

**Corpo da Solicitação:**
```json
{
  "titulo": "Clean Code - Edição Atualizada",
  "nomeAutor": "Robert Martin",
  "texto": "Lorem Ipsum - conteúdo atualizado"
}
```

**Resposta:**
```json
{
  "id": 1,
  "titulo": "Clean Code - Edição Atualizada",
  "nomeAutor": "Robert Martin",
  "texto": "Lorem Ipsum - conteúdo atualizado"
}
```

## Configuração e Instalação
Para configurar e instalar a Biblioteca de Livros API, siga estas etapas:

1. Clone o repositório do projeto.
2. Importe o projeto para sua IDE preferida como um projeto Maven.
3. Certifique-se de que o Java JDK está instalado e configurado.
4. Configure o banco de dados (instruções a seguir).
5. Execute o projeto através da sua IDE ou use o comando `mvn spring-boot:run` no terminal.

## Configuração do Banco de Dados
A API utiliza um banco de dados para armazenar dados. Siga estas etapas para configurar o banco de dados:

1. Crie um banco de dados no seu SGBD preferido.
2. Atualize o arquivo `application.properties` do Spring com as informações do seu banco de dados (URL, usuário e senha).
3. Execute o projeto para que as tabelas sejam criadas automaticamente pelo Hibernate.

## Uso
Após iniciar a aplicação, você pode utilizar as funcionalidades da API acessando os endpoints definidos acima através de um cliente API como Postman ou cURL.

## Contribuições
Contribuições para a Biblioteca de Livros API são bem-vindas. Por favor, siga as diretrizes de contribuição disponíveis no repositório do projeto.

Para clonar o repositório da Biblioteca de Livros, você pode usar o seguinte comando no terminal ou no prompt de comando:

```bash
git clone https://github.com/herickkgb/Biblioteca_de_Livros.git
```

Este comando irá baixar o repositório para sua máquina local. Certifique-se de ter o Git instalado para poder executar este comando. Se você não tiver o Git instalado, pode baixá-lo e instalá-lo a partir do [site oficial do Git](https://git-scm.com/).
