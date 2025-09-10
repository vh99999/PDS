package main;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfDesc;

	/**
	 * Create the panel.
	 */
	public PanelCadastro(Frame f) {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("", "[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]", "[20][34.00,grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1 3 11,grow");
		panel.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][10px]", "[grow][][grow][][grow][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Nome do produto:");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel, "cell 0 0 2 1,grow");
		
		tfNome = new JTextField();
		panel.add(tfNome, "cell 0 1 6 1,growx");
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço(ex: 10.99):");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_1, "cell 0 2 2 1,grow");
		
		tfPreco = new JTextField();
		panel.add(tfPreco, "cell 0 3 6 1,grow");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_2, "cell 0 4 2 1,grow");
		
		tfDesc = new JTextField();
		panel.add(tfDesc, "cell 0 5 6 2,grow");
		tfDesc.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 7 1 5 11,grow");
		
		
		JButton btnNewButton = new JButton("Cadastrar Produto\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDAO pDAO = new ProdutoDAO();
				String nome = tfNome.getText();
				String preco = tfPreco.getText();
				String desc = tfDesc.getText();
				
				Produto u = new Produto(nome, preco, desc);
				
				pDAO.cadastrarProduto(u);
				
				tfNome.setText("");
				tfPreco.setText("");
				tfDesc.setText("");
			}
		});
		add(btnNewButton, "cell 4 10 3 1,growx");


	}

}
