function lista_hospital(){
    $("#datos").empty(); 
    $("#datos").html("<img src='img/loading.gif' id='load' width=40 height=40 alt='cargando...' />");
    $.ajax({                                 
        type:"get",
        url:"InfoHospitalServlet?id=all",
        datatype:"json",
        success: function(hospitales){   
            $("#datos").empty(); 
            var tabla = "<table class=\"table table-bordered\" id=\"tabla1\"><tr><td>ID</td><td>Nombre</td><td>Apellidos</td><td>Ajustes</td></tr>";            
            $.each(hospitales, function(index,hospital){                   
                tabla += '<tr>'
                tabla += '<td>'+hospital.id+'</td>'
                tabla += '<td>' +hospital.nombre+'</td>'
                tabla += '<td>' +hospital.direccion+ '</td>'
                tabla += '<td><button class="btn detalle_hospital btn btn-info" data-id="' + hospital.id + '" value=\"'+hospital.id+'\"><b >Detalles</b></td>'
                tabla += '<td><button class="btn editar_hospital btn btn-info" data-id="' + hospital.id + '" value=\"'+hospital.id+'\"><b>Editar</b></td>'
                tabla += '<td><button class="btn baja_hospital btn btn-info" data-id="' + hospital.id + '" value=\"'+hospital.id+'\"><b >Baja</b></td>'; 
                tabla += '</tr>'                   
            });                                      
            tabla += '<tr><td><button class="btn alta_hospital btn btn-info"><b>Alta</b></td></tr>';
            tabla += '</table>'                
            
            $("#datos").append(tabla);                            
            $(".detalle_hospital").click(function(){                  
                detalle_hospital($(this).data('id'))                                                                  
            });
            
            $(".editar_hospital").click(function(){                  
                editar_hospital($(this).data('id'))                                                                  
            });
            $(".alta_hospital").click(function(){                  
                alta_hospital()                                                                  
            });
            $(".baja_hospital").click(function(){                  
                baja_hospital($(this).data('id'))                                                                  
            });                                            
        },                
        error: function(){            
            $("#datos").empty();
            $("#datos").append("ERROR: Problema en la comunicacion con el servidor");
        }
        
        
    });

}
    


function detalle_hospital(id){
    
    $("#myModal").modal("show"); 
    $("#datosmodal").html("<img src='img/loading.gif' id='load' width=40 height=40 alt='cargando...' />");                     
    $.ajax({
        type:"get",
        url:"InfoHospitalServlet?id="+id,
        datatype:"json",
        data: null,
        success: function(hospital){                              
            var tabla2 = "<table class=\"table table-bordered\" id=\"tabla1\"><tr><td>ID</td><td>Nombre</td>\n\
                        <td>Direccion</td><td>Telefono</td><td>Personal</td><td>Salas</td></tr>";
            tabla2 += '<tr><td>'+hospital.id+'</td>\n\
                        <td>' +hospital.nombre+'</td><td>' +hospital.direccion+'</td>\n\
                <td>' +hospital.telefono+ '</td><td>' +hospital.personal+ '</td><td>' +hospital.salas+ '</td>';
            tabla2 += '</tr></table>';  
                               
            $("#datosmodal").empty();
            $("#datosmodal").html(tabla2); 
                                      
        }
                          
    });
    
}
function editar_hospital(id){
    $("#myModal").modal("show"); 
    $("#datosmodal").html("<img src='img/loading.gif' width=40 height=40 alt='cargando...' />");        
    $.ajax({                    
        url: 'InfoHospitalServlet?id='+id, 
        dataType: 'json',
        type: "GET",
        success: function(hospital){                              
            $("#datosmodal").empty(); 
            var form="<form action='EditarHospitalServlet'>"+     
            "<input name='id' type='hidden' class='input-large' value='"+hospital.id+"' />"+  											 
           "<label>Nombre</label>"+  
            "<input name='nombre' type='text' class='input-large' value='"+hospital.nombre+"' />"+  											 
            "<label>Direccion</label>"+  
            "<input name='direccion' type='text' class='input-large' value='"+hospital.direccion+"'/>"+ 											 
            "<label>Telefono</label>"+  
            "<input name='telefono' type='text' class='input-large' value='"+hospital.telefono+"'/>"+  											 
            "<label>Personal</label>"+  
            "<input name='personal' type='text' class='input-large' value='"+hospital.personal+"'/>"+							 
            "<label>Salas</label>"+  
            "<input name='salas' type='text' class='input-large' value='"+hospital.salas+"'/>"+ 
            "<div>"+ 
            "<button name='save-hospital' type='submit' class='btn btn-primary'>Editar</input>"+  
            "</div>"+                     
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
function baja_hospital(id){ 
    $("#datosmodal").html("<img src='img/loading.gif' width=40 height=40 alt='eliminando...' />");
    
    $.ajax({                    
        url: 'BajaHospitaleServlet?id='+id, 
        dataType: 'text',
        type: "POST",
        success: 
            
        function(text){                   
            $("#datosmodal").empty(); 
            $("#datosmodal").append("<p>"+text+"</p>");                                                                  
            lista_hospitales();            
        },      
        error: function(){                
            if(id ==""){                    
                $("#datosmodal").empty(); 
                $("#datosmodal").append("<p>Error</p>");                    
            }
        }            
    });  
 
}
    


function alta_hospital()
{
    
    $("#myModal").modal("show"); 
    $("#datosmodal").empty();    
    var form="<form action='AltaHospitalServlet'>"+     
    "<label>Nombre</label>"+  
    "<input name='nombre' type='text' class='input-large'/>"+  											 
    "<label>Direccion</label>"+  
    "<input name='direccion' type='text' class='input-large'/>"+ 											 
    "<label>Telefono</label>"+  
    "<input name='telefono' type='text' class='input-large'/>"+  											 
    "<label>Personal</label>"+  
    "<input name='personal' type='text' class='input-large'/>"+							 
    "<label>Salas</label>"+  
    "<input name='salas' type='text' class='input-large'/>"+ 
    "<div>"+  
    "<button name='save-hospital' type='submit' class='btn btn-primary'>Dar de alta</input>"+  
    "</div>"+                     
    "</form>";                                
    $("#datosmodal").append(form);      
}          
            