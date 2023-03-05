package modelo.beans;

import java.util.Date;

public class LibroCajaBanco {

    private String numero_correlativo;
    private Date fecha_operacion;
    private String descripcion;
    private int codigo;
    private String NombreCC;
    private String NombreCCont;
    private String denominacion;
    private double deudor;
    private double acreedor;
    private String nombrebanco;
    private int numeroCuenta;
    private String formaPago;
    private String cuentaBanco;
    private String codigoEntidad;

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    public String getNumero_correlativo() {
        return numero_correlativo;
    }

    public void setNumero_correlativo(String numero_correlativo) {
        this.numero_correlativo = numero_correlativo;
    }

    public Date getFecha_operacion() {
        return fecha_operacion;
    }

    public void setFecha_operacion(Date fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNombreCC() {
        return NombreCC;
    }

    public void setNombreCC(String NombreCC) {
        this.NombreCC = NombreCC;
    }

    public String getNombreCCont() {
        return NombreCCont;
    }

    public void setNombreCCont(String NombreCCont) {
        this.NombreCCont = NombreCCont;
    }

    public String getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(String cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

}
