package com.provasubstitutiva.fiap.domain.model;

import java.util.Objects;

public class Avaliacao {

    private Long id;
    private Long idCliente;
    private int estrelas;
    private String comentario;
    private Long idEstabelecimento;
    private Long idProfissional;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Long idCliente, int estrelas, String comentario, Long idEstabelecimento, Long idProfissional) {
        if(estrelas < 0 || estrelas > 5) { throw new IllegalStateException("A avaliação deve conter de 0 a 5 estrelas"); }
        if(Objects.nonNull(idEstabelecimento) && Objects.nonNull(idProfissional)) { throw new IllegalStateException("Não avalie um profissional e um estabelecimento simultâneamente"); }

        this.id = id;
        this.idCliente = idCliente;
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.idEstabelecimento = idEstabelecimento;
        this.idProfissional = idProfissional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }
}
