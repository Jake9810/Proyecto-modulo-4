package jira.nube.appear.web.controller.pago;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jira.nube.appear.ejb.modelo.AlumnoEnt;
import jira.nube.appear.ejb.modelo.PagosEnt;
import jira.nube.appear.ejb.servicio.AlumnosServiceLocal;
import jira.nube.appear.ejb.servicio.CatalogosServiceLocal;
import jira.nube.appear.ejb.servicio.PagosServiceLocal;

import java.io.Serializable;
import java.util.Date;

@Named(value="registarPagoController")
@ViewScoped
public class RegistrarPagoController implements Serializable {
/*
    private Integer idA;
    private Date fechap;
    private final float montoM=15000;
    private boolean montoMo=false;// (float) ((35*montoM)/100);
    private float montoT;//=montoM+((35*montoM)/100);
    private PagosEnt nuevo;
    private AlumnoEnt alumnoN;
    @Inject
    private PagosServiceLocal pagoService;

    @Inject
    private CatalogosServiceLocal catalogosService;

    @Inject
    private AlumnosServiceLocal alumnosService;

    @PostConstruct
    public void init(){
        nuevo=new PagosEnt();

    }

    public String realizarPago(){
        try{
            nuevo.setFechaPago(fechap);
            pagoService.crear(nuevo);
            if(!montoMo){
                montoT=montoM+((35*montoM)/100);
                nuevo.setMontoT(montoT);
                nuevo.setMontoMora((float) ((35*montoM)/100));
            }
            else{
                nuevo.setMontoT(montoM);
                nuevo.setMontoMora(0);
            }
            nuevo.setAlumno(idA);
            pagoService.crear(nuevo);
            return "pago agregado";
        }catch (Exception e){
            return "no se pudo realizar el pago: "+e;
        }
    }

    //*****************************
    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public Date getFechap() {
        return fechap;
    }

    public void setFechap(Date fechap) {
        this.fechap = fechap;
    }

    public float getMontoM() {
        return montoM;
    }



    public float getMontoT() {
        return montoT;
    }

    public void setMontoT(float montoT) {
        this.montoT = montoT;
    }

    public PagosEnt getNuevo() {
        return nuevo;
    }

    public void setNuevo(PagosEnt nuevo) {
        this.nuevo = nuevo;
    }

    public AlumnoEnt getAlumnoN() {
        return alumnoN;
    }

    public void setAlumnoN(AlumnoEnt alumnoN) {
        this.alumnoN = alumnoN;
    }

    public CatalogosServiceLocal getCatalogosService() {
        return catalogosService;
    }

    public void setCatalogosService(CatalogosServiceLocal catalogosService) {
        this.catalogosService = catalogosService;
    }

    public AlumnosServiceLocal getAlumnosService() {
        return alumnosService;
    }

    public void setAlumnosService(AlumnosServiceLocal alumnosService) {
        this.alumnosService = alumnosService;
    }*/
}
