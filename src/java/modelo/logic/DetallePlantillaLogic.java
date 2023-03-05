package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.DetallePlantilla;
import modelo.dao.DetallePlantillaDao;

public class DetallePlantillaLogic {
    
    private final DetallePlantillaDao dpDao = new  DetallePlantillaDao();
    private final DetallePlantilla dpBeans = new  DetallePlantilla();
    private String mensaje;
    
    public List Listar(int busq) {
        
        List<DetallePlantilla> pantillas = new ArrayList<>();
        pantillas = dpDao.listar(busq);
        return pantillas;
        
    }
    
    public String Agregar(String cu, String pl){
        
        if(!"".equals(cu) &&
           !"".equals(pl)){
            
           dpBeans.setCuenta(Integer.parseInt(cu));
           dpBeans.setId_plantilla(Integer.parseInt(pl));
           mensaje = dpDao.Agregar(dpBeans);
                   
        }else{
            String valorFaltante;
            if(cu.equals("")){
               valorFaltante = "CUENTA VACIA";
            }else{
               valorFaltante= "PLANTILLA VACIA"; 
            }       
            mensaje = "FALTAN DATOS: "+valorFaltante;
        }

        return mensaje;
        
    }
    
    public String Editar(String cu, String pl){
        
        if(!"".equals(cu) &&
           !"".equals(pl)){
            
           dpBeans.setCuenta(Integer.parseInt(cu));
           dpBeans.setId_plantilla(Integer.parseInt(pl));
           mensaje = dpDao.Modificar(dpBeans);
            
        }else{
            String valorFaltante;
            if(cu.equals("")){
               valorFaltante = "CUENTA VACIA";
            }else{
               valorFaltante= "PLANTILLA VACIA"; 
            }      
            mensaje = "FALTAN DATOS: "+valorFaltante;
        }
        
        return mensaje;
    }
    
    public String Eliminar(String id){
        
        if(!"".equals(id)){
            
            mensaje = dpDao.Eliminar(Integer.parseInt(id));
            
        }else{
            mensaje = "ID INVALIDA";
        }
        
        return mensaje;
    }
    
}
