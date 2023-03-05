<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
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
        <!-- Barra Lateral -->
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
                <li>
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
                                <a href="#">Operaciones</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
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
                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer"  id="MostrarCR" onclick="location.href = ">
                            <h3 class="itemm">Cierre de Cuentas de Resultado</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" id="MostrarCB" onclick="location.href = ">
                            <h3 class="itemm">Cierre de Cuentas de Balance</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" id="MostrarAA" onclick="location.href = ">
                            <h3 class="itemm">Asiento de Apertura</h3>
                        </span>
                    </li>
                </ul>
                <div class="head-title">
                    <div class="left">
                        <h1>Opciones</h1>
                    </div>
                </div>
                <div class="table-data">
                    <div class="todo">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Nombre</label>
                                <input type="text" name="txtNombre" placeholder="Nombre">
                            </div>
                            <div class="form-control">
                                <label for="text">Precio de Compra</label>
                                <input type="text" name="txtPrecio_compra" placeholder="Precio de Compra">
                            </div>
                            <div class="form-control">
                                <label for="text">Precio de Venta</label>
                                <input type="text" name="txtPrecio_venta" placeholder="Precio de Venta">
                            </div>
                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_tipocambio">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>Lista</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Nombre</th>
                                    <th>Fecha</th>
                                    <th>Precio de Compra</th>
                                    <th>Precio de Venta</th>
                                </tr>
                            </thead>
                            <tbody id="tipo_cambio">
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="CRcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarCR">X</button>
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Tipo de Operación:</label>
                                <input type="number" id="TipoOper" name="txtTipOp" placeholder="Tipo de Operación">
                            </div>
                            <div class="form-control">
                                <input type="text" id="NomTipOp" readonly>
                            </div>
                            <input type="hidden" name="URL" value="cierre_cuentasresultado">
                            <div style="text-align: center;">
                                <button class="btn" type="submit">Generar Cierre</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="CBcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarCB">X</button>
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Tipo de Operación:</label>
                                <input type="number" id="TipoOper1" name="txtTipOp" placeholder="Tipo de Operación">
                            </div>
                            <div class="form-control">
                                <input type="text" id="NomTipOp1" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Glosa:</label>
                                <input type="text" name="txtGlosa" placeholder="Glosa">
                            </div>
                            <input type="hidden" name="URL" value="cierre_cuentasbalance">
                            <div style="text-align: center;">
                                <button class="btn" type="submit">Generar Cierre</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="AAcontenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="OcultarAA">X</button>
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Tipo de Operación:</label>
                                <input type="number" id="TipoOper2" name="txtTipOp" placeholder="Tipo de Operación">
                            </div>
                            <div class="form-control">
                                <input type="text" id="NomTipOp2" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Glosa:</label>
                                <input type="text" name="txtGlosa" placeholder="Glosa">
                            </div>
                            <input type="hidden" name="URL" value="asiento_apertura">
                            <div style="text-align: center;">
                                <button class="btn" type="submit">Generar Apertura</button>
                            </div>
                        </form>
                    </div>
                </div> 
            </main>
        </section>
        <script src="js/panel.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 
        <script src="js/TipoCambio.js" type="text/javascript"></script>
    </body>
</html>
