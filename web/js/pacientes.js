function lista_pacientes(pageNumber){
    $("#datos").empty();     
    var pages= $.getValues("InfoPacienteServlet?id=getpages");    
    var pacientes=$.getValues("InfoPacienteServlet?id=getpage&page="+pageNumber);   
  
    var tabla = "<table class=\"table table-bordered\" id=\"tabla1\"><tr><td>ID</td><td>Nombre</td><td>Apellidos</td><td>Ajustes</td></tr>";            
    $.each(pacientes, function(index,paciente){                   
        tabla += '<tr>'
        tabla += '<td>'+paciente.id+'</td>'
        tabla += '<td>' +paciente.nombre+'</td>'
        tabla += '<td>' +paciente.apellidos+ '</td>'
        tabla += '<td><button class="btn detalle_paciente btn btn-info" data-id="' + paciente.id + '" value=\"'+paciente.id+'\"><b >Detalles</b></td>'
        tabla += '<td><button class="btn editar_paciente btn btn-info" data-id="' + paciente.id + '" value=\"'+paciente.id+'\"><b>Editar</b></td>'
        tabla += '<td><button class="btn baja_paciente btn btn-info" data-id="' + paciente.id + '" value=\"'+paciente.id+'\"><b >Baja</b></td>'; 
        tabla += '</tr>'                   
    });                                      
    tabla += '<tr><td> <button class="btn alta_paciente btn btn-info"><b>Alta</b></td>';
    tabla += '<td colspan=4>'+getNeighborhood("index.jsp?ver=pacientes&pagenumber=", pageNumber, pages, 10)+'</td></tr>'; 
    tabla += '</table>'                
            
    $("#datos").append(tabla);                            
    $(".detalle_paciente").click(function(){                                  
        detalle_paciente($(this).data('id'))                                                                  
    });            
    $(".editar_paciente").click(function(){                  
        editar_paciente($(this).data('id'))                                                                  
    });
    $(".alta_paciente").click(function(){                  
        alta_paciente($(this).data('id'))                                                                  
    });
    $(".baja_paciente").click(function(){                  
        baja_paciente($(this).data('id'))                                                                  
    });                                            
  
}
    


function detalle_paciente(id){  
    $("#myModal").modal("show"); 
    $("#datosmodal").html("<img src='img/loading.gif' id='load' width=40 height=40 alt='cargando...' />");                     
    $.ajax({
        type:"get",
        url:"InfoPacienteServlet?id="+id,
        datatype:"json",
        data: null,
        success: function(paciente){               
            var tabla2 = "<table class=\"table table-bordered\" id=\"tabla1\"><tr><td>ID</td><td>Nombre</td>\n\
                        <td>Apellidos</td><td>Direccion</td><td>Telefono</td><td>DNI</td><td>NISS</td><td>Sexo</td><td>habitacion</td></tr>";
            var habitacion=$.getValues("InfoHabitacionServlet?id="+paciente.habitacionId); 
            
            tabla2 += '<tr><td>'+paciente.id+'</td>\n\
                        <td>' +paciente.nombre+'</td><td>' +paciente.apellidos+'</td>\n\
                <td>' +paciente.direccion+ '</td><td>' +paciente.telefono+ '</td><td>' +paciente.DNI+ '</td><td>' +paciente.NSS+ '</td><td>' +paciente.Sexo+ '</td>'+ '</td><td>' +habitacion.numero+ '</td>';
            tabla2 += '</tr></table>';                                
            $("#datosmodal").empty();
            $("#datosmodal").html(tabla2); 
                                      
        }
                          
    });
    
}
function editar_paciente(id){
    $("#myModal").modal("show"); 
    $("#datosmodal").html("<img src='img/loading.gif' width=40 height=40 alt='cargando...' />");        
    $.ajax({                    
        url: 'controlador?id='+id, 
        dataType: 'json',
        type: "GET",
        success: function(paciente){                              
            $("#datosmodal").empty(); 
            var form="<form action='EditarPacienteServlet'>"+     
            "<input name='id' type='hidden' class='input-large' value='"+paciente.id+"' />"+  											 
            "<label>Nombre</label>"+  
            "<input name='nombre' type='text' class='input-large' value='"+paciente.nombre+"' />"+  											 
            "<label>Apellidos</label>"+  
            "<input name='apellidos' type='text' class='input-large' value='"+paciente.apellidos+"'/>"+ 											 
            "<label>Telefono</label>"+  
            "<input name='telefono' type='text' class='input-large' value='"+paciente.telefono+"'/>"+  											 
            "<label>Direccion</label>"+  
            "<input name='direccion' type='text' class='input-large' value='"+paciente.direccion+"'/>"+							 
            "<label>DNI</label>"+  
            "<input name='DNI' type='text' class='input-large' value='"+paciente.DNI+"'/>"+             
            "<label>NSS</label>"+  
            "<input name='NSS' type='text' class='input-large' value='"+paciente.NSS+"'/>"+             
            "<label>sexo</label>"+  
            "<input name='sexo' type='text' class='input-large' value='"+paciente.sexo+"'/>"+ 
            select_habitaciones(paciente.habitacionId) +
            "<button name='save-paciente' type='submit' class='btn btn-primary'>Editar</input>"+  
            
            "</form>";  

            $("#datosmodal").empty();
            $("#datosmodal").html(form); 
                                     
        },
        error: function(){                
            if(id ==""){                    
                $("#datosmodal").empty(); 
                $("#datosmodal").append("<p>Debe introducir un id.</p>");                    
            }
        }            
    });    
}
function baja_paciente(id){ 
    $("#datosmodal").html("<img src='img/loading.gif' width=40 height=40 alt='eliminando...' />");
    
    $.ajax({                    
        url: 'BajaPacienteServlet?id='+id, 
        dataType: 'text',
        type: "POST",
        success: 
            
        function(text){                   
            $("#datosmodal").empty(); 
            $("#datosmodal").append("<p>"+text+"</p>");                                                                  
            lista_pacientes();            
        },      
        error: function(){                
            if(id ==""){                    
                $("#datosmodal").empty(); 
                $("#datosmodal").append("<p>Error</p>");                    
            }
        }            
    });  
 
}
    



