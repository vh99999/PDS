package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField tfNome;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JTextField tfCPF;
	private JButton btnCadastro;
	private JRadioButton rdbtnNewRadioButton;

	public TelaCadastroUsuario() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("fill, insets 5",
				"[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]",
				"[20][34.00][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));

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

		rdbtnNewRadioButton = new JRadioButton("Administrador?");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnNewRadioButton, "cell 6 8,grow");

		btnCadastro = new JButton("Cadastrar");
		add(btnCadastro, "cell 6 10,grow");

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = getHeight();
				int fontSize = Math.max(15, panelHeight / 33);
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfNome.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				tfCPF.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				lblCPF.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
				btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
			}
		});
	}

	public void cadastro(ActionListener actionListener) {
		this.btnCadastro.addActionListener(actionListener);
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

	public JButton getBtnCadastro() {
		return btnCadastro;
	}

	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}
}