package controller;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import view.PanelCadastro;

public class CadastroController {

	private final PanelCadastro view;
	private final ProdutoDAO model;
	private final Navegador navegador;
	private String nomeOriginalSelecionado = null;

	public CadastroController(PanelCadastro view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		atualizarLista();

		this.view.getListaProdutos().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Produto selecionado = view.getListaProdutos().getSelectedValue();
				if (selecionado != null) {
					nomeOriginalSelecionado = selecionado.getNome();
				} else {
					nomeOriginalSelecionado = null;
				}
			}
		});

		this.view.cadastrar(e -> {
			String nome = view.getTfNome().getText();
			String precoStr = view.getTfPreco().getText();
			String desc = view.getTfDesc().getText();
			String quantidadeStr = view.getTfQuantidade().getText();

			if (nome.trim().isEmpty() || precoStr.trim().isEmpty() || desc.trim().isEmpty()
					|| quantidadeStr.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {
				BigDecimal preco = new BigDecimal(precoStr.replace(",", "."));
				int quantidade = Integer.parseInt(quantidadeStr);
				Produto p = new Produto(nome, preco, desc, quantidade);
				if (nomeOriginalSelecionado != null) {
					model.atualizarProduto(nomeOriginalSelecionado, p);
					nomeOriginalSelecionado = null;
				} else {
					model.cadastrarProduto(p);
				}
				view.getTfNome().setText("");
				view.getTfPreco().setText("");
				view.getTfDesc().setText("");
				view.getTfQuantidade().setText("");
				atualizarLista();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Preço ou quantidade inválidos. Use apenas números (ex: 10.99)",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		this.view.remover(e -> removerProduto());

		this.view.sair(e -> {
			navegador.setUsuarioAtual(null);
			navegador.navegarPara("LOGIN");
		});
	}

	private void atualizarLista() {
		view.getListModel().clear();
		List<Produto> produtos = model.listarProdutos();
		for (Produto p : produtos) {
			view.getListModel().addElement(p);
		}
	}

	private void removerProduto() {
		Produto selecionado = view.getListaProdutos().getSelectedValue();
		if (selecionado != null) {
			model.removerProduto(selecionado.getNome());
			view.getTfNome().setText("");
			view.getTfPreco().setText("");
			view.getTfDesc().setText("");
			nomeOriginalSelecionado = null;
			atualizarLista();
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
		}
	}
}