package com.example.practice.respositories;

import com.example.practice.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRespository extends JpaRepository<Student,Long> {
}
