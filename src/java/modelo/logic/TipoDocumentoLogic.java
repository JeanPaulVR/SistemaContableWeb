/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.TipoDocumento;
import modelo.dao.TipoDocumentoDao;

/**
 *
 * @author USER
 */
public class TipoDocumentoLogic {

    String msj;
    TipoDocumentoDao daoCC = new TipoDocumentoDao();
    TipoDocumento beansCC = new TipoDocumento();

    public String Agregar(TipoDocumento clasebien) {

        List<TipoDocumento> tipo;
        tipo = daoCC.listar("");

        if (!"".equals(clasebien.getCodigo())) {

            int contadorC = 0;
            int contadorA = 0;

            while (contadorC < tipo.size()) {
                if (clasebien.getCodigo().equals(tipo.get(contadorC).getCodigo())) {
                    contadorA++;
                    break;
                }
                contadorC++;
            }
            if (contadorA == 0) {
                msj = daoCC.Agregar(clasebien);
            } else {
                msj = "TIPO DOCUMENTO EXISTENTE";
            }

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<TipoDocumento> Tipod;
        Tipod = daoCC.listar(busq);
        return Tipod;
    }
    
    public String Modificar(TipoDocumento tipod) {

        if (tipod.getNombre().compareTo("") != 0) {

           int pos=0;

            if (pos == 0) {
                msj = daoCC.Modificar(tipod);
            } else {
                msj = "NOMBRE DEL DOCUMENTO YA EXISTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public String Eliminar(String codigo) {

        if (codigo.compareTo("") != 0) {
            msj = daoCC.Eliminar(codigo);
        } else {
            msj = "TIPO DOCUMENTO EXISTENTE";
        }

        return msj;
    }
    
}
