/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.TipoOperacion;
import modelo.dao.TipoOperacionDao;

/**
 *
 * @author ferdinand
 */
public class TipoOperacionLogic {

    String msj;
    TipoOperacionDao daoTO = new TipoOperacionDao();
    TipoOperacion beansTO = new TipoOperacion();

    public String Agregar(TipoOperacion tp) {

        List<TipoOperacion> operaciones = new ArrayList<>();
        operaciones = daoTO.listar("");

        if (tp.getCodigo().compareTo("") != 0
                && tp.getTipo_cambio().compareTo("") != 0
                && tp.getNombre().compareTo("") != 0) {

            int cont = 0, l = operaciones.size(), rep = 0;

            while (cont < l) {

                if (operaciones.get(cont).getCodigo().equals(tp.getCodigo())) {
                    rep = rep + 1;
                } else {
                }

                cont = cont + 1;
            }

            if (rep == 0) {
                msj = daoTO.Agregar(tp);
            } else {
                msj = "CODIGO INVALIDO";
            }

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<TipoOperacion> tp = new ArrayList<>();
        tp = daoTO.listar(busq);
        return tp;
    }

    public TipoOperacion DatosTO(String busq) {
        beansTO = daoTO.Datos(busq);
        return beansTO;
    }
    
    public String Editar(String [] tipo_operacion){
        
        if (tipo_operacion[0].compareTo("") != 0
                && tipo_operacion[1].compareTo("") != 0
                && tipo_operacion[2].compareTo("") != 0) {
            beansTO.setCodigo(tipo_operacion[0]);
            beansTO.setNombre(tipo_operacion[1]);
            beansTO.setTipo_cambio(tipo_operacion[2]);
            msj = daoTO.Editar(beansTO);
        }else{
            msj = "FALTAN DATOS";  
        }
          
        return msj;
    }
    
    public String Eliminar(String cod){
        
        msj = daoTO.Eliminar(Integer.parseInt(cod));
        
        return msj;
    }
}
