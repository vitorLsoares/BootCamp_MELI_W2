package br.com.meli.hql.dto;

import br.com.meli.hql.entity.Turn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class dtoConsultasPacienteDentista {

    private String nomePaciente;
    private String nomeDentista;
    private String startTime;
    private String endTime;

    public static List<dtoConsultasPacienteDentista> convertTunrToDto(List<Turn> turnList){
        List<dtoConsultasPacienteDentista> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        for (Turn tunr: turnList) {

            dtoConsultasPacienteDentista dto = new dtoConsultasPacienteDentista();
            dto.setNomeDentista(tunr.getDiary().getDentist().getName() +" "+ tunr.getDiary().getDentist().getLast_name());
            dto.setNomePaciente(tunr.getPatient().getName() + " " + tunr.getPatient().getName());
            dto.setStartTime(tunr.getDay().format(formatter).toString()+" "+tunr.getDiary().getStart_time());
            dto.setEndTime(tunr.getDay().format(formatter).toString()+" "+tunr.getDiary().getEnding_time());
            list.add(dto);
        }

        return list;
    }

}
