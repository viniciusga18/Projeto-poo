package model;

import interfaces.Utilizavel;

public abstract class Recurso implements Utilizavel {
    private Integer id;
    private String nome;
    private Integer anoFabricacao;

    public abstract void descricao();

    protected Recurso() {}

    public Recurso(String nome, Integer anoFabricacao) {
        this.nome = nome;
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}
