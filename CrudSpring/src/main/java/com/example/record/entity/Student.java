package com.example.record.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank (message = "Empty field")
    private String name ;
    private int age ;
    private boolean concluded ;

    public Student(String name, int age, boolean concluded) {
        this.name = name;
        this.age = age;
        this.concluded = concluded;
    }
}
