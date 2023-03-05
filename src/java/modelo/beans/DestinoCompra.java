/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author ferdinand
 */
public class DestinoCompra {
    private int cuenta_origen; 
    private int cuenta_cargo;    
    private int cuenta_abono;
    
    public int getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public int getCuenta_cargo() {
        return cuenta_cargo;
    }

    public void setCuenta_cargo(int cuenta_cargo) {
        this.cuenta_cargo = cuenta_cargo;
    }

    public int getCuenta_abono() {
        return cuenta_abono;
    }

    public void setCuenta_abono(int cuenta_abono) {
        this.cuenta_abono = cuenta_abono;
    }
    
}
