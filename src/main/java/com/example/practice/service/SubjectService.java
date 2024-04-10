package com.example.practice.service;

import com.example.practice.entities.Subject;
import com.example.practice.respositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject subject) {
        if (subjectRepository.existsById(id)) {
            subject.setSubjectId(id);
            return subjectRepository.save(subject);
        }
        return null; // Or throw an exception
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}

