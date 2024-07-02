package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() > countMaxId) {
                countMaxId = teacher.getTeacherId();
            }
        }
        countMaxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth);
        teacher.setTeacherId(countMaxId);
        teachers.add(teacher);
    }

    public void update(Long teacherId, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId().equals(teacherId)) {
                teacher.setFirstName(firstName);
                teacher.setSecondName(secondName);
                teacher.setPatronymic(patronymic);
                teacher.setDateOfBirth(dateOfBirth);
                return;
            }
        }
        throw new IllegalArgumentException("Teacher not found with ID: " + teacherId);
    }
}

