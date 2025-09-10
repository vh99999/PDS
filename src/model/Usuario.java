package model;

public class Usuario {
	private String usuario;
	private String cpfCnpj;
	private boolean admin;
	
	public Usuario(String usuario, String cpfCnpj, boolean admin) {
		super();
		this.usuario = usuario;
		this.cpfCnpj = cpfCnpj;
		this.admin = admin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	

}
