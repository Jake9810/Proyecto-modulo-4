package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="materias")
public class MateriasEnt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id")
    private int id;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="nombre")
    private String name;

    @OneToMany(mappedBy = "materia")// relación  una materia a muchos alumnos
    private Set<AlumnoEnt> alumnos=new LinkedHashSet<>();

    public MateriasEnt() {

    }

    public MateriasEnt(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriasEnt that = (MateriasEnt) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }



    /*@ManyToMany
    @JoinTable(name="calificaciones", joinColumns =@JoinColumn( name="idM"),
                inverseJoinColumns = @JoinColumn(name="id"))
    private Set<CalificacionesEnt> alumnosC=new LinkedHashSet<>();*/

    /*********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AlumnoEnt> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<AlumnoEnt> alumnos) {
        this.alumnos = alumnos;
    }
    /////////////////

   /* public Set<CalificacionesEnt> getAlumnosC() {
        return alumnosC;
    }

    public void setAlumnosC(Set<CalificacionesEnt> alumnosC) {
        this.alumnosC = alumnosC;
    }*/
}
