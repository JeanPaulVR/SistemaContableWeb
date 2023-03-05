/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.beans;


/**
 *
 * @author Jean Paul
 */
public class Usuario {
    private int codigo;
    private String dni;
    private String apell;
    private String nombres;
    private String usuario;
    private String contraseña;
    private int digitos;
    private int periodo;
    private String RUC;
    private String razonSocial;
    private int diferenciaDebe;
    private int diferenciaHaber;
    private int cuentaIGV;
    private int cuentaCaja;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getDigitos() {
        return digitos;
    }

    public void setDigitos(int digitos) {
        this.digitos = digitos;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getDiferenciaDebe() {
        return diferenciaDebe;
    }

    public void setDiferenciaDebe(int diferenciaDebe) {
        this.diferenciaDebe = diferenciaDebe;
    }

    public int getDiferenciaHaber() {
        return diferenciaHaber;
    }

    public void setDiferenciaHaber(int diferenciaHaber) {
        this.diferenciaHaber = diferenciaHaber;
    }

    public int getCuentaIGV() {
        return cuentaIGV;
    }

    public void setCuentaIGV(int cuentaIGV) {
        this.cuentaIGV = cuentaIGV;
    }

    public int getCuentaCaja() {
        return cuentaCaja;
    }

    public void setCuentaCaja(int cuentaCaja) {
        this.cuentaCaja = cuentaCaja;
    }
}
