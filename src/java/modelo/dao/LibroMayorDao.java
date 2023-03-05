package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.LibroMayor;

public class LibroMayorDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    
    public List listar(String busq) {

        List<LibroMayor> LibrodM = new ArrayList<>();
        
               String sql = "SELECT *" +
                     "FROM asiento_contable  ac  " +
                     "LEFT JOIN detalle_asiento da ON  ac.numero_asiento= da.num_asiento " +
                     "LEFT JOIN documento d ON d.serie= da.seriedocumento " + busq;
               
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroMayor lm = new LibroMayor();
                
                lm.setFecha_operacion(rs.getDate("fecha"));
                lm.setNumero_cuenta(rs.getInt("numero_cuenta"));
                lm.setNumero_correlativo("");
                lm.setGlosa(rs.getString("glosa"));
                lm.setDeudor(rs.getDouble("debe_soles"));
                lm.setAcreedor(rs.getDouble("haber_soles"));
                LibrodM.add(lm);
                
            }   

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return LibrodM;

    }
    
    public List repotelistar(int busq, int fi, int ff,int p) {

        List<LibroMayor> LibrodM = new ArrayList<>();

        String sql = "SELECT fecha, glosa, debe_soles, haber_soles "
                + "FROM asiento_contable  ac "
                + " JOIN detalle_asiento da ON  ac.numero_asiento= da.num_asiento "
                + "LEFT JOIN documento d ON d.serie= da.seriedocumento "
                + "WHERE MONTH(fecha) between "+fi+" AND " +ff+ " and numero_cuenta = "+busq+" and id_periodo= "+p
                + " GROUP BY fecha";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroMayor lm = new LibroMayor();

                lm.setFecha_operacion(rs.getDate("fecha"));
                lm.setNumero_correlativo("");
                lm.setGlosa(rs.getString("glosa"));
                lm.setDeudor(rs.getDouble("debe_soles"));
                lm.setAcreedor(rs.getDouble("haber_soles"));
                LibrodM.add(lm);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return LibrodM;

    }

}
