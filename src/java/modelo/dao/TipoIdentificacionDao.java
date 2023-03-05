/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.TipoIdentificacion;

/**
 *
 * @author ferdinand
 */
public class TipoIdentificacionDao {
    
        
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<TipoIdentificacion> TipoI = new ArrayList<>();

        String sql = "SELECT * FROM tipo_identificacion "
                + "WHERE codigo LIKE '%" + busq + "%' "
                + "OR nombre LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoIdentificacion ti = new TipoIdentificacion();
                ti.setCodigo(rs.getInt("codigo"));
                ti.setNombre(rs.getString("nombre"));

                TipoI.add(ti);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return TipoI;

    }

    public String Agregar(TipoIdentificacion TipoI) {

        String sql = "INSERT INTO tipo_identificacion("
                + "codigo, "
                + "nombre) "
                + "VALUES (?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, TipoI.getCodigo());
            ps.setString(2, TipoI.getNombre());

            ps.executeUpdate();

            mensaje = "TIPO DE IDENTIFICACION AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR TIPO DE IDENTIFICACION: " + e;
        }

        return mensaje;
    }

    public String Editar(TipoIdentificacion TipoI) {

        String sql = "UPDATE tipo_identificacion SET "
                + "nombre=? "
                + "WHERE "
                + "codigo="
                + TipoI.getCodigo();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, TipoI.getNombre());

            mensaje = "TIPO DE IDENTIFICACION EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR AL EDITAR TIPO DE IDENTIFICACION: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM tipo_identificacion WHERE codigo=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "TIPO DE IDENTIFICACION ELIMINADO";

        } catch (Exception e) {

            mensaje = "FALLO AL ELIMINAR TIPO DE IDENTIFICACION: " + e;

        }

        return mensaje;
    }

    

    
}
