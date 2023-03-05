/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.TipoCambio;
import modelo.dao.TipoCambioDao;

/**
 *
 * @author ferdinand
 */
public class TipoCambioLogic {

    String msj;
    TipoCambioDao daoTC = new TipoCambioDao();
    TipoCambio beansTC = new TipoCambio();

    public String Agregar(TipoCambio TipoCambio) {

        List<TipoCambio> cambios = new ArrayList<>();

        if (TipoCambio.getNombre().compareTo("") != 0) {

            List<String> nombres = new ArrayList<>();

            int contadorC = 0;

            while (contadorC < cambios.size()) {
                nombres.add(cambios.get(contadorC).getNombre());
                contadorC = contadorC + 1;
            }

            int pos = nombres.indexOf(TipoCambio.getNombre());

            msj = daoTC.Agregar(TipoCambio);

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<TipoCambio> tp = new ArrayList<>();
        tp = daoTC.listar(busq);
        return tp;
    }
    
    public TipoCambio DatosUltimo() {
        
        beansTC = daoTC.Datos();
        return beansTC;
    }
}
