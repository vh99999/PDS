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

import com.formdev.flatlaf.FlatClientProperties;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class PanelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfDesc;
	private JButton btnCadastro;
	public DefaultListModel<String> listModel;
	public JList<String> listaProdutos;
	private JButton btnRemover;

	/**
	 * Create the panel.
	 */
	public PanelCadastro() {
		setPreferredSize(new Dimension(700, 400));

		setLayout(new MigLayout("", "[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]",
				"[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));

		JPanel panel = new JPanel();
		add(panel, "cell 1 1 3 11, grow, push");
		panel.setLayout(
				new MigLayout("", "[10px][grow][grow][grow][grow][grow][10px]", "[grow][][grow][][grow][][grow]"));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		tfNome = new JTextField();
		panel.add(tfNome, "cell 0 1 7 1, growx, push");
		tfNome.setColumns(10);
		tfNome.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "NOME DO PRODUTO");
		tfNome.putClientProperty("JComponent.roundRect", true);

		tfPreco = new JTextField();
		panel.add(tfPreco, "cell 0 3 7 1, growx, push");
		tfPreco.setColumns(10);
		tfPreco.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PREÇO DO PRODUTO");
		tfPreco.putClientProperty("JComponent.roundRect", true);

		tfDesc = new JTextField();
		tfDesc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfDesc, "cell 0 5 7 2, growx, push");
		tfDesc.setColumns(10);
		tfDesc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIÇÃO");
		tfDesc.putClientProperty("JComponent.roundRect", true);

		listModel = new DefaultListModel<>();
		listaProdutos = new JList<>(listModel);
		JScrollPane scroll = new JScrollPane(listaProdutos);
		add(scroll, "cell 9 1 3 11, grow, push");

		btnCadastro = new JButton("Cadastrar Produto");
		add(btnCadastro, "cell 6 5,push,grow");

		btnRemover = new JButton("Remover produto");
		add(btnRemover, "cell 6 7,grow, push");
		btnCadastro.putClientProperty("JComponent.roundRect", true);

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
			}
		});
	}

	public void cadastrar(ActionListener actionListener) {
		this.btnCadastro.addActionListener(actionListener);
	}

	public void remover(ActionListener actionListener) {
		this.btnRemover.addActionListener(actionListener);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JTextField getTfPreco() {
		return tfPreco;
	}

	public void setTfPreco(JTextField tfPreco) {
		this.tfPreco = tfPreco;
	}

	public JTextField getTfDesc() {
		return tfDesc;
	}

	public void setTfDesc(JTextField tfDesc) {
		this.tfDesc = tfDesc;
	}
}