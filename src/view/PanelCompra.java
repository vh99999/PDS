package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelCompra extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelCompra() {
		setPreferredSize(new Dimension(700, 400));
		setOpaque(false);
		setLayout(new MigLayout("", "[20][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]", "[20][34.00][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][20]"));


	}

}
