package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import models.NodeLetter;

public class JFrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelMain panelMain;

	public JFrameMain(NodeLetter rootTree) {
		init(rootTree);
	}

	private void init(NodeLetter rootTree) {
		setTitle(ConstantsGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH)).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		panelMain = new JPanelMain(rootTree);
		add(panelMain);
		setVisible(true);
	}
	
	public void repaintTree(NodeLetter rootTree) {
		panelMain.setRootTree(rootTree);
	}

}
