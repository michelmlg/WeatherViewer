# Etapa 1: Builder com Maven
FROM maven:3.8.1-openjdk-11 AS builder
WORKDIR /usr/src/app

# Copiar o arquivo pom.xml para baixar dependências
COPY pom.xml .

# Baixar as dependências do Maven em modo offline
RUN mvn dependency:go-offline -B

# Copiar o restante do projeto para a imagem
COPY . .

# Compilar o projeto e empacotar o WAR
RUN mvn clean package -DskipTests

# Etapa 2: Deploy com Tomcat
FROM tomcat:9.0.74-jdk11

RUN apt-get update && apt-get install -y maven && apt-get clean

WORKDIR /usr/local/tomcat/webapps/

# Copiar o WAR gerado na etapa de build
COPY --from=builder /usr/src/app/target/*.war ./ROOT.war

# Expor a porta padrão do Tomcat
EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]
