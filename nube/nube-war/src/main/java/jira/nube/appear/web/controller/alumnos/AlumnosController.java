package jira.nube.appear.web.controller.alumnos;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJBException;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jira.nube.appear.ejb.modelo.AlumnoEnt;
import jira.nube.appear.ejb.modelo.MateriasEnt;
import jira.nube.appear.ejb.modelo.PagosEnt;
import jira.nube.appear.ejb.servicio.AlumnosServiceLocal;
import jira.nube.appear.ejb.servicio.CatalogosServiceLocal;
import jira.nube.appear.ejb.servicio.MateriasServiceLocal;
import jira.nube.appear.ejb.servicio.PagosServiceLocal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


@Named(value = "alumnosController")
@ViewScoped
public class AlumnosController implements Serializable {
    private static final Logger logger = Logger.getLogger(AlumnosController.class.getName());
    private Integer idM;
    private final float montoM = 15000;
    private final float montoMo = 0;// (float) ((35*montoM)/100);
    private float montoT = montoM + montoMo;
    private int idA;
    @Inject
    private AlumnosServiceLocal alumnosService;

    @Inject
    private MateriasServiceLocal materiasService;

    @Inject
    private CatalogosServiceLocal catalogosService;

    private List<MateriasEnt> catMaterias;
    private List<AlumnoEnt> catAlumnos;
    private AlumnoEnt nuevo;

    private String n;
    private String t;
    private Integer idk;
    private String unom;
    private String upass;


    //private Date today.;


    @PostConstruct
    public void init() {
        nuevo = new AlumnoEnt();
        catMaterias = catalogosService.getCatalogoMaterias();
        catAlumnos=catalogosService.getCatalogoAlumnos();
        //size = alumnosService.listar().size() + 1;
        //today.getTime();

    }

    public String guardarAlumno() {
        try {
            MateriasEnt materia = materiasService.getMateria(idM);
            nuevo.setMateria(materia);
            alumnosService.crear(nuevo);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "Alumno guardado");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            logger.log(Level.INFO, "ERROR: " + e);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "Alumno no guardado");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return "error: " + e;
        }
    }

    public void borrarAlumno() {
        AlumnoEnt alumno = alumnosService.getAlumno(idA);
        try {
            alumnosService.borrar(alumno);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", " Alumno borrado");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
        } catch (EJBException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "No se pudo borrar el Alumno");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
        }

    }

    public void buscarAlumno(Integer id) {
        FacesContext context;
        FacesMessage message;
        nuevo = alumnosService.getAlumno(id);
        if (!nuevo.getNombre().equals(null)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "Alumno encontrado");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "Alumno no encontrado");
        }
        context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }

    public void actualizaAlumno(){
       AlumnoEnt alumno = alumnosService.getAlumno(idA);
        try {
            if(nuevo.getNombre()==null){ nuevo.setNombre(alumno.getNombre());}
            if(nuevo.getTutor()==null){ nuevo.setTutor(alumno.getTutor());}
            if(nuevo.getIdK()==null){ nuevo.setIdK(alumno.getIdK());}
            if(nuevo.getUnom()==null) {nuevo.setUnom(alumno.getUnom());}
            if(nuevo.getUpass()==null) {nuevo.setUpass(alumno.getUpass());}
            if(idM!=null){
                MateriasEnt materia = materiasService.getMateria(idM);
                nuevo.setMateria(materia);
            }
            else{nuevo.setMateria(alumno.getMateria());}
            alumnosService.actualiza(nuevo);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", " Alumno actualizado");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
        } catch (EJBException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Estatus", "No se pudo actualizar el Alumno");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
        }
    }

    /*********************************/
    public AlumnoEnt getNuevo() {
        return nuevo;
    }

    public void setNuevo(AlumnoEnt nuevo) {
        this.nuevo = nuevo;
    }

    public AlumnosServiceLocal getAlumnosService() {
        return alumnosService;
    }

    public void setAlumnosService(AlumnosServiceLocal alumnosService) {
        this.alumnosService = alumnosService;
    }

    public MateriasServiceLocal getMateriasService() {
        return materiasService;
    }

    public void setMateriasService(MateriasServiceLocal materiasService) {
        this.materiasService = materiasService;
    }

    public List<MateriasEnt> getCatMaterias() {
        return catMaterias;
    }

    public List<AlumnoEnt> getCatAlumnos() {
        return catAlumnos;
    }

    public Integer getIdM() {
        return idM;
    }

    public void setIdM(Integer idM) {
        this.idM = idM;
    }

    public float getMontoM() {
        return montoM;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    ///

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Integer getIdk() {
        return idk;
    }

    public void setIdk(Integer idk) {
        this.idk = idk;
    }

    public String getUnom() {
        return unom;
    }

    public void setUnom(String unom) {
        this.unom = unom;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
