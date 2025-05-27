# Microsserviço de Usuários (ms-usuarios)

Este microsserviço é responsável pela gestão de usuários no sistema de gerenciamento de biblioteca.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Gradle**
- **PostgreSQL**
- **Docker** e **Docker Compose**
- **Swagger** para documentação da API

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://adoptium.net/)
- [Gradle](https://gradle.org/)

## Configuração e Execução

### Executar com Docker

1. Clone o repositório:
   ```bash
   git clone https://github.com/luizfilipebp/ms-usuarios.git
   cd ms-usuarios
   ```
2. Construa e inicie o container:

```bash
docker build -t ms-usuarios .
docker run -p 8083:8080 ms-usuarios
```

## Executar Localmente
1. Configure o banco de dados PostgreSQL:
- Crie um banco de dados chamado usuarios.
- Configure o usuário e senha no arquivo application.yml.

2. Compile e execute o projeto:

```bash
./gradlew :infrastructure:bootRun
```

3. Acesse o microsserviço em: http://localhost:8083


## Documentação da API
A documentação da API está disponível via Swagger em:
http://localhost:8083/swagger-ui.html

## Variáveis de Ambiente
- SPRING_DATASOURCE_URL: URL de conexão com o banco de dados.
- SPRING_DATASOURCE_USERNAME: Usuário do banco de dados.
- SPRING_DATASOURCE_PASSWORD: Senha do banco de dados.

## Arquitetura Limpa

O microsserviço segue os princípios da **Arquitetura Limpa**, com as seguintes camadas:

- **Camada Core**: Contém as regras de negócio e entidades do domínio, isoladas de dependências externas.
- **Camada Application**: Orquestra os casos de uso e interage com a camada Core.
- **Camada UseCase**: Representa os casos de uso do sistema, encapsulando a lógica de aplicação e garantindo a execução correta das regras de negócio.
- **Camada Infrastructure**: Implementa detalhes como configurações, banco de dados e integrações externas.

## Estrutura do Projeto
```
ms-livros/
├── application/          # Código principal do microsserviço (casos de uso)
├── core/                 # Regras de negócio e entidades do domínio
├── usecase/              # Interfaces e abstrações do domínio
├── infrastructure/       # Configurações e integrações
├── Dockerfile            # Configuração do container Docker
└── README.md             # Documentação do microsserviço
```
