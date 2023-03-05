/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.AsientoContable;
import modelo.beans.AsientoTesoreria;
import modelo.beans.BalanceComprobacion;
import modelo.beans.ClaseBien;
import modelo.beans.CuentaContable;
import modelo.beans.CuentaCorriente;
import modelo.beans.DestinoCompra;
import modelo.beans.DetalleAsiento;
import modelo.beans.DetallePlantilla;
import modelo.beans.Documento;
import modelo.beans.LibroCajaBanco;
import modelo.beans.LibroDiario;
import modelo.beans.LibroMayor;
import modelo.beans.PeriodoContable;
import modelo.beans.PlantillaAsiento;
import modelo.beans.TipoCambio;
import modelo.beans.TipoDocumento;
import modelo.beans.TipoIdentificacion;
import modelo.beans.TipoOperacion;
import modelo.beans.Usuario;
import modelo.dao.AsientoTesoreriaDao;
import modelo.dao.BalanceComprobacionDao;
import modelo.logic.AsientoContableLogic;
import modelo.logic.AsientoTesoreriaLogic;
import modelo.logic.ClaseBienLogic;
import modelo.logic.CuentaContableLogic;
import modelo.logic.CuentaCorrienteLogic;
import modelo.logic.DestinoCompraLogic;
import modelo.logic.DetalleAsientoLogic;
import modelo.logic.DetallePlantillaLogic;
import modelo.logic.DocumentoLogic;
import modelo.logic.LibroCajaBancoLogic;
import modelo.logic.LibroDiarioLogic;
import modelo.logic.LibroMayorLogic;
import modelo.logic.PeriodoContableLogic;
import modelo.logic.PlantillaAsientoLogic;
import modelo.logic.TipoCambioLogic;
import modelo.logic.TipoDocumentoLogic;
import modelo.logic.TipoIdentificacionLogic;
import modelo.logic.TipoOperacionLogic;
import modelo.logic.UsuarioLogic;

