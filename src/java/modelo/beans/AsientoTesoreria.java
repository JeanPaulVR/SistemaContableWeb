package modelo.beans;

import java.util.Date;

public class AsientoTesoreria {
    
    private String numero_asiento;
    
    private String numero_cuentac;
    
    private String nombre_cuentac;
    
    private String cuenta_auxiliar;
    
    private Date fecha_emision;
    
    private String moneda;
    
    private String tipo_operacion;
    
    private String glosa;
    
    private String tipo_documento;
    
    private String serie;
    
    private String correlativo;
    
    private double importeS;
    
    private double importeD;
    
    private int Clase_Bien;
    
    private int tipo_cambio;
    
    private String tipo_tesoreria;
    
    private String nombre_cuenta_auxiliar;
    
    private String Debe_Haber;

    public String getNumero_cuentac() {
        return numero_cuentac;
    }

    public void setNumero_cuentac(String numero_cuentac) {
        this.numero_cuentac = numero_cuentac;
    }

    public String getNombre_cuentac() {
        return nombre_cuentac;
    }

    public void setNombre_cuentac(String nombre_cuentac) {
        this.nombre_cuentac = nombre_cuentac;
    }

    public String getCuenta_auxiliar() {
        return cuenta_auxiliar;
    }

    public void setCuenta_auxiliar(String cuenta_auxiliar) {
        this.cuenta_auxiliar = cuenta_auxiliar;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
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

    public double getImporteS() {
        return importeS;
    }

    public void setImporteS(double importeS) {
        this.importeS = importeS;
    }

    public double getImporteD() {
        return importeD;
    }

    public void setImporteD(double importeD) {
        this.importeD = importeD;
    }

    public int getClase_Bien() {
        return Clase_Bien;
    }

    public void setClase_Bien(int Clase_Bien) {
        this.Clase_Bien = Clase_Bien;
    }

    public int getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(int tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public String getTipo_tesoreria() {
        return tipo_tesoreria;
    }

    public void setTipo_tesoreria(String tipo_tesoreria) {
        this.tipo_tesoreria = tipo_tesoreria;
    }

    public String getNombre_cuenta_auxiliar() {
        return nombre_cuenta_auxiliar;
    }

    public void setNombre_cuenta_auxiliar(String nombre_cuenta_auxiliar) {
        this.nombre_cuenta_auxiliar = nombre_cuenta_auxiliar;
    }

    public String getDebe_Haber() {
        return Debe_Haber;
    }

    public void setDebe_Haber(String Debe_Haber) {
        this.Debe_Haber = Debe_Haber;
    }

    public String getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(String numero_asiento) {
        this.numero_asiento = numero_asiento;
    }

}
