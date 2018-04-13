package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.JFrameMain;
import models.TreeLetters;

public class Controller implements ActionListener {
	private static Controller controller;
	private TreeLetters treeLetters;
	private JFrameMain frameMain;
	
	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}
	
	public void initComponents() {
		treeLetters = new TreeLetters();
		frameMain = new JFrameMain(treeLetters.getRoot());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case ADD_WORD: 
			addWord();
			break;
		default:
			break;
		}
	}

	private void addWord() {
		String word = JOptionPane.showInputDialog(frameMain, "Ingresa la palabra", "Nueva palabra", JOptionPane.INFORMATION_MESSAGE);
		treeLetters.addWord(word);
		treeLetters.showTreeInConsole(treeLetters.getRoot(), " ");
		frameMain.repaintTree(treeLetters.getRoot());
	}

}
