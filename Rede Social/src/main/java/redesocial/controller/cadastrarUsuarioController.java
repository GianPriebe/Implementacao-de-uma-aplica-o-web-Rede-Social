package redesocial.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redesocial.model.Usuario;

/**
 * Servlet implementation class cadastrarUsuarioController
 */
@WebServlet("/cadastrarUsuarioController")
public class cadastrarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String mensagem = null;
		String usuarioCheck = new Usuario().CheckExistsUser(email);
		System.out.println(usuarioCheck);
		if (nome != null && !nome.isEmpty()
				&& email != null && !email.isEmpty()
				&& senha != null && !senha.isEmpty()) {
			
			if (usuarioCheck != null) {
				mensagem = "Email ja cadastrado!";
			} else {
				Usuario usuario = new Usuario(nome, email, senha);
				usuario.Salvar();
				mensagem = "Usuario cadastrado!";
			}
		} else {
			mensagem = "Todos os campos precisam ser preenchidos!";
		}
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarUsuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
