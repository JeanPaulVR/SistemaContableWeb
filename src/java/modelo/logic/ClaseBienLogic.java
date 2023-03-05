/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.ClaseBien;
import modelo.dao.ClaseBienDao;

/**
 *
 * @author USER
 */
public class ClaseBienLogic {

    String msj;
    ClaseBienDao daoCC = new ClaseBienDao();
    ClaseBien beansCC = new ClaseBien();

    public String Agregar(ClaseBien clasebien) {

        List<ClaseBien> claseb;
        claseb = daoCC.listar("");

        if (clasebien.getCodigo() > 0) {

            int contadorC = 0;
            int contadorA = 0;
            while (contadorC < claseb.size()) {
                if (clasebien.getCodigo() == claseb.get(contadorC).getCodigo()) {
                    contadorA++;
                    break;

                }
                contadorC++;
            }
            if (contadorA == 0) {
                msj = daoCC.Agregar(clasebien);

            } else {
                msj = "CLASE EXISTENTE";
            }

        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        List<ClaseBien> clasebien;
        clasebien = daoCC.listar(busq);
        return clasebien;
    }
    
    public String Modificar(ClaseBien claseb) {

        if (claseb.getNombre().compareTo("") != 0) {

           int pos=0;

            if (pos == 0) {
                msj = daoCC.Modificar(claseb);
            } else {
                msj = "NOMBRE DE LA CLASE BIEN YA EXISTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public String Eliminar(int numero) {

        if (numero != 0) {
            msj = daoCC.Eliminar(numero);
        } else {
            msj = "CLASE BIEN EXISTENTE";
        }

        return msj;
    }
    
}
