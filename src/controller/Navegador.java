package controller;

import javax.swing.JPanel;

import model.Usuario;
import view.Frame;

public class Navegador {

	private Frame frame;
	private Usuario usuarioAtual;
	private CompraController compraController;

	public Navegador(Frame frame, CompraController compraController) {
		this.frame = frame;
		this.compraController = compraController;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.frame.adicionarTela(nome, tela);
	}

	public void navegarPara(String nome) {
		if ("COMPRA".equals(nome) && compraController != null) {
			compraController.atualizarListas();
		}
		this.frame.mostrarTela(nome);
	}

	public void sair() {
		this.frame.dispose();
	}

	public void setUsuarioAtual(Usuario usuario) {
		this.usuarioAtual = usuario;
	}

	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}

	public void setCompraController(CompraController compraController) {
		this.compraController = compraController;
	}
}