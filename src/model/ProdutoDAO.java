package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutoDAO {

	static String url = "jdbc:mysql://localhost:3306/Supermercado_BD";
	static String Usuario = "root";
	static String Senha = "root";

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
				
				stmt.setString(3, u.getDesc());

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
	
	public Usuario getProduto(String nome, String CPF) {
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
	
	public List<Produto> listarProdutos() {
	    List<Produto> lista = new ArrayList<>();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, Usuario, Senha);

	        String sql = "SELECT * FROM Produtos";
	        var stmt = conn.prepareStatement(sql);
	        var rs = stmt.executeQuery();

	        while (rs.next()) {
	            Produto p = new Produto(
	                rs.getString("Nome"),
	                rs.getBigDecimal("preco").toString(),
	                rs.getString("descricao")
	            );
	            lista.add(p);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return lista;
	}
	
	public void removerProduto(String nome) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, Usuario, Senha);

	        String sql = "DELETE FROM Produtos WHERE Nome = ?";
	        var stmt = conn.prepareStatement(sql);
	        stmt.setString(1, nome);

	        int linhas = stmt.executeUpdate();
	        if (linhas > 0) {
	        	JOptionPane.showMessageDialog(null, "Produto removido: " + nome);
	        }

	        stmt.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public List<Produto> listarProdutosCompra() {
	    List<Produto> lista = new ArrayList<>();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(url, Usuario, Senha);

	        String sql = "SELECT * FROM Produtos";
	        var stmt = conn.prepareStatement(sql);
	        var rs = stmt.executeQuery();

	        while (rs.next()) {
	            Produto p = new Produto(
	                rs.getString("Nome"),
	                String.valueOf(rs.getDouble("preco")),
	                rs.getString("descricao")
	            );
	            lista.add(p);
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return lista;
	}






}
