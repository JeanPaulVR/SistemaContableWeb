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
import modelo.beans.LibroRegistroCompraVenta;

/**
 *
 * @author USER
 */
public class LibroRegistroCompraVentaDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listarCompras(int fi, int ff, int periodo) {

        List<LibroRegistroCompraVenta> Librorc = new ArrayList<>();

        String sql = "SELECT num_asiento, d.fecha_emision as fechae, d.fecha_vencimiento as fechav, d.cod_tipo as tipod, "
                + "d.serie as seried, d.correlativo as correlativod, id_tipoiden , numero_identi, denominacion, "
                + "(coalesce(da.debe_soles,0)+coalesce(da.haber_soles,0)) as Importe, "
                + "( select  (coalesce(das.debe_soles,0)+coalesce(das.haber_soles,0)) "
                + "FROM detalle_asiento das WHERE numero_cuenta = 67611 and das.num_asiento = da.num_asiento) as Diferencia, precio_venta, "
                + "dfk.cod_tipo as tipo1, dfk.serie as serie1, dfk.correlativo as correlativo1, dfk.fecha_emision as fecha1, "
                + "d.MontoISC, d.OtrosM, d.BIAGCFOGE, d.MIGVIPMOPG, d.VANG, d.BIAGCFOGyNG, d.MIGVIPMOPGyNG, d.BIAGsinCF, d.MIGVIPMsinCF, d.ICBPER "
                + "FROM documento d left join tipo_documento td "
                + "on d.cod_tipo = td.codigo left join cuenta_corriente cc "
                + "on d.num_cuentacorriente = cc.numero_identi left join detalle_asiento da "
                + "on d.serie= da.seriedocumento left join asiento_contable ac "
                + "on da.num_asiento= ac.numero_asiento left join tipo_cambio tc "
                + "on da.id_tipocambio = tc.id left join documento dfk "
                + "on d.fk_correlativo = dfk.correlativo "
                + "where codigo_operacion =1201 "
                + "AND MONTH(d.fecha_emision) between " + fi + " AND " + ff + " "
                + "AND id_periodo = " + periodo + " ";
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroRegistroCompraVenta lrc = new LibroRegistroCompraVenta();

