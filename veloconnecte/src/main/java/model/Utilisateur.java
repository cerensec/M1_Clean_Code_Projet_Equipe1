package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
public class Utilisateur {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
