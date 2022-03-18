# Escopo e objetivo
Projeto é um desafio proposto pela Empresa Docket para vaga de Desenvolvedor Java Junior.

## Utilização da API...
- A aplicação pode ser iniciada pelo / ou por um /home.

> http://localhost:8080

## Como executar...
Este aplicativo é empacotado como um war que possui o Tomcat 8 incorporado. Nenhuma instalação do Tomcat ou JBoss é necessária. 

Você o executa usando o java -jarcomando.
- Verifique se você está usando o JDK 1.8 e o Maven 3.x
- Clonar este repositório com o comando:
> git clone https://github.com/MBeuaK/Desafio-Maxima-Tech.git
- Rodar o script dump.sql para criar a estrutura do banco de dados e fazer um carga inicial:
> Atenção: O script se encontra na pasta: src -> main -> resource -> dump.sql
- Execute o comando:
> java -jar equiplano-0.0.1-SNAPSHOT.war

## Tecnologias...
- Java 8;
- Spring Boot;
- Banco de dados MySQL;
- Arquitetura de microserviço;
- API RESTFull;
- Swagger API V2;
- Teste unitário - JUnit 5;
- Thymeleaf
