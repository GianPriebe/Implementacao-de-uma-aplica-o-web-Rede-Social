package redesocial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import redesocial.model.Usuario;

public class UserDao {
	
	public String checkExistsUser(String email) {
		String sql2 = "SELECT CASE WHEN EXISTS (SELECT * FROM usuarios WHERE email = \'"+email+"\') THEN \'"+email+"\' ELSE NULL END AS email;";
		PreparedStatement pStatement2 = null;
		Usuario usuario1 = null;
		ResultSet rs = null;
		Connection conn = null;
		String checar = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement2 = conn.prepareStatement(sql2);
			rs = pStatement2.executeQuery();
			usuario1 = new Usuario();
			if (rs.next()) {
				checar = rs.getString("email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement2 != null)
					pStatement2.close();
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
		return checar;
	}
	
	public void cadastrarUser(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, email, _password, logado) VALUES (?,?,?, false);";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, usuario.getNome());
			pStatement.setString(2, usuario.getEmail());
			pStatement.setString(3, usuario.getPassword());
			pStatement.execute();
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

	public Usuario buscarUsuario(String email, String senha) {
		String sql = "SELECT * FROM usuarios WHERE email = \'"+email+"\' AND _password = \'"+senha+"\';";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Usuario usuario = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("_password"));
				}
			}
			
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
		return usuario;
	}
}