                lrc.setNumerocorrelativo(rs.getString("num_asiento"));
                lrc.setFechaemision(rs.getDate("fechae"));
                lrc.setFechavencimiento(rs.getDate("fechav"));
                lrc.setCodtipo(rs.getString("tipod"));
                lrc.setSerie(rs.getString("seried"));
                lrc.setCorrelativo(rs.getString("correlativod"));
                lrc.setTipoidenti(rs.getString("id_tipoiden"));
                lrc.setNumeroidenti(rs.getString("numero_identi"));
                lrc.setDenominacion(rs.getString("denominacion"));
                lrc.setImporte(rs.getDouble("Importe"));
                lrc.setDiferencia(rs.getDouble("Diferencia"));
                lrc.setTipocambio(rs.getDouble("precio_venta"));
                lrc.setFktipo(rs.getString("tipo1"));
                lrc.setFkserie(rs.getString("serie1"));
                lrc.setFkcorrelativo(rs.getString("correlativo1"));
                lrc.setFkfecha(rs.getDate("fecha1"));
                lrc.setMontoISC(rs.getDouble("MontoISC"));
                lrc.setOtrosM(rs.getDouble("OtrosM"));
                lrc.setBIAGCFOGE(rs.getDouble("BIAGCFOGE"));
                lrc.setMIGVIPMOPG(rs.getDouble("MIGVIPMOPG"));
                lrc.setVANG(rs.getDouble("VANG"));
                lrc.setBIAGCFOGyNG(rs.getDouble("BIAGCFOGyNG"));
                lrc.setMIGVIPMOPGyNG(rs.getDouble("MIGVIPMOPGyNG"));
                lrc.setBIAGsinCF(rs.getDouble("BIAGsinCF"));
                lrc.setMIGVIPMsinCF(rs.getDouble("MIGVIPMsinCF"));
                lrc.setICBPER(rs.getDouble("ICBPER"));
                Librorc.add(lrc);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return Librorc;

    }

    public List listarVentas(int fi, int ff, int periodo) {

        List<LibroRegistroCompraVenta> Librorc = new ArrayList<>();

        String sql = "SELECT num_asiento, d.fecha_emision as fechae, d.fecha_vencimiento as fechav ,d.cod_tipo as tipod, d.serie as seried, d.correlativo as correlativod , id_tipoiden , numero_identi, denominacion, "
                + "(coalesce(da.debe_soles,0)+coalesce(da.haber_soles,0)) as Importe, precio_venta, dfk.cod_tipo as tipo1, dfk.serie as serie1, dfk.correlativo as correlativo1, dfk.fecha_emision as fecha1, "
                + "( select  (coalesce(das.debe_soles,0)+coalesce(das.haber_soles,0)) "
                + "FROM detalle_asiento das WHERE numero_cuenta = 77611 and das.num_asiento = da.num_asiento) as Diferencia, "
                + "d.MontoISC, d.OtrosM "
                + "FROM documento d left join tipo_documento td "
                + "on d.cod_tipo = td.codigo left join cuenta_corriente cc "
                + "on d.num_cuentacorriente = cc.numero_identi left join detalle_asiento da "
                + "on d.serie= da.seriedocumento left join asiento_contable ac "
                + "on da.num_asiento= ac.numero_asiento left join tipo_cambio tc "
                + "on da.id_tipocambio = tc.id left join documento dfk "
                + "on d.fk_serie = dfk.serie "
                + "where codigo_operacion =1202 "
                + "AND MONTH(d.fecha_emision) between " + fi + " AND " + ff + " "
                + "AND id_periodo = " + periodo + " ";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroRegistroCompraVenta lrc = new LibroRegistroCompraVenta();

                lrc.setNumerocorrelativo(rs.getString("num_asiento"));
                lrc.setFechaemision(rs.getDate("fechae"));
                lrc.setFechavencimiento(rs.getDate("fechav"));
                lrc.setCodtipo(rs.getString("tipod"));
                lrc.setSerie(rs.getString("seried"));
                lrc.setCorrelativo(rs.getString("correlativod"));
                lrc.setTipoidenti(rs.getString("id_tipoiden"));
                lrc.setNumeroidenti(rs.getString("numero_identi"));
                lrc.setDenominacion(rs.getString("denominacion"));
                lrc.setImporte(rs.getDouble("Importe"));
                lrc.setDiferencia(rs.getDouble("Diferencia"));
                lrc.setTipocambio(rs.getDouble("precio_venta"));
                lrc.setFktipo(rs.getString("tipo1"));
                lrc.setFkserie(rs.getString("serie1"));
                lrc.setFkcorrelativo(rs.getString("correlativo1"));
                lrc.setFkfecha(rs.getDate("fecha1"));
                lrc.setMontoISC(rs.getDouble("MontoISC"));
                lrc.setOtrosM(rs.getDouble("OtrosM"));
                Librorc.add(lrc);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return Librorc;

    }

    public List InventarioBalances(int periodo, String cuenta) {

        List<LibroRegistroCompraVenta> Librorc = new ArrayList<>();

        String sql = "select numero_cuenta, id_tipoiden, numero_identi,denominacion, sum(debe_soles) as DEBE,sum(haber_soles) as HABER "
                + "from tipo_identificacion ti inner join cuenta_corriente cc "
                + "on ti.codigo= cc.id_tipoiden inner join documento d "
                + "on d.num_cuentacorriente= cc.numero_identi inner join detalle_asiento da "
                + "on da.seriedocumento= d.serie inner join asiento_contable ac "
                + "on da.num_asiento = ac.numero_asiento "
                + "where numero_cuenta like '" + cuenta + "%' and id_periodo= " + periodo + " "
                + "group by numero_identi, numero_cuenta";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroRegistroCompraVenta lrc = new LibroRegistroCompraVenta();

                lrc.setCuentaCC(rs.getInt("numero_cuenta"));
                lrc.setTipoidenti(rs.getString("id_tipoiden"));
                lrc.setNumeroidenti(rs.getString("numero_identi"));
                lrc.setDenominacion(rs.getString("denominacion"));
                lrc.setDebe(rs.getDouble("DEBE"));
                lrc.setHaber(rs.getDouble("HABER"));
                Librorc.add(lrc);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return Librorc;

    }
}
