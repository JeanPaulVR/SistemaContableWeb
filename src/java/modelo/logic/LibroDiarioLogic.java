/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.LibroDiario;
import modelo.dao.LibroDiarioDao;

/**
 *
 * @author USER
 */
public class LibroDiarioLogic {
    
    String msj;
    LibroDiarioDao daoLD = new LibroDiarioDao();
    LibroDiario beansLD = new LibroDiario();
    
    public List Listar(LibroDiario libro, int periodo) {
        String busq = "WHERE id_periodo = " + periodo + " ";
        List<LibroDiario> ld;
        
        String codop = "";
        String fecha = "";
        String tipodoc = "";
        String serie = "";
        String correl = "";
        String estado = "";
        
        if (!"".equals(libro.getTipooperacion())) {
            codop = "codigo_operacion = '" + libro.getTipooperacion() + "' ";
        }
        if (libro.getFechaInicio() != null) {
            if (libro.getFechaFin() != null) {
                fecha = "fecha BETWEEN '" + libro.getFechaInicio() + "' and '" + libro.getFechaFin() + "' ";
            } else {
                fecha = "fecha BETWEEN '" + libro.getFechaInicio() + "' and NOW() ";
            }
        }
        if (!"".equals(libro.getTipoDoc())) {
            tipodoc = "cod_tipo = '" + libro.getTipoDoc() + "' ";
        }
        if (!"".equals(libro.getSerie())) {
            serie = "serie = '" + libro.getSerie() + "' ";
        }
        if (!"".equals(libro.getCorrelativo())) {
            correl = "correlativo = '" + libro.getCorrelativo() + "' ";
        }
        if (!"".equals(libro.getEstado())) {
            estado = "estado = '" + libro.getEstado() + "' ";
        }
        
        String [] cons = {codop, fecha, tipodoc, serie, correl, estado};
        
        for (String con : cons) {
            if (con.compareTo("") != 0) {
                if (busq.compareTo("")!=0) {
                    busq += "AND " + con;
                } else {
                    busq += "WHERE " + con;
                }
            }
        }
        
        ld = daoLD.listar(busq);
        return ld;
    }
}
