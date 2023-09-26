package com.studentapp.domain.students;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentsRepository {

    private final List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        student.setId(generateId());  // assuming there's a method to generate unique IDs
        students.add(student);
        return student;
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findById(String id) {
        return students.stream()
                       .filter(student -> student.getId().equals(id))
                       .findFirst();
    }

    public Optional<Student> findByStudentNameAndAddress(String studentName, String address) {
        return students.stream()
                .filter(student -> student.getStudentName().equals(studentName) && student.getAddress().equals(address))
                .findFirst();
    }

    private String generateId() {
        // A simple ID generation logic (not ideal for real-world scenarios)
        return String.valueOf(students.size() + 1);
    }
}
