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
import modelo.beans.LibroDiario;

/**
 *
 * @author USER
 */
public class LibroDiarioDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<LibroDiario> Librod = new ArrayList<>();

        String sql = "SELECT codigo_operacion, num_asiento, fecha, moneda, glosa, SUM(debe_soles) AS SSoles , SUM(debe_dolares) AS SDolares, estado "
                + "FROM asiento_contable  ac LEFT JOIN detalle_asiento da ON ac.numero_asiento  = da.num_asiento "
                + "LEFT JOIN documento d ON da.seriedocumento=d.serie "
                + busq
                + "GROUP BY num_asiento, codigo_operacion, fecha, moneda, glosa, estado;";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroDiario ld = new LibroDiario();

                ld.setTipooperacion(rs.getString("codigo_operacion"));
                ld.setNumeroasiento(rs.getString("num_asiento"));
                ld.setFecha(rs.getDate("fecha"));
                ld.setMoneda(rs.getString("moneda"));
                ld.setImporteSoles(rs.getDouble("SSoles"));
                ld.setImporteDolares(rs.getDouble("SDolares"));
                ld.setGlosa(rs.getString("glosa"));
                //ld.setModo(rs.getString("modo"));
                //ld.setTipo(rs.getString("tipo"));
                ld.setEstado(rs.getString("estado"));
                Librod.add(ld);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Librod;

    }

    public List reportelistar(int fi, int ff, int periodo) {

        List<LibroDiario> Librod = new ArrayList<>();

        String sql = "SELECT num_asiento,fecha, glosa, numero_cuenta, nombre, debe_soles, haber_soles "
                + "FROM asiento_contable  ac LEFT JOIN detalle_asiento da ON ac.numero_asiento  = da.num_asiento "
                + "LEFT JOIN cuenta_contable cc ON cc.numero= da.numero_cuenta "
                + "WHERE MONTH(fecha) between " + fi + " AND " + ff + " "
                + "AND id_periodo = " + periodo + " ";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroDiario ld = new LibroDiario();
                ld.setNumeroasiento(rs.getString("num_asiento"));
                ld.setFecha(rs.getDate("fecha"));
                ld.setGlosa(rs.getString("glosa"));
                ld.setNumerocuenta(rs.getInt("numero_cuenta"));
                ld.setNombrecuenta(rs.getString("nombre"));
                ld.setDebesoles(rs.getDouble("debe_soles"));
                ld.setHabersoles(rs.getDouble("haber_soles"));
                Librod.add(ld);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Librod;

    }
}
