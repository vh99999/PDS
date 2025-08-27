package main;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	
	private PanelLogin panelLogin;
	private PanelCadastro panelCadastro;
	private PanelCompra panelCompra;


	public static final String LOGIN_PANEL = "Login";
	public static final String CAD_PANEL = "Cadastro";
	public static final String COMP_PANEL = "Compra";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		cardLayout = new CardLayout();

		contentPane = new JPanel(cardLayout);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		panelLogin = new PanelLogin(this);
		panelCadastro = new PanelCadastro(this);
		panelCompra = new PanelCompra(this);

		contentPane.add(panelLogin, LOGIN_PANEL);
		contentPane.add(panelCadastro, CAD_PANEL);
		contentPane.add(panelCompra, COMP_PANEL);;

		setContentPane(contentPane);

		mostrarTela(LOGIN_PANEL);
	}
	
	public void mostrarTela(String panelName) {
		cardLayout.show(contentPane, panelName);
	}

}
