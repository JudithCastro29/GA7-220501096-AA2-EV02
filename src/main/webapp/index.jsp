<%-- 
    Document   : index
    Created on : 19/12/2024, 7:06:14 p. m.
    Author     : Cristian Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STOCKMASTER</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
    </head>
    <body>
        <!-- Main container with PicoCSS -->
        <main class="container">
            <div class="login-container">
                <h1>LOGIN STOCKMASTER</h1>
                <h3>
                    <%
                        if (request.getAttribute("mensajeError") != null) {
                            out.print(request.getAttribute("mensajeError"));
                        }
                    %>
                </h3>

                <form action="Recibirdatos" method="POST">
                    <input type="text" name="user" placeholder="Usuario" required>
                    <input type="password" name="password" placeholder="Contraseña" required>
                    <input type="submit" value="Ingresar">
                </form>
            </div>
        </main>
    </body>
</html>
