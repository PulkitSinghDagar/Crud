package com.example.projectapi.service.impl;


import com.example.projectapi.dto.StudentDto;
import com.example.projectapi.entity.Student;
import com.example.projectapi.exception.ResourceNotFoundException;
import com.example.projectapi.exception.StudentAlreadyExistException;
import com.example.projectapi.mapper.StudentMapper;
import com.example.projectapi.repository.StudentRepository;
import com.example.projectapi.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentserviceImpl implements IStudentService {


   private StudentRepository studentRepository;

    @Override
    public void createAccount(StudentDto studentDto) {
        Student student = StudentMapper.maptoStudent(studentDto, new Student());

      Optional<Student> optionalStudent= studentRepository.findByName(studentDto.getName());
        System.out.println(optionalStudent.toString());
        if(optionalStudent.isPresent()){
            throw  new StudentAlreadyExistException("Student of same Name Exist" + studentDto.getName());
        }
student.setCreatedAt(LocalDateTime.now());
        student.setCreatedBy("king");
        studentRepository.save(student);

    }

    @Override
    public StudentDto fetchStudent(String name) {
       Student student= studentRepository.findByName(name).orElseThrow(
                ()-> new ResourceNotFoundException("name")
        );
        StudentDto studentDto= StudentMapper.maptoStudentDto(student,new StudentDto());
        return studentDto;
    }


    @Override
    public boolean updateStudentKYCStatus(String name, String newKycStatus) {
        // Fetch the student from the database by name
        Student existingStudent = studentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with name: " + name));

        // Update the KYC status
        existingStudent.setKycStatus(newKycStatus);

        // Set updated information
       // existingStudent.setUpdatedAt(LocalDateTime.now());
        existingStudent.setUpdatedBy("admin");

        // Save the updated student to the database
        studentRepository.save(existingStudent);

        return true; // Indicating successful update
    }

    @Override
    public boolean deleteStudent(String name) {
        // Fetch the student from the database by name
        Optional<Student> optionalStudent = studentRepository.findByName(name);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return true; // Indicating successful deletion
        } else {
            throw new ResourceNotFoundException("Student not found with name: " + name);
        }
    }



}
