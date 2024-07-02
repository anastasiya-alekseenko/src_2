package ru.gb.oseminar;

import ru.gb.oseminar.controller.TeacherController;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TeacherController teacherController = new TeacherController();

        teacherController.create("Ivan", "Ivanov", "Ivanovich", LocalDate.of(1980, 1, 15));
        teacherController.create("Petr", "Petrov", "Petrovich", LocalDate.of(1975, 3, 22));
        teacherController.create("Sidor", "Sidorov", "Sidorovich", LocalDate.of(1985, 5, 30));

        teacherController.getAllTeachers();

        teacherController.updateTeacher(1L, "Ivan", "Ivanov", "Sergeevich", LocalDate.of(1980, 1, 15));

        teacherController.getAllTeachers();
    }
}

