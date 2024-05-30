## Реализация Spring Boot Starter для логирования HTTP запросов

_**Инструкция по запуску:**_

1. Запуск Starter через IDE:
- скачать проект из репозитория;
- загрузить все зависимости;
- в консоле выполнить команду mvn clean install;

2. Открыть Ваше приложение на базе Spring Boot
- добавить Starter:
   ```
   <dependency>
            <groupId>com.example</groupId>
            <artifactId>http-logger-spring-boot-starter</artifactId>
            <version>1.0.0</version>
   </dependency>
   ```
- чтобы активировать логирование прописать в **application.properties** свойство:
   ```
   endpoint.logging.active=true
   ```
- выполнить запрос.

3. Логи будут выводиться в следующем формате: 
```
=========================================
Тип запроса: GET
URI эндпоинта: http://localhost:8080/
Статус: 200
Заголовки запроса: {sec-fetch-mode=navigate, sec-fetch-site=none, accept-language=ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7, sec-fetch-user=?1....}
Заголовки ответа: {Keep-Alive=timeout=60, Connection=keep-alive, Content-Length=37, Date=Thu, 30 May 2024 23:14:45 GMT, Content-Type=text/html;charset=UTF-8}
Время выполнения запроса: 73 мс

=========================================
 ```


_**Проект построен на базе Spring Boot и использует следующие технологии:**_
- Java 11
- Spring Framework
- Maven


