<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="modelo.logic.CuentaContableLogic" scope="page" id="ccLogic"/>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.beans.CuentaContable"%>
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
        <!-- Barra Lateral -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Sistema C.</span>
            </a>
            <ul class="side-menu top">
                <li class="active">
                    <a href="Controlador?URL=area_dashboard">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_mantenimiento">
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
                        <h1>Consultas</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Consultas</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="text">
                            <h3>Cuentas por Pagar</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="text">
                            <h3>Cuentas por Cobrar</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="text">
                            <h3>Libro Diario</h3>
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
                                <label for="text">Número</label>
                                <input type="text" name="txtNumero" placeholder="Número">
                            </div>
                            <div class="form-control">
                                <label for="text">Nombre</label>
                                <input type="text" name="txtNombre" placeholder="Nombre">
                            </div>
                            <div class="form-control">
                                <label for="text">Moneda</label>
                                <input type="text" name="txtMoneda" placeholder="Moneda">
                            </div>
                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_cuentacontable">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
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
                                    <th>Numero</th>
                                    <th>Nombre</th>
                                    <th>Moneda</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<CuentaContable> cuentas = new ArrayList<>();
                                    cuentas = ccLogic.Listar();
                                    
                                    int m=cuentas.size();
                                    int i=0;
                                    
                                    while(i<m){
                              
                                        int numero = cuentas.get(i).getNumero();
                                        String nombre = cuentas.get(i).getNombre();
                                        String moneda = cuentas.get(i).getMoneda();
                                %>
                                <tr>
                                    <td>
                                        <p><%=numero%></p>
                                    </td>
                                    <td><%=nombre%></td>
                                    <td><span class="status completed"><%=moneda%></span></td>
                                </tr>
                                <%
                                        i=i+1;
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </section>

        <script src="js/panel.js"></script>
    </body>
</html>
