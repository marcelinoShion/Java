package com.example.record.controller;

import com.example.record.entity.Student;
import com.example.record.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    @PostMapping
    public Student registryStudent(@RequestBody Student student){
        return studentService.create(student);
    }
    @GetMapping
    public List<Student> allStudents(){
        return studentService.read();
    }
    @PutMapping("{id}")
    public Object updateStudent(@PathVariable("id") Long id ,@RequestBody Student student){
        return studentService.update(id, student);
    }
    @DeleteMapping("{id}")
    public String removeStudent(@PathVariable("id") Long id){
        return studentService.delete(id);
    }
}
