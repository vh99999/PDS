package model;

public class ItemCarrinho {
	private Produto produto;
	private int quantidadeComprada;

	public ItemCarrinho(Produto produto, int quantidadeComprada) {
		this.produto = produto;
		this.quantidadeComprada = quantidadeComprada;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}

	@Override
	public String toString() {
		return produto.getNome() + " - Qtd: " + quantidadeComprada + " - R$" + produto.getPreco().setScale(2);
	}
}
