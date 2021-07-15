package br.com.meli.obter.diploma;

import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.model.Subject;
import br.com.meli.obter.diploma.repository.StudentRepository;
import br.com.meli.obter.diploma.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CertificateServiceImplTest {

    //ESSE É UM EXEMPLO DE COMO NÃO FAZER TESTES UNITÁRIOS
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

    @BeforeEach
    void initUseCase(){
        List<Subject> subjectsS1 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",10),
                        new Subject("Fisica",8.0),
                        new Subject("Quimica",5.0)
                )
        );
        Student student = new Student("Kamila Abuquerque",subjectsS1);

        studentRepository.add(student);
    }

    @AfterEach
    void finalUseCase(){
        studentRepository.removeAll();
    }

    @Test
    void deveRetornarEstudantePorNome(){
        //Setup
        List<Subject> subjectsS2 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",9.5),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",9.0)

                )
        );
        Student estudanteDesejado = new Student("Leandro de Almeida",subjectsS2);
        studentRepository.add(estudanteDesejado);
        String nomeDesejado = "Leandro de Almeida";

        //Execuçao
        Student estudanteEsperado = studentService.getStudantByName(nomeDesejado);

        //Condiçoes
        assertEquals(estudanteEsperado,estudanteDesejado);
    }

    @Test
    void deveRetornarOutroEstudantePorNome(){
        //Setup
        List<Subject> subjectsS2 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",9.5),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",9.0)

                )
        );
        Student estudanteDesejado = new Student("Leandro de Almeida",subjectsS2);
        studentRepository.add(estudanteDesejado);
        String nomeDesejado = "Kamila Abuquerque";

        //Execuçao
        Student estudanteEsperado = studentService.getStudantByName(nomeDesejado);

        //Condiçoes
        assertNotEquals(estudanteEsperado,estudanteDesejado);
    }

    @Test
    void deveCriarUmEstudanteAdicionandoNaLista(){
        //Setup
        List<Subject> subjectsS2 = new ArrayList<>(
                Arrays.asList(
                        new Subject("Matematica",9.5),
                        new Subject("Fisica",8.5),
                        new Subject("Quimica",9.0)

                )
        );
        Student estudanteDesejado = new Student("Leandro de Almeida",subjectsS2);

        String nomeDesejado = "Leandro de Almeida";

        //Execuçao
        Student estudanteEsperado = studentService.getStudantByName(nomeDesejado);

        //Condiçoes
        assertNotEquals(estudanteEsperado,estudanteDesejado);
    }





}
