package com.provasubstitutiva.fiap.domain.model;

public class Endereco {

    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private double latitude;
    private double longitude;
    private Long idEstabelecimento;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String cep, String numero, double latitude, double longitude, Long idEstabelecimento) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idEstabelecimento = idEstabelecimento;
    }

    public boolean isValid() {
        return logradouro != null
                && cep != null
                && numero != null
                && idEstabelecimento != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Long getIdEstabelecimento() {
        return idEstabelecimento;
    }

    public void setIdEstabelecimento(Long idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }
}
