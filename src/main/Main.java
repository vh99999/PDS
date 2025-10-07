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
		Navegador navegador = new Navegador(frame);
		ProdutoDAO produtodao = new ProdutoDAO();
		UsuarioDAO usuariodao = new UsuarioDAO();

		PanelCadastro panelcadastro = new PanelCadastro();
		CadastroController cadastrocontroller = new CadastroController(panelcadastro, produtodao, navegador);

		PanelLogin panellogin = new PanelLogin();
		LoginController logincontroller = new LoginController(panellogin, produtodao, navegador);

		TelaCadastroUsuario cadastrousuario = new TelaCadastroUsuario();
		CadastroUsuarioController cadastrousuariocontroller = new CadastroUsuarioController(cadastrousuario, usuariodao, navegador);
		
		PanelCompra panelcompra = new PanelCompra();
		CompraController compracontroller = new CompraController(panelcompra, produtodao, navegador);

		navegador.adicionarPainel("CADASTRO", panelcadastro);
		navegador.adicionarPainel("LOGIN", panellogin);
		navegador.adicionarPainel("TELACADASTROUSUARIO", cadastrousuario);
		navegador.adicionarPainel("COMPRA", panelcompra);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		navegador.navegarPara("LOGIN");

	}
}
