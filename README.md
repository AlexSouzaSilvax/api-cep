# API Cep 
Consulta de CEP e Gerenciamento de Endereços

Desafio técnico para vaga FullStack Jr na Solution TI.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Swagger 3**
- **PostgreSQL**
- **Docker**
- **Render**
- **Trello**

## Hospedagem

- **API**: [Render](https://api-cep-6e3z.onrender.com)
- **Banco de Dados**: [Supabase](https://supabase.com/)

## Metodologia de Desenvolvimento

Estamos utilizando metodologias ágeis para o desenvolvimento dessa api, especificamente o Kanban. Você pode acompanhar o progresso do projeto no nosso quadro do Trello: [Solution Trello Board](https://trello.com/b/3O8SKX6c/solution).

## Funcionalidades

- Consulta de CEP à base de dados do ViaCEP.
- Cadastro de Usuários com endereços.
- Gerenciamento de Usuários e endereços.
- Documentação da API com Swagger.

## Documentação da API

A documentação da API está disponível através do Swagger na seguinte URL: `https://api-cep-6e3z.onrender.com/swagger-ui.html`

## Executar o Projeto


```bash
# executar
    mvn spring-boot:run
```

## Subir para hub.docker.com

```bash
    docker login
```

```bash
    docker build -t api-cep:latest .
```

```bash
    docker tag api-cep:latest seu-usuario-docker/api-cep:latest
```

```bash
    docker push seu-usuario-docker/api-cep:latest
```

## Deploy no Render

 - Acessar painel dashboard do [Render](https://dashboard.render.com/web/srv-ctvjpulds78s73emk8gg/logs) 
 - Manual Deploy --> Deploy latest reference

## Contribuição

Se você deseja contribuir com este projeto, sinta-se à vontade para abrir um pull request ou relatar um problema.

## Contato

Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.

Email: alexsouzasilvax@gmail.com

---

_Este projeto foi criado para apresentar como teste técnico à uma vaga de desenvolvedor fullsatck jr._
