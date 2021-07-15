package br.com.meli.obter.diploma.repository;

import br.com.meli.obter.diploma.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepository {

    private static final List<Student> students = new ArrayList<>();

    public List<Student> getList(){
        return StudentRepository.students;
    }

    public void add(Student student){
        StudentRepository.students.add(student);
    }

    //Método utilizado para os Teste Unitários
    public void removeAll(){
        StudentRepository.students.clear();
    }

}
