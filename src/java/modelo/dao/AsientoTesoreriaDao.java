package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.AsientoTesoreria;
import modelo.logic.CuentaCorrienteLogic;

public class AsientoTesoreriaDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();

    private List Repetidos(int periodo) {

        List<String> seriedocumento = new ArrayList<>();

        String sql = "SELECT seriedocumento, "
                + "count(*) AS cantidad "
                + "FROM detalle_asiento da inner join asiento_contable ac on "
                + " ac.numero_asiento = da.num_asiento "
                + "WHERE id_periodo = " + periodo + " "
                + "GROUP BY seriedocumento "
                + "HAVING count(*) > 1;";
        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                seriedocumento.add(rs.getString("seriedocumento"));
            }

        } catch (SQLException e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return seriedocumento;
    }

    public List listar(String busq, int periodo) {

        List<AsientoTesoreria> asientoT = new ArrayList<>();
        List<String> seriedocumento = this.Repetidos(periodo);

        String sql = "select numero, nombre, numero_identi, fecha_emision, ac.moneda, codigo_operacion, "
                + "glosa,cod_tipo,serie, correlativo, debe_soles, haber_soles, debe_dolares, haber_dolares, clase_bien, id_tipocambio "
                + "from documento d inner join detalle_asiento da "
                + "on d.serie=da.seriedocumento inner join asiento_contable ac "
                + "on ac.numero_asiento = da.num_asiento inner join cuenta_contable cc "
                + "on cc.numero=da.numero_cuenta inner join cuenta_corriente cco "
                + "on cco.numero_identi= d.num_cuentacorriente " + busq
                + " and id_periodo = " + periodo + " ";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                AsientoTesoreria at = new AsientoTesoreria();
                at.setNumero_cuentac(rs.getString("numero"));
                at.setNombre_cuentac(rs.getString("nombre"));
                at.setCuenta_auxiliar(rs.getString("numero_identi"));
                at.setFecha_emision(rs.getDate("fecha_emision"));
                at.setMoneda(rs.getString("ac.moneda"));
                at.setTipo_operacion(rs.getString("codigo_operacion"));
                at.setGlosa(rs.getString("glosa"));
                at.setTipo_documento(rs.getString("cod_tipo"));
                at.setSerie(rs.getString("serie"));
                at.setCorrelativo(rs.getString("correlativo"));
                at.setImporteS(rs.getDouble("debe_soles"));
                at.setClase_Bien(rs.getInt("clase_bien"));
                at.setTipo_cambio(rs.getInt("id_tipocambio"));

                //FUNCIONES//
                CuentaCorrienteLogic cc = new CuentaCorrienteLogic();
                at.setNombre_cuenta_auxiliar(cc.DatosCC(at.getCuenta_auxiliar()).getDenominacion());

                if (at.getImporteS() > 0) {
                    at.setImporteD(rs.getDouble("debe_dolares"));
                    at.setTipo_tesoreria("Comprobante de Pago Compra");
                    at.setDebe_Haber("Haber");
                } else {
                    at.setImporteS(rs.getDouble("haber_soles"));
                    at.setImporteD(rs.getDouble("haber_dolares"));
                    at.setTipo_tesoreria("Comprobante de Pago Venta");
                    at.setDebe_Haber("Debe");
                }

                //verificar duplicidad de serie documento
                int pos = seriedocumento.indexOf(at.getSerie());
                if (pos == -1) {
                    asientoT.add(at);
                }

            }
        } catch (SQLException e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return asientoT;
    }

    public String Crear_Serie(int periodo) {

        List<String> serie = new ArrayList<>();

        String sql = "SELECT serie FROM documento "
                + "WHERE id_periodo = " + periodo + " ";

        String valor;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("serie").substring(0, 3).equals("TES")) {
                    serie.add(rs.getString("serie"));
                }
            }
        } catch (SQLException e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }

        if (serie.isEmpty()) {
            valor = "TES00001";
        } else {
            int numero = 0;
            for (int i = 0; i < serie.size(); i++) {
                int n = Integer.parseInt(serie.get(i).substring(3, 8));
                if (n > numero) {
                    numero = n;
                }
            }
            String cont = String.valueOf(numero);
            String ser = "";

            for (int i = 0; i < (5 - cont.length()); i++) {
                ser += 0;
            }
            numero++;
            ser += numero;
            valor = "TES" + ser;
        }

        return valor;
    }

}
