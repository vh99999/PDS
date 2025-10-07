package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class PanelCompra extends JPanel {

    private static final long serialVersionUID = 1L;

    private DefaultListModel<String> estoqueModel;
    private DefaultListModel<String> carrinhoModel;

    public JList<String> listaEstoque;
    public JList<String> listaCarrinho;

    JButton btnRemover;
    JButton btnAdicionar;
    private JLabel lblTotal;

    public PanelCompra() {
        setPreferredSize(new Dimension(979, 594));
        setOpaque(false);

        setLayout(new MigLayout("", 
            "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", 
            "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));

        carrinhoModel = new DefaultListModel<>();
        listaCarrinho = new JList<>(carrinhoModel);
        JScrollPane scrollCarrinho = new JScrollPane(listaCarrinho);
        add(scrollCarrinho, "cell 1 2 4 11,grow");

        estoqueModel = new DefaultListModel<>();
        listaEstoque = new JList<>(estoqueModel);
        JScrollPane scrollEstoque = new JScrollPane(listaEstoque);
        add(scrollEstoque, "cell 8 2 4 11,grow");

        btnAdicionar = new JButton("Adicionar ao Carrinho");
        add(btnAdicionar, "cell 5 6 3 1,grow");

        btnRemover = new JButton("Remover do Carrinho");
        add(btnRemover, "cell 5 8 3 1,grow");
        
        lblTotal = new JLabel("Total: R$0.00");
        add(lblTotal, "cell 2 13,grow");
    }

    public void adicionar(ActionListener actionListener) {
        this.btnAdicionar.addActionListener(actionListener);
    }

    public void remover(ActionListener actionListener) {
        this.btnRemover.addActionListener(actionListener);
    }

    public DefaultListModel<String> getEstoqueModel() {
        return estoqueModel;
    }

    public DefaultListModel<String> getCarrinhoModel() {
        return carrinhoModel;
    }

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}
    
    
}