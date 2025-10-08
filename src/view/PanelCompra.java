package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.ItemCarrinho;
import model.Produto;
import net.miginfocom.swing.MigLayout;

public class PanelCompra extends JPanel {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<Produto> estoqueModel;
	private DefaultListModel<ItemCarrinho> carrinhoModel;

	private JList<Produto> listaEstoque;
	private JList<ItemCarrinho> listaCarrinho;

	JButton btnRemover;
	JButton btnAdicionar;
	private JButton btnFinalizar;
	private JLabel lblTotal;
	private JButton btnSair;

	public PanelCompra() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);

		setLayout(new MigLayout("fill, insets 5",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));

		carrinhoModel = new DefaultListModel<>();

		btnSair = new JButton("Log out");
		add(btnSair, "cell 6 0,growx");
		listaCarrinho = new JList<>(carrinhoModel);
		JScrollPane scrollCarrinho = new JScrollPane(listaCarrinho);
		add(scrollCarrinho, "cell 1 2 4 11,grow");

		estoqueModel = new DefaultListModel<>();
		listaEstoque = new JList<>(estoqueModel);
		JScrollPane scrollEstoque = new JScrollPane(listaEstoque);
		add(scrollEstoque, "cell 8 2 4 11,grow");

		btnAdicionar = new JButton("Adicionar ao Carrinho");
		add(btnAdicionar, "cell 5 6 3 1,grow");

		btnRemover = new JButton("Remover do Carrinho");
		add(btnRemover, "cell 5 8 3 1,grow");

		btnFinalizar = new JButton("Finalizar Compra");
		add(btnFinalizar, "cell 5 10 3 1,grow");

		lblTotal = new JLabel("Total: R$0.00");
		add(lblTotal, "cell 2 13,grow");

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
				int fontSizeLista = Math.max(15, panelHeight / 40);
				Font font = new Font("Tahoma", Font.PLAIN, fontSizeLista);
				lblTotal.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnRemover.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				listaCarrinho.setFont(font);
				listaEstoque.setFont(font);
			}
		});
	}

	public void adicionar(ActionListener actionListener) {
		this.btnAdicionar.addActionListener(actionListener);
	}

	public void remover(ActionListener actionListener) {
		this.btnRemover.addActionListener(actionListener);
	}

	public void finalizarCompra(ActionListener actionListener) {
		this.btnFinalizar.addActionListener(actionListener);
	}

	public void sair(ActionListener actionListener) {
		this.btnSair.addActionListener(actionListener);
	}

	public DefaultListModel<Produto> getEstoqueModel() {
		return estoqueModel;
	}

	public DefaultListModel<ItemCarrinho> getCarrinhoModel() {
		return carrinhoModel;
	}

	public JList<Produto> getListaEstoque() {
		return listaEstoque;
	}

	public JList<ItemCarrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void atualizarTotal() {
		double total = 0.0;
		for (int i = 0; i < carrinhoModel.size(); i++) {
			ItemCarrinho item = carrinhoModel.getElementAt(i);
			total += item.getProduto().getPreco().doubleValue() * item.getQuantidadeComprada();
		}
		lblTotal.setText(String.format("Total: R$%.2f", total));
	}
}