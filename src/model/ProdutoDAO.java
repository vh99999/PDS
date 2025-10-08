package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProdutoDAO {

	static String url = "jdbc:mysql://localhost:3306/Supermercado_BD";
	static String Usuario = "root";
	static String Senha = "root";

	public void cadastrarProduto(Produto p) {
		if (p.getNome() == null || p.getNome().isEmpty() || p.getPreco() == null) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);

			String sql = "INSERT INTO Produtos (Nome, preco, descricao, quantidade) VALUES (?, ?, ?, ?)";
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, p.getNome());
			stmt.setBigDecimal(2, p.getPreco());
			stmt.setString(3, p.getDesc());
			stmt.setInt(4, p.getQuantidade());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso!",
					JOptionPane.PLAIN_MESSAGE);

			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Produto> listarProdutos() {
		List<Produto> lista = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);

			String sql = "SELECT * FROM Produtos WHERE quantidade > 0";
			var stmt = conn.prepareStatement(sql);
			var rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getString("Nome"), rs.getBigDecimal("preco"), rs.getString("descricao"),
						rs.getInt("quantidade"));
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

	public void atualizarProduto(String nomeOriginal, Produto p) {
		if (p.getNome() == null || p.getNome().isEmpty() || p.getPreco() == null) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);

			String sql = "UPDATE Produtos SET Nome = ?, preco = ?, descricao = ?, quantidade = ? WHERE Nome = ?";
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, p.getNome());
			stmt.setBigDecimal(2, p.getPreco());
			stmt.setString(3, p.getDesc());
			stmt.setInt(4, p.getQuantidade());
			stmt.setString(5, nomeOriginal);

			int linhas = stmt.executeUpdate();
			if (linhas > 0) {
				JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Sucesso!",
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado para atualizar.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

			stmt.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void atualizarQuantidade(String nome, int novaQuantidade) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, Usuario, Senha);
			if (novaQuantidade > 0) {
				String sql = "UPDATE Produtos SET quantidade = ? WHERE Nome = ?";
				var stmt = conn.prepareStatement(sql);
				stmt.setInt(1, novaQuantidade);
				stmt.setString(2, nome);
				stmt.executeUpdate();
				stmt.close();
			} else {
				String sql = "DELETE FROM Produtos WHERE Nome = ?";
				var stmt = conn.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.executeUpdate();
				stmt.close();
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}