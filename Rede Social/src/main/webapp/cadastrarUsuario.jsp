<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styleJavaPage.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;1,700&display=swap" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Rede Social</title>
</head>
<body>
  <header>
  </header>
 	 <main class="main">
   		 <!-- Formulário de postagem -->
    	 <div class="newPost">
		 	<div class="infoUser">
		 		<strong name="nome">Cadastrar Usuario</strong><br>
    	 	<form action="cadastrarUsuario" method="post" class="redesocialForm" id="formpost">
		 		<label><strong>Nome:    </strong></label><input type="text" name="nome" class="textarea"><br>
		 		<label><strong>Email:   </strong></label><input type="text" name="email" class="textarea"><br>
		 		<label><strong>Senha:</strong></label><input type="text" name="senha" class="textarea">
         		<div class="iconsAndButton">
        			<input id="redesocialButton" type="submit" name="salvar" id="botao" class="btnSubmitForm" value="Cadastrar Usuario">
         		</div>
         		<a href="loginUsuario.jsp">Login</a>
         		<div>
					<%
					String mensagem = (String) request.getAttribute("mensagem");
					String col_mensagem = "white";
					if (mensagem == "Email ja cadastrado!") {
						col_mensagem = "red";
					} else if (mensagem == "Usuario cadastrado!") {
						col_mensagem = "green";
					} else if (mensagem == "Todos os campos precisam ser preenchidos!") {
						col_mensagem = "blue";
					}
					%> <font color="<%= col_mensagem %>" > <%= mensagem %> </font>
				</div>
     		</form>
     		</div>
    	 </div>
  	 </main>
</body>
</html>