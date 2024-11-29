package redesocial.controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redesocial.dao.MySqlConnection;
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
				try {
					LogadoTrueSQL(email);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Runtime.getRuntime().exec("cmd /c "+ "\"cd C:\\Users\\Giammnn\\git\\repository\\Rede Social\\src\\main\\webapp\\ && executarJs.bat\"");
				Esperar(response);
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
	
	

	private void Esperar(HttpServletResponse response) throws IOException {
		System.out.println("Esperando por 5 segundos...");
	        
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					response.sendRedirect("http://localhost:8081");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Tempo de espera concluído!");
				timer.cancel();
			}
		}, 1000); // Espera por 5000 milissegundos (5 segundos)
	}

	
	private void LogadoTrueSQL(String email) throws SQLException {
		String sql = "UPDATE usuarios SET logado='0';";
		String sql2 = "UPDATE usuarios SET logado='1' WHERE email=\'"+email+"\';";
		Connection conn = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement2 = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.execute();
			pStatement2 = conn.prepareStatement(sql2);
			pStatement2.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
