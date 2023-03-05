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
import modelo.beans.TipoCambio;

/**
 *
 * @author ferdinand
 */
public class TipoCambioDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<TipoCambio> TipoC = new ArrayList<>();

        String sql = "SELECT * FROM tipo_cambio "
                + "WHERE id LIKE '%" + busq + "%' "
                + "OR nombre LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                TipoCambio tc = new TipoCambio();
                tc.setId(rs.getInt("id"));
                tc.setNombre(rs.getString("nombre"));
                tc.setFecha(rs.getDate("fecha"));
                tc.setPrecio_compra(rs.getDouble("precio_compra"));
                tc.setPrecio_venta(rs.getDouble("precio_venta"));
                TipoC.add(tc);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return TipoC;

    }
    
    public TipoCambio Datos() {
        
        TipoCambio tc = new TipoCambio();
        String sql = "SELECT * FROM tipo_cambio "
                + "ORDER BY fecha DESC";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                tc.setId(rs.getInt("id"));
                tc.setNombre(rs.getString("nombre"));
                tc.setFecha(rs.getDate("fecha"));
                tc.setPrecio_compra(rs.getDouble("precio_compra"));
                tc.setPrecio_venta(rs.getDouble("precio_venta"));

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return tc;

    }

    public String Agregar(TipoCambio TipoC) {

        String sql = "INSERT INTO tipo_cambio("
                + "nombre, "
                + "fecha, "
                + "precio_compra, "
                + "precio_venta) "
                + "VALUES (?,CURDATE(),?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, TipoC.getNombre());
            ps.setDouble(2, TipoC.getPrecio_compra());
            ps.setDouble(3, TipoC.getPrecio_venta());

            ps.executeUpdate();

            mensaje = "TIPO DE CAMBIO AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR TIPO DE CAMBIO: " + e;
        }

        return mensaje;
    }

    public String Editar(TipoCambio TipoC) {

        String sql = "UPDATE tipo_cambio SET "
                + "nombre=?, "
                + "precio_compra=?, "
                + "precio_venta=? "
                + "WHERE "
                + "id="
                + TipoC.getId();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, TipoC.getNombre());
            ps.setDouble(2, TipoC.getPrecio_compra());
            ps.setDouble(3, TipoC.getPrecio_venta());

            mensaje = "TIPO DE CAMBIO EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR AL EDITAR TIPO DE CAMBIO: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM tipo_cambio WHERE id=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "TIPO DE CAMBIO ELIMINADO";

        } catch (Exception e) {

            mensaje = "FALLO AL ELIMINAR TIPO DE CAMBIO: " + e;

        }

        return mensaje;
    }
}
