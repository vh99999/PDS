package controller;


import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.PanelCadastro;
;

public class CadastroController {
	
	private final PanelCadastro view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastro).
	 * @param model Referência ao modelo de dados (CandidatoDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroController(PanelCadastro view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;
		
		this.view.cadastrar(e -> {
			
			String nome = view.getTfNome().getText();
		    String preco = view.getTfPreco().getText();
		    String Desc = view.getTfDesc().getText();
			
			Produto u = new Produto(nome, preco, Desc);
			
			view.getTfNome().setText("");
		    view.getTfPreco().setText("");
		    view.getTfDesc().setText("");
			
			model.cadastrarProduto(u);
			
		});
		
		
		
		
		
		
		
	}

}
