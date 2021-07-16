package br.com.meli.obter.diploma.service;

import br.com.meli.obter.diploma.dto.StudentDTO;
import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.model.Subject;
import br.com.meli.obter.diploma.repository.StudentRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Stubber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentServiceTest {

    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    public void initSetup(){
        studentService = new StudentService(studentRepository);
    }

    @Test
    void shoulGetListOfStudent() {
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Albuquerque",subjectsS1);

        List<Subject> subjectsS2 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",9.5),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",9.0)

                )
        );
        Student student2 = new Student("Leandro de Almeida",subjectsS2);
        List<Student> listEstudante = new ArrayList<>(Arrays.asList(student2,student));
        Mockito.when(studentRepository.getList()).thenReturn(listEstudante);

        //Execução
        List<Student> saidaDesejada = studentService.getListOfStudent();

        //Condiçao
        Assertions.assertEquals(listEstudante,saidaDesejada);
        Mockito.verify(studentRepository).getList();
    }

    @Test
    void getStudantByName() throws Exception{
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Albuquerque",subjectsS1);

        List<Subject> subjectsS2 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",9.5),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",9.0)

                )
        );
        Student student2 = new Student("Leandro de Almeida",subjectsS2);
        List<Student> listEstudante = new ArrayList<>(Arrays.asList(student2,student));
        Mockito.when(studentRepository.getList()).thenReturn(listEstudante);

        //Execução
        Student saidaDesejada = studentService.getStudantByName("Kamila Albuquerque");

        //Condiçao
        Assertions.assertEquals(student,saidaDesejada);
        Mockito.verify(studentRepository).getList();

    }

    @Test
    void shouldCreateStudent() {
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Albuquerque",subjectsS1);
        Mockito.doNothing().when(studentRepository).add(student);

        //Execução
        Student saidaDesejada = studentService.createStudent(student);

        //Condiçao
        Assertions.assertEquals(saidaDesejada,student);
        Mockito.verify(studentRepository).add(student);
    }

    @Test
    void shouldCreateDiploma() {
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Albuquerque",subjectsS1);
        StudentDTO studentToReturn = new StudentDTO("Sua média foi de"+((10+8.0+5.0)/3),((10+8.0+5.0)/3),student);

        StudentService localMockService = Mockito.mock(StudentService.class);
        Mockito.when(localMockService.createDiploma(student)).thenReturn(studentToReturn);

        //Execução
        StudentDTO saidaDesejada = localMockService.createDiploma(student);

        //Condiçao
        Assertions.assertEquals(saidaDesejada,studentToReturn);
        Mockito.verify(localMockService).createDiploma(student);
    }

    @Test //Possivel de Fazer Teste Unitário
    void shouldCalculateAverage() {
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",5.7)
                )
        );
        Student student = new Student("Kamila Abuquerque",subjectsS1);
        double saidaDesejada = (10+8.5+5.7)/3;

        //Execução
        double retorno = studentService.calculateAverage(student);


        //Condiçao
        assertEquals(retorno,saidaDesejada);
    }

    @Test //Possível de Fazer teste unitário
    void shouldWhiteDiploma() {
        //Setup
        String saidaDesejada = "Sua média foi de 10.0";

        //Execuçao
        String retorno = studentService.whiteDiploma(10);

        //Condiçao
        assertEquals(retorno,saidaDesejada);
    }
}