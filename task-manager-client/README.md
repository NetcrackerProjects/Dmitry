# Менеджер задач клиент

## Используемые технологии
* Java (1.8.0_192)
* Maven (3.6.0)

## Структура прокета
    * [api]
        * [controller]
    * [command]
        * [help]
        * [project]
        * [task]
        * [user]
    * [controller]
    * [entity]
    * [error]
        * [command]
    * [util]

## Сборка проекта
    mvn clean install

## Запуск
    java -jar ./target/taskmanagerclient/bin/task-manager-client.jar

## Учетные записи по умолчанию
    [Логин]     [Пароль]
    admin       admin
    test        test
