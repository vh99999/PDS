package main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ProdutoDAO {

	static String url = "jdbc:mysql://localhost:3306/Supermercado_BD";
	static String Usuario = "root";
	static String Senha = "admin";

	public void cadastrarProduto(Produto u) {

		if (u.getNome().isEmpty() || u.getPreco().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);

		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, Usuario, Senha);

				String sql = "INSERT INTO Produtos (Nome, preco, descricao) VALUES (?, ?, ?)";
				var stmt = conn.prepareStatement(sql);

				stmt.setString(1, u.getNome());
				
				try {
					BigDecimal preco = new BigDecimal(u.getPreco().replace(",", ".")); 
																						
					stmt.setBigDecimal(2, preco);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Preço inválido. Use apenas números (ex: 10.99)", "Erro",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				stmt.setString(3, u.getDesc()); // contratado

				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso!",
						JOptionPane.PLAIN_MESSAGE);
				

				stmt.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public Usuario getProdutos(String nome, String CPF) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, Usuario, Senha);

	        String sql = "SELECT * FROM Login WHERE Nome = ? AND CPF = ?";
	        var stmt = conn.prepareStatement(sql);

	        stmt.setString(1, nome);
	        stmt.setString(2, CPF);

	        var rs = stmt.executeQuery();

	        if (rs.next()) {
	            Usuario u = new Usuario(
	                rs.getString("Nome"),
	                rs.getString("CPF"),
	                rs.getBoolean("idAdmin")
	            );
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
	    return null;
	}

}
