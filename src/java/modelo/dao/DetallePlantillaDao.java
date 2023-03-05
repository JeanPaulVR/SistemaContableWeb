package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.CuentaContable;
import modelo.beans.DetallePlantilla;

public class DetallePlantillaDao {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(int busq) {

        List<DetallePlantilla> DetalleP = new ArrayList<>();

        String sql = "SELECT * FROM detalle_plantilla "
                + "WHERE id_plantilla = " + busq + ";";


        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
                        
            CuentaContableDao cuentas = new CuentaContableDao();
            CuentaContable c;
            
            while (rs.next()) {

                DetallePlantilla dp = new DetallePlantilla();
                dp.setId_detalle_plantilla(rs.getInt("id_detalle_plantilla"));
                dp.setCuenta(rs.getInt("cuenta"));
                c = cuentas.Datos(dp.getCuenta());
                dp.setNombre_cuenta(c.getNombre());
                
                dp.setId_plantilla(rs.getInt("id_plantilla"));
                DetalleP.add(dp);

            }

        } catch (SQLException e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return DetalleP;

    }
    
    public String Agregar(DetallePlantilla DetalleP) {

        String sql = "INSERT INTO detalle_plantilla("
                + "cuenta,"
                + "id_plantilla) "
                + "VALUES (?,?)";

    try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, DetalleP.getCuenta());
            ps.setInt(2, DetalleP.getId_plantilla());
            ps.executeUpdate();

            mensaje = "DETALLE DE PLANTILLA AGREGADA";

        } catch (SQLException e) {  

            mensaje = "ERROR AL AGREGAR DETALLE DE PLANTILLA: " + e;
        }

        return mensaje;
    }

    public String Modificar(DetallePlantilla DetalleP) {

        String sql = "UPDATE detalle_plantilla SET "
                + "cuenta = ?, "
                + "id_plantilla = ? "
                + "WHERE id_detalle_plantilla = "
                + DetalleP.getId_detalle_plantilla();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, DetalleP.getCuenta());
            ps.setInt(2, DetalleP.getId_plantilla());
            ps.executeUpdate();

            mensaje = "DETALLE DE PLANTILLA EDITADA";

        } catch (SQLException e) {

            mensaje = "ERROR AL EDITAR DETALLE DE PLANTILLA: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM detalle_plantilla WHERE id_detalle_plantilla=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "DETALLE DE PLANTILLA ELIMINADA";

        } catch (SQLException e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;
    }
    
}
