/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logic;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Usuario;
import modelo.dao.UsuarioDao;

/**
 *
 * @author Jean Paul
 */
public class UsuarioLogic {

    String msj;
    UsuarioDao daoU = new UsuarioDao();
    Usuario beansU = new Usuario();

    public String Ingresar(String usuario, String contraseña) {

        //Verificacion del usuario y contraseña
        beansU = daoU.Datos(usuario);

        if (usuario.compareTo("") != 0) {
            if (contraseña.compareTo("") != 0) {
                if (beansU.getUsuario() != null) {
                    if (beansU.getContraseña().compareTo(contraseña) == 0) {
                        msj = "INGRESO_USUARIO";
                    } else {
                        msj = "CONTRASEÑA INCORRECTA";
                    }
                } else {
                    msj = "EL NOMBRE DE USUARIO NO EXISTE";
                }
            } else {
                msj = "INGRESE LA CONTRASEÑA";
            }
        } else {
            msj = "NECESITA INGRESAR SU NOMBRE DE USUARIO";
        }

        return msj;

    }

    public Usuario DatosU(String usuario) {
        beansU = daoU.Datos(usuario);
        return beansU;
    }

    public Usuario DatosUxC(int cod) {
        beansU = daoU.DatosxC(cod);
        return beansU;
    }

    public String Registro(Usuario usuario) {

        //validacion de los parametros ingresados 
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = daoU.listarUsuarios();

        if (usuario.getDni().compareTo("") != 0
                && usuario.getApell().compareTo("") != 0
                && usuario.getNombres().compareTo("") != 0
                && usuario.getUsuario().compareTo("") != 0
                && usuario.getContraseña().compareTo("") != 0) {

            if (usuario.getUsuario().length() > 5) {
                
                List<String> contenedorUsuario = new ArrayList<>();

                int n = usuarios.size();
                int contadorU = 0;

                while (contadorU < n) {
                    contenedorUsuario.add(usuarios.get(contadorU).getUsuario());
                    contadorU = contadorU + 1;
                }

                int posU = contenedorUsuario.indexOf(usuario.getUsuario());

                if (posU >= 0) {

                    msj = "EL USUARIO YA EXISTE";

                } else {
                    if (usuario.getDni().length() == 8) {
                        msj = (daoU.Agregar(usuario));
                    } else {
                        msj = "!El DNI DEBE CONTENER 8 NUMEROS¡";
                    }
                }
            } else {
                msj = "NOMBRE DE USUARIO INVALIDO";
            }
        } else {
            msj = "FALTAN DATOS";
        }

        return msj;
    }

    public String ModificarDigito(int digito, Usuario usuario){
        
        if(digito > usuario.getDigitos()){
            msj = daoU.ModificarDigitos(digito, usuario.getCodigo());
        }else{
            msj = "NO PUEDE REDUCIR EL NUMERO DE DIGITOS";
        }
        return msj;
    }
    
    public String ModificarPeriodo(int digito, Usuario usuario){
        
        msj = daoU.ModificarPeriodo(digito, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarRUC(String RUC, Usuario usuario){
        
        msj = daoU.ModificarRUC(RUC, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarRazonSocial(String razon, Usuario usuario){
        
        msj = daoU.ModificarRazonSocial(razon, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarDiferenciaD(int diferencia, Usuario usuario){
        
        msj = daoU.ModificarDiferenciaD(diferencia, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarDiferenciaH(int diferencia2, Usuario usuario){
        
        msj = daoU.ModificarDiferenciaH(diferencia2, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarCaja(int caja, Usuario usuario){
        
        msj = daoU.ModificarCaja(caja, usuario.getCodigo());
        return msj;
    }
    
    public String ModificarIGV(int IGV, Usuario usuario){
        
        msj = daoU.ModificarIGV(IGV, usuario.getCodigo());
        return msj;
    }
    
    public int Contar() {

        int n = daoU.Contar();
        return n;
    }
    
}
