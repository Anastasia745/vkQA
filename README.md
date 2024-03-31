# Инструкция по запуску тестов
## Запуск всех тестов
```
mvn test
```
## Запуск группы тестов
Тесты для Chrome:
```
mvn test Dtest=ChromeSearchTest
```
Тесты для для Edge:
```
mvn test Dtest=EdgeSearchTest
```
Тесты для для Firefox:
```
mvn test Dtest=FirefoxSearchTest
```
## Запуск одного теста
```
mvn test Dtest=<Имя класса>#<Имя теста>
```
Например, выделение поискового запроса жирным шрифтом в браузере Chrome:
```
mvn test Dtest=ChromeSearchTest#boldFont
```
