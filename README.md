# EcoSmart API

Esta é uma API WebMVC para gerenciar clientes e gerar dicas e recomendações de como reduzir o consumo de energia. chamada EcoSmart.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Flyway
- Spring Security
- Spring AI
## Funcionalidades

- CRUD (Create, Read, Update, Delete) de clientes
- Geração de recomendações de consumo energético para clientes

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/0Romero/EcoSmart
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd ecosmart
   ```

3. Execute o projeto usando Maven:

   ```bash
   mvn spring-boot:run
   ```

## API Key 

- Para a funcionalidade do projeto é obrigatória uma chave API da OpenAI. 
- Adcionar sua chave no application.properties do projeto.
