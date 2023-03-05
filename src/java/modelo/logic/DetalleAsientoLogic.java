/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.DetalleAsiento;
import modelo.beans.TipoCambio;
import modelo.dao.DetalleAsientoDao;

/**
 *
 * @author Jean Paul
 */
public class DetalleAsientoLogic {

    String msj;
    DetalleAsientoDao daoAC = new DetalleAsientoDao();
    DetalleAsiento beansAC = new DetalleAsiento();
    List<DetalleAsiento> lista = new ArrayList<>();

    public String Agregar(DetalleAsiento detalle) {
        
        if (detalle.getCuenta() > 0
                && detalle.getTipoCambio() > 0
                && !"".equals(detalle.getNumeroAsiento())
                && !"".equals(detalle.getSerieDoc())) {

            if (detalle.getDebesoles() > 0 || detalle.getDebedolares() > 0) {
                msj = daoAC.AgregarDebe(detalle);
            } else {
                msj = daoAC.AgregarHaber(detalle);
            }

        } else {
            msj = "INCOMPLETO";
        }
        return msj;
    }

    public DetalleAsiento AgregarDebeHaber(int tipocambio, String tipo, double monto) {

        TipoCambioLogic logicTC = new TipoCambioLogic();
        TipoCambio beansTC = new TipoCambio();
        DetalleAsiento det = new DetalleAsiento();

        beansTC = logicTC.DatosUltimo();
        double debeSoles, debeDolares, haberSoles, haberDolares;
        double importe=Math.round(monto * Math.pow(10, 2)) / Math.pow(10, 2);
        
        if (tipo.equals("Debe")) {
            if (tipocambio == 1) {
                debeDolares = Math.round((importe / beansTC.getPrecio_venta()) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setDebesoles(importe);
                det.setDebedolares(debeDolares);
            } else {
                debeSoles = Math.round((importe * beansTC.getPrecio_compra()) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setDebesoles(debeSoles);
                det.setDebedolares(importe);
            }

        } else {
            if (tipocambio == 1) {
                haberDolares = Math.round((importe / beansTC.getPrecio_venta()) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setHabersoles(importe);
                det.setHaberdolares(haberDolares);
            } else {
                haberSoles = debeSoles = Math.round((importe * beansTC.getPrecio_compra()) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setHabersoles(haberSoles);
                det.setHaberdolares(importe);
            }
        }
        det.setTipoCambio(beansTC.getId());

        return det;
    }
    
    public List Listar(String busq, int periodo) {

        lista = daoAC.listarAC(busq, periodo);
        return lista;
    }

    public String Eliminar(List<DetalleAsiento> detalles) {

        for (DetalleAsiento det : detalles) {
            msj=daoAC.Eliminar(det.getId());
        }
        return msj;
    }
}
