/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.util.Date;

/**
 *
 * @author Jean Paul
 */
public class LibroMayor {

    private Date fecha_operacion;
    private int numero_cuenta;
    private String numero_correlativo;
    private String glosa;
    private double deudor;
    private double acreedor;
    private Date fechaInicio;
    private Date fechaFin;

    public Date getFecha_operacion() {
        return fecha_operacion;
    }

    public void setFecha_operacion(Date fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getNumero_correlativo() {
        return numero_correlativo;
    }

    public void setNumero_correlativo(String numero_correlativo) {
        this.numero_correlativo = numero_correlativo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public double getDeudor() {
        return deudor;
    }

    public void setDeudor(double deudor) {
        this.deudor = deudor;
    }

    public double getAcreedor() {
        return acreedor;
    }

    public void setAcreedor(double acreedor) {
        this.acreedor = acreedor;
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
}
