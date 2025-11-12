package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;

public class PanelLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JTextField tfCPF;
	private JButton btnLogin;
	private JButton btnNewButton;

	public PanelLogin() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("fill, insets 50 20 20 20", "50[grow][grow][grow]50", "[grow 40][grow 30][grow 20]"));

		lblNome = new JLabel("Nome");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNome, "flowx,cell 1 0,grow");
		lblNome.putClientProperty("JComponent.roundRect", true);

		tfNome = new JTextField();
		add(tfNome, "cell 0 0 3 1,growx");
		tfNome.setColumns(10);

		lblCPF = new JLabel("CPF");
		lblCPF.setVerticalAlignment(SwingConstants.TOP);
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCPF, "flowy,cell 1 1,grow");
		lblCPF.putClientProperty("JComponent.roundRect", true);

		tfCPF = new JTextField();
		add(tfCPF, "cell 0 1 3 1,growx");
		tfCPF.setColumns(10);

		btnNewButton = new JButton("Cadastrar-se");
		add(btnNewButton, "flowy,cell 1 2,growx");

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnLogin, "cell 1 2,growx,aligny bottom");
		btnLogin.putClientProperty("JComponent.roundRect", true);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
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

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCPF() {
		return lblCPF;
	}

	public JTextField getTfCPF() {
		return tfCPF;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}
}