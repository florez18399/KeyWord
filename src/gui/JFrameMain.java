package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameMain extends JFrame{
	
	public JFrameMain() {
		init();
	}

	private void init() {
		setTitle(ConstantsGUI.TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.ICON_APP_PATH)).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
}
