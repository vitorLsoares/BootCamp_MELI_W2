package br.com.meli.hql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String start_time;
    private String ending_time;

    @ManyToOne
    private Dentist dentist;

    public Diary(String start_time, String ending_time, Dentist dentist) {
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.dentist = dentist;
    }

}
