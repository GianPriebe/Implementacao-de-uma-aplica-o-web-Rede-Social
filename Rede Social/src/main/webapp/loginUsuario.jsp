<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/usuarioStyle.css">
<meta charset="ISO-8859-1">
<title>Rede Social</title>
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
		<form action="loginUsuario" method="post" class="usuarioForm">
			<div>
				<label><strong>Email:</strong></label><input type="text"
					name="email">
				<label><strong>Senha:</strong></label><input type="text"
					name="senha">
			</div>
			<br>
			<div>
				<input id="redesocialButton" type="submit" name="salvar"
					value="Consultar Usuario">
			</div>
			<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null)
					out.print(mensagem);
			%>
		</form>
	</main>
</body>
</html>