<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/usuarioStyle.css">
<meta charset="ISO-8859-1">
<title>Banana Bacana</title>
</head>
<body>
	<nav class="usuarioNav">
		<ul>
			<li><span style="color: yellow">RedeSocial</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="cadastrarUsuario.jsp">Cadastrar Usuario</a></li>
			<li><a href="loginUsuario.jsp">Login</a></li>
		</ul>
	</nav>
	<main class="usuarioMain">
		<form action="http://localhost:8081" method="post" class="usuarioForm">
			<div>
				<label><strong>Email:</strong></label><input type="text"
					name="Email">
				<label><strong>Senha:</strong></label><input type="text"
					name="Senha">
			</div>
			<br>
			<div>
				<input id="redesocialButton" type="submit" name="salvar"
					value="Consultar Usuario">
			</div>
		</form>
	</main>
</body>
</html>