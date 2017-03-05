/**
 * Created by VAIO on 25.02.2017.
 */
$(document).ready(function () {
    var name = $("#addName");
    var userName = $("#addUserName");
    var brthDay = $("#addBirthDay");


    name.on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));

    userName.on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));

    brthDay.on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));

    //Функция добавления нового пользователя
    function addUser(){
        var dogName = name.val();
        var dogLogin = userName.val();
        var dogDate = brthDay.val();

        if ((dogName != "") && (dogLogin != "") && (dogDate != "")) {
            $("#user-list").load("UserList/add?userName=" + dogName + "&userPass=" + dogLogin +
                "&userDate="+ dogDate + "&userLogin=" + dogLogin);
            name.val("");
            userName.val("");
            brthDay.val("");
        }
        else {
            alert("Пустого пса нельзя добавить!");
        }
    }
});