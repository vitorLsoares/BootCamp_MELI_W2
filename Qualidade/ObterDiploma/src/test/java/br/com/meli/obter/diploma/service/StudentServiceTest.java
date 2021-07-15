package br.com.meli.obter.diploma.service;

import br.com.meli.obter.diploma.dto.StudentDTO;
import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.model.Subject;
import br.com.meli.obter.diploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

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

        StudentService localMockService = Mockito.mock(StudentService.class);
        Mockito.when(localMockService.getListOfStudent()).thenReturn(listEstudante);

        //Execução
        List<Student> saidaDesejada = localMockService.getListOfStudent();

        //Condiçao
        Assertions.assertEquals(saidaDesejada,listEstudante);
        Mockito.verify(localMockService).getListOfStudent();
    }

    @Test
    void getStudantByName() {
        //Setup
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Albuquerque",subjectsS1);

        StudentService localMockService = Mockito.mock(StudentService.class);
        Mockito.when(localMockService.getStudantByName("Kamila Albuquerque")).thenReturn(student);

        //Execução
        Student saidaDesejada = localMockService.getStudantByName("Kamila Albuquerque");

        //Condiçao
        Assertions.assertEquals(saidaDesejada,student);
        Mockito.verify(localMockService).getStudantByName("Kamila Albuquerque");
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

        StudentService localMockService = Mockito.mock(StudentService.class);
        Mockito.when(localMockService.createStudent(student)).thenReturn(student);

        //Execução
        Student saidaDesejada = localMockService.createStudent(student);

        //Condiçao
        Assertions.assertEquals(saidaDesejada,student);
        Mockito.verify(localMockService).createStudent(student);
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