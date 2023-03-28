package com.example.l45_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L45RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(L45RestApplication.class, args);
    }

    // HTTP 1/1 GET /store/book ?id=15

    /*

    GET     - READ
    POST    - CREATE
    PUT     - UPDATE
    DELETE  - DELETE

    /store/ios/travel
    1) Получение всего  GET /store/ios/travel
                        GET /store/ios
                        GET /store
    2) Получение конкретного    GET     /store/ios/travel/{5}, GET/store/ios/travel?id=5
    3) Сохранение объекта       POST    /store/ios/travel   {body}
    4) Обновить приложение      PUT     /store/ios/travel/{5}   {body}
    5) Удалить приложение       DELETE  /store/ios/travel/{5}
    6) Поиск по критериям       GET     /store/ios/travel?from12/01/2023&author=AngryBirds - не используется
    6) Поиск по критериям       POST    /store/ios/travel/search    {body}
    7) Удаление множества объектов за раз POST  /store/ios/travel/delete    {body} - очень редко
    8) Запустить ракету         POST    /nasa/{15}:start - редко

    User (id,login, description, age)

    PATCH
        {
            "description": {"action" : "update", "value" : "test}
        }

        - Безопастность         -   GET+,   POST-,  PUT-,   DELETE-,    PATCH-
        (свойство метода которое ничего не меняет на сервере, т.е. например не может получить ошибку)

        - Индемпатентность      -   GET+,   POST-,  PUT+,   DELETE+,    PATCH-
        (при PUT внутри выполняется сначало GET, а потом уже сам PUT этого объекта)
        (при PATCH он не проверят и не берет объект который мы хотим обновить и просто отправляем данные)
        (вызов один раз или неского раз одного и того же метода окажет одно и то же влияне на нашу систему)
     */

}
