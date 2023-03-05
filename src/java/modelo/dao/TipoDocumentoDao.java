/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.TipoDocumento;

/**
 *
 * @author USER
 */
public class TipoDocumentoDao {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;
    
    
    public List listar(String busq) {

        List<TipoDocumento> Tipod = new ArrayList<>();

        String sql = "SELECT * FROM tipo_documento "
                + "WHERE nombre LIKE '%" + busq + "%' "
                + "OR codigo LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoDocumento td = new TipoDocumento();
                td.setCodigo(rs.getString("codigo"));
                td.setNombre(rs.getString("nombre"));
               

                Tipod.add(td);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Tipod;

    }

    public String Agregar(TipoDocumento tipodo) {

        String sql = "INSERT INTO tipo_documento( "
                + "codigo, "
                + "nombre) "
                + "VALUES (?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipodo.getCodigo());
            ps.setString(2, tipodo.getNombre());

            ps.executeUpdate();

            mensaje = "TIPO DOCUMENTO AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR TIPO DOCUMENTO: " + e;
        }

        return mensaje;
    }
    
    public String Modificar(TipoDocumento tipod) {

        String sql = "UPDATE tipo_documento SET "
                + "nombre = ? "
                + "WHERE codigo = "
                + tipod.getCodigo();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipod.getNombre());
            ps.executeUpdate();

            mensaje = "TIPO DOCUMENTO EDITADO";

        } catch (SQLException e) {

            mensaje = "ERROR AL EDITAR TIPO DOCUMENTO: " + e;

        }

        return mensaje;

    }

    public String Eliminar(String n) {

        String sql = "DELETE FROM tipo_documento WHERE codigo=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "TIPO DE DOCUMENTO ELIMINADO";

        } catch (SQLException e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;
    }

    
}
