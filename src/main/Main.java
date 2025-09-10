package main;

import controller.Navegador;
import model.UsuarioDAO;
import view.Frame;
import view.PanelCadastro;

public class Main {
	
	public static void main(String[] args){
		
		Frame frame = new Frame();
		Navegador navegador = new Navegador(frame);
		UsuarioDAO usuariodao = new UsuarioDAO();
		
		PanelCadastro panelcad = new PanelCadastro();
		
		
		
		
		
		
	}
}
