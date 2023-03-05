/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.CuentaCorriente;
import modelo.dao.CuentaCorrienteDao;

/**
 *
 * @author USER
 */
public class CuentaCorrienteLogic {

    String msj;
    CuentaCorrienteDao daoCC = new CuentaCorrienteDao();
    CuentaCorriente beansCC = new CuentaCorriente();
    List<CuentaCorriente> cuentaco;

    public String Agregar(CuentaCorriente cuentacorriente) {
        
        cuentaco = daoCC.listar("");

        if (!"".equals(cuentacorriente.getNumero())) {
            int contadorC = 0;
            int contadorA = 0;
            while (contadorC < cuentaco.size()) {
                if (cuentacorriente.getNumero() == cuentaco.get(contadorC).getNumero()) {
                    contadorA++;
                    break;
                }
                contadorC++;
            }
            if (contadorA == 0) {

                msj = daoCC.Agregar(cuentacorriente);
            } else {
                msj = "CUENTA CORRIENTE EXISTENTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {
        
        cuentaco = daoCC.listar(busq);
        return cuentaco;
    }
    
    public CuentaCorriente DatosCC(String busq) {
        beansCC = daoCC.Datos(busq);
        return beansCC;
    }
    
    public int ComprobarModificar(int numero, String denominacion) {

        cuentaco = daoCC.listar("");
        int resultado = 0;

        for (int i = 0; i < cuentaco.size(); i++) {
            if (denominacion.equals(cuentaco.get(i).getDenominacion()) && numero != cuentaco.get(i).getNumero().length()) {
                resultado++;
                break;
            }
        }

        return resultado;
    }
    
    public String Modificar(CuentaCorriente cuentac) {

        if (cuentac.getDenominacion().compareTo("") != 0) {

           int pos=ComprobarModificar(cuentac.getNumero().compareTo(""), cuentac.getDenominacion());

            if (pos == 0) {
                msj = daoCC.Modificar(cuentac);
            } else {
                msj = " CUENTA CORRIENTE EXISTENTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public String Eliminar(int codigo) {

        if (codigo != 0) {
            msj = daoCC.Eliminar(codigo);
        } else {
            msj = "CUENTA CORRIENTE EXISTENTE";
        }

        return msj;
    }
}
