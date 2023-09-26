package com.studentapp.domain.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentsDomainService {

    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsDomainService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    /**
     * Check if the given student's name and address are unique.
     * 
     * @param student The student entity to check.
     * @return true if the student's name and address are unique, false otherwise.
     */
    public boolean isStudentUnique(Student student) {
        Optional<Student> existingStudent = studentsRepository.findByStudentNameAndAddress(student.getStudentName(), student.getAddress());
        return existingStudent.isEmpty() || existingStudent.get().getId().equals(student.getId());
    }
}
