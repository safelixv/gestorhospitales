<%-- 
    Document   : index
    Created on : 15-feb-2013, 17:56:32
    Author     : vesprada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <script>
            var numeroPagina=<% if (request.getParameter("pagenumber") != null) {
                    out.print(request.getParameter("pagenumber"));
                } else {
                    out.print(1);
                }
            %>
                var ver=<% if (request.getParameter("ver") != null) {
                    out.print("'"+request.getParameter("ver")+"'");
                } else {
                    out.print("'pacientes'");
                   }%>
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" type="text/css" href="css/micss.css" />
        <link rel="stylesheet" type="text/css" href="css/plantilla.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>

        
    </head>

    <body>

        <div id="cabecera" class="row">
            <img id="logo" src="/ProyectoHospitalRiaza/img/medicina.gif" /> <h1>Hospital General</h1>   

            <div class="row offset4 span3" id="formulario">
                <input type="text" maxlength="3" id="entrada">
                <button type="button" class="btn btn-info" id="buscar">Buscar <i class="icon-search icon-white"></i>

            </div>  

        </div>


        <div id="menuizq"><h3>Navegacion</h3><br />
            <ul id="menuprin">
                <li><h4><img src="img/flecha.gif" /><a href="#" />Inicio</h4></li>
                <ul id="submenu">
                    <li id="listado_pacientes"><img src="img/flecha.gif" /><a href="index.jsp?ver=pacientes" > Pacientes</a></li>
                    <li id="listado_hospitales"><img src="img/flecha.gif" /><a href="index.jsp?ver=hospitales" > Hospital</a></li>
                    <li id="listado_habitaciones"><img src="img/flecha.gif" /><a href="index.jsp?ver=habitaciones"> Habitaciones</a></li>
                </ul>
            </ul>

        </div>


        <div class="span6" id="datos"></div>




        <div id="myModal" class="modal hide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">


            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">Datos personales</h3>
            </div>


            <div class="modal-body" id="modal_cuerpo" >
                <div id="datosmodal"></div>
            </div>


            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>


        </div>




        <div id="pie">

            Centro Medico Hospital Central

        </div>
        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="js/pacientes.js" type="text/javascript"></script>
        <script src="js/Hospitales.js" type="text/javascript"></script>
        <script src="js/ajax.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>

