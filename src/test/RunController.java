package test;

import controller.Controller;
import gui.ConstantsGUI;

public class RunController {
	public static void main(String[] args) {
		Controller controller = Controller.getInstance();
		controller.initComponents();
	}
}
