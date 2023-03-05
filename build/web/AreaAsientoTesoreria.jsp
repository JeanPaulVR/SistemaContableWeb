<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session = "true"%>
<jsp:useBean class="modelo.logic.LibroCajaBancoLogic" scope="page" id="cbLogic"/>
<%@page import="modelo.beans.LibroCajaBanco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
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
                <li class="active">
                    <a href="Controlador?URL=area_tipocambio">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Operaciones</span>
                    </a>
                </li>
                <li >
                    <a href="Controlador?URL=area_librodiario">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Consultas</span>
                    </a>
                </li>
                <li>
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
                        <h1>Operaciones</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Asiento Tesoreria</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipocambio'">
                            <h3 class="itemm">Tipo de Cambio</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_asientocontable'">
                            <h3 class="itemm">Asiento Contable</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_asientotesoreria'">
                            <h3 class="itemm">Asiento de Tesoreria</h3>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="card-body" >
                        <form style="display:flex; justify-content: space-between" id="finalizarFormteso">

                            <div class="row g-3 align-items-center" >
                                <div class="col-auto">
                                    <label  class="col-form-label" >Tipo de Operación:</label>
                                </div>
                                <div class="col-auto" >
                                    <input type="number" class="form-control" name="txtTipoO" id="TipoOper" style="width: 60px;"> 
                                </div>
                                <div class="col-auto">
                                    <input type="text" id="NomTipOp" name="txtNombre" class="form-control" style="width: 300px;" readonly>
                                </div>
                                <div class="row g-3 align-items-center">
                                    <div class="col-auto">
                                        <label  class="col-form-label"> Moneda</label>
                                    </div>
                                    <select id="TCid" name="txtTipoCambio" class="form-select" style="width: 100px;">
                                        <option></option>
                                        <option value="1">Soles</option>
                                        <option value="2">Dólares</option>
                                    </select>
                                    <div class="col-auto">
                                        <label  class="col-form-label"> Nº de Asiento:</label>
                                    </div>
                                    <div class="col-auto" >
                                        <input type="number" id="NumeroAsiento" name="txtNumeroAsiento" class="form-control" style="width: 95px;" readonly>
                                    </div>
                                </div>
                                <div class="row g-3 align-items-center" >                          
                                    <div class="col-auto">
                                        <label class="col-form-label">Glosa:</label>
                                    </div>
                                    <div class="col-auto" >
                                        <input type="text" name="txtGlosa" id="Glosa" class="form-control">
                                    </div>
                                    <div class="col-auto">
                                        <label  class="col-form-label"> Fecha:</label>
                                    </div>
                                    <div class="col-auto" >
                                        <input type="date" id="NAfecha" name="txtFecha" class="form-control">
                                    </div>
                                </div>
                            </div>

                            <div class="mb-3">
                                <div>Correlativo</div>                     
                                <input type="text" class="form-control" style="width:300px" name="txtCorrelativo">

                                <div>Método de Pago</div>  
                                <select name="txtMetodoPago" class="form-select" style="width:300px;" name="">
                                    <option></option>
                                    <option value="003">Tranferencia</option>
                                    <option value="008">Efectivo</option>
                                </select>
                                <br><!-- comment -->
                                <div>Caja/Banco</div>
                                <select name="txtNumeroCuentaContable" class="form-select" style="width:300px;">
                                    <option value =""></option>
                                    <%
                                        List<LibroCajaBanco> lista=new ArrayList<>();
                                        lista=cbLogic.Listarbancos();
                                        for(LibroCajaBanco cb: lista){
                                    %>
                                    <option value="<%=cb.getNumeroCuenta()%>"><%=cb.getNombrebanco()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div>
                                <input type="hidden" id="TipoDocH" name="txtTipoDocumentoSeleccionar" >
                                <input type="hidden" id="CuentaAuxH" name="txtCuentaCorrienteSelecionar" >
                                <input type="hidden" id="ClaseBienH" name="txtClaseBienSeleccionar" >
                                <input type="hidden" id="ImporteH" name="txtImporteSeleccionar" >
                                <input type="hidden" id="DebeHaberH" name="txtdhSeleccionar" >
                                <input type="hidden" id="SerieH" name="txtSerieSeleccionada" >
                                <input type="hidden" id="CuentaContH" name="txtNumeroCuentaContableSeleccionado" >
                            </div>    
                        </form>
                    </div> 
                </div>
                <div class="table-data">
                    <div class="todo">
                        <form id="formTesoreria">
                            <div class="card-body">
                                <div class="container-fluid">
                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label class="col-form-label" for="text">Serie:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="text" name="txtSerieSeleccionada" class="form-control">
                                        </div>

                                        <div class="col-auto">
                                            <label class="col-form-label" for="text">Correlativo:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="text" name="txtCorrelativo" class="form-control">
                                        </div>
                                        <div class="col-auto" >
                                            <button type="button" class="btn" id="BtnBuscarTeso">Buscar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Lista Tesorerías</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table class="table">
                            <thead class="table-ligth">
                                <tr>
                                    <th>Tipo</th>
                                    <th>Cuenta Auxiliar</th>
                                    <th>Documento</th>
                                    <th>Moneda</th>
                                    <th>Soles</th>
                                    <th>Dolares</th>

                                </tr>
                            </thead>
                            <tbody id="asiento_tesoreria">
                            </tbody>
                        </table>
                    </div>
                </div>
                <br>
                <div class="col-auto" style="display: flex;justify-content: space-between;">
                    <div class="col-auto" style="display: flex">
                        <button type="button" class="btn" id="FinalizarAsientoTesoreria">Finalizar</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn" id="CancelarAsiento">Cancelar</button>
                    </div>

                </div>
            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/Tesoreria.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>


    </body>
</html>