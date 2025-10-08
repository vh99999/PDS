package main;

import javax.swing.UIManager;

import controller.CadastroController;
import controller.CadastroUsuarioController;
import controller.CompraController;
import controller.LoginController;
import controller.Navegador;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.Frame;
import view.PanelCadastro;
import view.PanelCompra;
import view.PanelLogin;
import view.TelaCadastroUsuario;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf());
		} catch (Exception ex) {
			System.err.println("Falha ao carregar o tema FlatLaf");
		}

		Frame frame = new Frame();
		PanelCompra panelCompra = new PanelCompra();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Navegador navegador = new Navegador(frame, null);

		CompraController compraController = new CompraController(panelCompra, produtoDAO, navegador);
		navegador.setCompraController(compraController);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PanelCadastro panelCadastro = new PanelCadastro();
		new CadastroController(panelCadastro, produtoDAO, navegador);
		PanelLogin panelLogin = new PanelLogin();
		new LoginController(panelLogin, usuarioDAO, navegador);
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		new CadastroUsuarioController(telaCadastroUsuario, usuarioDAO, navegador);

		navegador.adicionarPainel("CADASTRO", panelCadastro);
		navegador.adicionarPainel("LOGIN", panelLogin);
		navegador.adicionarPainel("TELACADASTROUSUARIO", telaCadastroUsuario);
		navegador.adicionarPainel("COMPRA", panelCompra);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		navegador.navegarPara("LOGIN");
	}
}