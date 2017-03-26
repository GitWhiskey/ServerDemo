/**
 * Created by Maxon on 24.02.2017.
 */
$(document).ready(function () {

    var findingButton = $("#find-users");
    var addButton = $("#addDog");
    var input = $("#search-input");

    input.keypress(function (event) {
        if (event.keyCode === 13) {
            findingButton.click();
        }
    });
    
    $("#addName").on("keypress",(function(event) {
        if (event.keyCode === 13) {
            addUser();
        }
    }));

    $("#addUserName").on("keypress",(function(event) {
        if (event.keyCode === 13) {
            addUser();
        }
    }));

    $("#addBirthDay").on("keypress",(function(event) {
        if (event.keyCode === 13) {
            addUser();
        }
    }));

    //Функция добавления нового пользователя
    function addUser(){
        var dogName = $("#addName").val();
        var dogLogin = $("#addUserName").val();
        var dogDate = $("#addBirthDay").val();

        if ((dogName !== "") && (dogLogin !== "") && (dogDate !== "")) {
            $("#user-list").load("UserList/add?userName=" + dogName + "&userPass=" + dogLogin +
                "&userDate="+ dogDate + "&userLogin=" + dogLogin);
            $("#addName").val("");
            $("#addUserName").val("");
            $("#addBirthDay").val("");
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