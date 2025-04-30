package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String isim;
    private String soyisim;
    private String email;
    
    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    
    private Set<Course> courses = new HashSet<>();
    
    public Student() {
    }
    


    public Student(String isim, String soyisim, String email, Date enrollmentDate) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }
} 