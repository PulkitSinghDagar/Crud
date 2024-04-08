package com.example.projectapi.service;

import com.example.projectapi.dto.StudentDto;

public interface IStudentService {


    void createAccount(StudentDto studentDto);

    StudentDto fetchStudent(String name);



    public boolean updateStudentKYCStatus(String name, String newKycStatus);


    boolean deleteStudent(String name);
}
