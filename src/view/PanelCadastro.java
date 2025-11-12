package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.formdev.flatlaf.FlatClientProperties;

import model.Produto;
import net.miginfocom.swing.MigLayout;

public class PanelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfDesc;
	private JButton btnCadastro;
	private JButton btnRemover;

	private DefaultListModel<Produto> listModel;
	private JList<Produto> listaProdutos;
	private JTextField TfQuantidade;
	private JButton btnSair;

	public PanelCadastro() {
		setPreferredSize(new Dimension(700, 400));
		setLayout(new MigLayout("fill, insets 15", "[grow][grow 20][grow]", "[grow][grow][grow][grow][grow]"));

		listModel = new DefaultListModel<>();

		JPanel Carrinho = new JPanel();
		add(Carrinho, "cell 0 1 1 3,push,grow");
		Carrinho.setLayout(new MigLayout("fill, insets 20 20 20 20", "[grow]", "[grow][grow][grow]"));
		Carrinho.setBorder(BorderFactory.createLineBorder(Color.black));

		tfNome = new JTextField();
		Carrinho.add(tfNome, "cell 0 0,push,growx");
		tfNome.setColumns(10);
		tfNome.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "NOME DO PRODUTO");
		tfNome.putClientProperty("JComponent.roundRect", true);

		tfPreco = new JTextField();
		Carrinho.add(tfPreco, "cell 0 1,push,growx");
		tfPreco.setColumns(10);
		tfPreco.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PREÇO DO PRODUTO");
		tfPreco.putClientProperty("JComponent.roundRect", true);

		TfQuantidade = new JTextField();
		Carrinho.add(TfQuantidade, "cell 0 2,growx");
		TfQuantidade.setColumns(10);
		TfQuantidade.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "QUANTIDADE");

		tfDesc = new JTextField();
		tfDesc.setHorizontalAlignment(SwingConstants.LEFT);
		Carrinho.add(tfDesc, "cell 0 3,push,growx");
		tfDesc.setColumns(10);
		tfDesc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIÇÃO");
		tfDesc.putClientProperty("JComponent.roundRect", true);

		btnSair = new JButton("Log out");
		add(btnSair, "cell 0 0 3 1,alignx center");

		JScrollPane scrollProdutosCadastrados = new JScrollPane();
		add(scrollProdutosCadastrados, "cell 2 1 1 3,push,grow");
		listaProdutos = new JList<>(listModel);
		scrollProdutosCadastrados.setViewportView(listaProdutos);

		btnCadastro = new JButton("Cadastrar Produto");
		add(btnCadastro, "flowy,cell 1 2,push,alignx center");
		btnCadastro.putClientProperty("JComponent.roundRect", true);

		btnRemover = new JButton("Remover produto");
		add(btnRemover, "cell 1 2,push,alignx center");

		listaProdutos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Produto selecionado = listaProdutos.getSelectedValue();
					if (selecionado != null) {
						tfNome.setText(selecionado.getNome());
						tfPreco.setText(String.valueOf(selecionado.getPreco()));
						tfDesc.setText(selecionado.getDesc());
						TfQuantidade.setText(String.valueOf(selecionado.getQuantidade()));
					}
				}
			}
		});

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
				tfNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfPreco.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfDesc.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnRemover.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				scrollProdutosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				TfQuantidade.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
			}
		});
	}

	public void cadastrar(ActionListener actionListener) {
		this.btnCadastro.addActionListener(actionListener);
	}

	public void remover(ActionListener actionListener) {
		this.btnRemover.addActionListener(actionListener);
	}

	public void sair(ActionListener actionListener) {
		this.btnSair.addActionListener(actionListener);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public JTextField getTfPreco() {
		return tfPreco;
	}

	public JTextField getTfQuantidade() {
		return TfQuantidade;
	}

	public void setTfQuantidade(JTextField tfQuantidade) {
		TfQuantidade = tfQuantidade;
	}

	public JTextField getTfDesc() {
		return tfDesc;
	}

	public DefaultListModel<Produto> getListModel() {
		return listModel;
	}

	public JList<Produto> getListaProdutos() {
		return listaProdutos;
	}
}