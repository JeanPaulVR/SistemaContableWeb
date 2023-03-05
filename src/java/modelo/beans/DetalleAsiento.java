/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

/**
 *
 * @author Jean Paul
 */
public class DetalleAsiento {
    private int id;
    private double habersoles;
    private double haberdolares;
    private double debesoles;
    private double debedolares;
    private int cuenta;
    private int tipoCambio;
    private String serieDoc;
    private String numeroAsiento;
    private String nombrecc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHabersoles() {
        return habersoles;
    }

    public void setHabersoles(double habersoles) {
        this.habersoles = habersoles;
    }

    public double getHaberdolares() {
        return haberdolares;
    }

    public void setHaberdolares(double haberdolares) {
        this.haberdolares = haberdolares;
    }

    public double getDebesoles() {
        return debesoles;
    }

    public void setDebesoles(double debesoles) {
        this.debesoles = debesoles;
    }

    public double getDebedolares() {
        return debedolares;
    }

    public void setDebedolares(double debedolares) {
        this.debedolares = debedolares;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(int tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getSerieDoc() {
        return serieDoc;
    }

    public void setSerieDoc(String serieDoc) {
        this.serieDoc = serieDoc;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getNombrecc() {
        return nombrecc;
    }

    public void setNombrecc(String nombrecc) {
        this.nombrecc = nombrecc;
    }
}