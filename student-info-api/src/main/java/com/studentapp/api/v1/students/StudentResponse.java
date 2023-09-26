package com.studentapp.api.v1.students;

import com.studentapp.application.students.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private String studentName;
    private int studentAge;
    private String address;

    public static StudentResponse fromDto(StudentDto studentDto) {
        return StudentResponse.builder()
                .studentName(studentDto.getStudentName())
                .studentAge(studentDto.getStudentAge())
                .address(studentDto.getAddress())
                .build();
    }
}