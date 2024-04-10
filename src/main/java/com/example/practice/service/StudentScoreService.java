package com.example.practice.service;

import com.example.practice.entities.StudentScore;
import com.example.practice.respositories.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentScoreService {

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public List<StudentScore> getAllStudentScores() {
        return studentScoreRepository.findAll();
    }

    public Optional<StudentScore> getStudentScoreById(Long id) {
        return studentScoreRepository.findById(id);
    }

    public StudentScore createStudentScore(StudentScore studentScore) {
        return studentScoreRepository.save(studentScore);
    }

    public StudentScore updateStudentScore(Long id, StudentScore studentScore) {
        if (studentScoreRepository.existsById(id)) {
            studentScore.setStudentScoreId(id);
            return studentScoreRepository.save(studentScore);
        }
        return null; // Or throw an exception
    }

    public void deleteStudentScore(Long id) {
        studentScoreRepository.deleteById(id);
    }
}

