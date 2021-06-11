package com.map.restAPI.controller;

import com.map.restAPI.dao.StudentDao;
import com.map.restAPI.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        System.err.println("get all : ");
        List<Student> studentList= studentDao.findAll();
        System.err.println("studentList : " + studentList.size());
        return new ResponseEntity<>(studentList, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        System.err.println("find by id : " + id);
        Student student= studentDao.findById(id).orElse(null);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student response= studentDao.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student response= studentDao.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        Student student = studentDao.findById(id).orElse(null);
        studentDao.delete(student);
        return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
    }
}
