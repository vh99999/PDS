package controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;
import view.PanelCompra;

public class CompraController {

	private final PanelCompra view;
	private final ProdutoDAO model;
	private final Navegador navegador;

	/**
	 * 
	 * 
	 * @param view
	 * @param model
	 * @param navegador
	 */
	public CompraController(PanelCompra view, ProdutoDAO model, Navegador navegador) {
	    this.view = view;
	    this.model = model;
	    this.navegador = navegador;

	    atualizarListas();

	    this.view.adicionar(e -> {
	        String selecionado = view.listaEstoque.getSelectedValue();
	        if (selecionado != null) {
	            view.getCarrinhoModel().addElement(selecionado);
	            atualizarTotal();

	        }
	    });

	    this.view.remover(e -> {
	        String selecionado = view.listaCarrinho.getSelectedValue();
	        if (selecionado != null) {
	            view.getCarrinhoModel().removeElement(selecionado);
	            atualizarTotal();
	        }
	    });
	}

	private void atualizarListas() {
	    view.getEstoqueModel().clear();
	    view.getCarrinhoModel().clear();

	    List<Produto> produtos = model.listarProdutos();
	    for (Produto p : produtos) {
	        view.getEstoqueModel().addElement(p.toString());
	    }
	}
	
	private void atualizarTotal() {
	    double total = 0.0;
	    for (int i = 0; i < view.getCarrinhoModel().getSize(); i++) {
	        String item = view.getCarrinhoModel().getElementAt(i);
	        try {
	            String precoStr = item.split("R\\$")[1].split(" ")[0].replace(",", ".");
	            total += Double.parseDouble(precoStr);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    view.getLblTotal().setText(String.format("Total: R$%.2f", total));
	}

}
