package controller;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.PanelCadastro;;

public class CadastroController {

	private final PanelCadastro view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	/**
	 * 
	 * 
	 * @param view
	 * @param model
	 * @param navegador
	 */
	public CadastroController(PanelCadastro view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		atualizarLista();

		this.view.cadastrar(e -> {

			String nome = view.getTfNome().getText();
			String preco = view.getTfPreco().getText();
			String Desc = view.getTfDesc().getText();

			Produto u = new Produto(nome, preco, Desc);

			if (nome.trim().equals("") || preco.trim().equals("") || Desc.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {

				view.getTfNome().setText("");
				view.getTfPreco().setText("");
				view.getTfDesc().setText("");

				model.cadastrarProduto(u);
				atualizarLista();
			}

		});

		this.view.remover(e -> {

			removerProduto();

		});

	}

	private void atualizarLista() {
		view.listModel.clear();
		List<Produto> produtos = model.listarProdutos();
		for (Produto p : produtos) {
			view.listModel.addElement(p.toString());
		}
	}

	private void removerProduto() {
		String selecionado = view.listaProdutos.getSelectedValue();
		if (selecionado != null) {
			String nome = selecionado.split(" - ")[0];
			model.removerProduto(nome);
			atualizarLista();
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
		}
	}

}
