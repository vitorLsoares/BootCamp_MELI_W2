package br.com.meli.hql.jpa.service;

import br.com.meli.hql.jpa.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDentist {

    private DentistRepository dentistRepository;

    @Autowired
    public ServiceDentist(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }


}
