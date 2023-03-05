/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.Documento;

/**
 *
 * @author Jean Paul
 */
public class DocumentoDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public List listar(String busq) {

        List<Documento> lista = new ArrayList<>();

        String sql = "SELECT * FROM documento "
                + "WHERE serie LIKE '%" + busq + "%';";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Documento doc = new Documento();
                doc.setSerie(rs.getString("serie"));
                doc.setCorrelativo(rs.getString("correlativo"));
                doc.setConcepto(rs.getString("concepto"));
                doc.setAmbito(rs.getString("ambito"));
                doc.setFechaEmision(rs.getDate("fecha_emision"));
                doc.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                doc.setFormaPago(rs.getString("forma_pago"));
                doc.setNumerocuentacorriente(rs.getString("num_cuentacorriente"));
                doc.setTipoDoc(rs.getString("cod_tipo"));
                doc.setMontoISC(rs.getDouble("MontoISC"));
                doc.setOtrosM(rs.getDouble("OtrosM"));
                doc.setBIAGCFOGE(rs.getDouble("BIAGCFOGE"));
                doc.setMIGVIPMOPG(rs.getDouble("MIGVIPMOPG"));
                doc.setVANG(rs.getDouble("VANG"));
                doc.setBIAGCFOGyNG(rs.getDouble("BIAGCFOGyNG"));
                doc.setMIGVIPMOPGyNG(rs.getDouble("MIGVIPMOPGyNG"));
                doc.setBIAGsinCF(rs.getDouble("BIAGsinCF"));
                doc.setMIGVIPMsinCF(rs.getDouble("MIGVIPMsinCF"));
                doc.setICBPER(rs.getDouble("ICBPER"));
                lista.add(doc);

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return lista;

    }

    public String Agregar(Documento documento) {

        String sql = "INSERT INTO documento("
                + "serie, "
                + "correlativo, "
                + "concepto, "
                + "ambito, "
                + "fecha_emision, "
                + "fecha_vencimiento, "
                + "forma_pago, "
                + "num_cuentacorriente, "
                + "cod_tipo, "
                + "clase_bien, "
                + "fk_serie, "
                + "fk_correlativo, "
                + " MontoISC, "
                + "OtrosM, "
                + "BIAGCFOGE, "
                + "MIGVIPMOPG, "
                + "VANG, "
                + "BIAGCFOGyNG, "
                + "MIGVIPMOPGyNG, "
                + "BIAGsinCF, "
                + "MIGVIPMsinCF, "
                + "ICBPER) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getSerie());
            ps.setString(2, documento.getCorrelativo());
            ps.setString(3, documento.getConcepto());
            ps.setString(4, documento.getAmbito());
            ps.setDate(5, (Date) documento.getFechaEmision());
            ps.setDate(6, (Date) documento.getFechaVencimiento());
            ps.setString(7, documento.getFormaPago());
            ps.setString(8, documento.getNumerocuentacorriente());
            ps.setString(9, documento.getTipoDoc());
            ps.setString(10, documento.getClaseBien());
            ps.setString(11, documento.getFkSerie());
            ps.setString(12, documento.getFkCorrelativo());
            ps.setDouble(13, documento.getMontoISC());
            ps.setDouble(14, documento.getOtrosM());
            ps.setDouble(15, documento.getBIAGCFOGE());
            ps.setDouble(16, documento.getMIGVIPMOPG());
            ps.setDouble(17, documento.getVANG());
            ps.setDouble(18, documento.getBIAGCFOGyNG());
            ps.setDouble(19, documento.getMIGVIPMOPGyNG());
            ps.setDouble(20, documento.getBIAGsinCF());
            ps.setDouble(21, documento.getMIGVIPMsinCF());
            ps.setDouble(22, documento.getICBPER());

            ps.executeUpdate();

            mensaje = "AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;
        }

        return mensaje;
    }

    public String Editar(Documento documento) {

        String sql = "UPDATE documento SET "
                + "concepto=?, "
                + "fecha_emision=?, "
                + "fecha_vencimiento=?, "
                + "num_cuentacorriente=?, "
                + "clase_bien=?, "
                + "fk_serie=?, "
                + "fk_correlativo=?, "
                + " MontoISC=?, "
                + "OtrosM=?, "
                + "BIAGCFOGE=?, "
                + "MIGVIPMOPG=?, "
                + "VANG=?, "
                + "BIAGCFOGyNG=?, "
                + "MIGVIPMOPGyNG=?, "
                + "BIAGsinCF=?, "
                + "MIGVIPMsinCF=?, "
                + "ICBPER=? "
                + "WHERE "
                + "serie= '"
                + documento.getSerie() + "'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento.getConcepto());
            ps.setDate(2, (Date) documento.getFechaEmision());
            ps.setDate(3, (Date) documento.getFechaVencimiento());
            ps.setString(4, documento.getNumerocuentacorriente());
            ps.setString(5, documento.getClaseBien());
            ps.setString(6, documento.getFkSerie());
            ps.setString(7, documento.getFkCorrelativo());
            ps.setDouble(8, documento.getMontoISC());
            ps.setDouble(9, documento.getOtrosM());
            ps.setDouble(10, documento.getBIAGCFOGE());
            ps.setDouble(11, documento.getMIGVIPMOPG());
            ps.setDouble(12, documento.getVANG());
            ps.setDouble(13, documento.getBIAGCFOGyNG());
            ps.setDouble(14, documento.getMIGVIPMOPGyNG());
            ps.setDouble(15, documento.getBIAGsinCF());
            ps.setDouble(16, documento.getMIGVIPMsinCF());
            ps.setDouble(17, documento.getICBPER());
            ps.executeUpdate();
            mensaje = "EDITADO";

        } catch (Exception e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;

    }

    public Documento Datosdoc(String busq) {

        Documento doc = new Documento();
        String sql = " SELECT * FROM documento d INNER JOIN detalle_asiento da on d.serie= da.seriedocumento "
                + "WHERE num_asiento = " + busq;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                doc.setSerie(rs.getString("serie"));
                doc.setCorrelativo(rs.getString("correlativo"));
                doc.setConcepto(rs.getString("concepto"));
                doc.setAmbito(rs.getString("ambito"));
                doc.setFechaEmision(rs.getDate("fecha_emision"));
                doc.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                doc.setFormaPago(rs.getString("forma_pago"));
                doc.setNumerocuentacorriente(rs.getString("num_cuentacorriente"));
                doc.setTipoDoc(rs.getString("cod_tipo"));
                doc.setClaseBien(rs.getString("clase_bien"));
                doc.setFkSerie(rs.getString("fk_serie"));
                doc.setFkCorrelativo(rs.getString("fk_correlativo"));
                doc.setMontoISC(rs.getDouble("MontoISC"));
                doc.setOtrosM(rs.getDouble("OtrosM"));
                doc.setBIAGCFOGE(rs.getDouble("BIAGCFOGE"));
                doc.setMIGVIPMOPG(rs.getDouble("MIGVIPMOPG"));
                doc.setVANG(rs.getDouble("VANG"));
                doc.setBIAGCFOGyNG(rs.getDouble("BIAGCFOGyNG"));
                doc.setMIGVIPMOPGyNG(rs.getDouble("MIGVIPMOPGyNG"));
                doc.setBIAGsinCF(rs.getDouble("BIAGsinCF"));
                doc.setMIGVIPMsinCF(rs.getDouble("MIGVIPMsinCF"));
                doc.setICBPER(rs.getDouble("ICBPER"));

            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return doc;
    }
}
