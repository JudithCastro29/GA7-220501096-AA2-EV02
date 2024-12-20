<%-- 
    Document   : panel
    Created on : 19/12/2024, 7:06:47 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PANEL DE USUARIOS STOCKMASTER</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
    </head>
    <body>
        <!-- Main container with PicoCSS -->
        <main class="container">
            <div class="panel-container">
                <h1>Hola, <%= request.getAttribute("usuario")%></h1>
                <p>Este es tu panel de usuario. Bienvenido al sistema de gestión de inventarios STOCKMASTER.</p>
                <a href="logout">Cerrar sesión</a>
            </div>
        </main>
    </body>
</html>
