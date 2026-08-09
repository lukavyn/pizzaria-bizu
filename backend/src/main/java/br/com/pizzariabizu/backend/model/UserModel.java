package br.com.pizzariabizu.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "cad_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String nome;
    private String data_nascimento;
    @Column(unique = true)
    private String email;
    private String senha;

}
