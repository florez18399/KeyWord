package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import models.NodeLetter;

public class JPanelDrawTree extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodeLetter rootTree;
	
	public JPanelDrawTree(NodeLetter rootTree) {
		this.rootTree = rootTree;
		init();
	}
	
	private void init() {
		repaint();
	}

	private void paintTree(Graphics graphics) {
		paintTree(rootTree, 50, 50, graphics);
	}

	private void paintTree(NodeLetter actualNode, int x, int y, Graphics graphics) {
		graphics.drawString(String.valueOf(actualNode.getInfo()), x, y);
		for (NodeLetter sonNode : actualNode.getChildren()) {
			paintTree(sonNode, x + 20, y + 20, graphics);
		}
	}

	@Override
	public void paint(Graphics g) {
		paintTree(g);
		super.paint(g);
	}
	
}	
