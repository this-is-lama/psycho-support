# PsychoSupport - Сервис психологической поддержки

Простое веб-приложение, предоставляющее случайные сообщения психологической поддержки с возможностью добавления новых сообщений.

## Технологии
- Java 8
- Servlet API 4.0
- Apache Tomcat 9
- Maven
- Docker

## Функциональность
- GET `/help-service/v1/support` - получение случайного сообщения поддержки
- POST `/help-service/v1/support` - добавление нового сообщения (параметр `message`)

## Установка и запуск

### Требования
- JDK 8+
- Apache Maven
- Docker (опционально)

### Сборка и запуск

1. **Сборка проекта:**
   ```bash
   mvn clean package
   ```

2. **Запуск в Docker:**
   ```bash
   docker-compose up
   ```

3. **Доступ к приложению:**
   После запуска приложение будет доступно по адресу:
      ```
      http://localhost:8080/psychosupport-1.0-SNAPSHOT/help-service/v1/support
      ```

### Ручное развертывание в Tomcat
1. Скопируйте `target/psychosupport-1.0-SNAPSHOT.war` в директорию `webapps` вашего сервера Tomcat
2. Запустите Tomcat

## Примеры запросов

**Получить случайное сообщение:**
```bash
curl http://localhost:8080/psychosupport-1.0-SNAPSHOT/help-service/v1/support
```

**Добавить новое сообщение:**
```bash
curl -X POST -d "message=Ваше новое сообщение поддержки" http://localhost:8080/psychosupport-1.0-SNAPSHOT/help-service/v1/support
```

## Структура проекта
```
src/
├── main/
│   ├── java/my/project/psychosupport/
│   │   ├── HelpRepository.java   # Хранилище сообщений
│   │   ├── HelpService.java      # Бизнес-логика
│   │   └── HelpServlet.java      # Сервлет обработки запросов
│   └── webapp/WEB-INF/
│       └── web.xml               # Конфигурация развертывания
pom.xml                           # Конфигурация Maven
docker-compose.yml                # Конфигурация Docker
```
