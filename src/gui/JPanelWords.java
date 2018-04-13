package gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class JPanelWords extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listWords; 
	private JList<String> jListWords;
	
	public JPanelWords(ArrayList<String> listWord) {
		this.listWords = listWord;
		init();
	}

	private void init() {
		this.jListWords = new JList<String>();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		fillJList();
	}

	private void fillJList() {
		jListWords.removeAll();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String string : listWords) {
			listModel.addElement(string);
		}
		jListWords.setModel(listModel);
		repaint();
		revalidate();
	}
}
