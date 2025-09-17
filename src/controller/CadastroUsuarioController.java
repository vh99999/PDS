package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;

public class CadastroUsuarioController {
	
	private final TelaCadastroUsuario view;
	private final UsuarioDAO model;
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastro).
	 * @param model Referência ao modelo de dados (CandidatoDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroUsuarioController(TelaCadastroUsuario view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		
		this.view.cadastro(e -> {
			
			String usuario = view.getTfNome().getText();
		    String cpf = view.getTfCPF().getText();
			
			UsuarioDAO dao = new UsuarioDAO();
			Usuario u = new Usuario(usuario, cpf, view.getRdbtnNewRadioButton().isSelected());

			dao.cadastrar(u);
			
			view.getTfCPF().setText("");
			view.getTfNome().setText("");
			// prim.mostrarTela(prim.TRABALHOS_PANEL);
			
		});
		
		
		
		
		
		
	}

}
