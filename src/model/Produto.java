package model;

import java.text.DecimalFormat;

public class Produto {
	
	String nome;
	String preco;
	String desc;
	
	public Produto(String nome, String preco, String desc) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desc = desc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString() {
	    try {
	        double valor = Double.parseDouble(preco);
	        DecimalFormat df = new DecimalFormat("0.00");
	        return nome + " - R$" + df.format(valor) + " | " + desc;
	    } catch (NumberFormatException e) {
	        return nome + " - R$" + preco + " | " + desc;
	    }
	}



	

	
	

}
