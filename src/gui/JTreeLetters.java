package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import models.NodeLetter;

public class JTreeLetters extends JTree {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode mutableTreeNode;
	private DefaultTreeModel defaultTreeModel;
	private NodeLetter root;

	public JTreeLetters(NodeLetter root) {
		mutableTreeNode = new DefaultMutableTreeNode();
		defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
		setModel(defaultTreeModel);
		this.root = root;
		init();
	}

	public void init() {
		setSize(500, 500);
		setLayout(new BorderLayout());
		setOpaque(false);
		paintTree();
		repaint();
	}

	public void paintTree() {
		if (root != null) {
			mutableTreeNode = createNodeJtree(root);
			defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
			setModel(defaultTreeModel);
			for (NodeLetter actualNode : root.getChildren()) {
				paintTree(actualNode, mutableTreeNode);
			}
		}
	}

	public void setIconNode(String pathIcon) {
		DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) getCellRenderer();
		ImageIcon imageIcon = getScaleIconImage(pathIcon);
		render.setLeafIcon(getScaleIconImage("/images/fileIcon.png"));
		render.setOpenIcon(imageIcon);
		render.setClosedIcon(imageIcon);
		paintTree();
	}

	private void paintTree(NodeLetter root, DefaultMutableTreeNode jroot) {
		if (root != null) {
			DefaultMutableTreeNode jNode = createNodeJtree(root);
			jroot.add(jNode);
			for (NodeLetter actualNode : root.getChildren()) {
				paintTree(actualNode, jNode);
			}
		}
	}

	public DefaultMutableTreeNode createNodeJtree(NodeLetter node) {
		return new DefaultMutableTreeNode(node.getInfo() + "  " + node.getMark());
	}

	public ImageIcon getScaleIconImage(String imageURL) {
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
		Image image = imageIcon.getImage();
		imageIcon = new ImageIcon(image.getScaledInstance(20, 20, java.awt.Image.SCALE_REPLICATE));
		return imageIcon;
	}

	public void repaintTree() {
		removeAll();
		paintTree();
		revalidate();
		repaint();
	}

	/**
	 * @return the root
	 */
	public NodeLetter getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(NodeLetter root) {
		System.out.println("Repintando árbol");
		this.root = root;
		repaintTree();
	}

}
