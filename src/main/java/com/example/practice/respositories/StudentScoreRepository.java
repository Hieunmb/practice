package com.example.practice.respositories;

import com.example.practice.entities.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {

    @Query("SELECT s.studentId, s.fullName, sub.subjectName, ss.score1, ss.score2, sub.credit " +
            "FROM Student s " +
            "JOIN StudentScore ss ON s.studentId = ss.studentId " +
            "JOIN Subject sub ON ss.subjectId = sub.subjectId")
    List<Object[]> getStudentScores();
}


