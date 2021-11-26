

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actividades</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <script type="text/javascript" >

            $(document).ready(function () {
                $("#tablaUsuario").on("click","#btnModificar",function(){
                    //alert("hola");
                    
                    var id=$(this).attr("idUsuario");
                    var nombre=$(this).attr("nombre");
                    var apellido=$(this).attr("apellido");
                    var telefono=$(this).attr("telefono");
                    
                    $("#modNombre").val(nombre);
                    $("#modApellido").val(apellido);
                    $("#modTelefono").val(telefono);
                     $("#idUsuarioModificar").val(id);
                    var urlServler="actividades/ServletControlador?accion=modificarUsuario&idUsuario";
                    
                   //$("#aperturaForm").html('<form action='+urlServler+id+' method="POST">');
                    
                   
                });

                
            });

        </script>  
    </head>
    <body>

        <div class="container">



            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#"><i class="fab fa-rocketchat"></i> 
                        Actividades</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" id="usuarios" href="${pageContext.request.contextPath}/ServletControlador?accion=cargarUsuarios">Usuarios</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Tareas</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>



        </div>

    </body>
</html>



<!-- Button trigger modal -->


<!-- Modal -->




