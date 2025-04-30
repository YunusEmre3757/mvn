package com.example.backend.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name = "teachers")
@Getter
@Setter
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    
    private String name;
    private String surname;
    private String department;



    
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
    
    public Teacher() {
    }
    
    public Teacher(String name, String surname, String department) {
        this.name = name;
        this.surname = surname;
        this.department = department;
    }
    
} 