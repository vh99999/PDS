package controller;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuario;

public class CadastroUsuarioController {

	private final TelaCadastroUsuario view;
	private final UsuarioDAO model;
	private final Navegador navegador;

	public CadastroUsuarioController(TelaCadastroUsuario view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		this.view.cadastro(e -> {
			String usuario = view.getTfNome().getText();
			String cpf = view.getTfCPF().getText();
			boolean admin = view.getRdbtnNewRadioButton().isSelected();

			Usuario u = new Usuario(usuario, cpf, admin);

			view.getTfCPF().setText("");
			view.getTfNome().setText("");
			view.getRdbtnNewRadioButton().setSelected(false);

			if (model.cadastrar(u)) {
				navegador.navegarPara("LOGIN");
			}
		});
	}
}