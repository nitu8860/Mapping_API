package com.example.Mapping_API.service;

import com.example.Mapping_API.model.Student;
import com.example.Mapping_API.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
            existingStudent.setBranch(updatedStudent.getBranch());
            existingStudent.setDepartment(updatedStudent.getDepartment());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    public boolean deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
            return true;
        } else {
            return false;
        }
    }
}
