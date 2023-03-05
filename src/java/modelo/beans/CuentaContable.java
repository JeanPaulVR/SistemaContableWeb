package modelo.beans;

public class CuentaContable {
    
    private int numero;
    private String nombre;   
    private String moneda;
    private String entidad_bancaria;
    private String cuenta_banco;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEntidad_bancaria() {
        return entidad_bancaria;
    }

    public void setEntidad_bancaria(String entidad_bancaria) {
        this.entidad_bancaria = entidad_bancaria;
    }

    public String getCuenta_banco() {
        return cuenta_banco;
    }

    public void setCuenta_banco(String cuenta_banco) {
        this.cuenta_banco = cuenta_banco;
    }
      
}
