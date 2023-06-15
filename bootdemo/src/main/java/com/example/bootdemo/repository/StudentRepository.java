package com.example.bootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootdemo.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
