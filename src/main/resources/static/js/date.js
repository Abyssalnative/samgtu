let now = Date();
let curr_day = now.getDay();
let curr_month = now.getMonth();
let curr_year = now.getFullYear();
let day_of_week = ["(Воскресенье)", "(Понедельник)", "(Вторник)", "(Среда)", "(Четверг)", "(Пятница)", "(Суббота)"][new Date().getDay()];document.write(curr_day + "." + curr_month + "." + curr_year + " " + day_of_week);
