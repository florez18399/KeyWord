package models;

public class TreeLetters {
	private NodeLetter root;

	public TreeLetters() {
		root = new NodeLetter('R');
	}

	public NodeLetter getRoot() {
		return root;
	}

	public void setRoot(NodeLetter root) {
		this.root = root;
	}
}
