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
import modelo.beans.TipoOperacion;

/**
 *
 * @author ferdinand
 */
public class TipoOperacionDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<TipoOperacion> TipoO = new ArrayList<>();

        String sql = "SELECT * FROM tipo_operacion "
                + "WHERE codigo LIKE '%" + busq + "%' "
                + "OR nombre LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoOperacion to = new TipoOperacion();
                to.setCodigo(rs.getString("codigo"));
                to.setNombre(rs.getString("nombre"));
                to.setTipo_cambio(rs.getString("tipo_cambio"));

                TipoO.add(to);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return TipoO;

    }

    public String Agregar(TipoOperacion TipoO) {

        String sql = "INSERT INTO tipo_operacion("
                + "codigo, "
                + "nombre, "
                + "tipo_cambio) "
                + "VALUES (?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, TipoO.getCodigo());
            ps.setString(2, TipoO.getNombre());
            ps.setString(3, TipoO.getTipo_cambio());

            ps.executeUpdate();

            mensaje = "TIPO DE OPERACION AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR TIPO DE OPERACION: " + e;
        }

        return mensaje;
    }

    public String Editar(TipoOperacion TipoO) {

        String sql = "UPDATE tipo_operacion SET "
                + "nombre=?, "
                + "tipo_cambio=? "
                + "WHERE "
                + "codigo="
                + TipoO.getCodigo();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, TipoO.getNombre());
            ps.setString(2, TipoO.getTipo_cambio());
            ps.executeUpdate();
            mensaje = "TIPO DE OPERACION EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR AL EDITAR TIPO DE OPERACION: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM tipo_operacion WHERE codigo=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "TIPO DE OPERACION ELIMINADO";

        } catch (Exception e) {

            mensaje = "FALLO AL ELIMINAR TIPO DE OPERACION: " + e;

        }

        return mensaje;
    }

    public TipoOperacion Datos(String busq) {

        String sql = "SELECT * "
                + "FROM tipo_operacion "
                + "WHERE codigo = '" + busq + "'";

        TipoOperacion to = new TipoOperacion();
        
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                to.setCodigo(rs.getString("codigo"));
                to.setNombre(rs.getString("nombre"));
                to.setTipo_cambio(rs.getString("tipo_cambio"));

            }

        } catch (Exception e) {
            return null;
        }

        return to;
    }
}
