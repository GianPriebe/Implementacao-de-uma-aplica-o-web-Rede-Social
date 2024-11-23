<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/redesocialStyle.css">

<meta charset="ISO-8859-1">
<title>Rede Social</title>
</head>
<body>
	<nav class="redesocialNav">
		<ul>
			<li><span style="color: yellow">Rede Social</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="cadastrarUsuario.jsp">Cadastrar Usuario</a></li>
			<li><a href="loginUsuario.jsp">Login</a></li>
		</ul>
	</nav>
	<main class="usuarioMain">
		<form action="cadastrarUsuario" method="post" class="redesocialForm">
			<div>
				<label><strong>Nome:</strong></label><input type="text"
					name="nome">
			</div>
			<div>
				<label><strong>Email:</strong></label><input type="text"
					name="email">
			</div>
			<div>
				<label><strong>Password:</strong></label><input type="text"
					name="senha">
			</div>
			<br>
			<div>
				<input id="redesocialButton" type="submit" name="salvar"
					value="Cadastrar Usuario">
			</div>
			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null)
					out.print(mensagem);
				%>
			</div>
		</form>
	</main>
</body>
</html>