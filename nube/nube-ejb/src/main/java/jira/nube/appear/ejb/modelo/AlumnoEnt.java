package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="alumnos")
public class AlumnoEnt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id_cliente")
    private Integer id;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="nom")
    private String nombre;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="tutor")
    private String tutor;

    @Basic(optional = false)
    @Column(name="id_centro")
    private Integer idK; //private KumonEnt id;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="nom_sys_user")
    private String Unom;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="pass")
    private String Upass;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="materia")
    private MateriasEnt materia;


    /*@OneToMany(mappedBy = "alumno")
    private Set<PagosEnt> pagos =new LinkedHashSet<>();*/
    @Basic(optional = false)
    @Column(name = "pago")
    private Integer pagos;

    /*@ManyToMany
    @JoinTable(name="calificaciones", joinColumns =@JoinColumn( name="idA"),
            inverseJoinColumns = @JoinColumn(name="id"))
    private Set<CalificacionesEnt> calificaciones=new LinkedHashSet<>();*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoEnt alumnoEnt = (AlumnoEnt) o;
        return id.equals(alumnoEnt.id) && nombre.equals(alumnoEnt.nombre) && tutor.equals(alumnoEnt.tutor)
                && idK.equals(alumnoEnt.idK) && Unom.equals(alumnoEnt.Unom) && Upass.equals(alumnoEnt.Upass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tutor, idK, Unom, Upass);
    }

    public AlumnoEnt(){
    } //void constructor

    public AlumnoEnt(Integer id, String nombre, String tutor, Integer idKu,
                     String Unom, String Upass){
        this.id= id;
        this.nombre=nombre;
        this.tutor=tutor;
        this.idK=idKu;
        this.Unom=Unom;
        this.Upass=Upass;
    }


    /*********************************/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Integer getIdK() {
        return idK;
    }

    public void setIdK(Integer idK) {
        this.idK = idK;
    }

    public String getUnom() {
        return Unom;
    }

    public void setUnom(String unom) {
        Unom = unom;
    }

    public String getUpass() {
        return Upass;
    }

    public void setUpass(String upass) {
        Upass = upass;
    }

    public MateriasEnt getMateria() {
        return materia;
    }

    public void setMateria(MateriasEnt materia) {
        this.materia = materia;
    }

    /*public Set<PagosEnt> getPagos() {
        return pagos;
    }

    public void setPagos(Set<PagosEnt> pagos) {
        this.pagos = pagos;
    }*/
    ///////////////

    public Integer getPagos() {
        return pagos;
    }

    public void setPagos(Integer pagos) {
        this.pagos = pagos;
    }
}
