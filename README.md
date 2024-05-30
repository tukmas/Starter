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
Заголовки запроса: {sec-fetch-mode=navigate, sec-fetch-site=none, accept-language=ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7, sec-fetch-user=?1, accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7, sec-ch-ua="Google Chrome";v="125", "Chromium";v="125", "Not.A/Brand";v="24", sec-ch-ua-mobile=?0, sec-ch-ua-platform="Windows", host=localhost:8080, upgrade-insecure-requests=1, connection=keep-alive, cache-control=max-age=0, accept-encoding=gzip, deflate, br, zstd, user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36, sec-fetch-dest=document}
Заголовки ответа: {Keep-Alive=timeout=60, Connection=keep-alive, Content-Length=37, Date=Thu, 30 May 2024 23:14:45 GMT, Content-Type=text/html;charset=UTF-8}
Время выполнения запроса: 73 мс
=========================================
   ```
**_Проект использует следующие технологии:_**
- Java 17
- Spring Framework
- Maven
