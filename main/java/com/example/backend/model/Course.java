package com.example.backend.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    
    private String title;
    private String courseCode;
    


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course() {
    }
    
    public Course(String title, String courseCode) {
        this.title = title;
        this.courseCode = courseCode;
    }
    

} 