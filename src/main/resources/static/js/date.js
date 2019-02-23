var now = new Date();
var curr_day = now.getDay();
var curr_month = now.getMonth();
var curr_year = now.getFullYear();
var day_of_week = ["(Воскресенье)", "(Понедельник)", "(Вторник)", "(Среда)", "(Четверг)", "(Пятница)", "(Суббота)"][new Date().getDay()];
document.write(curr_day + "." + curr_month + "." + curr_year + " " + day_of_week);