package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatClientProperties;

import net.miginfocom.swing.MigLayout;

public class PanelCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfDesc;
	private JButton btnCadastro;

	/**
	 * Create the panel.
	 */
	public PanelCadastro() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("", "[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]", "[20][34.00,grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1 3 11,grow");
		panel.setLayout(new MigLayout("", "[10px][grow][grow][grow][grow][grow][10px]", "[grow][][grow][][grow][][grow]"));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		tfNome = new JTextField();
		panel.add(tfNome, "cell 0 1 7 1,growx");
		tfNome.setColumns(10);
		tfNome.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "NOME DO PRODUTO");
		
		tfPreco = new JTextField();
		panel.add(tfPreco, "cell 0 3 7 1,grow");
		tfPreco.setColumns(10);
		tfPreco.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PREÇO DO PRODUTO");
		
		tfDesc = new JTextField();
		panel.add(tfDesc, "cell 0 5 7 2,grow");
		tfDesc.setColumns(10);
		tfDesc.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "DESCRIÇÃO DO PRODUTO");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 7 1 5 11,grow");
		
		
		btnCadastro = new JButton("Cadastrar Produto\r\n");
		add(btnCadastro, "cell 4 10 3 1,growx");
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
				int fontSize2 = Math.max(15, panelHeight / 40);
				tfNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfDesc.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfPreco.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
			}
		});
		

	}
	
	public void cadastrar(ActionListener actionListener) {
		this.btnCadastro.addActionListener(actionListener);
	}
	
	
	
}
