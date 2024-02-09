package com.example.record.service;

import com.example.record.entity.Student;
import com.example.record.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public Student create(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> read(){
        return studentRepository.findAll();
    }

    public Object update(Long id , Student student){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            student.setId(id);
            studentRepository.save(student);
            return student;
        }
        return "Student not found";
    }
    public String delete(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(id);
            return "Deleted successfully";
        }
        return "Student not found";
    }
}
