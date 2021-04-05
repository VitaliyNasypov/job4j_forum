# job4j_forum
[![Build Status](https://travis-ci.com/VitaliyNasypov/job4j_forum.svg?branch=master)](https://travis-ci.com/VitaliyNasypov/job4j_forum)
[![codecov](https://codecov.io/gh/VitaliyNasypov/job4j_forum/branch/master/graph/badge.svg)](https://codecov.io/gh/VitaliyNasypov/job4j_forum)
[![Heroku](https://heroku-badge.herokuapp.com/?app=heroku-badge)](https://frozen-mountain-05627.herokuapp.com)

 Классическое приложение форум, с использованием Spring Boot.

 Проект размещён на облачной PaaS-платформе [Heroku](https://frozen-mountain-05627.herokuapp.com).

 Краткое описание проекта:
- С помощью Spring Boot Security реализована регистрация и авторизация пользователей
- Пользователи могу создавать посты, и изменять только свои посты
- Пользователи могут просматривать посты и оставлять там комментарии
- Запросы к БД осуществлялись используя Spring Boot Data
- Данные хранятся в PostgreSQL, для тестов использовалась H2
- С помощью Liquibase происходило управление схемой БД
- Для тестирования использовался Spring Boot Test
- Использовался шаблон MVC

В данном проекте использовались:
- Java 11
- Spring Boot: Web, Security, Data, Test, Devtools
- JSP, JSTL, Bootstrap
- JaCoCo, Checkstyle
- PostgreSQL, H2, Liquibase
- Logback
- Apache Commons DBCP
- Lombok

Главная страница. На ней находятся все посты. Пользователи могут добавлять новые посты, просматривать существующие. Редактировать пост может только автор поста.
![](images/main.png)
Добавить новый пост.
![](images/new_post.png)
Изменить существующий пост. Доступна страница только автору данного поста.
![](images/edit.png)
Страница поста с комментариями. Комментарии могут добавлять все авторизованные пользователи.
![](images/view.png)
Регистрация.
![](images/sign_up.png)
Вход пользователя в свой аккаунт.
![](images/login.png)