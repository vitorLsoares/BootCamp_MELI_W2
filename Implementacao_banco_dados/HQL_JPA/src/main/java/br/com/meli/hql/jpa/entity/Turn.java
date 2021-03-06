package br.com.meli.hql.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate day;

    @ManyToOne(targetEntity = Diary.class)
    private Diary diary;

    @ManyToOne(targetEntity = TurnStatus.class)
    private TurnStatus turnStatus;

    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;

    public Turn(LocalDate day, Diary diary, TurnStatus turnStatus, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }
}
