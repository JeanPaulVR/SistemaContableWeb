package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.LibroCajaBanco;

public class LibroCajaBancoDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(int banco, int fi, int ff, int periodo) {

        List<LibroCajaBanco> LibrodCB = new ArrayList<>();

        String sql = " select numero_asiento, ac.fecha as FechaO, d.forma_pago as FPago, d.concepto Conc, cc.denominacion as DenomCC, cco.numero as CtaCont, cco.nombre as NomCC, debe_soles, haber_soles "
                + "from asiento_contable ac left join detalle_asiento da "
                + "on ac.numero_asiento= da.num_asiento left join documento d "
                + "on d.serie= da.seriedocumento left join cuenta_corriente cc "
                + "on d.num_cuentacorriente=cc.numero_identi left join cuenta_contable cco "
                + "on da.numero_cuenta=cco.numero "
                + "where seriedocumento is not null and numero_cuenta = " + banco + " "
                + "and id_periodo= " + periodo + " "
                + "and month(fecha) between " + fi + " and " + ff;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroCajaBanco lcb = new LibroCajaBanco();
                lcb.setNumero_correlativo((rs.getString("numero_asiento")));
                lcb.setFecha_operacion((rs.getDate("FechaO")));
                lcb.setFormaPago(rs.getString("FPago"));
                lcb.setDescripcion(rs.getString("Conc"));
                lcb.setNombreCC(rs.getString("DenomCC"));
                lcb.setNumeroCuenta(rs.getInt("CtaCont"));
                lcb.setNombreCCont(rs.getString("NomCC"));
                lcb.setDeudor(rs.getDouble("debe_soles"));
                lcb.setAcreedor(rs.getDouble("haber_soles"));
                LibrodCB.add(lcb);

            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return LibrodCB;

    }

    public double saldo(int banco, int fi, int ff, int periodo) {

        String sql = "select sum(debe_soles) as DEBE, sum(haber_soles) as HABER "
                + "from asiento_contable ac left join detalle_asiento da "
                + "on ac.numero_asiento= da.num_asiento left join documento d "
                + "on d.serie= da.seriedocumento left join cuenta_corriente cc "
                + "on d.num_cuentacorriente=cc.numero_identi left join cuenta_contable cco "
                + "on da.numero_cuenta=cco.numero "
                + "where seriedocumento is not null and numero_cuenta = " + banco + " "
                + "and month(fecha) between " + fi + " and " + fi + " "
                + "and id_periodo= " + periodo + " "
                + "group by numero_cuenta;";

        double debe = 0;
        double haber = 0;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                debe = rs.getDouble("DEBE");
                haber = rs.getDouble("HABER");
            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return debe - haber;

    }

    public double saldoAp(int banco, int fi, int ff, int periodo) {

        String sql = "SELECT debe_soles as DEBE, haber_dolares as HABER "
                + "from asiento_contable ac inner join detalle_asiento da "
                + "on ac.numero_asiento= da.num_asiento "
                + "where tipo_asiento = 1 and numero_cuenta=10411 and id_periodo= " + periodo + " ";

        double debe = 0;
        double haber = 0;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                debe = rs.getDouble("DEBE");
                haber = rs.getDouble("HABER");
            }

        } catch (Exception e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return debe - haber;

    }

    public List listarbancos() {

        List<LibroCajaBanco> lcyb = new ArrayList<>();

        String sql = "SELECT  * "
                + "FROM cuenta_contable "
                + "where numero like '1041%' and moneda is not null";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroCajaBanco lcb = new LibroCajaBanco();
                lcb.setNombrebanco(rs.getString("nombre"));
                lcb.setNumeroCuenta(rs.getInt("numero"));
                lcyb.add(lcb);
            }

        } catch (Exception e) {

        }

        return lcyb;

    }

    public List InventarioBalance(int periodo) {

        List<LibroCajaBanco> lcyb = new ArrayList<>();

        String sql = "select numero, nombre, entidad_bancaria, cuenta_banco, sum(debe_soles) as DEBE, sum(haber_soles) as HABER "
                + "from cuenta_contable cc left join detalle_asiento da  "
                + "on cc.numero= da.numero_cuenta left join documento d  "
                + "on da.seriedocumento=d.serie left join asiento_contable ac "
                + "on da.num_asiento=ac.numero_asiento "
                + "where numero like '10%' "
                + "and id_periodo = " + periodo + " " 
                + "group by numero, nombre";
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                LibroCajaBanco lcb = new LibroCajaBanco();
                lcb.setNombrebanco(rs.getString("nombre"));
                lcb.setNumeroCuenta(rs.getInt("numero"));
                lcb.setCuentaBanco(rs.getString("cuenta_banco"));
                lcb.setCodigoEntidad(rs.getString("entidad_bancaria"));
                lcb.setAcreedor(rs.getDouble("DEBE"));
                lcb.setDeudor(rs.getDouble("HABER"));
                lcyb.add(lcb);
            }

        } catch (Exception e) {

        }

        return lcyb;

    }

}
