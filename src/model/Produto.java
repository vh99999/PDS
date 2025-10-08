package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

	private String nome;
	private BigDecimal preco;
	private String desc;
	private int quantidade;

	public Produto(String nome, BigDecimal preco, String desc, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.desc = desc;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDesc() {
		return desc;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return nome + " - R$" + preco.setScale(2, RoundingMode.HALF_UP) + " | " + desc + " | Qtd: " + quantidade;
	}
}