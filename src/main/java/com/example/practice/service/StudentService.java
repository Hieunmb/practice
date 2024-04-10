package com.example.practice.service;

import com.example.practice.dtos.StudentScoreDTO;
import com.example.practice.entities.Student;
import com.example.practice.entities.StudentScore;
import com.example.practice.respositories.StudentRespository;
import com.example.practice.respositories.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRespository employeeRepository;
    @Autowired
    private StudentScoreRepository studentScoreRepository;
    public List<Student> getAllProducts() {
        return employeeRepository.findAll();
    }

    public Optional<Student> getProductById(Long id) {
        return employeeRepository.findById(id);
    }

    public Student createProduct(Student employee) {
        return employeeRepository.save(employee);
    }

    public Student updateProduct(Long id, Student employee) {
        if (employeeRepository.existsById(id)) {
            employee.setStudentId(id);
            return employeeRepository.save(employee);
        }
        return null; // Or throw an exception
    }

    public void deleteProduct(Long id) {
        employeeRepository.deleteById(id);
    }
    public List<StudentScoreDTO> getStudentScores() {
        List<Object[]> result = studentScoreRepository.getStudentScores();
        List<StudentScoreDTO> studentScores = new ArrayList<>();

        for (Object[] obj : result) {
            StudentScoreDTO dto = new StudentScoreDTO();
            dto.setStudentId((Long) obj[0]);
            dto.setStudentName((String) obj[1]);
            dto.setSubjectName((String) obj[2]);
            dto.setScore1((Double) obj[3]);
            dto.setScore2((Double) obj[4]);
            dto.setCredit((Integer) obj[5]);
            dto.setGrade(calculateGrade((Double) obj[3], (Double) obj[4]));
            studentScores.add(dto);
        }

        return studentScores;
    }

    private String calculateGrade(double score1, double score2) {
        double grade = 0.3 * score1 + 0.7 * score2;
        if (grade >= 8.0)
            return "A";
        else if (grade >= 6.0)
            return "B";
        else if (grade >= 4.0)
            return "D";
        else
            return "F";
    }
}