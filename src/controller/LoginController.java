package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.ProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;
import view.PanelLogin;

public class LoginController {

	private final PanelLogin view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * 
	 * @param view      Referência à tela que controla (TelaCadastro).
	 * @param model     Referência ao modelo de dados (CandidatoDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public LoginController(PanelLogin view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		this.view.login(e -> {
			String nome = view.getTfNome().getText();
			String CPF = view.getTfCPF().getText();

			model.UsuarioDAO dao = new model.UsuarioDAO();
			model.Usuario u = dao.login(nome, CPF);

			if (u != null) {
				if (u.isAdmin()) {
					navegador.navegarPara("CADASTRO");
				} else {
					navegador.navegarPara("COMPRA");
				}
			}
			view.getTfNome().setText("");
			view.getTfCPF().setText("");
		});
		
		
		this.view.cadastro(e -> {
			navegador.navegarPara("TELACADASTROUSUARIO");
		});
		

	}

}
