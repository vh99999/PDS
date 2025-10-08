package model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class UsuarioDAO {

	static String url = "jdbc:mysql://localhost:3306/Supermercado_BD";
	static String Usuario = "root";
	static String Senha = "root";

	public boolean cadastrar(Usuario u) {
		if (u.getUsuario().isEmpty() || u.getCpfCnpj().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);

			String sql = "INSERT INTO Login (Nome, CPF_CNPJ, idAdmin) VALUES (?, ?, ?)";
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getCpfCnpj());
			stmt.setBoolean(3, u.isAdmin());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso!",
					JOptionPane.PLAIN_MESSAGE);

			stmt.close();
			conn.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Usuario login(String nome, String cpfCnpj) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);

			String sql = "SELECT * FROM Login WHERE Nome = ? AND CPF_CNPJ = ?";
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, cpfCnpj);

			var rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario(rs.getString("Nome"), rs.getString("CPF_CNPJ"), rs.getBoolean("idAdmin"));
				rs.close();
				stmt.close();
				conn.close();
				return u;
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Usuario não encontrado");
		return null;
	}
}