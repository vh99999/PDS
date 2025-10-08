package model;

public class Usuario {

	private String usuario;
	private String cpfCnpj;
	private boolean admin;

	public Usuario(String usuario, String cpfCnpj, boolean admin) {
		this.usuario = usuario;
		this.cpfCnpj = cpfCnpj;
		this.admin = admin;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}