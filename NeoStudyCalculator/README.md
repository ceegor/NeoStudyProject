# Vacation Pay Calculator

Микросервис для расчёта суммы отпускных выплат сотруднику.

Реализован в рамках тестового задания.

---

## Технологии

- Java 11
- Spring Boot 2.7.x
- Maven
- JUnit 5
- MockMvc
- REST API

---

## Функциональность

Приложение предоставляет 1 REST endpoint:

### GET /calculate

Поддерживаются **2 режима расчёта**:

---

### Режим 1 — по количеству дней

**Параметры:**
- `averageSalary` — средняя зарплата за 12 месяцев
- `vacationDays` — количество дней отпуска

**Пример запроса:**

http://localhost:8080/calculate?averageSalary=60000&vacationDays=10

**Ответ:**
```json
{
  "amount": 20477.82,
  "payableDays": 10
}
```

### Режим 2 — по датам

**Учитываются:**
- `выходные(сб/вс)`
- `праздники`

**Параметры:**
- `averageSalary` — средняя зарплата за 12 месяцев
- `startDate` (yyyy-MM-dd)
- `endDate` (yyyy-MM-dd)

**Пример запроса:**

http://localhost:8080/calculate?averageSalary=60000&startDate=2026-05-04&endDate=2026-05-08

**Ответ:**
```json
{
"amount": 10238.91,
"payableDays": 5
}
```

### Формула расчёта
**Среднедневной заработок:**

averageSalary / 29.3

**Сумма отпускных:**

daily * payableDays

**Округление:**

HALF_UP, 2 знака после запятой

### Обработка ошибок
**Единый формат ошибок:**
```json
{
  "code": "VALIDATION_ERROR",
  "message": "Validation failed",
  "violations": [
    {
      "field": "averageSalary",
      "message": "must not be null"
    }
  ]
}
```

## Запуск проекта
**Сборка и тесты:**

mvn clean test

**Запуск сервера:**

mvn spring-boot:run

### Тестирование

**Покрыто:**
- `unit тесты бизнес-логики`
- `web тесты контроллера (MockMvc)`
- `валидация параметров`

**Запуск:**

mvn test

## Автор

Легуенко Егор

Java



