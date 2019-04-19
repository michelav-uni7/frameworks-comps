## Exercício 1

Construir uma aplicação Java EE (apenas na camada Web) que lista os produtos disponíveis em uma 
loja online. Utilizaremos os recursos do CDI (Context and Dependecy Injection) para gerenciar 
os objetos de negócio da nossa aplicação.

### Pontos importantes

**1. Criar o projeto Maven**

```
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=uni7 -DartifactId=app-web
```

**2. Ajuste o empacotamento e as dependências de cada projeto**

O empacotamento do projeto é war e ele depende da API java ee web (javaee-web-api)

**4. Configure os plugins necessários**

* maven-war-plugin
* maven-compiler-plugin

**5. Uso do Docker**

Primeiramente você deve instalar o wrapper do maven como o comando abaixo:

```
mvn -N io.takari:maven:0.7.5:wrapper
```

Após isso, utilize a ideia de [multi-stage build](https://docs.docker.com/develop/develop-images/multistage-build/) 
para empacotar a aplicação em uma imagem executável.

Você pode criar suas próprias imagens-base ou utilizar algumas já prontas como a [michelav/wildfly](https://cloud.docker.com/repository/docker/michelav/wildfly).

Veja o [*Dockerfile* de exemplo](app-web/Dockerfile) disponível no próprio repositório.

### Execução

Você pode construir e executar a aplicação das seguintes formas:

* Utilizando o próprio ambiente do Eclipse, fazendo deploy no servidor disponível na IDE;
* Construindo e implantando via linha de comando e Maven;
* Construindo a imagem Docker e a executando:
	* ```docker build -t myapp .```
	* ```docker run -p 9990:9990 -p 8080:8080 myapp```