/**
 *
 * @author Jean Paul
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private String acceso = "";
    private String msj = "";
    private String rutaUrl = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rutaUrl = request.getParameter("URL");

        switch (rutaUrl) {
            case "registrar":
                Registrar(request, response);
                break;
            case "ingresar":
                Ingresar(request, response);
                break;
            case "agregar_cuentacontable":
                AgregarCuentaContable(request, response);
                break;
            case "agregar_cuentacorriente":
                AgregarCuentaCorriente(request, response);
                break;
            case "agregar_clasebien":
                AgregarClaseBien(request, response);
                break;
            case "agregar_tipodocumento":
                AgregarTipoDocumento(request, response);
                break;
            case "agregar_detalleasiento":
                AgregarDetalleAsiento(request, response);
                break;
            case "agregar_detalleplantilla":
                AgregarDetallePlantilla(request, response);
                break;
            case "finalizar_asientocontable":
                FinalizarAsientoContable(request, response);
                break;
            case "finalizar_asientotesoreria":
                FinalizarAsientoTesoreria(request, response);
                break;
            case "agregar_tipooperacion":
                AgregarTipoOperacion(request, response);
                break;
            case "agregar_numeroasiento":
                AgregarNumeroAsiento(request, response);
                break;
            case "agregar_tipoidentificacion":
                AgregarTipoIdentificacion(request, response);
                break;
            case "agregar_tipocambio":
                AgregarTipoCambio(request, response);
                break;
            case "agregar_destinocompra":
                AgregarDestinoCompra(request, response);
                break;
            case "agregar_plantillacierre":
                AgregarPlantillaCierre(request, response);
                break;
            case "area_dashboard":
                AreaDashboard(request, response);
                break;
            case "listar_cuentacontable":
                ListarCuentaContable(request, response);
                break;
            case "listar_cuentacorriente":
                ListarCuentaCorriente(request, response);
                break;
            case "listar_clasebien":
                ListarClaseBien(request, response);
                break;
            case "listar_tipodocumento":
                ListarTipoDocumento(request, response);
                break;
            case "listar_periodocontable":
                ListarPeriodoContable(request, response);
                break;
            case "listar_tipocambio":
                ListarTipoCambio(request, response);
                break;
            case "listar_tipooperacion":
                ListarTipoOperacion(request, response);
                break;
            case "listar_tipoidentificacion":
                ListarTipoIdentificacion(request, response);
                break;
            case "listar_destinocompra":
                ListarDestinoCompra(request, response);
                break;
            case "listar_detalleasiento":
                ListarDetalleAsiento(request, response);
                break;
            case "listar_librodiario":
                ListarLibroDiario(request, response);
                break;
            case "listar_libromayor":
                ListarLibroMayor(request, response);
                break;
            case "listar_librocajabanco":
                ListarLibroCajaBanco(request, response);
                break;
            case "listar_detalleplantilla":
                ListarDetallePlantilla(request, response);
                break;
            case "modificar_digitos":
                ModificarDigitos(request, response);
                break;
            case "modificar_cuentacontable":
                ModificarCuentaContable(request, response);
                break;
            case "eliminar_cuentacorriente":
                EliminarCuentaCorriente(request, response);
                break;
            case "modificar_cuentacorriente":
                ModificarCuentaCorriente(request, response);
                break;
            case "modificar_clasebien":
                ModificarClaseBien(request, response);
                break;
            case "modificar_tipodocumento":
                ModificarTipoDocumento(request, response);
                break;
            case "eliminar_clasebien":
                EliminarClaseBien(request, response);
                break;
            case "eliminar_tipodocumento":
                EliminarTipoDocumento(request, response);
                break;
            case "eliminar_cuentacontable":
                EliminarCuentaContable(request, response);
                break;
            case "cancelar_asientocontable":
                CancelarAsientoContable(request, response);
                break;
            case "recuperar_detalle":
                RecuperarDetalleA(request, response);
                break;
            case "recuperar_documento":
                RecuperarDocumento(request, response);
                break;
            case "mostrar_nombreTO":
                MostrarNombreTO(request, response);
                break;
            case "mostrar_nombreCC":
                MostrarNombreCC(request, response);
                break;
            case "mostrar_nombreCCorriente":
                MostrarNombreCCorriente(request, response);
                break;
            case "modificar_periodocontable":
                ModificarPeriodoContable(request, response);
                break;
            case "modificar_detalleasiento":
                ModificarDetalleAsiento(request, response);
                break;
            case "modificar_destinocompra":
                ModificarDestinoCompra(request, response);
                break;
            case "eliminar_destinocompra":
                EliminarDestinoCompra(request, response);
                break;
            case "modificar_tipooperacion":
                ModificarTipoOperacion(request, response);
                break;
            case "eliminar_tipooperacion":
                EliminarTipoOperacion(request, response);
                break;
            case "eliminar_detalleasiento":
                EliminarDetalleAsiento(request, response);
                break;
            case "area_agregardocumento":
                ListarAsientoTesoreria(request, response);
                break;
            case "listar_plantillacierre":
                ListarPlantillaCierre(request, response);
                break;
            case "modificar_plantillacierre":
                ModificarPlantillaCierre(request, response);
                break;
            case "eliminar_plantillacierre":
                EliminarPlantillaCierre(request, response);
                break;
            case "listar_detallesBD":
                ListarDetallesBD(request, response);
                break;
            case "listar_asientotesoreria":
                ListarAsientoTesoreria(request, response);
                break;
            case "guardar_detalleasmodificados":
                GuardarDetallesModificados(request, response);
                break;
            case "cierre_cuentasresultado":
                CierreCuentasResultado(request, response);
                break;
            case "cierre_cuentasbalance":
                CierreCuentasBalance(request, response);
                break;
            case "modificar_detalleplantilla":
                ModificarDetallePlantilla(request, response);
                break;
            case "eliminar_detalleplantilla":
                EliminarDetallePlantilla(request, response);
                break;
            case "asiento_apertura":
                AsientoApertura(request, response);
                break;
            case "ajustar_cambio":
                AjustarCambio(request, response);
                break;
            case "area_plancontable":
                AreaPlanContable(request, response);
                break;
            case "area_clasebien":
                AreaClaseBien(request, response);
                break;
            case "area_tipodocumento":
                AreaTipoDocumento(request, response);
                break;
            case "area_cuentacorriente":
                AreaCuentaCorriente(request, response);
                break;
            case "area_asientocontable":
                AreaAsientoContable(request, response);
                break;
            case "area_tipocambio":
                AreaTipoCambio(request, response);
                break;
            case "area_tipooperacion":
                AreaTipoOperacion(request, response);
                break;
            case "area_destinocompra":
                AreaDestinoCompra(request, response);
                break;
            case "area_periodos":
                AreaPeriodoContable(request, response);
                break;
            case "area_tipoidentificacion":
                AreaTipoIdentificacion(request, response);
                break;
            case "agregar_periodocontable":
                AgregarPeriodoContable(request, response);
                break;
            case "area_librodiario":
                AreaLibroDiario(request, response);
                break;
            case "area_libromayor":
                AreaLibroMayor(request, response);
                break;
            case "area_consultas":
                AreaConsultas(request, response);
                break;
            case "area_informes":
                AreaInformes(request, response);
                break;
            case "area_ajustes":
                AreaAjustes(request, response);
                break;
            case "area_librocajabanco":
                AreaLibroCajaBanco(request, response);
                break;
            case "area_plantillacierre":
                AreaPlantillaCierre(request, response);
                break;
            case "probarlista":
                ProbarListas(request, response);
                break;
            case "area_asientotesoreria":
                AreaAsientoTesoreria(request, response);
                break;

            default:
                throw new AssertionError();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    //Areas de la Pagina
    public void AreaDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaDashboard.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPlanContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPlanContable.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaCuentaCorriente.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaClaseBien.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoDocumento.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoCambio.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaAsientoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaAsientoContable.jsp";
        CancelarAsientoContable(request, response);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaLibroDiario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaLibroDiario.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaConsultas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaConsultas.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaInformes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaInformes.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaAjustes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaAjustes.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoOperacion.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaDestinoCompra.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPeriodoContable.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaTipoIdentificacion.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaLibroMayor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaLibroMayor.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaLibroCajaBanco(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaLibroCajaBanco.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaPlantillaCierre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaPlantillaCierre.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AreaAsientoTesoreria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        acceso = "/AreaAsientoTesoreria.jsp";
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    //Funciones
    public void Registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = new Usuario();

        uB.setDni(request.getParameter("txtDni"));
        uB.setApell(request.getParameter("txtApellidos"));
        uB.setNombres(request.getParameter("txtNombres"));
        uB.setUsuario(request.getParameter("txtUsuario"));
        uB.setContraseña(request.getParameter("txtContraseña"));

        msj = uL.Registro(uB);
        acceso = "/index.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void Ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String usuario = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtContraseña");

        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB = uL.DatosU(usuario);

        msj = uL.Ingresar(usuario, contraseña);

        if (msj.compareTo("INGRESO_USUARIO") == 0) {

            //creamos la sesion
            HttpSession osesion = request.getSession();
            osesion.setAttribute("Usuario", uB);
            osesion.setAttribute("verif", "clnt");
            response.sendRedirect("AreaDashboard.jsp");

        } else {

            acceso = "/index.jsp";
            request.setAttribute("msj", msj);
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

        }
    }

    public void AgregarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String nombre = request.getParameter("txtNombre");
        String moneda = String.valueOf(request.getParameter("txtMoneda"));
        String entidad_bancaria = request.getParameter("txtEntidad");
        String cuenta_banco = request.getParameter("txtCuenta");
        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB = new CuentaContable();
        ccB.setNumero(numero);
        ccB.setNombre(nombre);
        ccB.setMoneda(moneda);
        ccB.setEntidad_bancaria(entidad_bancaria);
        ccB.setCuenta_banco(cuenta_banco);

        msj = msj = ccL.Agregar(ccB);
        acceso = "/AreaPlanContable.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumeroM"));
        String nombre = request.getParameter("txtNombreM");
        String moneda = String.valueOf(request.getParameter("txtMonedaM"));

        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB = new CuentaContable();

        ccB.setNumero(numero);
        ccB.setNombre(nombre);
        ccB.setMoneda(moneda);

        msj = ccL.Modificar(ccB);

        response.getWriter().print(msj);
    }

    public void EliminarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumeroM"));

        CuentaContableLogic ccL = new CuentaContableLogic();

        msj = ccL.Eliminar(numero);

        response.getWriter().print(msj);
    }

    public void ListarCuentaContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaContableLogic ccL = new CuentaContableLogic();

        String busq = request.getParameter("busq");

        List<CuentaContable> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String numero = request.getParameter("txtNumero");
        String denominacion = request.getParameter("txtDenominacion");
        String pais = request.getParameter("txtPais");
        String Direccion = request.getParameter("txtDireccion");
        String idtipo = request.getParameter("txtidtipo");

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();
        CuentaCorriente ccB = new CuentaCorriente();

        ccB.setNumero(numero);
        ccB.setDenominacion(denominacion);
        ccB.setPais(pais);
        ccB.setDireccion(Direccion);
        ccB.setIdtipo(idtipo);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaCuentaCorriente.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigo");
        String nombre = request.getParameter("txtNombre");

        TipoDocumentoLogic ccL = new TipoDocumentoLogic();
        TipoDocumento ccB = new TipoDocumento();

        ccB.setCodigo(codigo);
        ccB.setNombre(nombre);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaTipoDocumento.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();

        String busq = request.getParameter("busq");

        List<CuentaCorriente> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarPlantillaCierre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PlantillaAsientoLogic paL = new PlantillaAsientoLogic();

        String busq = request.getParameter("busq");

        List<PlantillaAsiento> lista;
        lista = paL.Listar2(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarPlantillaCierre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        Usuario usu = (Usuario) osesion.getAttribute("Usuario");
        String cd = request.getParameter("txtCuenta_destinoM");
        String gl = request.getParameter("txtGlosaM");
        String cu = String.valueOf(usu.getCodigo());

        PlantillaAsientoLogic paL = new PlantillaAsientoLogic();

        msj = paL.Agregar(cd, gl, cu);

        acceso = "/AreaPlantillaCierre.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarPlantillaCierre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cd = request.getParameter("txtCuenta_destinoM");
        String gl = request.getParameter("txtGlosaM");
        String id = request.getParameter("txtNumeroM");

        PlantillaAsientoLogic paL = new PlantillaAsientoLogic();

        msj = paL.Editar(id, cd, gl);
        response.getWriter().print(msj);
    }

    public void EliminarPlantillaCierre(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("txtNumeroM");

        PlantillaAsientoLogic paL = new PlantillaAsientoLogic();

        msj = paL.Eliminar(id);

        response.getWriter().print(msj);
    }

    public void AgregarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nombre = request.getParameter("txtNombre");

        ClaseBienLogic ccL = new ClaseBienLogic();
        ClaseBien ccB = new ClaseBien();

        ccB.setCodigo(codigo);
        ccB.setNombre(nombre);

        msj = ccL.Agregar(ccB);
        acceso = "/AreaClaseBien.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ClaseBienLogic ccL = new ClaseBienLogic();

        String busq = request.getParameter("busq");

        List<ClaseBien> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoDocumentoLogic ccL = new TipoDocumentoLogic();
        String busq = request.getParameter("busq");

        List<TipoDocumento> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarLibroMayor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        LibroMayorLogic lmL = new LibroMayorLogic();
        LibroMayor lmB = new LibroMayor();

        if (!"".equals(request.getParameter("txtCuenta"))) {
            lmB.setNumero_cuenta(Integer.parseInt(request.getParameter("txtCuenta")));
        }
        if (!"".equals(request.getParameter("txtFecha_inicio"))) {
            lmB.setFechaInicio(Date.valueOf(request.getParameter("txtFecha_inicio")));
        }
        if (!"".equals(request.getParameter("txtFecha_fin"))) {
            lmB.setFechaFin(Date.valueOf(request.getParameter("txtFecha_fin")));
        }

        List<LibroMayor> lista;
        lista = lmL.Listar(lmB, uB.getPeriodo());

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PeriodoContableLogic ccL = new PeriodoContableLogic();

        String busq = request.getParameter("busq");

        List<PeriodoContableLogic> lista;
        lista = ccL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarLibroDiario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        LibroDiarioLogic ldL = new LibroDiarioLogic();
        LibroDiario libro = new LibroDiario();

        libro.setTipooperacion(request.getParameter("txttipoOpe"));

        if (!"".equals(request.getParameter("txtFechain"))) {
            libro.setFechaInicio(Date.valueOf(request.getParameter("txtFechain")));
        }
        if (!"".equals(request.getParameter("txtFechafin"))) {
            libro.setFechaFin(Date.valueOf(request.getParameter("txtFechafin")));
        }

        libro.setSerie(request.getParameter("txtserie"));
        libro.setCorrelativo(request.getParameter("txtcorrel"));
        libro.setTipoDoc(request.getParameter("txttipoDoc"));
        if (String.valueOf(request.getParameter("txtestado")) != null) {
            libro.setEstado(String.valueOf(request.getParameter("txtestado")));
        }

        List<LibroDiario> lista;
        lista = ldL.Listar(libro, uB.getPeriodo());
        //String aaa= ldL.Listar(libro);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nombre = request.getParameter("txtNombre");
        double pc = Double.parseDouble(request.getParameter("txtPrecio_compra"));
        double pv = Double.parseDouble(request.getParameter("txtPrecio_venta"));

        TipoCambioLogic tcL = new TipoCambioLogic();
        TipoCambio tcB = new TipoCambio();

        tcB.setNombre(nombre);
        tcB.setPrecio_compra(pc);
        tcB.setPrecio_venta(pv);
        msj = tcL.Agregar(tcB);

        acceso = "/AreaTipoCambio.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoCambioLogic tcL = new TipoCambioLogic();

        String busq = request.getParameter("busq");

        List<TipoCambioLogic> lista;
        lista = tcL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigo");

        String nombre = request.getParameter("txtNombre");
        String tipo_cambio = request.getParameter("txtTipo_cambio");

        TipoOperacionLogic toL = new TipoOperacionLogic();
        TipoOperacion toB = new TipoOperacion();

        toB.setCodigo(codigo);
        toB.setNombre(nombre);
        toB.setTipo_cambio(tipo_cambio);
        msj = toL.Agregar(toB);
        acceso = "/AreaTipoOperacion.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String[] destino_compra = new String[3];

        destino_compra[0] = request.getParameter("txtCuenta_origenM");
        destino_compra[1] = request.getParameter("txtCuenta_cargoM");
        destino_compra[2] = request.getParameter("txtCuenta_abonoM");

        DestinoCompraLogic dcL = new DestinoCompraLogic();

        msj = dcL.Editar(destino_compra);

        response.getWriter().print(msj);
    }

    public void EliminarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ID = request.getParameter("txtCuenta_origenM");

        DestinoCompraLogic dcL = new DestinoCompraLogic();

        msj = dcL.Eliminar(ID);

        response.getWriter().print(msj);
    }

    public void ModificarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String[] tipo_operacion = new String[3];

        tipo_operacion[0] = request.getParameter("txtCodigoM");
        tipo_operacion[1] = request.getParameter("txtNombreM");
        tipo_operacion[2] = request.getParameter("txtTipo_cambioM");

        TipoOperacionLogic tcL = new TipoOperacionLogic();

        msj = tcL.Editar(tipo_operacion);

        response.getWriter().print(msj);
    }

    public void EliminarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigoM");

        TipoOperacionLogic toL = new TipoOperacionLogic();

        msj = toL.Eliminar(codigo);

        response.getWriter().print(msj);
    }

    public void ListarTipoOperacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoOperacionLogic toL = new TipoOperacionLogic();

        String busq = request.getParameter("busq");

        List<TipoOperacionLogic> lista;
        lista = toL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int codigo;
        if (request.getParameter("txtCodigo").compareTo("") != 0) {
            codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        } else {
            codigo = 0;
        }

        String nombre = request.getParameter("txtNombre");

        TipoIdentificacionLogic tiL = new TipoIdentificacionLogic();
        TipoIdentificacion tiB = new TipoIdentificacion();

        tiB.setCodigo(codigo);
        tiB.setNombre(nombre);
        msj = tiL.Agregar(tiB);
        acceso = "/AreaTipoIdentificacion.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarTipoIdentificacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoIdentificacionLogic tiL = new TipoIdentificacionLogic();

        String busq = request.getParameter("busq");

        List<TipoIdentificacionLogic> lista;
        lista = tiL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int cuenta_origen, cuenta_cargo, cuenta_abono;

        if (request.getParameter("txtCuenta_origen").compareTo("") != 0) {
            cuenta_origen = Integer.parseInt(request.getParameter("txtCuenta_origen"));
        } else {
            cuenta_origen = 0;
        }
        if (request.getParameter("txtCuenta_cargo").compareTo("") != 0) {
            cuenta_cargo = Integer.parseInt(request.getParameter("txtCuenta_cargo"));
        } else {
            cuenta_cargo = 0;
        }
        if (request.getParameter("txtCuenta_abono").compareTo("") != 0) {
            cuenta_abono = Integer.parseInt(request.getParameter("txtCuenta_abono"));
        } else {
            cuenta_abono = 0;
        }

        DestinoCompraLogic dcL = new DestinoCompraLogic();
        DestinoCompra dcB = new DestinoCompra();

        dcB.setCuenta_origen(cuenta_origen);
        dcB.setCuenta_cargo(cuenta_cargo);
        dcB.setCuenta_abono(cuenta_abono);
        msj = dcL.Agregar(dcB);
        acceso = "/AreaDestinoCompra.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ListarDestinoCompra(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DestinoCompraLogic dcL = new DestinoCompraLogic();
        String busq = request.getParameter("busq");

        List<DestinoCompraLogic> lista;
        lista = dcL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ModificarDigitos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        UsuarioLogic uL = new UsuarioLogic();
        Usuario uB;
        uB = (Usuario) osesion.getAttribute("Usuario");

        if (!"".equals(request.getParameter("txtDigito"))) {
            int digito = Integer.parseInt(request.getParameter("txtDigito"));
            uL.ModificarDigito(digito, uB);
            uB.setDigitos(digito);
        }
        if (!"".equals(request.getParameter("txtRUC"))) {
            String RUC = request.getParameter("txtRUC");
            uL.ModificarRUC(RUC, uB);
            uB.setRUC(RUC);
        }
        if (!"".equals(request.getParameter("txtRazonS"))) {
            String RazonSocial = request.getParameter("txtRazonS");
            uL.ModificarRazonSocial(RazonSocial, uB);
            uB.setRazonSocial(RazonSocial);
        }
        if (!"".equals(request.getParameter("txtDiferenciaCambio"))) {
            int diferenciaC = Integer.parseInt(request.getParameter("txtDiferenciaCambio"));
            uB.setDiferenciaDebe(diferenciaC);
            uL.ModificarDiferenciaD(diferenciaC, uB);
        }
        if (!"".equals(request.getParameter("txtDiferenciaCambio2"))) {
            int diferenciaH = Integer.parseInt(request.getParameter("txtDiferenciaCambio2"));
            uB.setDiferenciaHaber(diferenciaH);
            uL.ModificarDiferenciaH(diferenciaH, uB);
        }
        if (!"".equals(request.getParameter("txtIGV"))) {
            int IGV = Integer.parseInt(request.getParameter("txtIGV"));
            uB.setCuentaIGV(IGV);
            uL.ModificarIGV(IGV, uB);
        }
        if (!"".equals(request.getParameter("txtCaja"))) {
            int caja = Integer.parseInt(request.getParameter("txtCaja"));
            uB.setCuentaCaja(caja);
            uL.ModificarCaja(caja, uB);
        }

        msj = "Cambios Aplicados";

        request.setAttribute("Usuario", uB);
        acceso = "/AreaAjustes.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarDetalleAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        DestinoCompraLogic desL = new DestinoCompraLogic();
        CuentaContableLogic ccL = new CuentaContableLogic();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DetalleAsiento det = new DetalleAsiento();
        DetalleAsiento detc = new DetalleAsiento();
        DetalleAsiento deta = new DetalleAsiento();
        DetalleAsiento complemento = new DetalleAsiento();
        DestinoCompra desB;
        CuentaContable ccB;
        CuentaContable ccBC;
        CuentaContable ccBA;

        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos") == null ? destinos = new ArrayList<>() : (ArrayList) osesion.getAttribute("destinos");
        Documento documento = (Documento) osesion.getAttribute("documento") == null ? documento = new Documento() : (Documento) osesion.getAttribute("documento");
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        //Recuperamos Datos del DetalleAsiento
        int tipocambio = Integer.parseInt(request.getParameter("txtCambioOculto"));
        int cuenta = Integer.parseInt(request.getParameter("txtNumCuenta"));
        String tipoDH = String.valueOf(request.getParameter("txtTipo"));
        String nombrecc = request.getParameter("txtNombreCC");
        double importe = Double.parseDouble(request.getParameter("txtImporte"));

        det = daL.AgregarDebeHaber(tipocambio, tipoDH, importe);
        det.setCuenta(cuenta);
        det.setNombrecc(nombrecc);

        if (request.getParameter("txtTipoD") != null) {

            //Recuperamos datos del Documento
            documento.setTipoDoc(request.getParameter("txtTipoD"));
            documento.setNumerocuentacorriente(request.getParameter("txtCuentaCorriente"));
            documento.setConcepto(request.getParameter("txtConcepto"));
            documento.setSerie(request.getParameter("txtSerie"));
            documento.setCorrelativo(request.getParameter("txtCorrelativo"));
            documento.setFechaEmision(Date.valueOf(request.getParameter("txtFechaEmision")));
            documento.setFechaVencimiento(Date.valueOf(request.getParameter("txtFechaVencimiento")));
            documento.setClaseBien(request.getParameter("txtClaseBien"));
            if (documento.getTipoDoc().equals("07")) {
                documento.setFkSerie(request.getParameter("txtfkSerie"));
                documento.setFkCorrelativo(request.getParameter("txtfkCorrelativo"));
            }
            //documento.setAmbito(String.valueOf(request.getParameter("txtAmbito")));
            //documento.setFormaPago(String.valueOf(request.getParameter("txtFormaPago")));

            double impuesto = 0;

            documento.setMontoISC(Double.parseDouble(request.getParameter("txtMontoISC")));
            documento.setOtrosM(Double.parseDouble(request.getParameter("txtOtrosM")));
            if (String.valueOf(cuenta).substring(0, 1).equals("4")) {
                documento.setBIAGCFOGE(Double.parseDouble(request.getParameter("txtBIAGCFOGE")));
                documento.setMIGVIPMOPG(Double.parseDouble(request.getParameter("txtMIGVIPMOPG")));
                documento.setVANG(Double.parseDouble(request.getParameter("txtVANG")));
                documento.setBIAGCFOGyNG(Double.parseDouble(request.getParameter("txtBIAGCFOGyNG")));
                documento.setMIGVIPMOPGyNG(Double.parseDouble(request.getParameter("txtMIGVIPMOPGyNG")));
                documento.setBIAGsinCF(Double.parseDouble(request.getParameter("txtBIAGsinCF")));
                documento.setMIGVIPMsinCF(Double.parseDouble(request.getParameter("txtMIGVIPMsinCF")));
                documento.setICBPER(Double.parseDouble(request.getParameter("txtICBPER")));

                impuesto = documento.getMIGVIPMOPG() + documento.getMIGVIPMOPGyNG() + documento.getMIGVIPMsinCF() + documento.getICBPER();

            } else if (String.valueOf(cuenta).substring(0, 1).equals("1")) {
                impuesto = Math.round(((importe * 0.18) / 1.18) * Math.pow(10, 2)) / Math.pow(10, 2);
            }

            if (impuesto > 0) {
                if (tipoDH.equals("Haber")) {
                    complemento = daL.AgregarDebeHaber(tipocambio, "Debe", impuesto);
                } else {
                    complemento = daL.AgregarDebeHaber(tipocambio, "Haber", impuesto);
                }
                ccB = ccL.DatosCC(uB.getCuentaIGV());
                complemento.setCuenta(ccB.getNumero());
                complemento.setNombrecc(ccB.getNombre());
                detalles.add(complemento);
            }

            detalles.add(det);
            msj = "Documento agregado";
            det.setSerieDoc(request.getParameter("txtSerie"));

        } else {
            detalles.add(det);
            msj = "Detalle agregado";
        }

        //Verificamos si la cuenta tiene destinos de compra
        desB = desL.VerificarDC(cuenta);

        if (desB.getCuenta_cargo() > 0) {

            //Cuenta Cargo
            ccBC = ccL.DatosCC(desB.getCuenta_cargo());
            detc = daL.AgregarDebeHaber(tipocambio, tipoDH, importe);
            detc.setNombrecc(ccBC.getNombre());
            detc.setCuenta(desB.getCuenta_cargo());
            destinos.add(detc);

            //Cuenta Abono
            ccBA = ccL.DatosCC(desB.getCuenta_abono());
            if (tipoDH.equals("Debe")) {
                deta = daL.AgregarDebeHaber(tipocambio, "Haber", importe);
            } else {
                deta = daL.AgregarDebeHaber(tipocambio, "Debe", importe);
            }
            deta.setNombrecc(ccBA.getNombre());
            deta.setCuenta(desB.getCuenta_abono());

            destinos.add(deta);
        }

        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("destinos", destinos);
        osesion.setAttribute("documento", documento);
        response.getWriter().print(msj);
    }

    public void CancelarAsientoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos") == null ? destinos = new ArrayList<>() : (ArrayList) osesion.getAttribute("destinos");
        Documento documento = (Documento) osesion.getAttribute("documento") == null ? documento = new Documento() : (Documento) osesion.getAttribute("documento");

        detalles.clear();
        destinos.clear();
        documento = new Documento();

        osesion.setAttribute("destinos", destinos);
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("documento", documento);
        msj = "Asiento Cancelado";
        response.getWriter().print(msj);
    }

    public void AjustarCambio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        DetalleAsiento det = new DetalleAsiento();
        DetalleAsiento detc = new DetalleAsiento();
        DetalleAsiento deta = new DetalleAsiento();
        CuentaContableLogic ccL = new CuentaContableLogic();
        DestinoCompraLogic dcL = new DestinoCompraLogic();
        TipoCambioLogic logicTC = new TipoCambioLogic();
        TipoCambio beansTC = new TipoCambio();
        CuentaContable ccB;
        DestinoCompra dcB;

        Usuario usu = (Usuario) osesion.getAttribute("Usuario");
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos") == null ? destinos = new ArrayList<>() : (ArrayList) osesion.getAttribute("destinos");

        double debesoles = Double.parseDouble(request.getParameter("debesoles"));
        double habersoles = Double.parseDouble(request.getParameter("habersoles"));
        double debedolares = Double.parseDouble(request.getParameter("debedolares"));
        double haberdolares = Double.parseDouble(request.getParameter("haberdolares"));
        double importe;

        beansTC = logicTC.DatosUltimo();

        if (debesoles != habersoles) {
            ccB = ccL.DatosCC(usu.getDiferenciaHaber());
            det.setCuenta(7761);
            det.setNombrecc(ccB.getNombre());
            det.setTipoCambio(beansTC.getId());
            if (debesoles < habersoles) {
                importe = Math.round((habersoles - debesoles) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setDebesoles(importe);
            } else {
                importe = Math.round((debesoles - habersoles) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setHabersoles(importe);
            }
            detalles.add(det);
        } else if (debedolares != haberdolares) {
            ccB = ccL.DatosCC(usu.getDiferenciaDebe());
            dcB = dcL.VerificarDC(usu.getDiferenciaDebe());
            det.setCuenta(usu.getDiferenciaDebe());
            det.setNombrecc(ccB.getNombre());
            det.setTipoCambio(beansTC.getId());
            detc.setTipoCambio(beansTC.getId());
            deta.setTipoCambio(beansTC.getId());
            detc.setCuenta(dcB.getCuenta_cargo());
            deta.setCuenta(dcB.getCuenta_abono());
            if (debedolares < haberdolares) {
                importe = Math.round((haberdolares - debedolares) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setDebedolares(importe);
                detc.setDebedolares(importe);
                deta.setHaberdolares(importe);
            } else {
                importe = Math.round((debedolares - haberdolares) * Math.pow(10, 2)) / Math.pow(10, 2);
                det.setHaberdolares(importe);
                detc.setHaberdolares(importe);
                deta.setDebedolares(importe);
            }
            detalles.add(det);
            destinos.add(deta);
            destinos.add(detc);
        } else {
            msj = "No es necesario aplicar un ajuste";
        }

        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("destinos", destinos);
        response.getWriter().print(msj);
    }

    public void ListarDetalleAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        //Recuperamos DetalleAsiento
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");

        try {
            Gson gson = new Gson();
            String json = gson.toJson(detalles);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void RecuperarDetalleA(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        //Recuperamos DetalleAsiento
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles") == null ? detalles = new ArrayList<>() : (ArrayList) osesion.getAttribute("detalles");

        int cuenta = Integer.parseInt(request.getParameter("cuentaContable"));
        int pos = 0;
        for (int i = 0; i < detalles.size(); i++) {
            if (detalles.get(i).getCuenta() == cuenta) {
                pos = i;
                break;
            }
        }

        try {
            Gson gson = new Gson();
            String json = gson.toJson(detalles.get(pos));
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void RecuperarDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        //Recuperamos Documento
        Documento documento = (Documento) osesion.getAttribute("documento") == null ? documento = new Documento() : (Documento) osesion.getAttribute("documento");

        try {
            Gson gson = new Gson();
            String json = gson.toJson(documento);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void FinalizarAsientoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        AsientoContableLogic acL = new AsientoContableLogic();
        AsientoContable acB = new AsientoContable();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DocumentoLogic dL = new DocumentoLogic();

        //Recuperamos Datos de Sesion
        Usuario usu = (Usuario) osesion.getAttribute("Usuario");
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos");

        Documento documento = (Documento) osesion.getAttribute("documento") == null ? documento = new Documento() : (Documento) osesion.getAttribute("documento");

        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        //Creamos el Asiento
        String Stipocambio = String.valueOf(request.getParameter("txtTipoCambio"));
        int tipocambio = Integer.parseInt(Stipocambio);

        acB.setNumero(request.getParameter("txtNumero"));
        acB.setFecha(Date.valueOf(request.getParameter("txtFecha")));
        acB.setGlosa(request.getParameter("txtGlosa"));
        acB.setCodOperacion(request.getParameter("txtTipoO"));
        acB.setIdPeriodo(usu.getPeriodo());
        acB.setCodUsuario(usu.getCodigo());
        acB.setEstado(request.getParameter("txtEstado"));

        if (tipocambio == 1) {
            acB.setMoneda("SOLES");
        } else {
            acB.setMoneda("DOLARES");
        }

        switch (acB.getCodOperacion()) {
            case "0101":
                acB.setTipoAsiento(1);
                documento = null;
                break;
            case "0201":
                acB.setTipoAsiento(3);
                documento = null;
                break;
            default:
                acB.setTipoAsiento(2);
                break;
        }

        msj = acL.Agregar(acB, uB.getPeriodo());

        if (msj.equals("AGREGADO")) {

            if (documento != null) {
                msj = dL.Agregar(documento);
                documento = new Documento();
                osesion.setAttribute("documento", documento);
            }
            for (DetalleAsiento det : detalles) {
                det.setNumeroAsiento(request.getParameter("txtNumero"));
                daL.Agregar(det);
            }
            for (DetalleAsiento des : destinos) {
                des.setNumeroAsiento(request.getParameter("txtNumero"));
                daL.Agregar(des);
            }
        }

        detalles.clear();
        destinos.clear();
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("destinos", destinos);

        response.getWriter().print(msj);
    }

    public void ModificarDetalleAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        EliminarDetalleAsiento(request, response);
        AgregarDetalleAsiento(request, response);
        response.getWriter().print(msj);
    }

    public void EliminarDetalleAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        DestinoCompraLogic dL = new DestinoCompraLogic();
        DestinoCompra des;

        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos");

        int CuentaContable = Integer.parseInt(request.getParameter("CuentaCC"));
        String veri = "" + CuentaContable;
        String TCC = veri.substring(0, 2);
        des = dL.VerificarDC(CuentaContable);
        for (DetalleAsiento det : detalles) {
            if (det.getCuenta() == CuentaContable) {
                detalles.remove(det);
                break;
            }
        }
        if (des.getCuenta_abono() > 0) {
            int cont = 0;
            for (DetalleAsiento det : destinos) {
                if (det.getCuenta() == des.getCuenta_cargo()) {
                    destinos.remove(det);
                    cont++;
                    break;
                }
            }
            for (DetalleAsiento det : destinos) {
                if (det.getCuenta() == des.getCuenta_abono()) {
                    destinos.remove(det);
                    cont++;
                    break;
                }
            }
            if (cont == 0) {
                for (DetalleAsiento det : detalles) {
                    if (det.getCuenta() == des.getCuenta_cargo()) {
                        detalles.remove(det);
                        cont++;
                        break;
                    }
                }
                for (DetalleAsiento det : detalles) {
                    if (det.getCuenta() == des.getCuenta_abono()) {
                        detalles.remove(det);
                        cont++;
                        break;
                    }
                }
            }
        }

        if (TCC.equals("12") || TCC.equals("42")) {
            Documento documento = new Documento();
            osesion.setAttribute("documento", documento);
            for (DetalleAsiento det : detalles) {
                if (det.getCuenta() == 40111) {
                    detalles.remove(det);
                    break;
                }
            }
        }
        msj = "Detalle Eliminado";
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("destinos", destinos);
        response.getWriter().print(msj);
    }

    public void ListarDetallesBD(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DocumentoLogic doL = new DocumentoLogic();
        AsientoContableLogic acL = new AsientoContableLogic();
        List<DetalleAsiento> detallesLD = new ArrayList<>();
        List<DetalleAsiento> detalles = new ArrayList<>();
        Documento documento;

        Usuario uB = (Usuario) osesion.getAttribute("Usuario");
        AsientoContable asiento = (AsientoContable) osesion.getAttribute("asiento") == null ? asiento = new AsientoContable() : (AsientoContable) osesion.getAttribute("asiento");
        detallesLD.clear();

        String NumeroAsiento = request.getParameter("NumeroAsiento");
        //Buscar el Asiento de la BD
        asiento = acL.DatosAC(NumeroAsiento, uB.getPeriodo());
        //Buscar de la BD los detalles que tengan ese numeroalles  de asiento
        detallesLD = daL.Listar(NumeroAsiento, uB.getPeriodo());
        detalles = daL.Listar(NumeroAsiento, uB.getPeriodo());
        //Buscar de la BD el documento perteneciente a ese numero de asiento
        documento = doL.DatosDoc(NumeroAsiento);

        osesion.setAttribute("asiento", asiento);
        osesion.setAttribute("detallesLD", detallesLD);
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("documento", documento);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(asiento);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void GuardarDetallesModificados(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DocumentoLogic doL = new DocumentoLogic();
        AsientoContableLogic acL = new AsientoContableLogic();
        AsientoContable acB = new AsientoContable();

        Documento documento = (Documento) osesion.getAttribute("documento") == null ? documento = new Documento() : (Documento) osesion.getAttribute("documento");
        ArrayList<DetalleAsiento> detalles = (ArrayList) osesion.getAttribute("detalles");
        ArrayList<DetalleAsiento> detallesLD = (ArrayList) osesion.getAttribute("detallesLD");
        ArrayList<DetalleAsiento> destinos = (ArrayList) osesion.getAttribute("destinos") == null ? destinos = new ArrayList<>() : (ArrayList) osesion.getAttribute("destinos");

        //Eliminar los detalles de la bd
        msj = daL.Eliminar(detallesLD);
        //Eliminar el documento de la bd
        msj = doL.Editar(documento);
        //Agregamos los nuevos detalles y documento

        acB.setGlosa(request.getParameter("txtGlosa"));
        acB.setCodOperacion(request.getParameter("txtTipoO"));
        acB.setNumero(request.getParameter("txtNumero"));
        acB.setEstado(request.getParameter("txtEstado"));

        msj = acL.Editar(acB);

        if (msj.equals("CAMBIOS APLICADOS")) {

            for (DetalleAsiento det : detalles) {
                det.setNumeroAsiento(request.getParameter("txtNumero"));
                daL.Agregar(det);
            }

            for (DetalleAsiento det : destinos) {
                det.setNumeroAsiento(request.getParameter("txtNumero"));
                daL.Agregar(det);
            }
        }

        documento = new Documento();
        detalles.clear();
        destinos.clear();
        detallesLD.clear();
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("detalles", detalles);
        osesion.setAttribute("detallesLD", detallesLD);
        response.getWriter().print(msj);

    }

    public void CierreCuentasResultado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        PlantillaAsientoLogic paL = new PlantillaAsientoLogic();
        AsientoContableLogic acL = new AsientoContableLogic();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        BalanceComprobacionDao balanceDao = new BalanceComprobacionDao();
        AsientoContable acB = new AsientoContable();
        List<PlantillaAsiento> plantillas = new ArrayList<>();

        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        //Llenamos datos en comun de todos los asientos
        LocalDate fechaActual = LocalDate.now();
        acB.setFecha(Date.valueOf(fechaActual));
        acB.setCodUsuario(uB.getCodigo());
        acB.setEstado("TERMINADO");
        acB.setIdPeriodo(uB.getPeriodo());
        acB.setTipoAsiento(3);
        acB.setMoneda("SOLES");
        acB.setCodOperacion(request.getParameter("txtTipOp"));

        //Recuperamos las plantillas del asiento de cierre
        plantillas = paL.Listar(uB.getCodigo());

        //Recorremos el arreglo
        for (PlantillaAsiento pla : plantillas) {

            List<DetalleAsiento> detalles = new ArrayList<>();
            //Variables que serviran para calcular el monto de la cuenta destino
            double sumaDebe = 0;
            double sumaHaber = 0;

            //Se completan los ultimos datos del asiento contable
            acB.setGlosa(pla.getGlosa());
            String NumAsiento = "1300";
            int numS = acL.NumeroAsiento("3", uB.getPeriodo()) + 1;
            switch (String.valueOf(numS).length()) {
                case 1:
                    NumAsiento += "000" + numS;
                    break;
                case 2:
                    NumAsiento += "00" + numS;
                    break;
                case 3:
                    NumAsiento += "0" + numS;
                    break;
                default:
                    NumAsiento += "" + numS;
            }
            acB.setNumero(NumAsiento);

            //Se recorren las cuentas de origen
            for (DetallePlantilla detP : pla.getCuentasOrigen()) {
                List<BalanceComprobacion> cuentas = new ArrayList<>();
                cuentas = balanceDao.ListarCuentas(detP.getCuenta(), 1, 12, uB.getPeriodo(), "");

                //Se llenan los detalle de asiento
                for (BalanceComprobacion bc : cuentas) {
                    DetalleAsiento daB = new DetalleAsiento();

                    if (bc.getDeudor() > bc.getAcreedor()) {
                        daB = daL.AgregarDebeHaber(1, "Haber", bc.getDeudor());
                        sumaDebe += bc.getDeudor();
                    } else {
                        daB = daL.AgregarDebeHaber(1, "Debe", bc.getAcreedor());
                        sumaHaber += bc.getAcreedor();
                    }
                    daB.setCuenta(bc.getCuenta());
                    daB.setNumeroAsiento(acB.getNumero());
                    detalles.add(daB);
                }
            }

            //Comprobacion de que existe al menos un detalle asiento
            if (!detalles.isEmpty()) {
                //Se crea el asiento de destino
                DetalleAsiento dest = new DetalleAsiento();

                //Agregamos el monto y demas datos
                if (sumaDebe > sumaHaber) {
                    dest = daL.AgregarDebeHaber(1, "Debe", sumaDebe - sumaHaber);
                } else {
                    dest = daL.AgregarDebeHaber(1, "Haber", sumaHaber - sumaDebe);
                }
                dest.setCuenta(pla.getCuentaDestino());
                dest.setNumeroAsiento(NumAsiento);
                detalles.add(dest);

                //Guardamos el asiento
                msj = acL.Agregar(acB, uB.getPeriodo());
                if (msj.equals("AGREGADO")) {
                    for (DetalleAsiento det : detalles) {
                        daL.Agregar(det);
                    }
                }
            }
        }
        response.getWriter().print(msj);
    }

    public void CierreCuentasBalance(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        AsientoContableLogic acL = new AsientoContableLogic();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        BalanceComprobacionDao balanceDao = new BalanceComprobacionDao();
        AsientoContable acB = new AsientoContable();
        PeriodoContableLogic pcL = new PeriodoContableLogic();
        List<DetalleAsiento> detalles = new ArrayList<>();

        Usuario uB = (Usuario) osesion.getAttribute("Usuario");
        PeriodoContable pcB = pcL.Datos(uB.getPeriodo());

        //Comprobacion del cierre de las cuentas de resultado
        List<BalanceComprobacion> comprobacion = new ArrayList<>();
        comprobacion = balanceDao.ListarCuentas(59, 1, 12, uB.getPeriodo(), "3");

        if (!comprobacion.isEmpty()) {
            //Llenamos datos del asiento
            LocalDate fechaActual = LocalDate.now();
            acB.setFecha(Date.valueOf(fechaActual));
            acB.setCodUsuario(uB.getCodigo());
            acB.setEstado("TERMINADO");
            acB.setIdPeriodo(uB.getPeriodo());
            acB.setTipoAsiento(3);
            acB.setMoneda("SOLES");
            acB.setCodOperacion(request.getParameter("txtTipOp"));
            acB.setGlosa(request.getParameter("txtGlosa"));

            String NumAsiento = "1300";
            int numS = acL.NumeroAsiento("3", uB.getPeriodo()) + 1;

            switch (String.valueOf(numS).length()) {
                case 1:
                    NumAsiento += "000" + numS;
                    break;
                case 2:
                    NumAsiento += "00" + numS;
                    break;
                case 3:
                    NumAsiento += "0" + numS;
                    break;
                default:
                    NumAsiento += "" + numS;
            }

            acB.setNumero(NumAsiento);

            //Recuperamos las cuentas que tuvieron movimiento en el periodo
            for (int cuenta = 10; cuenta < 60; cuenta++) {
                //Arreglo de movimientos del periodo
                List<BalanceComprobacion> cuentas = new ArrayList<>();
                cuentas = balanceDao.ListarCuentas(cuenta, 1, 12, uB.getPeriodo(), "2");

                //Arreglo del asiento de apertura
                List<BalanceComprobacion> apertura = new ArrayList<>();
                apertura = balanceDao.ListarCuentas(cuenta, 1, 12, uB.getPeriodo(), "1");

                //Creamos los detalles de asiento
                for (BalanceComprobacion bc : cuentas) {
                    DetalleAsiento daB = new DetalleAsiento();
                    double sumaDebe = 0;
                    double sumaHaber = 0;

                    //Movimientos del periodo
                    sumaDebe += bc.getAcreedor();
                    sumaHaber += bc.getDeudor();

                    for (BalanceComprobacion ap : apertura) {
                        if (ap.getCuenta() == bc.getCuenta()) {
                            sumaDebe += ap.getAcreedor();
                            sumaHaber += ap.getDeudor();
                            apertura.remove(ap);
                            break;
                        }
                    }

                    if (sumaDebe > sumaHaber) {
                        daB = daL.AgregarDebeHaber(1, "Haber", sumaDebe - sumaHaber);
                    } else if (sumaDebe < sumaHaber) {
                        daB = daL.AgregarDebeHaber(1, "Debe", sumaHaber - sumaDebe);
                    }
                    daB.setCuenta(bc.getCuenta());
                    daB.setNumeroAsiento(NumAsiento);
                    detalles.add(daB);
                }
            }

            //Insertamos el asiento
            if (!detalles.isEmpty()) {
                msj = acL.Agregar(acB, uB.getPeriodo());
                if (msj.equals("AGREGADO")) {
                    for (DetalleAsiento det : detalles) {
                        daL.Agregar(det);
                    }
                }
            }

        } else {
            msj = "PRIMERO DEBE CERRAR TODAS LAS CUENTAS DE RESULTADO";
        }

        response.getWriter().print(msj);

    }

    public void AsientoApertura(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);

        AsientoContableLogic acL = new AsientoContableLogic();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        AsientoContable acB = new AsientoContable();
        PeriodoContableLogic pcL = new PeriodoContableLogic();
        List<DetalleAsiento> detalles = new ArrayList<>();
        List<DetalleAsiento> apertura = new ArrayList<>();

        Usuario uB = (Usuario) osesion.getAttribute("Usuario");
        LocalDate fechaActual = LocalDate.now();

        //Recuperamos el ultimo asiento de cierre
        String numAsiento = acL.UltimoAsientoCierre(uB.getPeriodo());

        //Recuperamos los detalles del asiento
        detalles = daL.Listar(numAsiento, uB.getPeriodo() - 1);

        //Creamos el asiento de apertura
        String NumAsiento = "0000";
        int numS = acL.NumeroAsiento("1", 1) + 1;

        switch (String.valueOf(numS).length()) {
            case 1:
                NumAsiento += "000" + numS;
                break;
            case 2:
                NumAsiento += "00" + numS;
                break;
            case 3:
                NumAsiento += "0" + numS;
                break;
            default:
                NumAsiento += "" + numS;
        }
        acB.setNumero(NumAsiento);
        acB.setCodOperacion("0101");
        acB.setGlosa(request.getParameter("txtGlosa"));
        acB.setIdPeriodo(uB.getPeriodo());
        acB.setTipoAsiento(1);
        acB.setMoneda("SOLES");
        acB.setFecha(Date.valueOf(fechaActual));
        acB.setEstado("TERMINADO");
        acB.setCodUsuario(uB.getCodigo());

        //Creamos los detalles
        for (DetalleAsiento det : detalles) {
            DetalleAsiento ap = new DetalleAsiento();
            if (det.getDebesoles() > 0) {
                ap = daL.AgregarDebeHaber(1, "Haber", det.getDebesoles());
            } else {
                ap = daL.AgregarDebeHaber(1, "Debe", det.getHabersoles());
            }
            ap.setCuenta(det.getCuenta());
            ap.setNumeroAsiento(NumAsiento);
            apertura.add(ap);
        }

        //Guardamos datos
        msj = acL.Agregar(acB, uB.getPeriodo());
        if (msj.equals("AGREGADO")) {
            for (DetalleAsiento det : apertura) {
                daL.Agregar(det);
            }
            msj = "ASIENTO DE APERTURA CREADO CON EXITO";
        }
        response.getWriter().print(msj);
    }

    public void MostrarNombreTO(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        TipoOperacionLogic toL = new TipoOperacionLogic();
        TipoOperacion toB;

        String busq = request.getParameter("cons");
        toB = toL.DatosTO(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(toB.getNombre());
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarNombreCC(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaContableLogic ccL = new CuentaContableLogic();
        CuentaContable ccB;

        int busq = Integer.parseInt(request.getParameter("cons"));
        ccB = ccL.DatosCC(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(ccB.getNombre());
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void MostrarNombreCCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CuentaCorrienteLogic ccorL = new CuentaCorrienteLogic();
        CuentaCorriente ccorB;

        String busq = request.getParameter("cons");
        ccorB = ccorL.DatosCC(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(ccorB.getDenominacion());
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String año = request.getParameter("txtAño");
        String fi = request.getParameter("txtFecha_inicio");
        String ff = request.getParameter("txtFecha_fin");

        PeriodoContableLogic pcL = new PeriodoContableLogic();

        msj = pcL.Agregar(año, fi, ff);
        acceso = "/AreaPeriodoContable.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void AgregarNumeroAsiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");
        AsientoContableLogic asL = new AsientoContableLogic();

        String tipAsiento = request.getParameter("tipAsiento");

        int n = asL.NumeroAsiento(tipAsiento, uB.getPeriodo());
        String cont = String.valueOf(n);
        String numeroA = "";

        for (int i = 0; i < (4 - cont.length()); i++) {
            numeroA += 0;
        }
        n++;
        numeroA += n;

        try {
            Gson gson = new Gson();
            String json = gson.toJson(numeroA);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ModificarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String numero = request.getParameter("txtNumeroM");
        String denominacion = request.getParameter("txtDenominacionM");
        String pais = request.getParameter("txtPaisM");
        String direccion = request.getParameter("txtDireccionM");
        String idtipo = request.getParameter("txtidtipoM");

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();
        CuentaCorriente ccB = new CuentaCorriente();

        ccB.setNumero(numero);
        ccB.setDenominacion(denominacion);
        ccB.setPais(pais);
        ccB.setDireccion(direccion);
        ccB.setIdtipo(idtipo);

        msj = ccL.Modificar(ccB);

        response.getWriter().print(msj);
    }

    public void EliminarCuentaCorriente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numero = Integer.parseInt(request.getParameter("txtNumeroM"));

        CuentaCorrienteLogic ccL = new CuentaCorrienteLogic();

        msj = ccL.Eliminar(numero);

        response.getWriter().print(msj);
    }

    public void EliminarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigoM");

        TipoDocumentoLogic cbL = new TipoDocumentoLogic();

        msj = cbL.Eliminar(codigo);

        response.getWriter().print(msj);
    }

    public void ModificarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String codigo = request.getParameter("txtCodigoM");
        String nombre = request.getParameter("txtNombreM");

        TipoDocumentoLogic tdL = new TipoDocumentoLogic();
        TipoDocumento tdB = new TipoDocumento();

        tdB.setCodigo(codigo);
        tdB.setNombre(nombre);

        msj = tdL.Modificar(tdB);

        response.getWriter().print(msj);
    }

    public void EliminarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int codigo = Integer.parseInt(request.getParameter("txtCodigoM"));

        ClaseBienLogic cbL = new ClaseBienLogic();

        msj = cbL.Eliminar(codigo);

        response.getWriter().print(msj);
    }

    public void ModificarClaseBien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int codigo = Integer.parseInt(request.getParameter("txtCodigoM"));
        String nombre = request.getParameter("txtNombreM");

        ClaseBienLogic cbL = new ClaseBienLogic();
        ClaseBien cbB = new ClaseBien();

        cbB.setCodigo(codigo);
        cbB.setNombre(nombre);

        msj = cbL.Modificar(cbB);

        response.getWriter().print(msj);
    }

    public void ModificarPeriodoContable(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("txtIdM"));
        String estado = String.valueOf(request.getParameter("txtEstadoM"));

        PeriodoContableLogic pcL = new PeriodoContableLogic();

        msj = pcL.Editar(estado, id);

        response.getWriter().print(msj);
    }

    public void ListarLibroCajaBanco(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        LibroCajaBancoLogic lcbL = new LibroCajaBancoLogic();

        List<LibroCajaBanco> lista;
        lista = lcbL.Listarbancos();

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void ListarDetallePlantilla(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        DetallePlantillaLogic dpL = new DetallePlantillaLogic();

        int busq = Integer.parseInt(request.getParameter("busq"));

        List<DetallePlantilla> lista;
        lista = dpL.Listar(busq);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void AgregarDetallePlantilla(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cu = request.getParameter("txtCuenta_detalle_plantillaM");
        String pl = request.getParameter("txtId_detalle_plantillaM");
        DetallePlantillaLogic dpL = new DetallePlantillaLogic();

        msj = dpL.Agregar(cu, pl);
        acceso = "/AreaPlantillaCierre.jsp";
        request.setAttribute("msj", msj);
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    public void ModificarDetallePlantilla(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String cu = request.getParameter("txtCuenta_detalle_plantillaM");
        String id = request.getParameter("txtId_detalle_plantillaM");

        DetallePlantillaLogic dpL = new DetallePlantillaLogic();

        msj = dpL.Editar(cu, id);
        response.getWriter().print(msj);
    }

    public void EliminarDetallePlantilla(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("txtId_detalle_plantillaM");

        DetallePlantillaLogic dpL = new DetallePlantillaLogic();

        msj = dpL.Eliminar(id);

        response.getWriter().print(msj);
    }

    public void ListarAsientoTesoreria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");
        AsientoTesoreriaLogic atL = new AsientoTesoreriaLogic();
        String serie = request.getParameter("txtSerieSeleccionada");
        String correlativo = request.getParameter("txtCorrelativo");

        List<AsientoTesoreria> lista;
        lista = atL.Listar(serie, correlativo, uB.getPeriodo());

        try {
            Gson gson = new Gson();
            String json = gson.toJson(lista);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }

    public void FinalizarAsientoTesoreria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        AsientoContableLogic acL = new AsientoContableLogic();
        AsientoContable asiento = new AsientoContable();
        DetalleAsientoLogic daL = new DetalleAsientoLogic();
        DocumentoLogic dL = new DocumentoLogic();
        AsientoTesoreriaLogic atL = new AsientoTesoreriaLogic();

        //Recuperamos Datos 
        Usuario usu = (Usuario) osesion.getAttribute("Usuario");
        int pe = usu.getPeriodo();
        int cu = usu.getCodigo();
        String na = request.getParameter("txtNumeroAsiento");
        String fe = request.getParameter("txtFecha");
        String gl = request.getParameter("txtGlosa");
        String to = request.getParameter("txtTipoO");
        String au = request.getParameter("txtCorrelativo");
        String mp = request.getParameter("txtMetodoPago");
        String cc = request.getParameter("txtNumeroCuentaContable");
        String md = request.getParameter("txtTipoCambio");

        //Recuperamos Datos del Documento Seleccionado
        String tps = request.getParameter("txtTipoDocumentoSeleccionar");
        String ccs = request.getParameter("txtCuentaCorrienteSelecionar");
        String cbs = request.getParameter("txtClaseBienSeleccionar");
        String ips = request.getParameter("txtImporteSeleccionar");
        String dhs = request.getParameter("txtdhSeleccionar");
        String srs = request.getParameter("txtSerieSeleccionada");
        String ncs = request.getParameter("txtNumeroCuentaContableSeleccionado");

        String vvs = atL.VerifiarValoresSeleccionado(tps, ccs, cbs, ips, dhs, srs, ncs);
        String mensaje = atL.VerifiarValores(pe, cu, na, fe, gl, to, au, mp, cc, md, vvs);

        if (mensaje.equals("DATOS VALIDOS")) {

            //Creamos el Asiento Tesoreria
            String Stipocambio = String.valueOf(md);
            int tipocambio = Integer.parseInt(Stipocambio);
            asiento.setNumero(na);
            asiento.setFecha(Date.valueOf(fe));
            asiento.setGlosa(gl);
            asiento.setCodOperacion(to);
            asiento.setIdPeriodo(pe);
            asiento.setCodUsuario(cu);
            asiento.setEstado("TERMINADO");
            if (tipocambio == 1) {
                asiento.setMoneda("SOLES");
            } else {
                asiento.setMoneda("DOLARES");
            }

            asiento.setTipoAsiento(2);

            mensaje = acL.Agregar(asiento, usu.getPeriodo());

            if (mensaje.equals("AGREGADO")) {

                //DOCUMENTO//
                Documento documento = new Documento();
                documento.setTipoDoc(tps);
                documento.setNumerocuentacorriente(ccs);
                documento.setConcepto(gl);
                documento.setSerie(atL.Crear_Serie(usu.getPeriodo()));
                documento.setCorrelativo(au);
                documento.setFechaEmision(Date.valueOf(fe));
                documento.setClaseBien(cbs);
                documento.setFormaPago(mp);
                mensaje = dL.Agregar(documento);

                if (mensaje.equals("AGREGADO")) {

                    //DETALLE//
                    double importe = Double.parseDouble(ips);
                    DetalleAsiento detalleF;
                    detalleF = daL.AgregarDebeHaber(tipocambio, dhs, importe);
                    detalleF.setCuenta(Integer.parseInt(ncs));
                    detalleF.setSerieDoc(documento.getSerie());
                    detalleF.setNumeroAsiento(asiento.getNumero());
                    mensaje = daL.Agregar(detalleF);
                    if (mensaje.equals("AGREGADO")) {
                        //DETALLE FINAL//
                        DetalleAsiento detalle;
                        if ("Debe".equals(dhs)) {
                            dhs = "Haber";
                        } else {
                            dhs = "Debe";
                        }
                        detalle = daL.AgregarDebeHaber(tipocambio, dhs, importe);
                        detalle.setSerieDoc(srs);
                        detalle.setNumeroAsiento(asiento.getNumero());
                        if (mp.equals("003")) {
                            detalle.setCuenta(Integer.parseInt(cc));
                        } else {
                            detalle.setCuenta(usu.getCuentaCaja());
                        }

                        msj = daL.Agregar(detalle);
                    } else {
                        msj = mensaje;
                    }

                } else {
                    msj = mensaje;
                }

            } else {
                msj = mensaje;
            }

        } else {
            msj = mensaje;
        }

        response.getWriter().print(msj);
    }

    public void ProbarListas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession osesion = request.getSession(true);
        AsientoTesoreriaDao dao = new AsientoTesoreriaDao();
        Usuario uB = (Usuario) osesion.getAttribute("Usuario");

        String serie = dao.Crear_Serie(uB.getPeriodo());

        try {
            Gson gson = new Gson();
            String json = gson.toJson(serie);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(json);

        } catch (IOException e) {
        }
    }
}
