
# Base do projeto:

**Full Stack Side Project Starter**
Kickstart your full stack side-project with a Java Spring web server, Postgres database and Vue.js multi-container setup.
[Link do repositório](https://github.com/sxflynn/sideprojectstarter)

Utilizando esse como base, alterei o funcionamento do backend para utilizar Java SE 11 ao invés de Java Spring. Fiz essa mudança por estar estudando as classes dessa versão do Java.

Com essa mudança a arquitetura do projeto ficou assim:

Frontend: Vue.js(versão 3)
Servidor web: Tomcat 9.0.74 (openjdk11, Java SE 11) 
Banco de dados: PostgreSQL

Endpoints:
- Frontend - http://localhost:5173/
- Backend - http://localhost:8089/
- PostgreSQL - localhost:5433

### Pré-requisitos
1. Docker: Certifique-se de ter o Docker instalado em sua máquina.
Caso precise de ajuda para instalar, consulte a documentação oficial do Docker.

2. Conta no WeatherAPI: Crie uma conta gratuita em WeatherAPI, pois será necessária para acessar os dados climáticos.

## Instruções para o uso:

1. Criar um arquivo `.env` com base no arquivo de exemplo.

2. Iniciar os containers
  ```
  docker-compose up -d --build
  ```

3. Pronto!


