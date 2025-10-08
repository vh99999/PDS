package controller;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import model.ItemCarrinho;
import model.Produto;
import model.ProdutoDAO;
import view.PanelCompra;

public class CompraController {

	private final PanelCompra view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	public CompraController(PanelCompra view, ProdutoDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		atualizarListas();

		this.view.adicionar(e -> {
			Produto selecionado = view.getListaEstoque().getSelectedValue();
			if (selecionado != null) {
				String qtdStr = JOptionPane.showInputDialog("Quantidade a comprar de " + selecionado.getNome()
						+ " (em estoque: " + selecionado.getQuantidade() + "):");
				if (qtdStr != null) {
					try {
						int qtd = Integer.parseInt(qtdStr);
						if (qtd <= 0) {
							JOptionPane.showMessageDialog(null, "Quantidade deve ser maior que zero.");
							return;
						}
						if (qtd > selecionado.getQuantidade()) {
							JOptionPane.showMessageDialog(null, "Quantidade maior que o estoque disponível.");
							return;
						}
						boolean found = false;
						for (int i = 0; i < view.getCarrinhoModel().size(); i++) {
							ItemCarrinho item = view.getCarrinhoModel().getElementAt(i);
							if (item.getProduto().getNome().equals(selecionado.getNome())) {
								int novaQtd = item.getQuantidadeComprada() + qtd;
								if (novaQtd > selecionado.getQuantidade()) {
									JOptionPane.showMessageDialog(null,
											"Quantidade total no carrinho maior que o estoque disponível.");
									return;
								}
								item.setQuantidadeComprada(novaQtd);
								view.getCarrinhoModel().setElementAt(item, i);
								found = true;
								break;
							}
						}
						if (!found) {
							view.getCarrinhoModel().addElement(new ItemCarrinho(selecionado, qtd));
						}
						atualizarTotal();
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Quantidade inválida.");
					}
				}
			}
		});

		this.view.remover(e -> {
			ItemCarrinho selecionado = view.getListaCarrinho().getSelectedValue();
			if (selecionado != null) {
				view.getCarrinhoModel().removeElement(selecionado);
				atualizarTotal();
			}
		});

		this.view.finalizarCompra(e -> finalizarCompra());

		this.view.sair(e -> {
			navegador.setUsuarioAtual(null);
			navegador.navegarPara("LOGIN");
		});
	}

	public void atualizarListas() {
		view.getEstoqueModel().clear();
		view.getCarrinhoModel().clear();
		List<Produto> produtos = model.listarProdutos();
		for (Produto p : produtos) {
			view.getEstoqueModel().addElement(p);
		}
		atualizarTotal();
	}

	private void atualizarTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (int i = 0; i < view.getCarrinhoModel().getSize(); i++) {
			ItemCarrinho item = view.getCarrinhoModel().getElementAt(i);
			total = total.add(item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidadeComprada())));
		}
		view.getLblTotal().setText("Total: R$" + total.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
	}

	private void finalizarCompra() {
		boolean erroEstoque = false;
		for (int i = 0; i < view.getCarrinhoModel().getSize(); i++) {
			ItemCarrinho item = view.getCarrinhoModel().getElementAt(i);
			Produto estoque = null;
			for (int j = 0; j < view.getEstoqueModel().getSize(); j++) {
				Produto p = view.getEstoqueModel().getElementAt(j);
				if (p.getNome().equals(item.getProduto().getNome())) {
					estoque = p;
					break;
				}
			}
			if (estoque != null && estoque.getQuantidade() >= item.getQuantidadeComprada()) {
				int novaQuantidade = estoque.getQuantidade() - item.getQuantidadeComprada();
				model.atualizarQuantidade(estoque.getNome(), novaQuantidade);
			} else {
				erroEstoque = true;
			}
		}
		if (erroEstoque) {
			javax.swing.JOptionPane.showMessageDialog(null, "Estoque insuficiente para um ou mais produtos.");
		} else {
			mostrarNotaFiscalComSucesso();
			view.getCarrinhoModel().clear();
			atualizarListas();
		}
	}

	private void mostrarNotaFiscalComSucesso() {
		model.Usuario usuario = navegador.getUsuarioAtual();
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado para emissão da nota fiscal.");
			return;
		}
		StringBuilder nota = new StringBuilder();
		nota.append("--- NOTA FISCAL ---\n");
		nota.append("Nome: ").append(usuario.getUsuario()).append("\n");
		nota.append("CPF: ").append(usuario.getCpfCnpj()).append("\n\n");
		nota.append("Produtos comprados:\n");
		BigDecimal total = BigDecimal.ZERO;
		for (int i = 0; i < view.getCarrinhoModel().getSize(); i++) {
			model.ItemCarrinho item = view.getCarrinhoModel().getElementAt(i);
			nota.append("- ").append(item.getProduto().getNome()).append(" | Qtd: ")
					.append(item.getQuantidadeComprada()).append(" | Unitário: R$")
					.append(item.getProduto().getPreco().setScale(2)).append(" | Subtotal: R$").append(item.getProduto()
							.getPreco().multiply(BigDecimal.valueOf(item.getQuantidadeComprada())).setScale(2))
					.append("\n");
			total = total.add(item.getProduto().getPreco().multiply(BigDecimal.valueOf(item.getQuantidadeComprada())));
		}
		nota.append("\nTotal pago: R$").append(total.setScale(2)).append("\n-------------------\n");
		nota.append("\nCompra realizada com sucesso!");
		JOptionPane.showMessageDialog(null, nota.toString(), "Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
	}
}