/**
 * Created by VAIO on 05.03.2017.
 */
$(document).ready(function () {
    var input = $("#search-input");
    var name = $("#addName");

    var action = true;


    //TODO: 05.03.2017 Унифицировать функцию для всех инпутов
    function recognize() {
        window.ya.speechkit.settings.apikey = 'c4936434-79dd-4fd4-9edf-86c25699c967';
        ya.speechkit.recognize({
            // Функция будет вызвана, когда распознавание завершится.
            doneCallback: function(text) {
                if (text!=="")
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

    function recognizeName() {
        window.ya.speechkit.settings.apikey = 'c4936434-79dd-4fd4-9edf-86c25699c967';
        ya.speechkit.recognize({
            // Функция будет вызвана, когда распознавание завершится.
            doneCallback: function(text) {
                if (text!=="")
                    name.val(text);
                console.log("Финальный результат распознавания: " + text);
            },
            // Функция вызовется, как только сессия будет инициализирована.
            initCallback: function () {
                name.focus();
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

    // Привязка кнопки ctrl к активированию поиска
    input.keydown(function(eventObject){
        if ((eventObject.which === 17)&&(action === true)) {
            action = false;
            recognize();
        }
    });

    input.keyup(function(eventObject){
        if (eventObject.which === 17) {
            action = true;
        }
    });

    // Привязка кнопки ctrl к вводу имени
    name.keydown(function(eventObject){
        if ((eventObject.which === 17)&&(action === true)) {
            action = false;
            recognizeName();
        }
    });

    name.keyup(function(eventObject){
        if (eventObject.which === 17) {
            action = true;
        }
    });
});