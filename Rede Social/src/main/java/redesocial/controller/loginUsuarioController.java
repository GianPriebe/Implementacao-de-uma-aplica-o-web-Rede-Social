package redesocial.controller;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/loginUsuarioController")
public class loginUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUsuarioController() {
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

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String mensagem;
		
		if (email != null && !email.isEmpty()
				&& senha != null && !senha.isEmpty()) {
			Usuario usuario = new Usuario().BuscarUsuario(email, senha);
			if (usuario != null) {
				System.out.println(usuario.getEmail());
				System.out.println(usuario.getPassword());
				response.sendRedirect("http://localhost:8081");
			} else {
				mensagem = "Usuario e/ou senha errado(s)";
				Mensagem(request, response, mensagem);
			}
		} else {
			mensagem = "Todos os campos precisam ser preenchidos!";
			Mensagem(request, response, mensagem);
		}
	}
	
	private void Mensagem(HttpServletRequest request, HttpServletResponse response, String mensagem) throws ServletException, IOException {
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginUsuario.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
