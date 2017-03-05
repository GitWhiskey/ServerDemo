/**
 * Created by Maxon on 24.02.2017.
 */
$(document).ready(function () {

    var findingButton = $("#find-users");
    var addButton = $("#addDog");
    var input = $("#search-input");
    var action = true;

    function recognize() {
        window.ya.speechkit.settings.apikey = 'c4936434-79dd-4fd4-9edf-86c25699c967';
        ya.speechkit.recognize({
            // Функция будет вызвана, когда распознавание завершится.
            doneCallback: function(text) {
                if (text!="")
                    input.val(text);
                console.log("Финальный результат распознавания: " + text);
            },
            // Функция вызовется, как только сессия будет инициализирована.
            initCallback: function () {
                input.focus();
                console.log("Процесс распознавания запущен.");
            },
            // Вызывается в случае возникновения ошибки.
            errorCallback: function(err) {
                console.log("Возникла ошибка: " + err);
            },
            // Длительность промежутка тишины, при наступлении которой
            // распознавание завершается.
            utteranceSilence: 5
        });
    }

    // Привязка кнопки enter & ctrl к нажатию на кнопку
    input.keypress(function (event) {
        if (event.keyCode == 13) {
            findingButton.click();
        }
    });

    // Привязка кнопки ctrl к нажатию на кнопку
    input.keydown(function(eventObject){
        if ((eventObject.which == 17)&&(action === true)) {
            action = false;
            recognize();
        }
    });

    input.keyup(function(eventObject){
        if (eventObject.which == 17) {
            action = true;
        }
    });
    
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

    //Функция добавления нового пользователя
    function addUser(){
        var dogName = $("#addName").val();
        var dogLogin = $("#addUserName").val();
        var dogDate = $("#addBirthDay").val();

        if ((dogName != "") && (dogLogin != "") && (dogDate != "")) {
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