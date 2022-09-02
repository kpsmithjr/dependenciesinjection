package org.generation.dependenciesinjection.controller;

import java.util.List;

import org.generation.dependenciesinjection.model.Student;
import org.generation.dependenciesinjection.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    Student findById(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    @GetMapping("/student")
    List<Student> getStudents() {
        return studentService.all();
    }

    @PostMapping("/student")
    void addStudent(@RequestBody Student student) {
        studentService.add(student);
    }

    @DeleteMapping("/student")
    void deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
    }
}
