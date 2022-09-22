package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="pagos")
public class PagosEnt  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id")
    private int id;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="fecha_p")
    private Date fechaPago;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="monto_mensual")
    private float montoMensual;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="monto_moratorio")
    private float montoMora; //monto moratorio

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="monto_T")
    private float montoT;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="alumno")
    private AlumnoEnt alumno;*/
    @Basic(optional = false)
    @Column(name="alumno")
    private Integer alumno;


    public PagosEnt() {

    }

    public PagosEnt(int id, Date fechaPago, float montoMensual, float montoMora, float montoT) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.montoMensual = montoMensual;
        this.montoMora = montoMora;
        this.montoT = montoT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagosEnt pagosEnt = (PagosEnt) o;
        return id == pagosEnt.id && Float.compare(pagosEnt.montoMensual, montoMensual) == 0 && Float.compare(pagosEnt.montoMora, montoMora) == 0 && Float.compare(pagosEnt.montoT, montoT) == 0 && fechaPago.equals(pagosEnt.fechaPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaPago, montoMensual, montoMora, montoT);
    }

    /************************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public float getMontoMensual() {
        return montoMensual;
    }

    public void setMontoMensual(float montoMensual) {
        this.montoMensual = montoMensual;
    }

    public float getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(float montoMora) {
        this.montoMora = montoMora;
    }

    public float getMontoT() {
        return montoT;
    }

    public void setMontoT(float montoT) {
        this.montoT = montoT;
    }

    /*public AlumnoEnt getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoEnt alumno) {
        this.alumno = alumno;
    }*/

    public Integer getAlumno() {
        return alumno;
    }

    public void setAlumno(Integer alumno) {
        this.alumno = alumno;
    }
}
