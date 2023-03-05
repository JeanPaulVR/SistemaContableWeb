/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author USER
 */
public class BalanceGeneral {

    public int getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(int numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
   
    private int numerocuenta;
    private String nombrecuenta;
    private double importe;
    
    
    }
