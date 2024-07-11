<img src="reto-foro.png" style="margin-left:6rem" >
<h1 style="text-align:center; display:none;">Reto Alura</h1>
<hr>
<h2 style="text-align:center" >Daniel Jesus Vadillo Cocom</h2>
<hr>
<p>Como parte de mi proyecto final se creó un foro al estilo ALURA, donde se incluyen la creación de Topico, Usuarios y Perfiles, esto es más un CRUD de foros, con la finalidad de poner en practica los conocimientos de JAVA Spring Boot 3, También se implementó el sistema de Seguridad.</p>

<img src="caracteristica-img.png" style="margin-left:6rem" >
<h3>Funcionalidades del programa</h3>
<ul>
    <li>
    <h5>Listar Topicos</h5>
    <p>Como parte de un sistema REST el Foro puede listar de manera en paginación los topicos devolviendo un JSON con la información, es importante recalcar que solo se listan los topicos con el Status true</p>
    <img src="listar-topico.png" style="width:600px">
    </li>
    <li>
    <h5>Ver Topico Detallado</h5>
    <p>En caso de que solo se desee ver la información de un Topico se coloca el URL con el ID del topico</p>
    <img src="detalle-topico.png" style="width:600px">
    </li>
     <li>
    <h5>Eliminar Topico</h5>
    <p>Al igual que el detallado, se coloca el ID para posteriormente crear una comprobación de que realmente existe y después enviar la solicitud al JPA de un metodo Delete para la base de datos.</p>
    <img src="delete-topico.png" style="width:600px">
    </li>
     <li>
    <h5>Actualizar Topico</h5>
    <p>En este caso de actualizar los campos de Titulo, mensaje y el status para el caso que el topico desee ser eliminado de la vista principal pero no eliminado de la base de datos.</p>
    <img src="actualizacion-topico.png" style="width:600px" >
    </li>
     <li>
    <h5>Crear Usuario</h5>
    <p>Como parte de un sistema de seguridad se crea un usuario para poder acceder a la información, este usuario solo puede ser creado por un usuario con un Token inicial. </p>
    <img src="creacion-usuario.png" style="width:600px"> 
    </li>
     <li>
    <h5>Inicio de Sesion</h5>
    <p>Como forma de verificación se utiliza el Correo electronico para poder acceder como usuario, además que la contraseña que no tiene limitaciones.</p>
    <img src="inicio-token-JWT.png" style="width:600px">
    </li>
    <h3>Base de datos</h3>
    <img src="Base de datos.png">
    <img src="base da datos 2.png">
</ul>
<hr>
<img src="tecnologia-usada.png" style="margin-left:6rem">
<br><br><br>
<ul>
<li>Java 17</li>
<li>Spring Boot 3.3.1</li>
<li>WampServer 3.2.6</li>
<li>MySQL 5.7.36 </li>
<li>Insomnia 9.3.2</li>
</ul>
<hr>
