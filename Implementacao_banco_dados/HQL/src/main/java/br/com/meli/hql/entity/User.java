package br.com.meli.hql.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter @Getter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user_name;
    private String password;
    private String user_status;

    public User(String user_name, String password, String user_status) {
        this.user_name = user_name;
        this.password = password;
        this.user_status = user_status;
    }
}
