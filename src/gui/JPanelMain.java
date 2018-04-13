package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Commands;
import controller.Controller;
import models.NodeLetter;

public class JPanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTreeLetters treeLetters;
	private JTextField fieldWord;
	private JPanelWords panelWords;
	
	public JPanelMain(NodeLetter rootTree) {
		init(rootTree);
	}

	private void init(NodeLetter rootTree) {
		setLayout(new BorderLayout());
		JPanel panelTree = new JPanel();
		treeLetters = new JTreeLetters(rootTree);
		panelWords = new JPanelWords(new ArrayList<>());
		panelTree.add(treeLetters);
		panelTree.setBackground(Color.decode("#ff1a1a"));
		add(panelTree, BorderLayout.NORTH);
		add(panelWords, BorderLayout.CENTER);
		initSouth();
	}

	private void initSouth() {
		JPanel panelSouth = new JPanel(new FlowLayout());
		fieldWord = new JTextField();
		fieldWord.addKeyListener(Controller.getInstance());
		fieldWord.setPreferredSize(new Dimension(300, 20));
		panelSouth.add(fieldWord);
		JButton buttonAddWord = new JButton("Agrega palabra");
		buttonAddWord.setActionCommand(Commands.ADD_WORD.getCommand());
		buttonAddWord.setToolTipText(Commands.ADD_WORD.getDescription());
		buttonAddWord.addActionListener(Controller.getInstance());
		buttonAddWord.setPreferredSize(new Dimension(160, 20));
		panelSouth.add(buttonAddWord, BorderLayout.SOUTH);
		add(panelSouth, BorderLayout.SOUTH);
		
	}

	public void setRootTree(NodeLetter root) {
		treeLetters.setRoot(root);
	}

	public JTextField getFieldWord() {
		return fieldWord;
	}

	public void setFieldWord(JTextField fieldWord) {
		this.fieldWord = fieldWord;
	}

	public String getWord() {
		return fieldWord.getText();
	}

	public void cleanField() {
		fieldWord.setText("");
	}
}
