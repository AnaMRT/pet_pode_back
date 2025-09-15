
package app.pet_pode_back.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "plantas")
public class Plantas {

    @Column
    private String nomePopular;
    @Column
    private String nomeCientifico;
    @Column
    private String descricao;

    @Column
    private boolean toxica;

    @Column
    private String imagemUrl;


    @Id
    @GeneratedValue
    @Column
    private UUID id;


    public Plantas() {
    }

    public Plantas(String nomePopular, String nomeCientifico, String descricao, boolean toxica, String imagemUrl, UUID id) {
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.descricao = descricao;
        this.toxica = toxica;
        this.imagemUrl = imagemUrl;
        this.id = id;
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

    public boolean isToxica() {
        return toxica;
    }

    public void setToxica(boolean toxica) {
        this.toxica = toxica;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Plantas plantas = (Plantas) o;
        return toxica == plantas.toxica && Objects.equals(nomePopular, plantas.nomePopular) && Objects.equals(nomeCientifico, plantas.nomeCientifico) && Objects.equals(descricao, plantas.descricao) && Objects.equals(imagemUrl, plantas.imagemUrl) && Objects.equals(id, plantas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePopular, nomeCientifico, descricao, toxica, imagemUrl, id);
    }

    @Override
    public String toString() {
        return "Plantas{" +
                "nomePopular='" + nomePopular + '\'' +
                ", nomeCientifico='" + nomeCientifico + '\'' +
                ", descricao='" + descricao + '\'' +
                ", toxica=" + toxica +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", id=" + id +
                '}';
    }
}

