package com.example.practice.controllers;

import com.example.practice.entities.StudentScore;
import com.example.practice.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-scores")
public class StudentScoreController {

    @Autowired
    private StudentScoreService studentScoreService;

    @GetMapping
    public ResponseEntity<List<StudentScore>> getAllStudentScores() {
        List<StudentScore> studentScores = studentScoreService.getAllStudentScores();
        return ResponseEntity.ok(studentScores);
    }
    @PostMapping
    public ResponseEntity<StudentScore> createStudentScore(@RequestBody StudentScore studentScore) {
        StudentScore createdStudentScore = studentScoreService.createStudentScore(studentScore);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudentScore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentScore> updateStudentScore(@PathVariable Long id, @RequestBody StudentScore studentScore) {
        StudentScore updatedStudentScore = studentScoreService.updateStudentScore(id, studentScore);
        if (updatedStudentScore != null) {
            return ResponseEntity.ok(updatedStudentScore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentScore(@PathVariable Long id) {
        studentScoreService.deleteStudentScore(id);
        return ResponseEntity.noContent().build();
    }
}