function select_habitaciones(idHabitacion){
    var habitaciones=$.getValues("InfoHabitacionServlet?id=all");  
    var selectHabitaciones='<select name="habitacion_id">';
    $.each(habitaciones, function(index,habitacion){
        select='';
        if (habitacion.id == idHabitacion){
            select='selected';
        }
        selectHabitaciones+='<option value="'+habitacion.id+'" '+select+'>'+habitacion.numero+'</option>';
    }
    ); 
    selectHabitaciones+='</select>';
    return selectHabitaciones;
}

function alta_paciente()
{        
    $("#myModal").modal("show"); 
    $("#datosmodal").empty();       
    var form="<form action='AltaPacienteServlet'>"+     
    "<label>Nombre</label>"+  
    "<input name='nombre' type='text' class='input-large'/>"+  											 
    "<label>Apellidos</label>"+  
    "<input name='apellidos' type='text' class='input-large'/>"+ 											 
    "<label>Telefono</label>"+  
    "<input name='telefono' type='text' class='input-large'/>"+  											 
    "<label>Direccion</label>"+  
    "<input name='direccion' type='text' class='input-large'/>"+							 
    "<label>DNI</label>"+  
    "<input name='DNI' type='text' class='input-large'/>"+     
    "<label>NSS</label>"+  
    "<input name='NSS' type='text' class='input-large'/>"+    
    "<label>sexo</label>"+  
    "<input name='sexo' type='text' class='input-large'/>"+     
    "<label>habitacion</label>"+  select_habitaciones(0) + '</br>' +
    "<button name='save-paciente' type='submit' class='btn btn-primary'>Dar de alta</input>"+                      
    "</form>";                                
    $("#datosmodal").append(form);      
}          
            
function getNeighborhood(link,  page_number, total_pages, neighborhood) { 
    page_number=parseInt(page_number);
    total_pages=parseInt(total_pages);
    neighborhood=parseInt(neighborhood);
    vector = "<div class=\"pagination\"><ul>";
    if (page_number > 1)
        vector+=("<li><a class=\"pagination_link\" id=\"" + (page_number - 1) + "\" href=\"" + link + (page_number - 1) + "\">prev</a></li>");
    if (page_number > neighborhood + 1)
        vector+=("<li><a class=\"pagination_link\" id=\"1\" href=\"" + link + "1\">1</a></li>");
    if (page_number > neighborhood + 2)
        vector+=("<li>" + "<a href=\"#\">...</a>" + "</li>");
    for (i = (page_number - neighborhood); i <= (page_number + neighborhood); i++){
        if (i >= 1 && i <= total_pages){
            if (page_number == i){
                vector+=("<li class=\"active\"><a class=\"pagination_link\" id=\"" + i + "\" href=\"" + link +     i + "\">" + i + "</a></li>");
            }            
            else
                vector+=("<li><a class=\"pagination_link\" id=\"" + i + "\" href=\"" + link + i + "\">" + i + "</a></li>");
        }
    }
    if (page_number < total_pages - (neighborhood + 1))
        vector+=("<li>" + "<a href=\"#\">...</a>" + "</li>");
    if (page_number < total_pages - (neighborhood))
        vector+=("<li><a class=\"pagination_link\" id=\"" + total_pages + "\" href=\"" + link + total_pages + "\">" + total_pages + "</a></li>");
    if (page_number < total_pages)
        vector+=("<li><a class=\"pagination_link\"  id=\"" + (page_number + 1) + "\" href=\"" + link + (page_number + 1) + "\">next</a></li>");        
    vector += "</ul></div>";
    return vector;
}           


jQuery.extend({
    getValues: function(url) {
        var result = null;
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function(data) {
                result = data;
            }
        });
        return result;
    }
});