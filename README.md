# 📚 План обучения: Spring Boot Full-Stack Backend

> ⏱️ Программа на ~10 дней по 1 часу в день

| День | Задача                                                                                                  | Время |
|------|---------------------------------------------------------------------------------------------------------|-------|
| 1    | Инициализация проекта: Spring Boot, зависимости и skeleton приложения                                    | 1 ч   |
| 2    | Настройка Postgres: UserEntity, репозиторий, JPA-конфиг + миграции (Flyway)                              | 1 ч   |
| 3    | Контроллер `/auth/login`: Basic → Redis-токен (TokenCacheService)                                        | 1 ч   |
| 4    | MongoDB: модель `TaskDocument`, репозиторий, подключение в `application.yml`                             | 1 ч   |
| 5    | CRUD-методы в `TodoService` + эндпоинты `/tasks` (без Elasticsearch)                                     | 1 ч   |
| 6    | Настройка Elasticsearch: TaskIndex, репозиторий, mapping + коннектор                                     | 1 ч   |
| 7    | Интеграция Elasticsearch в создание/обновление/удаление задачи (индексация)                             | 1 ч   |
| 8    | Эндпоинт `/tasks/search`: multi-match + фильтры по тегам/статусу                                         | 1 ч   |
| 9    | Эндпоинт `/tasks/stats`: агрегации в Elasticsearch (count by status, top-tags)                           | 1 ч   |
| 10   | Тесты и рефакторинг: unit + интеграционные тесты (MongoDB, Elasticsearch, Redis)                         | 1 ч   |

---

## ✨ Цели курса
- Изучить полную интеграцию Spring Boot с PostgreSQL, MongoDB, Redis и Elasticsearch.
- Реализовать аутентификацию через Redis-токены.
- Научиться проектировать и индексировать данные в Elasticsearch.
- Освоить написание unit- и интеграционных тестов.

---

## ⚙️ Предварительные требования
- Java 17+
- Spring Boot 3.x
- Maven или Gradle
- PostgreSQL
- MongoDB
- Redis
- Elasticsearch
- Docker (опционально для локального запуска всех сервисов)

---

## 📌 Рекомендации
- Используйте Flyway для миграций базы данных.
- Следите за чистой архитектурой (Service, Repository, Controller).
- Пишите тесты с использованием Spring Boot Test, Testcontainers (для БД).
- Для Elasticsearch рекомендуется клиент Spring Data Elasticsearch 5.x+.

---

## 💡 Примерные ссылки
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [Spring Data Redis](https://spring.io/projects/spring-data-redis)
- [Spring Data Elasticsearch](https://spring.io/projects/spring-data-elasticsearch)
- [Flyway](https://flywaydb.org/documentation/)

