package com.studentapp.api.v1.students;

import com.studentapp.application.students.StudentDto;
import com.studentapp.application.students.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return studentDtos.stream()
                          .map(StudentResponse::fromDto)
                          .toList();
    }

    @PostMapping
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        StudentDto studentDto = studentService.addStudent(studentRequest.toDto());
        return StudentResponse.fromDto(studentDto);
    }
}
