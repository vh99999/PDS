package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario(Frame f) {
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
		
		rdbtnNewRadioButton = new JRadioButton("Administrador?");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		add(rdbtnNewRadioButton, "cell 6 8,grow");
		
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    String usuario = tfNome.getText();
			    String cpf = tfCPF.getText();
				
				UsuarioDAO dao = new UsuarioDAO();
				Usuario u = new Usuario(usuario, cpf, rdbtnNewRadioButton.isSelected());

				dao.cadastrar(u);
				
				tfCPF.setText("");
				tfNome.setText("");
				// prim.mostrarTela(prim.TRABALHOS_PANEL);
			}
		});
		add(btnCadastro, "cell 6 10,grow");
		
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
				btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
			}
		});

	}

}
