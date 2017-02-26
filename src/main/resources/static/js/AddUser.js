/**
 * Created by VAIO on 25.02.2017.
 */
$(document).ready(function () {
    var addDog = $("#addDogToModel");
    
    addDog.click(function (e) {
        e.preventDefault();
        var dogName = $("#userName").val();
        var dogLogin = $("#userLogin").val();
        var dogDate = $("#dateBrth").val();
        var dogPass = $("#userPass").val();

        if ((dogName != "") && (dogLogin != "") && (dogDate != "") && (dogPass != "")) {
            $("#user-list").load("UserList/add?userName=" + dogName + "&userPass=" + dogPass +
                "&userDate="+ dogDate + "&userLogin=" + dogLogin);
        }
        else {
            alert("Пустого пса нельзя добавить!");
        }
    });
});