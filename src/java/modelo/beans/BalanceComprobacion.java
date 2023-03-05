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
public class BalanceComprobacion {
    private double deudor;
    private double acreedor;
    private String nombreCuenta;
    private int cuenta;
    private Date fechaInicio;
    private Date fechaFin;
    
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

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
}
