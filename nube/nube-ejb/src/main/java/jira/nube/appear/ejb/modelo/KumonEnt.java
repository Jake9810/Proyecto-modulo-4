package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/*@Entity
@Table(name="kumon")*/
public class KumonEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id_Kumon")
    private Integer  idKumon;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="nom_sucursal")
    private String nomSucursal;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="zona")
    private String zona;

    public KumonEnt(){

    }// void constructor

    public KumonEnt(Integer idKumon, String nomSucursal, String zona) {
        this.idKumon = idKumon;
        this.nomSucursal = nomSucursal;
        this.zona = zona;
    }// constructor with parameters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KumonEnt kumonEnt = (KumonEnt) o;
        return idKumon.equals(kumonEnt.idKumon) && nomSucursal.equals(kumonEnt.nomSucursal) && zona.equals(kumonEnt.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKumon, nomSucursal, zona);
    }

    /***************************/
    public Integer getIdKumon() {
        return idKumon;
    }

    public void setIdKumon(Integer idKumon) {
        this.idKumon = idKumon;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}
