/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.List;
import modelo.beans.CuentaContable;
import modelo.dao.CuentaContableDao;

/**
 *
 * @author Jean Paul
 */
public class CuentaContableLogic {

    String msj;
    CuentaContableDao daoCC = new CuentaContableDao();
    CuentaContable beansCC = new CuentaContable();
    List<CuentaContable> cuentas;

    public String Agregar(CuentaContable cuentacontable) {

        if (cuentacontable.getNumero() > 0
                && cuentacontable.getNombre().compareTo("") != 0) {

            int posnombre = Existencia(0, cuentacontable.getNombre());
            int posnumero = Existencia(cuentacontable.getNumero(), "");
            int contadorPadre = CuentaPadre(cuentacontable.getNumero());
            
            if (posnumero == 0) {
                if (posnombre == 0) {
                    if (Integer.toString(cuentacontable.getNumero()).length() > 2) {

                        if (contadorPadre > 0) {
                            msj = daoCC.Agregar(cuentacontable);

                        } else {
                            msj = "CUENTA PADRE INEXISTENTE";
                        }
                    } else {
                        msj = daoCC.Agregar(cuentacontable);
                    }
                } else {
                    msj = "NOMBRE DE LA CUENTA YA EXISTE";
                }
            } else {
                msj = "NUMERO DE LA CUENTA YA EXISTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public List Listar(String busq) {

        cuentas = daoCC.listar(busq);
        return cuentas;
    }

    public int CuentaPadre(int numero) {
        
        String padreString = String.valueOf(numero);
        padreString = padreString.substring(0, padreString.length() - 1);

        int padre = Integer.parseInt(padreString);
        int contadorPadre = Existencia(padre, "");
        return contadorPadre;
    }
    
    public int CuentaHijo(int numero) {
        
        cuentas = daoCC.listar("");
        
        int hijo=numero*10;
        int contadorHijo = 0;
        
        for(int i=0; i<9; i++){
            for(int j=0; j<cuentas.size(); j++){
                if(cuentas.get(j).getNumero()==hijo){
                    contadorHijo++;
                    break;
                }
            }
            hijo++;
        }
        return contadorHijo;
    }

    public int Existencia(int numero, String nombre) {

        cuentas = daoCC.listar("");
        int i = 0;
        int resultado = 0;

        while (i < cuentas.size()) {
            if (numero > 0) {
                if (numero == cuentas.get(i).getNumero()) {
                    resultado++;
                    break;
                }
            } else {
                if (cuentas.get(i).getNombre().equals(nombre)) {
                    resultado++;
                    break;
                }
            }
            i++;
        }
        return resultado;
    }

    public int ComprobarModificar(int codigo, String nombre) {

        cuentas = daoCC.listar("");
        int resultado = 0;

        for (int i = 0; i < cuentas.size(); i++) {
            if (nombre.equals(cuentas.get(i).getNombre()) && codigo != cuentas.get(i).getNumero()) {
                resultado++;
                break;
            }
        }

        return resultado;
    }

    public String Modificar(CuentaContable cuentacontable) {

        if (cuentacontable.getNombre().compareTo("") != 0) {

            int pos = ComprobarModificar(cuentacontable.getNumero(), cuentacontable.getNombre());

            if (pos == 0) {
                msj = daoCC.Modificar(cuentacontable);
            } else {
                msj = "NOMBRE DE LA CUENTA YA EXISTE";
            }
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }

    public String Eliminar(int numero) {

        int hijo = CuentaHijo(numero);
        if (numero > 0) {
            if (hijo==0) {
                msj = daoCC.Eliminar(numero);
            }else{
                msj = "SUBCUENTAS EXISTENTES";
            }
        } else {
            msj = "SELECCIONE UNA CUENTA";
        }
        return msj;
    }

    public CuentaContable DatosCC(int busq) {
        beansCC = daoCC.Datos(busq);
        return beansCC;
    }
}