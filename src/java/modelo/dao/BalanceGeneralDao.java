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
import modelo.beans.BalanceGeneral;

/**
 *
 * @author USER
 */
public class BalanceGeneralDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List reportelistar(int busq, int ff, int digito, int periodo) {

        List<BalanceGeneral> Librobg = new ArrayList<>();

        String sql = "SELECT SUBSTR(da.numero_cuenta, 1, " + digito + ") AS Numero, cc.nombre as Nombre, coalesce(SUM(haber_soles),0) + coalesce(SUM(debe_soles),0) AS TOTAL "
                + "FROM cuenta_contable cc, detalle_asiento da "
                + "left join asiento_contable ac "
                + "on da.num_asiento = ac.numero_asiento "
                + "where month(ac.fecha) between  1 and " + ff + " "
                + "and da.numero_cuenta like '" + busq + "%' "
                + "and cc.numero=SUBSTR(da.numero_cuenta, 1, " + digito + ") "
                + "AND id_periodo = " + periodo + " "
                + "GROUP BY SUBSTR(da.numero_cuenta, 1, " + digito + "),  cc.nombre "
                + "having TOTAL>0 "
                + "ORDER BY SUBSTR(da.numero_cuenta, 1, " + digito + ") asc;";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                BalanceGeneral lbg = new BalanceGeneral();
                lbg.setNumerocuenta(rs.getInt("Numero"));
                lbg.setNombrecuenta(rs.getString("Nombre"));
                lbg.setImporte(rs.getDouble("TOTAL"));
                Librobg.add(lbg);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return Librobg;

    }
}
