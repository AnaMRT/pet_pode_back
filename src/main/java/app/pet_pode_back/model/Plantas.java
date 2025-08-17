package app.pet_pode_back.model;

public class Plantas {

    private String nomePopular;
    private String nomeCientifico;
    private String descricao;

    public Plantas() {
    }

    public Plantas(String nomePopular, String nomeCientifico, String descricao) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.descricao = descricao;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
