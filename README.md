# Projeto Teste — API de Clima

Esse projeto foi feito para eu estudar mais sobre o RestClient.

API REST desenvolvida com Spring Boot que recebe latitude e longitude e consulta as condições climáticas atuais na OpenWeather Current Weather API.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web MVC
- Spring `RestClient`
- Maven

## Configuração

A aplicação precisa de uma chave da OpenWeather. No arquivo `src/main/resources/application.properties`, configure a chave por variável de ambiente:

```properties
spring.application.name=projetoteste
openweather.api-key=${OPENWEATHER_API_KEY}
```

No PowerShell, defina a variável antes de iniciar a aplicação:

```powershell
$env:OPENWEATHER_API_KEY = "sua-chave-da-openweather"
```

Essa variável fica definida apenas para a sessão atual do terminal. Não publique a chave no GitHub.

## Executar

Na raiz do projeto, rode:

```powershell
.\mvnw.cmd spring-boot:run
```

Por padrão, a aplicação inicia na porta `8080`.

## Endpoint

### Consultar clima atual

```http
GET /weather?lat={latitude}&lon={longitude}
```

Exemplo para Londres:

```text
http://localhost:8080/weather?lat=51.5&lon=-0.1
```

A chave da OpenWeather é usada pelo backend e não precisa ser enviada na requisição ao endpoint `/weather`.

A resposta da OpenWeather é convertida para `WeatherResponseDTO`. A temperatura retornada usa Kelvin por padrão, salvo se a chamada for configurada com outra unidade.

## Testes

Para executar os testes:

```powershell
.\mvnw.cmd test
```

## Observações

- O serviço consulta `/data/2.5/weather` da OpenWeather.
- O acesso depende de uma chave válida e das condições e limites do plano da OpenWeather.
- Se a API externa retornar um erro, verifique a chave, o endpoint e o acesso habilitado na sua conta.
