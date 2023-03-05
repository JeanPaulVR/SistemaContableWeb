package modelo.logic;

import java.util.List;
import modelo.beans.LibroMayor;
import modelo.dao.LibroMayorDao;

public class LibroMayorLogic {

    private String msj;
    private LibroMayorDao daoLM = new LibroMayorDao();
    private LibroMayor beansLM = new LibroMayor();

    public List Listar(LibroMayor libro, int periodo) {

        String busq = " AND id_periodo = " + periodo + " ";
        List<LibroMayor> lm;
        
        String cuenta = "";
        String fecha = "";
        
        if (libro.getNumero_cuenta()>0) {
            cuenta = "numero_cuenta = " + libro.getNumero_cuenta() + " ";
        }
        if (libro.getFechaInicio() != null) {
            if (libro.getFechaFin() != null) {
                fecha = "fecha BETWEEN '" + libro.getFechaInicio() + "' and '" + libro.getFechaFin() + "' ";
            } else {
                fecha = "fecha BETWEEN '" + libro.getFechaInicio() + "' and NOW() ";
            }
        }
        
        String [] cons = {cuenta, fecha};
        
        for (String con : cons) {
            if (con.compareTo("") != 0) {
                if (busq.compareTo("")!=0) {
                    busq += "AND " + con;
                } else {
                    busq += "WHERE " + con;
                }
            }
        }
        
        lm = daoLM.listar(busq);
        return lm;

    }

}
