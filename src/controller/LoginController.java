package controller;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.PanelLogin;

public class LoginController {

	private final PanelLogin view;
	private final UsuarioDAO usuarioDAO;
	private final Navegador navegador;

	public LoginController(PanelLogin view, UsuarioDAO usuarioDAO, Navegador navegador) {
		this.view = view;
		this.usuarioDAO = usuarioDAO;
		this.navegador = navegador;

		this.view.login(e -> {
			String nome = view.getTfNome().getText();
			String cpf = view.getTfCPF().getText();

			if (nome.trim().isEmpty() || cpf.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
				view.getTfCPF().setText("");
				view.getTfNome().setText("");
				return;
			}

			Usuario u = usuarioDAO.login(nome, cpf);
			if (u != null) {
				navegador.setUsuarioAtual(u);
				if (u.isAdmin()) {
					navegador.navegarPara("CADASTRO");
				} else {
					navegador.navegarPara("COMPRA");
				}
			}
			view.getTfNome().setText("");
			view.getTfCPF().setText("");
		});

		this.view.cadastro(e -> navegador.navegarPara("TELACADASTROUSUARIO"));
	}
}