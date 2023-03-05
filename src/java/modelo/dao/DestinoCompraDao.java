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
import modelo.beans.DestinoCompra;


/**
 *
 * @author ferdinand
 */
public class DestinoCompraDao {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<DestinoCompra> DestinoC = new ArrayList<>();

        String sql = "SELECT * FROM destino_compra "
                + "WHERE cuenta_origen LIKE '%" + busq + "%' "
                + "OR cuenta_cargo LIKE '%" + busq + "%' "
                + "OR cuenta_abono LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                DestinoCompra dc = new DestinoCompra();
                dc.setCuenta_origen(rs.getInt("cuenta_origen"));
                dc.setCuenta_cargo(rs.getInt("cuenta_cargo"));
                dc.setCuenta_abono(rs.getInt("cuenta_abono"));

                DestinoC.add(dc);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return DestinoC;

    }

    public String Agregar(DestinoCompra DestinoC) {

        String sql = "INSERT INTO destino_compra("
                + "cuenta_origen, "
                + "cuenta_cargo, "
                + "cuenta_abono) "
                + "VALUES (?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, DestinoC.getCuenta_origen());
            ps.setInt(2, DestinoC.getCuenta_cargo());
            ps.setInt(3, DestinoC.getCuenta_abono());

            ps.executeUpdate();

            mensaje = "DESTINO DE COMPRA AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR DESTINO DE COMPRA: " + e;
        }

        return mensaje;
    }

    public String Editar(DestinoCompra DestinoC) {

        String sql = "UPDATE destino_compra SET "
                + "cuenta_cargo=?, "
                + "cuenta_abono=? "
                + "WHERE "
                + "cuenta_origen="
                + DestinoC.getCuenta_origen();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, DestinoC.getCuenta_cargo());
            ps.setInt(2, DestinoC.getCuenta_abono());
            ps.executeUpdate();
            mensaje = "DESTINO DE COMPRA EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR AL EDITAR DESTINO DE COMPRA: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM destino_compra WHERE cuenta_origen=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "DESTINO DE COMPRA ELIMINADO";

        } catch (Exception e) {

            mensaje = "FALLO AL ELIMINAR DESTINO DE COMPRA: " + e;

        }

        return mensaje;
    }
    
    public DestinoCompra Datos(int busq) {

        String sql = "SELECT * "
                + "FROM destino_compra "
                + "WHERE cuenta_origen = " + busq;

        DestinoCompra dc = new DestinoCompra();
        
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                dc.setCuenta_origen(rs.getInt("cuenta_origen"));
                dc.setCuenta_cargo(rs.getInt("cuenta_cargo"));
                dc.setCuenta_abono(rs.getInt("cuenta_abono"));
            }

        } catch (Exception e) {
            return null;
        }

        return dc;
    }
}
