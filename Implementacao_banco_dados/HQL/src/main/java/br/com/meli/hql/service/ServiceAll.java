package br.com.meli.hql.service;


import br.com.meli.hql.dto.dtoConsultasPacienteDentista;
import br.com.meli.hql.entity.*;
import br.com.meli.hql.repository.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceAll {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("dentinho");
    private final EntityManager em = factory.createEntityManager();

    private DentistRepository dentistRepository;
    private DiaryRepository diaryRepository;
    private PatientRepository patientRepository;
    private TurnRepository turnRepository;
    private TurnStatusRepositry turnStatusRepositry;
    private UserRepository userRepository;

    public ServiceAll(DentistRepository dentistRepository, DiaryRepository diaryRepository,
                      PatientRepository patientRepository, TurnRepository turnRepository,
                      TurnStatusRepositry turnStatusRepositry, UserRepository userRepository) {
        this.dentistRepository = dentistRepository;
        this.diaryRepository = diaryRepository;
        this.patientRepository = patientRepository;
        this.turnRepository = turnRepository;
        this.turnStatusRepositry = turnStatusRepositry;
        this.userRepository = userRepository;
    }

    public ServiceAll() {
    }

    public String populateAll(){
        try {
            em.getTransaction().begin();
            List<Dentist> dentistList = populateDentist();
            List<Diary> diaries = populateDiarys(dentistList);
            List<Patient> patients = populatePatient();
            List<TurnStatus> turnStatusList = populateTurnStatus();
            populateUser();
            populateTurn(diaries,turnStatusList,patients);
            em.getTransaction().commit();
            return "Criado";
        }catch (Exception e){
            em.getTransaction().rollback();
            return e.getMessage();
        }
    }

    public List<dtoConsultasPacienteDentista> getPacientePorDiaDentista(String day){
        try {
            em.getTransaction().begin();
            List<Turn> turnDb = turnRepository.findByDay(day);
            em.getTransaction().commit();
            return dtoConsultasPacienteDentista.convertTunrToDto(turnDb);
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }
    }

    public List<Turn> getDentistasMais2Turnos(String day){
        try {
            em.getTransaction().begin();
            List<Turn> turnDb = turnRepository.findDenistInDay(day);
            em.getTransaction().commit();
            return turnDb;
        }catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }
    }

    private List<Dentist> populateDentist(){
        dentistRepository = new DentistRepository(em);
        List<Dentist> dentistList = List.of(
          new Dentist("Carlos", "Alameda", "Rua Pirao doido", "10", LocalDate.of(2021, Month.APRIL,2), "123-123", "ca@email.com", "09394-4"),
          new Dentist("Joao", "Aguiar", "Rua Carlos del preste", "11", LocalDate.of(2021, Month.FEBRUARY,13), "567-467", "jo@email.com", "34567-4"),
          new Dentist("Pedro", "Lucena", "Rua Jorge amado", "23", LocalDate.of(2021, Month.JANUARY,10), "345-789", "pe@email.com", "80567-4"),
          new Dentist("Felipe", "Maradona", "Rua Jao pedro", "56", LocalDate.of(2021, Month.AUGUST,20), "236-589", "fe@email.com", "12345-4")
        );
        dentistList.forEach(dentistRepository::cadastra);
        return dentistList;
    }

    private List<Diary> populateDiarys(List<Dentist> dentistList){
        diaryRepository = new DiaryRepository(em);
        List<Diary> diaries = List.of(
                new Diary("08:00:00","08:30:00",dentistList.get(0)),
                new Diary("09:00:00","09:30:00",dentistList.get(0)),
                new Diary("10:00:00","10:30:00",dentistList.get(0)),
                new Diary("12:00:00","12:30:00", dentistList.get(0)),
                new Diary("14:30:00","15:00:00", dentistList.get(0)),
                new Diary("10:00:00","10:30:00", dentistList.get(1)),
                new Diary("09:00:00","09:30:00", dentistList.get(1)),
                new Diary("10:00:00","10:30:00", dentistList.get(1)),
                new Diary("12:00:00","12:30:00", dentistList.get(1)),
                new Diary("14:30:00","15:00:00", dentistList.get(1)),
                new Diary("10:00:00","10:30:00", dentistList.get(2)),
                new Diary("09:00:00","09:30:00", dentistList.get(2)),
                new Diary("10:00:00","10:30:00", dentistList.get(2)),
                new Diary("12:00:00","12:30:00", dentistList.get(2)),
                new Diary("14:30:00","15:00:00", dentistList.get(2)),
                new Diary("10:00:00","10:30:00", dentistList.get(3)),
                new Diary("09:00:00","09:30:00", dentistList.get(3)),
                new Diary("10:00:00","10:30:00",dentistList.get(3)),
                new Diary("12:00:00","12:30:00",dentistList.get(3)),
                new Diary("14:30:00","15:00:00",dentistList.get(3))

        );
        diaries.forEach(diaryRepository::cadastra);
        return diaries;
    }

    private void populateTurn(List<Diary> diaries, List<TurnStatus> turnStatuses, List<Patient> patients){
        turnRepository = new TurnRepository(em);
        List.of(
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(0),turnStatuses.get(0),patients.get(0)),
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(1),turnStatuses.get(1),patients.get(0)),
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(2),turnStatuses.get(2),patients.get(2)),
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(3),turnStatuses.get(3),patients.get(0)),
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(4),turnStatuses.get(4),patients.get(2)),
                new Turn(LocalDate.of(2021, Month.JULY,19),diaries.get(5),turnStatuses.get(5),patients.get(0)),
                new Turn(LocalDate.of(2021, Month.JULY,20),diaries.get(6),turnStatuses.get(6),patients.get(1)),
                new Turn(LocalDate.of(2021, Month.JULY,20),diaries.get(7),turnStatuses.get(7),patients.get(1)),
                new Turn(LocalDate.of(2021, Month.JULY,20),diaries.get(8),turnStatuses.get(8),patients.get(1)),
                new Turn(LocalDate.of(2021, Month.JULY,20),diaries.get(9),turnStatuses.get(9),patients.get(3)),
                new Turn(LocalDate.of(2021, Month.JULY,20),diaries.get(10),turnStatuses.get(10),patients.get(3)),
                new Turn(LocalDate.of(2021, Month.JULY,21),diaries.get(11),turnStatuses.get(11),patients.get(1)),
                new Turn(LocalDate.of(2021, Month.JULY,21),diaries.get(12),turnStatuses.get(12),patients.get(4)),
                new Turn(LocalDate.of(2021, Month.JULY,21),diaries.get(13),turnStatuses.get(13),patients.get(4)),
                new Turn(LocalDate.of(2021, Month.JULY,21),diaries.get(14),turnStatuses.get(14),patients.get(4)),
                new Turn(LocalDate.of(2021, Month.JULY,22),diaries.get(15),turnStatuses.get(15),patients.get(3)),
                new Turn(LocalDate.of(2021, Month.JULY,22),diaries.get(16),turnStatuses.get(16),patients.get(3)),
                new Turn(LocalDate.of(2021, Month.JULY,22),diaries.get(17),turnStatuses.get(17),patients.get(3)),
                new Turn(LocalDate.of(2021, Month.JULY,23),diaries.get(18),turnStatuses.get(18),patients.get(0)),
                new Turn(LocalDate.of(2021, Month.JULY,23),diaries.get(19),turnStatuses.get(19),patients.get(0))

        ).forEach(turnRepository::cadastra);
    }

    private List<Patient> populatePatient(){
        patientRepository = new PatientRepository(em);
        List<Patient> patientList = List.of(
            new Patient("Felipe", "Albuquerque","Rua Marechal","09834-6",LocalDate.of(2021, Month.APRIL,12),"456-165", "fe@email.com"),
            new Patient("Leonardo", "Carvalho","Rua Padre Albani","098745-3",LocalDate.of(2021, Month.FEBRUARY,17),"987-234", "le@email.com"),
            new Patient("Adalberto", "Moraes","Rua Emanuel Nobrega","098657-5",LocalDate.of(2021, Month.JULY,1),"124-726", "ad@email.com"),
            new Patient("Camila", "Luna","Rua Jão Pedrao","098584-3",LocalDate.of(2021, Month.DECEMBER,9),"734-912", "ca@email.com"),
            new Patient("Luana", "Almeida","Rua Trabuco ","234234-4",LocalDate.of(2021, Month.JUNE,2),"497-185", "lu@email.com")
        );
        patientList.forEach(patientRepository::cadastra);
        return patientList;
    }

    private List<TurnStatus> populateTurnStatus(){
        turnStatusRepositry = new TurnStatusRepositry(em);
        List<TurnStatus> turnStatusList = List.of(
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Cancelado"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Cancelado"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Cancelado"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Cassia","Concluido"),
          new TurnStatus("Amelia","Concluido"),
          new TurnStatus("Cassia","Cancelado"),
          new TurnStatus("Amelia","Pendente"),
          new TurnStatus("Amelia","Pendente")
        );
        turnStatusList.forEach(turnStatusRepositry::cadastra);
        return turnStatusList;
    }

    private void populateUser(){
        userRepository = new UserRepository(em);
        List.of(
                new User("Vitor","Soares","Admin"),
                new User("Amelia","Santos","atendente"),
                new User("Cassia","Almeida","atendente")

        ).forEach(userRepository::cadastra);
    }

}
