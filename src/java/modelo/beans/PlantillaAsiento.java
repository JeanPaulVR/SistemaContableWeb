/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;

import java.util.List;

/**
 *
 * @author Jean Paul
 */
public class PlantillaAsiento {
    private int id;
    private int cuentaDestino;
    private List<DetallePlantilla> cuentasOrigen;
    private String glosa;
    private int codigoUsuario;
    private String nombre_cuenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public List<DetallePlantilla> getCuentasOrigen() {
        return cuentasOrigen;
    }

    public void setCuentasOrigen(List<DetallePlantilla> cuentasOrigen) {
        this.cuentasOrigen = cuentasOrigen;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }
}
