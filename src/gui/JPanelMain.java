package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Commands;
import controller.Controller;
import models.NodeLetter;

public class JPanelMain extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTreeLetters treeLetters;
	
	public JPanelMain(NodeLetter rootTree) {
		init(rootTree);
	}

	private void init(NodeLetter rootTree) {
		setLayout(new BorderLayout());
		JPanel panelTree = new JPanel();
		treeLetters = new JTreeLetters(rootTree);
		panelTree.add(treeLetters);
		panelTree.setBackground(Color.decode("#ff1a1a"));
		add(panelTree, BorderLayout.CENTER);
		initJButton();
	}

	private void initJButton() {
		JButton buttonAddWord = new JButton("Agrega palabra");
		buttonAddWord.setActionCommand(Commands.ADD_WORD.getCommand());
		buttonAddWord.setToolTipText(Commands.ADD_WORD.getDescription());
		buttonAddWord.addActionListener(Controller.getInstance());
		buttonAddWord.setPreferredSize(new Dimension(50, 20));
		add(buttonAddWord, BorderLayout.SOUTH);
	}
	
	public void setRootTree(NodeLetter root) {
		treeLetters.setRoot(root);
	}
}
