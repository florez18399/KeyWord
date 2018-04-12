package models;

public class TreeLetters {
	private NodeLetter root;

	public TreeLetters() {
		root = new NodeLetter('R');
	}

	/**
	 * Agregar al árbol
	 */
	public void addWord(String word) {
		addWord(0, word, root);
	}

	private void addWord(int i, String word, NodeLetter actualLetter) {
		NodeLetter foundLetter = searchChildRoot(actualLetter, word.charAt(i));
		if (foundLetter != null) {
			addWord(i + 1, word, foundLetter);
		} else {
			NodeLetter nodeFather = actualLetter;
			while (i < word.length()) {
				nodeFather.getChildren().add(new NodeLetter(word.charAt(i)));
				nodeFather = nodeFather.getChildren().get(0);
				i++;
			}
		}
	}

	private NodeLetter searchChildRoot(NodeLetter father, char letter) {
		for (NodeLetter nodeLetter : father.getChildren()) {
			if (nodeLetter.getInfo() == letter)
				return nodeLetter;
		}
		return null;
	}

	public NodeLetter getRoot() {
		return root;
	}

	public void setRoot(NodeLetter root) {
		this.root = root;
	}
}
