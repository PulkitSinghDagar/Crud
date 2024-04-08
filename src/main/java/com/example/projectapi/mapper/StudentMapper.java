package com.example.projectapi.mapper;

import com.example.projectapi.dto.StudentDto;
import com.example.projectapi.entity.Student;

public class StudentMapper {


    public static StudentDto maptoStudentDto(Student student, StudentDto studentDto){
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        studentDto.setSex(student.getSex());
        studentDto.setKycStatus(student.getKycStatus());
        return studentDto;

    }
    public static Student maptoStudent(StudentDto studentDto, Student student){
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setSex(studentDto.getSex());
        student.setKycStatus(studentDto.getKycStatus());
        return student;
    }

}
