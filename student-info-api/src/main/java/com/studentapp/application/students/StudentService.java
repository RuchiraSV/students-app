package com.studentapp.application.students;

import com.studentapp.domain.students.Student;
import com.studentapp.domain.students.StudentsDomainService;
import com.studentapp.domain.students.StudentsRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentsRepository studentsRepository;
    private final StudentsDomainService sstudentsDomainService;

    // Add a new student
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = studentDto.toEntity(new Student());

        // Check if student is unique based on name and address before saving
        if (!sstudentsDomainService.isStudentUnique(student)) {
            throw new IllegalArgumentException("A student with the same name and address already exists.");
        }

        student = studentsRepository.save(student);
        return StudentDto.fromEntity(student);
    }

    // Get all students
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentsRepository.findAll();
        return students.stream()
                .map(StudentDto::fromEntity)
                .toList();
    }
}
