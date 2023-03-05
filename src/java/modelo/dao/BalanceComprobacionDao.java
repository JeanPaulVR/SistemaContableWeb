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
import modelo.beans.BalanceComprobacion;

/**
 *
 * @author Jean Paul
 */
public class BalanceComprobacionDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List ListarCuentas(int cuenta, int fi, int ff, int periodo, String tipoAsiento) {

        List<BalanceComprobacion> balances = new ArrayList<>();

        String sql = "select numero, nombre, Sum(debe_soles) as IMPORTEDEBE, Sum(haber_soles) as IMPORTEHABER "
                + "from cuenta_contable cc inner join detalle_asiento da "
                + "on cc.numero = da.numero_cuenta inner join asiento_contable ac "
                + "on da.num_asiento=ac.numero_asiento "
                + "where numero like '" + cuenta + "%' and month(fecha)  between " + fi + " and " + ff + " "
                + "and id_periodo = " + periodo + " "
                + "and tipo_asiento like '%" + tipoAsiento + "%' "
                + "group by numero, nombre";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                BalanceComprobacion bc = new BalanceComprobacion();

                bc.setCuenta(rs.getInt("numero"));
                bc.setNombreCuenta(rs.getString("nombre"));
                bc.setDeudor(rs.getDouble("IMPORTEDEBE"));
                bc.setAcreedor(rs.getDouble("IMPORTEHABER"));
                balances.add(bc);
            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }

        return balances;
    }

    public BalanceComprobacion ListarGananciasyPerdidas(int cuenta, int fi, int ff, int periodo, String tipoAsiento) {

        BalanceComprobacion bc = new BalanceComprobacion();

        String sql = "SELECT SUBSTR(da.numero_cuenta, 1,2 ) AS Numero, cc.nombre as Nombre, "
                + "Sum(debe_soles) as IMPORTEDEBE, Sum(haber_soles) as IMPORTEHABER "
                + "FROM cuenta_contable cc, detalle_asiento da left join asiento_contable ac "
                + "on da.num_asiento = ac.numero_asiento "
                + "where month(ac.fecha) between " + fi + " and " + ff + " "
                + "and da.numero_cuenta like '" + cuenta + "%' "
                + "and cc.numero=SUBSTR(da.numero_cuenta, 1, 2) "
                + "and tipo_asiento like '" + tipoAsiento + "%' "
                + "GROUP BY SUBSTR(da.numero_cuenta, 1, 2),  cc.nombre "
                + "ORDER BY SUBSTR(da.numero_cuenta, 1, 2) asc";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                bc.setCuenta(rs.getInt("Numero"));
                bc.setNombreCuenta(rs.getString("Nombre"));
                bc.setDeudor(rs.getDouble("IMPORTEDEBE"));
                bc.setAcreedor(rs.getDouble("IMPORTEHABER"));
            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }

        return bc;
    }

}
