/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.util.Date;

/**
 *
 * @author USER
 */
public class LibroDiario {
   private String tipooperacion; 
    private String numeroasiento;
    private Date fecha;
    private String moneda;
    private double importeSoles;
    private double importeDolares;
    private String glosa;
    private String modo;
    private String tipo;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoDoc;
    private String serie;
    private String correlativo;
    private int numerocuenta;
    private String nombrecuenta;
    private double debesoles;
    private double habersoles;
    
    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public double getDebesoles() {
        return debesoles;
    }

    public void setDebesoles(double debesoles) {
        this.debesoles = debesoles;
    }

    public double getHabersoles() {
        return habersoles;
    }

    public void setHabersoles(double habersoles) {
        this.habersoles = habersoles;
    }
    
    

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public String getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(String tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    public String getNumeroasiento() {
        return numeroasiento;
    }

    public void setNumeroasiento(String numeroasiento) {
        this.numeroasiento = numeroasiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getImporteSoles() {
        return importeSoles;
    }

    public void setImporteSoles(double importeSoles) {
        this.importeSoles = importeSoles;
    }

    public double getImporteDolares() {
        return importeDolares;
    }

    public void setImporteDolares(double importeDolares) {
        this.importeDolares = importeDolares;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
}
