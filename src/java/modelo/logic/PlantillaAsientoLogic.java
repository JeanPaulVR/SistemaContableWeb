/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.PlantillaAsiento;
import modelo.dao.PlantillaAsientoDao;

/**
 *
 * @author Jean Paul
 */
public class PlantillaAsientoLogic {
    
    String msj;
    PlantillaAsientoDao daoP = new PlantillaAsientoDao();
    PlantillaAsiento beansP = new PlantillaAsiento();
    List<PlantillaAsiento> plantillas = new ArrayList<>();
    
    private final PlantillaAsientoDao paDao = new  PlantillaAsientoDao();
    private final PlantillaAsiento paBeans = new  PlantillaAsiento();
    
    public List Listar(int cod){
        
        plantillas = daoP.Listar(cod);
        
        return plantillas;
    }
    
    public List Listar2(String busq) {
        
        List<PlantillaAsiento> pantillas = new ArrayList<>();
        pantillas = paDao.listarxCD(busq);
        return pantillas;
        
    }
    
    public String Agregar(String cd, String gl, String cu){
        
        if(!"".equals(cd) &&
           !"".equals(gl) &&
           !"".equals(cu)){
            
           paBeans.setCuentaDestino(Integer.parseInt(cd));
           paBeans.setGlosa(gl);
           paBeans.setCodigoUsuario(Integer.parseInt(cu));
           msj = paDao.Agregar(paBeans);
                   
        }else{
            String valorFaltante;
            if(cd.equals("")){
               valorFaltante = "CUENTA DE DESTINO VACIO";
            }else if(gl.equals("")){
               valorFaltante = "GLOSA VACIO"; 
            }else{
               valorFaltante= "CODIGO DE USUARIO VACIO"; 
            }       
            msj = "FALTAN DATOS: "+valorFaltante;
        }

        return msj;
        
    }
    
    public String Editar(String id, String cd, String gl){
        
        if(!"".equals(cd) &&
           !"".equals(gl) &&
           !"".equals(id)){
          
           paBeans.setId(Integer.parseInt(id));
           paBeans.setCuentaDestino(Integer.parseInt(cd));
           paBeans.setGlosa(gl);
           msj = paDao.Modificar(paBeans);
            
        }else{
            String valorFaltante;
            if(cd.equals("")){
               valorFaltante = "CUENTA DE DESTINO VACIO";
            }else if(gl.equals("")){
               valorFaltante = "GLOSA VACIO"; 
            }else{
               valorFaltante= "CODIGO DE USUARIO VACIO"; 
            }       
            msj = "FALTAN DATOS: "+valorFaltante;
        }
        
        return msj;
    }
    
    public String Eliminar(String id){
        
        if(!"".equals(id)){
            
            msj = paDao.Eliminar(Integer.parseInt(id));
            
        }else{
            msj = "ID INVALIDA";
        }
        
        return msj;
    }
}
