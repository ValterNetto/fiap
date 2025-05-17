package com.provasubstitutiva.fiap.domain.model;

public class Profissional {

    Long id;
    String nome;
    String email;
    String especialidade;
    Integer tarifaPorHora;
    Long idEstabelecimento;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(Integer tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
}
