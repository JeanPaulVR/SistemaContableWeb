<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <form action="#">
                    <div class="form-input">
                        <input type="checkbox" id="switch-mode" hidden>
                        <label for="switch-mode" class="switch-mode"></label>
                    </div>
                </form>
                <a href="#" class="profile">
                    <img src="img/people.png">
                </a>
            </nav>
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Dashboard</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Dashboard</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="#">Home</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </main>
        </section>

        <script src="js/panel.js"></script>
    </body>
</html>
