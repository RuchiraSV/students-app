package com.studentapp.application.students;

import com.studentapp.domain.students.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private String id;
    private String studentName;
    private int studentAge;
    private String address;

    // Convert Student entity to StudentDto
    public static StudentDto fromEntity(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .studentAge(student.getStudentAge())
                .address(student.getAddress())
                .build();
    }

    // Convert StudentDto to Student entity (usually used for updates)
    public Student toEntity(Student studentEntity) {
        studentEntity.setStudentName(this.studentName);
        studentEntity.setStudentAge(this.studentAge);
        studentEntity.setAddress(this.address);
        return studentEntity;
    }
}
