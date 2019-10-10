package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {

        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();

        Controller controller = new Controller();
        usersView.setController(controller);
        editUserView.setController( controller );

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView( editUserView );


        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm( 126L );

        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged( "Tom", 126L, 10 );
        usersView. fireEventShowDeletedUsers();

    }
}

/*  Всегда непонятно как делать непонятно что.

Чтобы не тратить время зря, поймите суть происходящего в модели MVC:
- есть база данных - лист User-ов (в задаче зачем-то разделена на 2 класса DataSource и UserDao)

- есть объект Model, который запрашивает из базы и хранит в своём листе часть User-ов.

    Также имеет CrUD-методы для работы с базой.
    Лист, хранящийся в Model, существует отдельно от базы.
    В нём хранятся копии объектов базы, а не ссылки на них.
    Все изменения. производимые в базе, ваша программа должна отражать в листе объекта Model.
    (в задаче Model разрастается до 2 интерфейсов и 4 классов)

- есть объекты View - что-то типа окна "список пользователей"
                              или окна "создание нового пользователя"
                              или окна "редактирование".
  Реагируют на действия пользователя - передают его команды Controller-у.

Также View отрисовывают на экране данные, полученные от Controller-а.
(в задаче окон и консольного ввода нет. Команды подаются из main.)

- есть Controller - "передаст" между View и Model (не может работать напрямую с базой! Доступ в базу только у Model).
Работает по схеме:
                  1) принял команду пользователя из View
                  2) передал её Model
                  3) отправил изменённые данные Model обратно во View для отрисовки на экране.*/