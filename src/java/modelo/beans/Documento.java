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
public class Documento {

    private String serie;
    private String correlativo;
    private String concepto;
    private String ambito;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String formaPago;
    private String numerocuentacorriente;
    private String tipoDoc;
    private String claseBien;
    private int baseImporte;
    private String fkSerie;
    private String fkCorrelativo;
    private Double MontoISC = 0.0;
    private Double OtrosM = 0.0;
    private Double BIAGCFOGE = 0.0;
    private Double MIGVIPMOPG = 0.0;
    private Double VANG = 0.0;
    private Double BIAGCFOGyNG = 0.0;
    private Double MIGVIPMOPGyNG = 0.0;
    private Double BIAGsinCF = 0.0;
    private Double MIGVIPMsinCF = 0.0;
    private Double ICBPER = 0.0;

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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNumerocuentacorriente() {
        return numerocuentacorriente;
    }

    public void setNumerocuentacorriente(String numerocuentacorriente) {
        this.numerocuentacorriente = numerocuentacorriente;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getClaseBien() {
        return claseBien;
    }

    public void setClaseBien(String claseBien) {
        this.claseBien = claseBien;
    }

    public int getBaseImporte() {
        return baseImporte;
    }

    public void setBaseImporte(int baseImporte) {
        this.baseImporte = baseImporte;
    }

    public String getFkSerie() {
        return fkSerie;
    }

    public void setFkSerie(String fkSerie) {
        this.fkSerie = fkSerie;
    }

    public String getFkCorrelativo() {
        return fkCorrelativo;
    }

    public void setFkCorrelativo(String fkCorrelativo) {
        this.fkCorrelativo = fkCorrelativo;
    }

    public Double getMontoISC() {
        return MontoISC;
    }

    public void setMontoISC(Double MontoISC) {
        this.MontoISC = MontoISC;
    }

    public Double getOtrosM() {
        return OtrosM;
    }

    public void setOtrosM(Double OtrosM) {
        this.OtrosM = OtrosM;
    }

    public Double getBIAGCFOGE() {
        return BIAGCFOGE;
    }

    public void setBIAGCFOGE(Double BIAGCFOGE) {
        this.BIAGCFOGE = BIAGCFOGE;
    }

    public Double getMIGVIPMOPG() {
        return MIGVIPMOPG;
    }

    public void setMIGVIPMOPG(Double MIGVIPMOPG) {
        this.MIGVIPMOPG = MIGVIPMOPG;
    }

    public Double getVANG() {
        return VANG;
    }

    public void setVANG(Double VANG) {
        this.VANG = VANG;
    }

    public Double getBIAGCFOGyNG() {
        return BIAGCFOGyNG;
    }

    public void setBIAGCFOGyNG(Double BIAGCFOGyNG) {
        this.BIAGCFOGyNG = BIAGCFOGyNG;
    }

    public Double getMIGVIPMOPGyNG() {
        return MIGVIPMOPGyNG;
    }

    public void setMIGVIPMOPGyNG(Double MIGVIPMOPGyNG) {
        this.MIGVIPMOPGyNG = MIGVIPMOPGyNG;
    }

    public Double getBIAGsinCF() {
        return BIAGsinCF;
    }

    public void setBIAGsinCF(Double BIAGsinCF) {
        this.BIAGsinCF = BIAGsinCF;
    }

    public Double getMIGVIPMsinCF() {
        return MIGVIPMsinCF;
    }

    public void setMIGVIPMsinCF(Double MIGVIPMsinCF) {
        this.MIGVIPMsinCF = MIGVIPMsinCF;
    }

    public Double getICBPER() {
        return ICBPER;
    }

    public void setICBPER(Double ICBPER) {
        this.ICBPER = ICBPER;
    }
}
