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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
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
                <li class="active">
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
                        <h1>Mantenimiento</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Mantenimiento</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="#">Plan Contable</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_librodiario'">
                            <h3 class="itemm" >Libro Diario</h3>
                        </span>

                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_libromayor'">
                            <h3 class="itemm" >Libro Mayor</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_librocajabanco'">
                            <h3 class="itemm" >Libro Caja y Bancos</h3>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="todo">
                        <form id="formLibroMayor">
                            <div class="card-body">
                                <div class="container-fluid">
                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label class="col-form-label" for="text">Numero de Cuenta</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="text" name="txtCuenta" class="form-control" style="width: 100px;">
                                        </div>
                                        <div class="col-auto">
                                            <input type="text" class="form-control" style="width: 350px;" readonly>
                                        </div>
                                    </div>
                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label  class="col-form-label" >Fecha de Inicio y Fin:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="date" class="form-control" name="txtFecha_inicio">
                                        </div>
                                        <div class="col-auto">
                                            <label  class="col-form-label" >....</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="date" class="form-control" name="txtFecha_fin">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <button type="button" class="btn" id="BtnBuscar">Buscar</button>
                    </div>
                </div>
                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Lista Libro Mayor</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>NUMERO DE CUENTA</th>
                                    <th>FECHA</th>
                                    <th>NCLD</th>
                                    <th>GLOSA</th>
                                    <th>DEUDOR</th>
                                    <th>ACREEDOR</th>
                                </tr>
                            </thead>
                            <tbody id="libro_mayor">
                            </tbody>
                        </table>
                        <form>
                            <button type="submit" class="btn">
                                <img src="Visualizar" alt=""/>Visualizar
                            </button>
                            <button type="submit" class="btn">
                                <img src="Imprimir" alt=""/> Imprimir
                            </button>
                        </form>
                    </div>
                </div>
            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/LibroMayor.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
