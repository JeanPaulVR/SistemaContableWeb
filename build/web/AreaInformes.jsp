<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<jsp:useBean class="modelo.logic.LibroCajaBancoLogic" scope="page" id="cbLogic"/>
<%@page import="modelo.beans.LibroCajaBanco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/panelcss.css">
        <title>Dashboard</title>
    </head>
    <body>
        <!-- Barra Lateral-->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Sistema C.</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="Controlador?URL=area_dashboard">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_plancontable">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Mantenimiento</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_tipocambio">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Operaciones</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_librodiario">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Consultas</span>
                    </a>
                </li>
                <li class="active">
                    <a href="Controlador?URL=area_informes">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Informes</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                <li>
                    <a href="Controlador?URL=area_ajustes">
                        <i class='bx bxs-cog' ></i>
                        <span class="text">Ajustes</span>
                    </a>
                </li>
            </ul>
        </section>
        <section id="content">
            <!-- Barra de Navegacion -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link"></a>
                <form action="#">
                    <div class="form-input">
                    </div>
                </form>
                <input type="checkbox" id="switch-mode" hidden>
                <label for="switch-mode" class="switch-mode"></label>
                <a href="#" class="profile">
                    <img src="img/people.png">
                </a>
            </nav>
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Informes</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Informes</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" id="MostrarCompras" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Registro de Compras</h3>
                        </span>

                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" id="MostrarVentas" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Registro de Ventas</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="btnmant" type="submit" id="MostrarLD" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Libro Diario</h3>
                        </span>
                    </li>
                </ul>
                <ul class="box-info">
                    <li>
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="btnmant" type="submit" id="MostrarLM" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Libro Mayor</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="btnmant"  id="MostrarCyB" type="submit" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Libro Caja y Bancos</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-smile'  ></i>
                        <span class="btnmant" type="submit"  id="MostrarBC" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Balance de Comprobacion</h3>
                        </span>
                    </li>
                </ul>
                <ul class="box-info">

                    <li>
                        <i class='bx bxs-smile'  ></i>
                        <span class="btnmant" type="submit"  id="MostrarBG" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Balance General</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-smile'  ></i>
                        <span class="btnmant" type="submit"  id="MostrarIyB" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Libro de Inventarios y Balances</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-smile'  ></i>
                        <span class="btnmant" type="submit"  id="MostrarEF" style="cursor:pointer" onclick="location.href = ">
                            <h3 class="itemm" >Estados Financieros</h3>
                        </span>
                    </li>
                </ul>

                <div class="RCcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarCompras">X</button>
                        <form action="RegistroCompras" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>

                <div class="RVcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarVentas">X</button>
                        <form action="RegistroVentas" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                     </div>   


                <div class="LDcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarLD">X</button>
                        <form action="RegistroLibroDiario" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                              </div> 
                    <%-- Modal Balance de Comprobacion --%>         


                <div class="BCcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarBC">X</button>
                        <form action="RegistroBalanceComprobacion" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div> 
                <%-- Modal Balance General --%>         


                <div class="BGcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarBG">X</button>
                        <form action="RegistroBalanceGeneral" method="post">
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Digitos</label>
                                <select name="Digitos">
                                    <%
                                        for(int i=1; i<Usuario.getDigitos(); i++){
                                        
                                    %>
                                    <option value="<%=i+1%>"><%=i+1%></option>
                                    <%
                                        }
                                        
                                    %>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>         


                <%-- Modal Caja y bancos --%>        


                <div class="CyBcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarCyB">X</button>
                        <form action="RegistroCajayBanco" method="post">

                            <div class="form-control">
                                <label for="text">Banco: </label>
                                <select name="Bancos">
                                    <%
                                        List<LibroCajaBanco> lista = new ArrayList<>();
                                        lista = cbLogic.Listarbancos();
                                        for(LibroCajaBanco cb : lista){
                                    %>
                                    <option value="<%=cb.getNumeroCuenta()%>"><%=cb.getNombrebanco()%></option>
                                    <%
                                     }
                                    %>
                                </select>
                            </div>

                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>
                <div class="LMcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarLM">X</button>
                        <form action="RegistroLibroMayor" method="post">
                            <div class="form-control">
                                <label for="text">Ingrese numero de cuenta</label>
                                <input type = "number" name = "txtCuentaLM" class="form-control">  
                            </div>
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>

                <%-- Modal EstadosFinancieros --%>    
                <div class="EFcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarEF">X</button>
                        <form action="RegistroEstadosFinancieros" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select name="FechaI">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <div class="form-control">
                                <label for="text">Hasta</label>
                                <select name="FechaF">
                                    <option value="1">ENERO</option>
                                    <option value="2">FEBRERO</option>
                                    <option value="3">MARZO</option>
                                    <option value="4">ABRIL</option>
                                    <option value="5">MAYO</option>
                                    <option value="6">JUNIO</option>
                                    <option value="7">JULIO</option>
                                    <option value="8">AGOSTO</option>
                                    <option value="9">SEPTIEMBRE</option>
                                    <option value="10">OCTUBRE</option>
                                    <option value="11">NOVIEMBRE</option>
                                    <option value="12">DICIEMBRE</option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button class="btn" type="submit">Generar Reporte</button>
                        </form>
                    </div>
                </div>
                <div class="IyBcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarIyB">X</button>
                        <form id="formIB" action="RegistroEstadosFinancieros" method="post">
                            <div class="form-control">
                                <label for="text">Desde</label>
                                <select onclick="Recuperar()" id="Selector">
                                    <option value="1">Cuenta 10 </option>
                                    <option  value="2">Cuenta 12 </option>
                                    <option value="3">Cuenta 42 </option>
                                </select>
                            </div>
                            <input type="hidden" name="RUC" value="<%=Usuario.getRUC()%>">
                            <input type="hidden" name="RS" value="<%=Usuario.getRazonSocial()%>">
                            <input type="hidden" name="IDPeriodo" value="<%=Usuario.getPeriodo()%>">
                            <button type="submit" class="btn" >Generar Reporte</button>
                        </form> 
                        
                    </div>
                </div> 
            </main>
        </section>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/Informes.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
