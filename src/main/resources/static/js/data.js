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
    $.getJSON("entity/lesson", {lastName: $("#lessonByTeacher").val()}, function (data) {
        alert(data.name);
    });
}

function findNearestLesson() {
    $.getJSON("entity/lesson/nearest", {name: $("#nearestLesson").val()}, function (data) {
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
    $.get("entity/teacher/save", {
        firstName: $("#teacherFirstName").val(),
        lastName: $("#teacherLastName").val()
    }, function (data) {
        alert(data.toLocaleString());
    });
    refreshTeacherButton('#selectTeacher');
    refreshTeacherButton('#selectTeacher2');
}

function addLesson() {
    $.get("entity/lesson/save", {
        teacherName: $("#selectTeacher").val(),
        lessonName: $("#lessonName").val(),
        type: $("#type").val()
    }, function (data) {
        alert(data.toLocaleString())
    });
}

function addSchedule() {
    $.get("entity/schedule/save", {
        even: $("#evenWeek").val(),
        teacherName: $("#selectTeacher2").val(),
        type: $("#scheduleLessonType").val(),
        dayOfWeek: $("#lessonDayOfWeek").val(),
        pairOrder: $("#pairOrder").val()
    }, function (data) {
        alert(data.toLocaleString())
    });
}

function deleteTeacher() {
    var conBox = confirm("Вы уверенны?");
    if (conBox) {
        var teacherLastName = $("#deleteTeacher").val();
        $.get("entity/teacher/" + teacherLastName + "/remove", {teacherName: teacherLastName}, function (data) {
            refreshTeacherButton('#selectTeacher');
            refreshTeacherButton('#selectTeacher2');
            alert(data.toLocaleString())
        });
    } else {
        alert("Преподаватель остался в базе")
    }
}

function refreshTypeButton() {
    $('#scheduleSelectTypeDiv').empty().append('<select id="scheduleLessonType"><option style="display:none">null</option></select>');
    $.getJSON("entity/lesson/select", {lastName: $('#selectTeacher2').val()}, function (data) {
        data.forEach(function (lesson) {
            $('#scheduleLessonType').append('<option>' + lesson.type + '</option>')
        })
    })

}

function refreshTeacherButton(selectTeacher) {
    $.getJSON("entity/teacher/select", function (data) {
        $(selectTeacher).empty();
        $(selectTeacher).append('<select id=' + selectTeacher + ' ><option style="display:none"></option></select>');
        data.forEach(function (teacher) {
            $(selectTeacher).append('<option>' + teacher.lastName + '</option>')
        })
    })
}

function parsingSchedule() {
    $.getJSON("entity/schedule", function (data) {
        data.forEach(function (schedule) {
            $('#scheduleTable' + schedule.day + ' > tbody:last-child').append('<tr><td>' + schedule.pairOrder + '</td>' +
                '<td>' + schedule.lesson.name + '</td><td>' + schedule.lesson.type + '</td><td>' + schedule.lesson.teacher.lastName + '</td></tr>');
            document.getElementById("scheduleTable" + schedule.day).style.display = "initial";
        })
    })
}

function showAllSchedule() {
    document.getElementById("fullScheduleTables").style.display ="initial";
    document.getElementById("showButton").style.display = "none";
    $.getJSON("entity/schedule/full", function (data) {
        data.forEach(function (schedule) {
            $('#fullScheduleTable' + schedule.day + ' > tbody:last-child').append('<tr><td>' + schedule.pairOrder + '</td>' +
                '<td>' + schedule.lesson.name + '</td><td>' + schedule.lesson.type + '</td><td>' + schedule.lesson.teacher.lastName + '</td></tr>');
            document.getElementById("fullScheduleTable" + schedule.day).style.display = "initial";
        })
    })
}
