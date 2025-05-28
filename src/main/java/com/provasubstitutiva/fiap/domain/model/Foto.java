package com.provasubstitutiva.fiap.domain.model;

public class Foto {

    private Long id;
    private String nome;
    private String foto;
    private Long idEstabelecimento;


    public Foto() {
    }

    public Foto(Long id, String nome, String foto, Long idEstabelecimento) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.idEstabelecimento = idEstabelecimento;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
}
