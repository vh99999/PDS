package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Navegador;
import net.miginfocom.swing.MigLayout;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JTextField tfCPF;
	private JButton btnLogin;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public PanelLogin() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("", "[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]", "[20][34.00][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNome, "cell 5 2 3 1,grow");
		
		tfNome = new JTextField();
		add(tfNome, "cell 4 3 5 1,grow");
		tfNome.setColumns(10);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCPF, "cell 5 4 3 1,grow");
		
		tfCPF = new JTextField();
		add(tfCPF, "cell 4 5 5 1,grow");
		tfCPF.setColumns(10);
		
		btnLogin = new JButton("Login");
		add(btnLogin, "cell 6 10,grow");
		
		btnNewButton = new JButton("Cadastrar-se");
		add(btnNewButton, "cell 6 11,grow");
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
				int fontSize2 = Math.max(15, panelHeight / 40);
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfCPF.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				lblCPF.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnLogin.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
			}
		});

	}
	
	public void login(ActionListener actionListener) {
		this.btnLogin.addActionListener(actionListener);
	}
	
	public void cadastro(ActionListener actionListener) {
		this.btnNewButton.addActionListener(actionListener);
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public void setTfNome(JTextField tfNome) {
		this.tfNome = tfNome;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public void setLblCPF(JLabel lblCPF) {
		this.lblCPF = lblCPF;
	}

	public JTextField getTfCPF() {
		return tfCPF;
	}

	public void setTfCPF(JTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
