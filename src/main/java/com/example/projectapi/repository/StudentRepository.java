package com.example.projectapi.repository;

import com.example.projectapi.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student>findByName(String name);
   // void deleteByName(String name);


//    @Transactional
//    @Modifying
//    void delete(String name);
}
