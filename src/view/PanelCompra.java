package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;

import model.Produto;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PanelCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<Produto> listaModel;
	private JList<Produto> listaProdutos;
	private JList<Produto> listaProdutos2;
	private JScrollPane scrollProduto;
	private JScrollPane scrollCarrinho;
	
	/**
	 * Create the panel.
	 */
	public PanelCompra() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("", "[grow][][][][][grow][][][][][][][][][][][][][][grow]", "[grow][][][][][][][][][][][][][][][][][][grow]"));
		
		listaModel = new DefaultListModel<>();
        listaProdutos = new JList<>(listaModel);
        listaProdutos2 = new JList<>(listaModel);
		
		scrollProduto = new JScrollPane(listaProdutos);
		add(scrollProduto, "cell 1 2 5 14,grow");
		
		scrollCarrinho = new JScrollPane(listaProdutos2);
		add(scrollCarrinho, "cell 14 2 5 14,grow");
		
		JButton btnCarrinho = new JButton("Adicionar ao Carrinho");
		add(btnCarrinho, "cell 6 7 8 1,grow");
		
		


	}

}
