/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.CuentaContable;
import modelo.beans.PlantillaAsiento;

/**
 *
 * @author Jean Paul
 */
public class PlantillaAsientoDao {

    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    List<PlantillaAsiento> plantillas = new ArrayList<>();
    int detalles[];

    public List listarxCD(String busq) {

        List<PlantillaAsiento> PlantillaA = new ArrayList<>();

        String sql = "SELECT * FROM plantilla_asiento "
                + "WHERE cuenta_destino LIKE '%" + busq + "%'; ";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            CuentaContableDao cuentas = new CuentaContableDao();
            CuentaContable c;

            while (rs.next()) {

                PlantillaAsiento pa = new PlantillaAsiento();
                pa.setId(rs.getInt("id"));
                pa.setCuentaDestino(rs.getInt("cuenta_destino"));
                c = cuentas.Datos(pa.getCuentaDestino());
                pa.setNombre_cuenta(c.getNombre());
                pa.setGlosa(rs.getString("glosa"));
                pa.setCodigoUsuario(rs.getInt("cod_usuario"));
                PlantillaA.add(pa);

            }

        } catch (SQLException e) {
            System.out.println("OCURRIO EL SIGUIENTE ERROR: " + e);
        }
        return PlantillaA;

    }

    public List Listar(int cod) {

        DetallePlantillaDao detPDao = new DetallePlantillaDao();
        String sql = "SELECT * "
                + "FROM plantilla_asiento "
                + "WHERE cod_usuario = " + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PlantillaAsiento pa = new PlantillaAsiento();
                pa.setId(rs.getInt("id"));
                pa.setCuentaDestino(rs.getInt("cuenta_destino"));
                pa.setGlosa(rs.getString("glosa"));
                pa.setCuentasOrigen(detPDao.listar(pa.getId()));
                plantillas.add(pa);

            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return plantillas;
    }

    public String Agregar(PlantillaAsiento PlantillaA) {

        String sql = "INSERT INTO plantilla_asiento("
                + "cuenta_destino, "
                + "glosa, "
                + "cod_usuario) "
                + "VALUES (?,?,?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, PlantillaA.getCuentaDestino());
            ps.setString(2, PlantillaA.getGlosa());
            ps.setInt(3, PlantillaA.getCodigoUsuario());
            ps.executeUpdate();

            mensaje = "PLANTILLA DE ASIENTO AGREGADA";

        } catch (SQLException e) {

            mensaje = "ERROR AL AGREGAR PLANTILLA DE ASIENTO: " + e;
        }

        return mensaje;
    }

    public String Modificar(PlantillaAsiento PlantillaA) {

        String sql = "UPDATE plantilla_asiento SET "
                + "cuenta_destino = ?, "
                + "glosa = ? "
                + "WHERE id = "
                + PlantillaA.getId();

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, PlantillaA.getCuentaDestino());
            ps.setString(2, PlantillaA.getGlosa());
            ps.executeUpdate();

            mensaje = "PLANTILLA DE ASIENTO EDITADA";

        } catch (SQLException e) {

            mensaje = "ERROR AL EDITAR PLANTILLA DE ASIENTO: " + e;

        }

        return mensaje;

    }

    public String Eliminar(int n) {

        String sql = "DELETE FROM plantilla_asiento WHERE id=" + n;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            mensaje = "PLANTILLA DE ASIENTO ELIMINADA";

        } catch (SQLException e) {

            mensaje = "ERROR: " + e;

        }

        return mensaje;
    }

}
