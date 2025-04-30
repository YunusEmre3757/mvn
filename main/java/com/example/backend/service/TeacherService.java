package com.example.backend.service;

import com.example.backend.model.Teacher;
import com.example.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher teacherDetails) {
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    existingTeacher.setName(teacherDetails.getName());
                    existingTeacher.setSurname(teacherDetails.getSurname());
                    existingTeacher.setDepartment(teacherDetails.getDepartment());
                    return teacherRepository.save(existingTeacher);
                });
    }

    public boolean deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 