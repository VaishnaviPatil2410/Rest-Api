package com.example.bootdemo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdemo.dto.Student;
import com.example.bootdemo.repository.StudentRepository;
import com.example.bootdemo.service.StudentService;

@RestController
@RequestMapping
public class controller {
	@Autowired
	StudentService sr;

	@GetMapping("/students")
	public List<Student> list(){
		return sr.listAll();
	}
	
	@PostMapping("/savedata")
	public String add(@RequestBody Student s) {
		sr.save(s);
		return "data saved successfully";
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student s, @PathVariable int id){
		try {
			Student existStudent = sr.get(id);
			sr.save(s);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id) {
		sr.delete(id);
	}
}

