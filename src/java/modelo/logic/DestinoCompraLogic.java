/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.CuentaContable;
import modelo.beans.DestinoCompra;
import modelo.dao.CuentaContableDao;
import modelo.dao.DestinoCompraDao;

/**
 *
 * @author ferdinand
 */
public class DestinoCompraLogic {
    
    String msj;
    DestinoCompraDao daoDC = new  DestinoCompraDao();
    DestinoCompra beansDC = new  DestinoCompra();
    CuentaContableDao daoCC = new  CuentaContableDao();
    
    
    public String Agregar(DestinoCompra dc) {
        
        List<DestinoCompra> compras = new ArrayList<>();
        compras=daoDC.listar("");
        
        List<CuentaContable> cuentas = new ArrayList<>();
        cuentas=daoCC.listar("");
        
        List<Integer> numeros = new ArrayList<>();
        
        if (dc.getCuenta_origen()>0 &&
            dc.getCuenta_cargo()>0  &&
            dc.getCuenta_abono()>0) {
           
            int cont=0, l=compras.size(), rep=0;
            
            while(cont<l){  
            if(compras.get(cont).getCuenta_origen()==dc.getCuenta_origen()){
                rep=rep+1;
            }
            cont=cont+1;
            }
            
            if(rep==0){
            int ref=0;
            while(ref<daoCC.listar("").size()){
            numeros.add(ref, cuentas.get(ref).getNumero());
            ref=ref+1;    
            }    
                
            int posicion1 = numeros.indexOf(dc.getCuenta_origen());
            int posicion2 = numeros.indexOf(dc.getCuenta_cargo());
            int posicion3 = numeros.indexOf(dc.getCuenta_abono());
            
            if(posicion1!=-1){  
                if(posicion2!=-1){
                    if(posicion3!=0-1){
                    msj=daoDC.Agregar(dc);
                    }else{
                msj="CUENTA ABONO INEXISTENTE";    
                }
                }else{
                msj="CUENTA CARGO INEXISTENTE";    
                } 
            }else{
            msj="CUENTA ORIGEN INEXISTENTE";    
            }
            
            } else{
            msj = "CUENTA DE ORIGEN INVALIDA";
            }
            
           
            
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    public String Editar(String[] destino_compra) {
            
        List<CuentaContable> cuentas = new ArrayList<>();
        cuentas=daoCC.listar("");
        
        List<Integer> numeros = new ArrayList<>();
        
        if (destino_compra[0].compareTo("")!=0 &&
            destino_compra[1].compareTo("")!=0 &&
            destino_compra[2].compareTo("")!=0) {
            
            int ref=0;
            
            while(ref<daoCC.listar("").size()){
            numeros.add(ref, cuentas.get(ref).getNumero());
            ref=ref+1;    
            }    
                
            int posicion1 = numeros.indexOf(Integer.parseInt(destino_compra[0]));
            int posicion2 = numeros.indexOf(Integer.parseInt(destino_compra[1]));
            int posicion3 = numeros.indexOf(Integer.parseInt(destino_compra[2]));
            
            if(posicion1!=-1){  
                if(posicion2!=-1){
                    if(posicion3!=0-1){
                   
                       int valor[]= new int [3];
                       for(int i = 0; i < 3; i++){
                       if(destino_compra[i].substring(0, 1).compareTo("2") == 0 ||
                          destino_compra[i].substring(0, 1).compareTo("4") == 0 ||
                          destino_compra[i].substring(0, 1).compareTo("6") == 0 ){    
                       valor[i]=1;
                       }
                       }
                       if(valor[0]!=0 && valor[1]!=0 && valor[2]!=0){
                        if(destino_compra[0].compareTo(destino_compra[1])!=0 &&
                           destino_compra[0].compareTo(destino_compra[2])!=0){  
                        beansDC.setCuenta_origen(Integer.parseInt(destino_compra[0]));
                        beansDC.setCuenta_cargo(Integer.parseInt(destino_compra[1]));
                        beansDC.setCuenta_abono(Integer.parseInt(destino_compra[2]));
                        msj=daoDC.Editar(beansDC);
                        }else{
                            msj="LAS CUENTAS NO PUEDEN SER LAS MISMAS";
                        }
                       }else{
                           msj="SOLO SE PUEDEN EMPLEAR LOS SIGUIENTES ELEMENTOS: 2, 4 Y 6";
                       }
                    }else{
                msj="CUENTA ABONO INEXISTENTE";    
                }
                }else{
                msj="CUENTA CARGO INEXISTENTE";    
                } 
            }else{
            msj="CUENTA ORIGEN INEXISTENTE";    
            }
            
        } else {
            msj = "FALTAN DATOS";
        }
        return msj;
    }
    
    
    public List Listar(String busq) {
        
        List<DestinoCompra> dc= new ArrayList<>();
        dc = daoDC.listar(busq);
        return dc;
    }
    
    public DestinoCompra VerificarDC(int codigo){
        
        beansDC = daoDC.Datos(codigo);
        return beansDC;
    }
    
    public String Eliminar(String ID){
        
        msj = daoDC.Eliminar(Integer.parseInt(ID));
        
        return msj;
    }
}
