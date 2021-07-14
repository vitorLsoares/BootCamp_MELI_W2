package br.com.meli.obter.diploma.service;

import br.com.meli.obter.diploma.dto.StudentDTO;
import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getListOfStudent(){
        return studentRepository.getList();
    }

    public Student getStudantByName(String name){
        return getListOfStudent().stream().filter(student -> student.getNome().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Student createStudent(Student student){
        studentRepository.add(student);
        return getStudantByName(student.getNome());
    }

    public StudentDTO createDiploma(Student student){
        Student studentCreated = createStudent(student);
        return StudentDTO.convertModelToDTO(studentCreated);
    }
}
