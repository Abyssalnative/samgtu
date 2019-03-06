Date.prototype.getWeek = function () {
    var date = new Date(this.getTime());
    date.setHours(0, 0, 0, 0);
    date.setDate(date.getDate() + 3 - (date.getDay() + 6) % 7);
    var week1 = new Date(date.getFullYear(), 0, 4);
    return 1 + Math.round(((date.getTime() - week1.getTime()) / 86400000
        - 3 + (week1.getDay() + 6) % 7) / 7);
};

function currentDate() {
    let now = new Date();
    let curr_day = now.getDate();
    let curr_year = now.getFullYear();
    let even;
    if (now.getWeek() % 2 === 0) {
        even = "(Четная)"
    } else {
        even = "(Нечетная)"
    }
    let curr_month = ["Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"][new Date().getMonth()];
    let day_of_week = ["(Воскресенье)", "(Понедельник)", "(Вторник)", "(Среда)", "(Четверг)", "(Пятница)", "(Суббота)"][new Date().getDay()];
    document.write(curr_day + " " + curr_month + " " + curr_year + " " + day_of_week + " " + even);
}

function findLessonByTeacher() {
    $.getJSON("entity/lesson/current", {teacherId: $("#lessonByTeacher").val()}, function (data) {
        alert(data.name)
    });
}

function findNextLesson() {
    $.getJSON("entity/schedule/next", {lessonId: $("#nextLessonName").val()}, function (data) {
        console.log(data);
        var even;
        if (data.even === true) {
            even = "(Четная)";
        } else {
            even = "(Нечетная)";
        }
        switch (data.day) {
            case 1:
                alert("Понедельник" + even);
                break;
            case 2:
                alert("Вторник" + even);
                break;
            case 3:
                alert("Среда" + even);
                break;
            case 4:
                alert("Четверг" + even);
                break;
            case 5:
                alert("Пятница" + even);
                break;
            case 6:
                alert("Суббота" + even);
                break;
            default:
                alert("Воскресенье" + even);
                break;
        }
    })
}

function addTeacher() {
    $.post("entity/teacher", {
        firstName: $("#teacherFirstName").val(),
        lastName: $("#teacherLastName").val()
    }, function (data) {
        refreshAllTeacherButton();
        alert(data.toLocaleString());
    });

}

function addLesson() {
    $.post("entity/lesson", {
        teacherId: $('#selectTeacher').val(),
        lessonName: $('#lessonName').val(),
        type: $('#type').val()
    }, function (data) {
        alert(data.toLocaleString())
    });
}

function addSchedule() {
    $.post("entity/schedule", {
        lessonId: $('#scheduleSelectLesson').val(),
        even: $('#evenWeek').val(),
        day: $('#lessonDayOfWeek').val(),
        pairOrder: $('#pairOrder').val()
    }, function (data) {
        alert(data.toLocaleString())
    })
}

function deleteTeacher() {
    var conBox = confirm("Вы уверенны?");
    if (conBox) {
        $.ajax({
            type: "DELETE",
            url: "entity/teacher",
            data: {teacherId: $('#deleteTeacher').val()},
            success: function (data) {
                refreshAllTeacherButton();
                refreshNextLessonButton();
                refreshScheduleLessonButton();
                alert(data.toLocaleString());
            }
        })
    } else {
        alert("Преподаватель остался в базе")
    }
}

function refreshTeacherButton(selectTeacher) {
    $.getJSON("entity/teacher/select", function (data) {
        $(selectTeacher).empty().append('<option value="" selected disabled hidden>Выбрать</option>');
        data.forEach(function (teacher) {
            $(selectTeacher).append('<option value="' + teacher.id + '" >' + teacher.lastName + '</option>')
        });
    })
}

function refreshNextLessonButton() {
    $.getJSON("entity/lesson", {teacherId: $('#nextTeacher').val()}, function (data) {
        $('#nextLessonName').empty().append('<option value="" selected disabled hidden>Выбрать</option>');
        data.forEach(function (lesson) {
            $('#nextLessonName').append('<option value="' + lesson.id + '">' + lesson.name + '(' + lesson.type + ')' + '</option>')
        })
    })
}

function refreshScheduleLessonButton() {
    $.getJSON("entity/lesson", {teacherId: $('#scheduleSelectTeacher').val()}, function (data) {
        $('#scheduleSelectLesson').empty().append('<select id="scheduleSelectLesson" ><option value="" selected disabled hidden>Выбрать</option></select>');
        data.forEach(function (lesson) {
            $('#scheduleSelectLesson').append('<option value="' + lesson.id + '">' + lesson.name + '(' + lesson.type + ')' + '</option>')
        })
    })
}


function refreshAllTeacherButton() {
    refreshTeacherButton('#selectTeacher');
    refreshTeacherButton('#scheduleSelectTeacher');
    refreshTeacherButton('#lessonByTeacher');
    refreshTeacherButton('#deleteTeacher');
    refreshTeacherButton('#nextTeacher');
}

function parsingSchedule() {
    $.getJSON("entity/schedule", {current: true}, function (data) {
        data.forEach(function (schedule) {
            $('#scheduleTable' + schedule.day + ' > tbody:last-child').append('<tr><td>' + schedule.pairOrder + '</td>' +
                '<td>' + schedule.lesson.name + '</td><td>' + schedule.lesson.type + '</td><td>' + schedule.lesson.teacher.lastName + '</td></tr>');
            document.getElementById("scheduleTable" + schedule.day).style.display = "initial";
        })
    });
    $.getJSON("entity/schedule", {current: false}, function (data) {
        data.forEach(function (schedule) {
            $('#fullScheduleTable' + schedule.day + ' > tbody:last-child').append('<tr><td>' + schedule.pairOrder + '</td>' +
                '<td>' + schedule.lesson.name + '</td><td>' + schedule.lesson.type + '</td><td>' + schedule.lesson.teacher.lastName + '</td></tr>');
            document.getElementById("fullScheduleTable" + schedule.day).style.display = "initial";
        })
    })
}



