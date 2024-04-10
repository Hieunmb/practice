package com.example.practice.controllers;

import com.example.practice.dtos.StudentScoreDTO;
import com.example.practice.entities.Student;
import com.example.practice.respositories.StudentRespository;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class StudentController {

    @Autowired
    private StudentService employeeService;

    @GetMapping
    public List<Student> getAllProducts() {
        return employeeService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Student> getProductById(@PathVariable Long id) {
        return employeeService.getProductById(id);
    }

    @PostMapping
    public Student  createProduct(@RequestBody Student employee) {
        return employeeService.createProduct(employee);
    }

    @PutMapping("/{id}")
    public Student updateProduct(@PathVariable Long id, @RequestBody Student employee) {
        return employeeService.updateProduct(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        employeeService.deleteProduct(id);
    }
    @GetMapping("/students")
    public ResponseEntity<List<StudentScoreDTO>> getStudentScores() {
        List<StudentScoreDTO> studentScores = employeeService.getStudentScores();
        return ResponseEntity.ok(studentScores);
    }
}