/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.DetalleAsiento;

/**
 *
 * @author Jean Paul
 */
public class DetalleAsientoDao {

    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<DetalleAsiento> lista = new ArrayList<>();

        String sql = "SELECT * FROM detalle_asiento "
                + "WHERE iddetalle_asiento LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                DetalleAsiento da = new DetalleAsiento();
                da.setId(rs.getInt("iddetalle_asiento"));
                da.setDebesoles(rs.getDouble("debe_soles"));
                da.setDebedolares(rs.getDouble("debe_dolares"));
                da.setHabersoles(rs.getDouble("haber_soles"));
                da.setHaberdolares(rs.getDouble("heber_dolares"));
                da.setTipoCambio(rs.getInt("id_tipocambio"));
                da.setCuenta(rs.getInt("numero_cuenta"));
                da.setSerieDoc(rs.getString("seriedocumento"));
                da.setNumeroAsiento(rs.getString("num_asiento"));
                lista.add(da);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return lista;
    }

    public String AgregarDebe(DetalleAsiento detalle) {

        String sql = "INSERT INTO detalle_asiento("
                + "debe_soles, "
                + "debe_dolares, "
                + "numero_cuenta, "
                + "id_tipocambio, "
                + "seriedocumento, "
                + "num_asiento) "
                + "VALUES (?,?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, detalle.getDebesoles());
            ps.setDouble(2, detalle.getDebedolares());
            ps.setInt(3, detalle.getCuenta());
            ps.setInt(4, detalle.getTipoCambio());
            ps.setString(5, detalle.getSerieDoc());
            ps.setString(6, detalle.getNumeroAsiento());

            ps.executeUpdate();

            mensaje = "AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;
        }

        return mensaje;
    }

    public String AgregarHaber(DetalleAsiento detalle) {

        String sql = "INSERT INTO detalle_asiento("
                + "haber_soles, "
                + "haber_dolares, "
                + "numero_cuenta, "
                + "id_tipocambio, "
                + "seriedocumento, "
                + "num_asiento) "
                + "VALUES (?,?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, detalle.getHabersoles());
            ps.setDouble(2, detalle.getHaberdolares());
            ps.setInt(3, detalle.getCuenta());
            ps.setInt(4, detalle.getTipoCambio());
            ps.setString(5, detalle.getSerieDoc());
            ps.setString(6, detalle.getNumeroAsiento());

            ps.executeUpdate();

            mensaje = "AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;
        }

        return mensaje;
    }

    public List listarAC(String busq, int periodo) {
        
        List<DetalleAsiento> lista = new ArrayList<>();
        String sql = "SELECT * from detalle_asiento da inner join cuenta_contable cc on da.numero_cuenta=cc.numero "
                + "inner join asiento_contable ac on ac.numero_asiento = da.num_asiento "
                + "WHERE num_asiento ='" + busq + "' "
                + "AND id_periodo = " + periodo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetalleAsiento da = new DetalleAsiento();
                da.setId(rs.getInt("iddetalle_asiento"));
                da.setDebesoles(rs.getDouble("debe_soles"));
                da.setDebedolares(rs.getDouble("debe_dolares"));
                da.setHabersoles(rs.getDouble("haber_soles"));
                da.setHaberdolares(rs.getDouble("haber_dolares"));
                da.setTipoCambio(rs.getInt("id_tipocambio"));
                da.setCuenta(rs.getInt("numero_cuenta"));
                da.setSerieDoc(rs.getString("seriedocumento"));
                da.setNumeroAsiento(rs.getString("num_asiento"));
                da.setNombrecc(rs.getString("nombre"));
                lista.add(da);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return lista;
    }

    public String Eliminar(int id) {
        String sql = "DELETE FROM detalle_asiento WHERE iddetalle_asiento=" + id;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "ELIMINADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;
    }
}
