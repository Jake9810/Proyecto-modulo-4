package jira.nube.appear.ejb.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class UsuariosEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="idUS")
    private Integer id;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="correo")
    private String mail;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="nombre")
    private String nom;

    @Basic(optional = false)
    @Size(max=45)
    @Column(name="pass")
    private String pass;


    public UsuariosEnt() {
    }

    public UsuariosEnt(Integer id, String mail, String nom, String pass) {
        this.id = id;
        this.mail = mail;
        this.nom = nom;
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEnt that = (UsuariosEnt) o;
        return id.equals(that.id) && mail.equals(that.mail) && nom.equals(that.nom) && pass.equals(that.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, nom, pass);
    }

    /*****************/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}


