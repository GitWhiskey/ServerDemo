/**
 * Created by Maxon on 24.02.2017.
 */
$(document).ready(function () {

    var findingButton = $("#find-users");
    var addButton = $("#addDog");
    // Привязка кнопки enter к нажатию на кнопку
    $("#search-input").keypress(function (event) {
        if (event.keyCode == 13) {
            findingButton.click();
        }
    });


    //TODO Эта срань обрабатывает события только первый раз при загрузке страницы
    $("#addName").on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));

    $("#addUserName").on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));

    $("#addBirthDay").on("keypress",(function(event) {
        if (event.keyCode == 13) {
            addUser();
        }
    }));


    // updateBind();
    //
    // function updateBind() {
    //
    //     $("#addName").keypress(function (event) {
    //         if (event.keyCode == 13) {
    //             addUser();
    //         }
    //     });
    //
    //     $("#addUserName").keypress(function (event) {
    //         if (event.keyCode == 13) {
    //             addUser();
    //         }
    //     });
    //
    //     $("#addBirthDay").keypress(function (event) {
    //         if (event.keyCode == 13) {
    //             addUser();
    //         }
    //     });
    // }


    //Функция добавления нового пользователя
    function addUser(){
        var dogName = $("#addName").val();
        var dogLogin = $("#addUserName").val();
        var dogDate = $("#addBirthDay").val();

        if ((dogName != "") && (dogLogin != "") && (dogDate != "")) {
            $("#user-list").load("UserList/add?userName=" + dogName + "&userPass=" + dogLogin +
                "&userDate="+ dogDate + "&userLogin=" + dogLogin);
        }
        else {
            alert("Пустого пса нельзя добавить!");
        }
    }

    findingButton.click(function () {
        var username =  $("#search-input").val();
        $("#user-list").load("UserList/find?username=" + username);
    });

    addButton.click(function () {
        $("#addDogForm").load("UserList/AddUser");
    });
});