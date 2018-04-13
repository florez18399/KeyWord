package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import models.NodeLetter;

public class JPanelMain extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelDrawTree panelDrawTree;
	
	public JPanelMain(NodeLetter rootTree) {
		init(rootTree);
	}

	private void init(NodeLetter rootTree) {
		setLayout(new BorderLayout());
		panelDrawTree = new JPanelDrawTree(rootTree);
		add(panelDrawTree, BorderLayout.CENTER);
	}
}
