/**
 * Created by Maxon on 24.02.2017.
 */
$(document).ready(function () {

    var findingButton = $("#find-users");
    // Привязка кнопки enter к нажатию на кнопку
    $("#search-input").keypress(function (event) {
        if (event.keyCode == 13) {
            findingButton.click();
        }
    });

    findingButton.click(function () {
        var username =  $("#search-input").val();
        $("#user-list").load("UserList/find?username=" + username);
    });
});