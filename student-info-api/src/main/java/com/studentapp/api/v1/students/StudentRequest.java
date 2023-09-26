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
public class StudentRequest {
    private String studentName;
    private int studentAge;
    private String address;

    public StudentDto toDto() {
        return StudentDto.builder()
                .studentName(studentName)
                .studentAge(studentAge)
                .address(address)
                .build();
    }
}
