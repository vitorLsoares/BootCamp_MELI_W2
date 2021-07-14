package br.com.meli.obter.diploma.controller;


import br.com.meli.obter.diploma.dto.StudentDTO;
import br.com.meli.obter.diploma.exceptions.ValidException;
import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/ml-school-01")
public class DiplomaController {

    @Autowired
    StudentService studentService;

    @PostMapping("/analyzeNotes")
    public ResponseEntity<StudentDTO> postDiploma(@Valid @RequestBody Student student){
        StudentDTO studentDTO = studentService.createDiploma(student);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/test/{Name}")
    public ResponseEntity<Student> getStudanteById(@PathVariable String Name){
        Student student = studentService.getStudantByName(Name);
        if (student == null)
            throw new ValidException("DEu ruim");
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }



}
