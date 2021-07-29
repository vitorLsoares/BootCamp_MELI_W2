package br.com.meli.hql.jpa.service;

import br.com.meli.hql.jpa.entity.Dentist;
import br.com.meli.hql.jpa.entity.Turn;
import br.com.meli.hql.jpa.repository.DentistRepository;
import br.com.meli.hql.jpa.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceTurn {

    private final TurnRepository turnRepository;
    private final DentistRepository dentistRepository;

    @Autowired
    public ServiceTurn(TurnRepository turnRepository, DentistRepository dentistRepository) {
        this.turnRepository = turnRepository;
        this.dentistRepository = dentistRepository;
    }

    public List<Turn> getPacientPorDentistaNoDia(String dentista, LocalDate dia){
        return turnRepository.findByDiary_DentistNameAndDayEquals(dentista,dia);
    }

    public Map<String, Integer> getAllDentistTurnInDay(LocalDate date){
        List<String> namesDentist = dentistRepository.findAll().stream().map(Dentist::getName).collect(Collectors.toList());
        HashMap<String, Integer> dicionario = null;
        for (String name:namesDentist) {
            Integer counter = turnRepository.countAllByDayAndDiary_Dentist_Name(date,name);
            if(counter > 2){
                assert false;
                dicionario.put(name,counter);
            }
        }
        return dicionario;
    }
}
