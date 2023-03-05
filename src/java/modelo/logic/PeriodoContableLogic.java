/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import modelo.beans.PeriodoContable;
import modelo.dao.PeriodoContableDao;

/**
 *
 * @author ferdinand
 */
public class PeriodoContableLogic {

    String msj;
    PeriodoContableDao daoPC = new PeriodoContableDao();
    PeriodoContable beansPC = new PeriodoContable();

    public List Listar(String busq) {

        List<PeriodoContable> periodos = new ArrayList<>();
        periodos = daoPC.listar(busq);
        return periodos;
    }
    
    public String Agregar(String año, String fi, String ff) {
        String mensaje;
        if(!"".equals(año) && !"".equals(fi) && !"".equals(ff)){
            PeriodoContable pc = new PeriodoContable();
            pc.setAño(Integer.parseInt(año));
            pc.setFecha_inicio(Date.valueOf(fi));
            pc.setFecha_fin(Date.valueOf(ff));
            mensaje = daoPC.Agregar(pc);    
        }else{
            mensaje = "DATOS INVALIDOS:\n"+
                    "Año="+año+"||Fecha Inicio="+fi+"||Fecha Fin="+ff;
        }
        
        return mensaje;
    }
    
    public PeriodoContable Datos(int id) {
        
        beansPC = daoPC.datos(id);
        return beansPC;
    }
    
    public String Editar(String estado, int id){
        
        msj=daoPC.Editar(estado, id);
        return msj;
        
    }
}
