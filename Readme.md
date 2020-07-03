[![Build Status](https://travis-ci.org/baratrumus/toDoList.svg?branch=master)](https://travis-ci.org/baratrumus/cinema)

#### To do List application.

It's simple notepad with ability to check work as done.
Application have plain interface and one page index.html. 
User can add new task,  change state of any task as done.
And use filter checkbox to show only done tasks.
All requests use AJAX. 
 


#### Technologies
* Servlets
* PostgreSQL, Hibernate
* JSP, HTML, CSS, Bootstrap, Javascript, JQuery, JSON, Ajax
* SL4J, LOG4J
* Travis CI
* Maven and plugins checkstyle, webapp-runner


![Main screen](https://github.com/baratrumus/toDoList/raw/master/ReadMePic/todo.JPG)

TO DO:
remove busy list and just block busy places



~~~~Разработан простой веб сайт для покупки билетов в кинотеатр.
Начальная страница сайта hall.html. 
На ней показан зал c 3 рядами.

Данные на hall.html загружаются с помощью Ajax через сервлет HallServlet. 
Внизу страницы отображаются занятые места. Информация подгружается через базу.
Страница  обновляется периодически через timeout.



После выбора места происходит переход на страницу оплаты pay.html. 
Пользователь видит место и сумму, вводит имя и телефон. 
Если место еще свободно, происходит резервирование места.
Данные обрабатываются с помощью Ajax через сервлет OrderServlet. 

Есть три слоя. 
Controller представлен классом CinemaController
Service - логика описана в вышеуказанных сервлетах
Работа с Persistence слоем описана в пакете cinema.data. 
В Persistence используется jdbc. Записи делаются атомарно. 
Пакет cinema.models - модели. 
 
 
 