package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.TeacherService;
import ru.gb.oseminar.view.TeacherView;

import java.time.LocalDate;
import java.util.List;

public class TeacherController implements UserController<Teacher> {

    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void updateTeacher(Long teacherId, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.update(teacherId, firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(teacherService.getAll());
    }

    public void getAllTeachers() {
        List<Teacher> teachers = teacherService.getAll();
        teacherView.sendOnConsole(teachers);
    }
}
