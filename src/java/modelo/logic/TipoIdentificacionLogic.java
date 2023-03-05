/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.TipoIdentificacion;
import modelo.dao.TipoIdentificacionDao;

/**
 *
 * @author ferdinand
 */
public class TipoIdentificacionLogic {

    String msj;
    TipoIdentificacionDao daoTI = new TipoIdentificacionDao();

    public String Agregar(TipoIdentificacion ti) {

        List<TipoIdentificacion> identificaciones = new ArrayList<>();
        identificaciones = daoTI.listar("");

        if (ti.getCodigo() > 0
                && ti.getNombre().compareTo("") != 0) {

            int cont = 0, l = identificaciones.size(), rep = 0;

            while (cont < l) {

                if (identificaciones.get(cont).getCodigo() == ti.getCodigo()) {
                    rep = rep + 1;
                } else {
                }

                cont = cont + 1;

            }

            if (rep == 0) {
                msj = daoTI.Agregar(ti);
            } else {
                msj = "CODIGO INVALIDO";
            }

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<TipoIdentificacion> ti = new ArrayList<>();
        ti = daoTI.listar(busq);
        return ti;
    }

}
