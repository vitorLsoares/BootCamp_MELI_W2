package br.com.meli.obter.diploma.dto;

import br.com.meli.obter.diploma.model.Student;
import br.com.meli.obter.diploma.model.Subject;


public class StudentDTO {

    private String message;
    private double average;
    private Student student;

    public StudentDTO(String message, double average, Student student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }
    public StudentDTO(){

    }

    public String getMessage() {
        return message;
    }

    public double getAverage() {
        return average;
    }

    public Student getStudent() {
        return student;
    }

    public static StudentDTO convertModelToDTO(Student student , double calculoDaMedia , String defaultMessage){
        return new StudentDTO(defaultMessage ,calculoDaMedia,student);
    }
}
