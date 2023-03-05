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
import modelo.beans.Usuario;

/**
 *
 * @author Jean Paul
 */
public class UsuarioDao {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion objcon = new Conexion();
    String mensaje;

    public Usuario Datos(String usuario) {

        Usuario u = new Usuario();
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE usuario = '" + usuario + "'";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setCodigo(rs.getInt("codigo"));
                u.setDni(rs.getString("dni"));
                u.setApell(rs.getString("apellidos"));
                u.setNombres(rs.getString("nombres"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setDigitos(rs.getInt("digitosdecontabilidad"));
                u.setPeriodo(rs.getInt("periodo"));
                u.setRUC(rs.getString("ruc"));
                u.setRazonSocial(rs.getString("razon_social"));
                u.setDiferenciaDebe(rs.getInt("diferencia_debe"));
                u.setDiferenciaHaber(rs.getInt("diferencia_haber"));
                u.setCuentaIGV(rs.getInt("cuenta_igv"));
                u.setCuentaCaja(rs.getInt("cuenta_caja"));
            }

        } catch (Exception e) {
            return null;
        }
        return u;
    }

    public Usuario DatosxC(int cod) {

        Usuario u = new Usuario();
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE codigo =" + cod;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                u.setCodigo(rs.getInt("codigo"));
                u.setDni(rs.getString("dni"));
                u.setApell(rs.getString("apellidos"));
                u.setNombres(rs.getString("nombres"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setDigitos(rs.getInt("digitosdecontabilidad"));
                u.setRUC(rs.getString("ruc"));
                u.setRazonSocial(rs.getString("razon_social"));
                u.setDiferenciaDebe(rs.getInt("diferencia_debe"));
                u.setDiferenciaHaber(rs.getInt("diferencia_haber"));
                u.setCuentaIGV(rs.getInt("cuenta_igv"));
                u.setCuentaCaja(rs.getInt("cuenta_caja"));
            }

        } catch (Exception e) {
            return null;
        }
        return u;
    }

    public String Agregar(Usuario usuario) {

        String sql = "INSERT INTO usuario ("
                + "nombres, "
                + "apellidos, "
                + "usuario, "
                + "contraseña,"
                + "dni) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApell());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getDni());

            ps.executeUpdate();

            mensaje = "USUARIO AGREGADO";

        } catch (Exception e) {

            mensaje = "ERROR AL AGREGAR USUARIO: " + e;
        }

        return mensaje;
    }

    public List listarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM usuario ";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Usuario u = new Usuario();
                u.setCodigo(rs.getInt("codigo"));
                u.setDni(rs.getString("dni"));
                u.setApell(rs.getString("apellidos"));
                u.setNombres(rs.getString("nombres"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setDigitos(rs.getInt("digitosdecontabilidad"));
                u.setRUC(rs.getString("ruc"));
                u.setRazonSocial(rs.getString("razon_social"));
                u.setDiferenciaDebe(rs.getInt("diferencia_debe"));
                u.setDiferenciaHaber(rs.getInt("diferencia_haber"));
                u.setCuentaIGV(rs.getInt("cuenta_igv"));
                u.setCuentaCaja(rs.getInt("cuenta_caja"));
                usuarios.add(u);
            }

        } catch (Exception e) {

        }

        return usuarios;

    }

    public int Contar() {

        int n = 0;
        String sql = "SELECT count(codigo) "
                + "FROM usuario";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                n = rs.getInt("count(codigo)");
            }

        } catch (Exception e) {

        }
        return n;
    }
    
    public String ModificarDigitos(int digito, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "digitosdecontabilidad = " + digito + " "
                + "WHERE codigo = " + codigo + ";";

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarPeriodo(int digito, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "periodo = " + digito + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarRUC(String RUC, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "ruc = " + RUC + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarRazonSocial(String razon, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "razon_social = '" + razon + "' "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarDiferenciaD(int diferencia, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "diferencia_debe = " + diferencia + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarDiferenciaH(int diferencia2, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "diferencia_haber = " + diferencia2 + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarIGV(int IGV, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "cuenta_igv = " + IGV + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
    
    public String ModificarCaja(int caja, int codigo){
        
        String sql = "UPDATE usuario SET "
                + "cuenta_caja = " + caja + " "
                + "WHERE codigo =" + codigo;

        try {

            con = objcon.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ACTUALIZADO";

        } catch (Exception e) {
            mensaje = "ERROR";
        }
        return mensaje;
    }
}
