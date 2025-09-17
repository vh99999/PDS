package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;

	/**
	 * Create the frame.
	 */
	public Frame() {
		setPreferredSize(new Dimension(700, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.cardLayout = new CardLayout();

		this.contentPane = new JPanel(this.cardLayout);
		this.contentPane.setPreferredSize(new Dimension(600, 675)); 
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
	}
	
	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
	}

	/**
	 * Método responsável por mostrar uma tela (painel) específica.
	 * @param nome Nome do painel.
	 */
	public void mostrarTela(String nome) {
		this.cardLayout.show(this.contentPane, nome);
		this.pack();
	}

}




