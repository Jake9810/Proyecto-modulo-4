package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Calificaciones")
public class CalificacionesEnt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id")
    private Integer idC;

    @Basic(optional = false)
    @Column(name="mod1")
    private float mod1;

    @Basic(optional = false)
    @Column(name="mod2")
    private float mod2;

    @Basic(optional = false)
    @Column(name="mod3")
    private  float mod3;

    @Basic(optional = false)
    @Column(name ="idA")
    private Integer idA;


    @Basic(optional = false)
    @Column(name ="idM")
    private Integer idM;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificacionesEnt that = (CalificacionesEnt) o;
        return idC.equals(that.idC) && idA.equals(that.idA) && idM.equals(that.idM) && Objects.equals(mod1, that.mod1) && Objects.equals(mod2, that.mod2) && Objects.equals(mod3, that.mod3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idC, idA, idM, mod1, mod2, mod3);
    }

    public CalificacionesEnt(){

    }

    public CalificacionesEnt(Integer idC, Integer idA, Integer idM, float mod1, float mod2, float mod3) {
        this.idC = idC;
        this.idA = idA;
        this.idM = idM;
        this.mod1 = mod1;
        this.mod2 = mod2;
        this.mod3 = mod3;
    }

    /******************************/

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public float getMod1() {
        return mod1;
    }

    public void setMod1(float mod1) {
        this.mod1 = mod1;
    }

    public float getMod2() {
        return mod2;
    }

    public void setMod2(float mod2) {
        this.mod2 = mod2;
    }

    public float getMod3() {
        return mod3;
    }

    public void setMod3(float mod3) {
        this.mod3 = mod3;
    }
}
