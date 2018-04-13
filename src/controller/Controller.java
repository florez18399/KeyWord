package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import gui.JFrameMain;
import models.TreeLetters;

public class Controller implements ActionListener, KeyListener {
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
		String word = frameMain.getWord();
		treeLetters.addWord(word);
		frameMain.cleanField();
		frameMain.repaintTree(treeLetters.getRoot());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
//		treeLetters.showArray(word);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println("Presiono tecla");
		System.out.println("Lo escrito actualmente");
		String word = frameMain.getWord();
		System.out.println(word);
		treeLetters.showArray(word);
	}

}
