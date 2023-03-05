package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.AsientoTesoreria;
import modelo.dao.AsientoTesoreriaDao;

public class AsientoTesoreriaLogic {
    
    private final AsientoTesoreriaDao atDao = new  AsientoTesoreriaDao();
    
    public List Listar(String serie, String correlativo, int periodo){
        
        List<AsientoTesoreria> asientos = new ArrayList<>();
        String busq;
        if(!"".equals(serie) && !"".equals(correlativo)){
           busq = "WHERE serie = '"+serie+"' AND correlativo = '"+correlativo+"'"; 
           asientos = atDao.listar(busq, periodo);
        }
        return asientos;
    }
    
    public String Crear_Serie(int periodo){
        String valores = atDao.Crear_Serie(periodo);
        return valores;
    }
    
    public String VerifiarValores(int pe, int cu, String na, String fe, 
                                  String gl, String to, String au, String mp,
                                  String cc, String md, String vvs){
        String mensaje;
        
        if(pe==0 || cu == 0 || "".equals(na) || 
           "".equals(fe) || "".equals(gl) || "".equals(to) || 
           "".equals(au) || "".equals(mp) || "".equals(md)){
            
            mensaje="DATOS INVALIDOS\n"+
                    "Periodo="+pe+"||Codigo usuario="+cu+"||Numero asiento="+na
                    +"||Fecha="+fe+"||Glosa="+gl+"||Tipo operacion="+to
                    +"||Cuenta corriente="+au+"||Metodo de pago="+mp+"||Moneda="+md;
            
        }else{     
            
            if(vvs.equals("DATOS VALIDOS")){
                mensaje = vvs;
            }else{
                mensaje = vvs;
            }
            
        }
          
        return mensaje;
    }
    
    public String VerifiarValoresSeleccionado(String tds, String ccs, String cbs, String ips, 
                                  String dhs, String srs, String ncs){
        String mensaje;
        
        if("".equals(tds) || "".equals(ccs) || "".equals(cbs) || 
           "".equals(ips) || "".equals(dhs) || "".equals(srs) ||
           "".equals(ncs)){
            
            mensaje="Tipo Documento Seleccionado="+tds+"||Cuenta Corriente Seleccionado="+ccs+"||Clase Bien Seleccionado="+cbs
                    +"||Importe Seleccionado="+ips+"||Debe_Haber Seleccionado="+dhs+"||Serie Seleccionado="+srs
                    +"||Numero Cuenta Contable="+ncs;
            
        }else{
            mensaje = "DATOS VALIDOS";        
        }
        
        return mensaje;
    }
    
}
