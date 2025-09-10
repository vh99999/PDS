package controller;

import javax.swing.JPanel;

import view.Frame;


public class Navegador {
	
	private Frame frame;
	
	public Navegador(Frame frame) {
		this.frame = frame;
	}

	/**
	 * Método responsável por chamar o método da view que adiciona as telas ao painel principal.
	 * @param nome Nome do painel.
	 * @param tela Painel que será adicionado.
	 */
	public void adicionarPainel(String nome, JPanel tela) {
		this.frame.adicionarTela(nome, tela);
	}

	/**
	 * Método responsável por chamar o método da view que navega para outra tela.
	 * @param nome Nome da tela.
	 */
	public void navegarPara(String nome) {
		this.frame.mostrarTela(nome);
	}

	/**
	 * Método responsável por chamar o método da view que fecha a aplicação.
	 */
	public void sair() {
		this.frame.dispose();
	}

}
