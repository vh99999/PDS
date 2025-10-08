package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	public Frame() {
		setTitle("Supermercado");
		setPreferredSize(new Dimension(900, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.cardLayout = new CardLayout();

		this.contentPane = new JPanel(this.cardLayout);
		this.contentPane.setPreferredSize(new Dimension(600, 675));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
	}

	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
	}

	public void mostrarTela(String nome) {
		this.cardLayout.show(this.contentPane, nome);
		this.pack();
	}
}