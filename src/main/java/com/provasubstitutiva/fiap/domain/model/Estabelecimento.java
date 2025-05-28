package com.provasubstitutiva.fiap.domain.model;

public class Estabelecimento {

    private Long id;
    private String nome;
    private Long idEndereco;
    private String email;

    public Estabelecimento() {
    }

    public Estabelecimento(Long id, String nome, Long idEndereco, String email) {
        this.id = id;
        this.nome = nome;
        this.idEndereco = idEndereco;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
