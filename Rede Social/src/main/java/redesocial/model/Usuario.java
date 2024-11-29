package redesocial.model;

import java.util.ArrayList;

import redesocial.dao.UserDao;

public class Usuario {

	private String nome;
	private String email;
	private String password;

	public Usuario(String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void Salvar() {
		new UserDao().cadastrarUser(this);
	}
	
	public String CheckExistsUser(String email) {
		return new UserDao().checkExistsUser(email);
	}
	
	public Usuario BuscarUsuario(String email, String senha) {
		return new UserDao().buscarUsuario(email, senha);
	}
}
