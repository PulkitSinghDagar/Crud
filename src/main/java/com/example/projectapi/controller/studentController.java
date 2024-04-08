package com.example.projectapi.controller;

import com.example.projectapi.constant.StudentConstant;
import com.example.projectapi.dto.ResponseDTO;
import com.example.projectapi.dto.StudentDto;

import com.example.projectapi.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class studentController {

 private IStudentService IStudentService;
//    private newserviceI newserviceIi;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("api working");
    }

    @GetMapping("/actual")
    public ResponseEntity<ResponseDTO> test(ResponseDTO responseDTO) {
        System.out.println(responseDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

@PostMapping("/create")
    public ResponseEntity<ResponseDTO> createStudent(@RequestBody StudentDto studentDto){
        IStudentService.createAccount(studentDto);
    System.out.println("k"+studentDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(StudentConstant.STATUS_200,StudentConstant.MESSAGE_201));
    }


    @GetMapping("/fetch")
    public ResponseEntity<StudentDto>fetchStudentDeatils(@RequestParam String name){
       StudentDto studentDto =IStudentService.fetchStudent(name);
       return ResponseEntity.status(HttpStatus.OK).body(studentDto);
    }


@PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDeatils(@RequestBody StudentDto studentDto){
        boolean isUpdated=IStudentService.updateStudentKYCStatus(studentDto.getName(), studentDto.getKycStatus());
        if(isUpdated){
            System.out.println("yaha pe"+isUpdated);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(StudentConstant.STATUS_200,StudentConstant.MESSAGE_201));
        }
        else {
            System.out.println("upar"+isUpdated);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(StudentConstant.STATUS_500,StudentConstant.MESSAGE_500));
        }



}
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteStudent(@RequestParam String name) {
        boolean isDeleted = IStudentService.deleteStudent(name);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(StudentConstant.STATUS_200, "Student deleted successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(StudentConstant.STATUS_500, "Student not found with name: " + name));
        }
    }


}
