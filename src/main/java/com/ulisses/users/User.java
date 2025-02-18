package com.ulisses.users;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 7)
    private String enderecoCEP;

    @Column(length = 250)
    private String enderecoLogradouro;

    @Column(length = 100)
    private String enderecoBairro;

    @Column(length = 100)
    private String enderecoCidade;

    @Column(length = 2)
    private String enderecoUF;

    @ElementCollection
    @CollectionTable(name = "user_telefones", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "telefone", nullable = false)
    private List<String> telefones;

    @ElementCollection
    @CollectionTable(name = "user_emails", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email", nullable = false)
    private List<String> emails;

    // Getters and Setters
}
