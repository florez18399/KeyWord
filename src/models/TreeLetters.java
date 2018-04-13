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
		System.out.println("Termino de agregar");
	}

	private void addWord(int i, String word, NodeLetter actualLetter) {
		System.out.println(i);
		if (i < word.length()) {
			NodeLetter foundLetter = searchChildRoot(actualLetter, word.charAt(i));
			if (foundLetter != null) {
				foundLetter.setMark(foundLetter.getMark() + 1);
				addWord(i + 1, word, foundLetter);
			} else {
				actualLetter.getChildren().add(new NodeLetter(word.charAt(i)));
				addWord(i + 1, word, actualLetter.getChildren().getLast());
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

	public void showTreeInConsole(NodeLetter actual, String separator) {
		System.out.println(separator + actual.getInfo());
		for (NodeLetter actualLetter : actual.getChildren()) {
			showTreeInConsole(actualLetter, separator + "                    |");
		}
	}

	public NodeLetter getRoot() {
		return root;
	}

	public void setRoot(NodeLetter root) {
		this.root = root;
	}
}
