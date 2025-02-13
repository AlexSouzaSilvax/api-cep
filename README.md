
# 📍 API Cep
_Consulta de CEP e Gerenciamento de Endereços._

<br>

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Swagger 3**
- **PostgreSQL**
- **Docker**
- **Render**
- **Trello**

<br>

## 🌐 Hospedagem

- **API**: <a href="https://api-cep-6e3z.onrender.com/swagger-ui/index.html" target="_blank">Acessar API</a>.
- **Banco de Dados**: [Supabase](https://supabase.com/)

<br>

## 📋 Metodologia de Desenvolvimento

Utilizamos metodologias ágeis para o desenvolvimento desta API, com foco no **Kanban**. Acompanhe o progresso do projeto no nosso quadro do Trello: <a href="https://trello.com/b/3O8SKX6c/solution" target="_blank">Trello Board</a>.

<br>

## 🔧 Funcionalidades

- 📍 Consulta de **CEP** à base de dados do <a href="https://viacep.com.br/" target="_blank">**ViaCEP**</a>.
- 📍 Cadastro de **Usuários** com **Endereços**.
- 📍 Gerenciamento de **Usuários** e **Endereços**.
- 📑 **Documentação da API** com Swagger.

<br>

## 📚 Documentação da API

A documentação completa da API está disponível via Swagger: <a href="https://api-cep-6e3z.onrender.com/swagger-ui.html" target="_blank">Documentação Swagger</a>.

<br>

# 🛠️ Como Rodar o Projeto

### 📌 **Pré-requisitos**
Certifique-se de ter instalado:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads) (opcional, caso precise clonar o repositório)

<br>

### 📂 **Clonar o Repositório**
Se ainda não clonou o projeto, execute:

```
git clone https://github.com/AlexSouzaSilvax/api-cep.git
```

```
cd api-cep
```

<br>

### ⚙️ **Configurar Variáveis de Ambiente**

Antes de rodar o projeto, configure as seguintes variáveis de ambiente:

```
CEP_DATABASE_URL=jdbc:postgresql://localhost:5432/postgres
```
```
CEP_DATABASE_USERNAME=seu_usuario
```
```
CEP_DATABASE_PASSWORD=sua_senha
```
```
URL_API_EXTERNO_VIA_CEP=https://viacep.com.br/ws/
```

### ⚙️ **Instalar Dependências**

Dentro da pasta do projeto, execute:
```
mvn clean install
```
ou, se quiser ignorar os testes:
```
mvn clean install -DskipTests
```

### 🛠️ Executar o Projeto

Para rodar a API localmente, use o seguinte comando:

```bash
    mvn clean install
```

```bash
    mvn spring-boot:run
```

### 🌐 **Acessar a Aplicação**
O projeto estará rodando em:

🔗 http://localhost:8080/swagger-ui/index.html

<br>

## 🚢 Deploy Docker Hub

1. Realize o login no Docker:

```bash
    docker login
```

2. Construa a imagem Docker:

```bash
    docker build -t api-cep:latest .
```

3. Marque a imagem com a tag desejada:

```bash
    docker tag api-cep:latest seu-usuario/api-cep:latest
```

4. Faça o push para o Docker Hub:

```bash
    docker push seu-usuario/api-cep:latest
```

<br>

## 🌍 Deploy no Render

1. Acesse o painel do Render: <a href="https://dashboard.render.com/web/srv-ctvjpulds78s73emk8gg" target="_blank">Dashboard Render</a>.
2. Clique em **Manual Deploy** → **Deploy latest reference**.

<br>

## 🤝 Contribuição

Se você deseja contribuir com este projeto, sinta-se à vontade para abrir um **pull request** ou **relatar um problema**.

<br>

## 💰 Apoie este Projeto

Se você gostou do projeto e gostaria de contribuir, faça uma doação via **Pix** 💠

<p align="center">
  <img width="400" height="auto" src="https://raw.githubusercontent.com/AlexSouzaSilvax/doacao-projetos-open-source/refs/heads/main/assets/qrcode-pix.jpg" alt="QR Code de Doação" />
</p>

```
00020126760014br.gov.bcb.pix0136a942ad44-c3f1-4694-b427-5561f0baea9b0214MUITO OBRIGADO5204000053039865802BR5919Alex Souza Da Silva6009Sao Paulo62280524DoacaoProjetosOpenSource6304CCA3
```

<br>

## 📩 Contato

Se tiver dúvidas ou sugestões, entre em contato pelo e-mail: [alexsouzasilvax@gmail.com](mailto:alexsouzasilvax@gmail.com).

<br>
<br>


_Este projeto foi criado para apresentar como teste técnico à uma vaga de desenvolvedor fullsatck jr._