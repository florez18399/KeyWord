package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.NodeLetter;

public class JPanelDrawTree extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodeLetter rootTree;
	private int y;

	public JPanelDrawTree(NodeLetter rootTree) {
		this.rootTree = rootTree;
		init();
	}

	private void init() {
		y = 40;
		repaint();
	}

	private void paintTree(Graphics graphics) {
		paintTree(rootTree, 50, 50, graphics);
	}

	private void paintTree(NodeLetter actualNode, int x, int y, Graphics graphics) {
		graphics.drawString(String.valueOf(actualNode.getInfo()), x, y);
		for (NodeLetter sonNode : actualNode.getChildren()) {
			y += y/(actualNode.getChildren().indexOf(sonNode) + 1);
			paintTree(sonNode, x + 40, y, graphics);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		paintTree(g);
	}

}
