package models;

import java.util.ArrayList;

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

	public NodeLetter searchNode(NodeLetter actual, char letter) {
		if (actual.getInfo() == letter) {
			return actual;
		} else {
			for (NodeLetter actualLetter : actual.getChildren()) {
				return searchNode(actualLetter, letter);
			}
		}
		return null;
	}

	public NodeLetter searchLetters(String word) {
		System.out.println(word);
		int i = 0;
		NodeLetter letterSearch = searchChildRoot(root, word.charAt(i));
		while (i < word.length()) {
			i++;
			letterSearch = searchChildRoot(letterSearch, word.charAt(i));
		}
		return letterSearch;
	}

	public ArrayList<String> getRecommendations(NodeLetter father, String word) {
		ArrayList<String> arrayList = new ArrayList<>();
		getRecommendations(arrayList, father, "");
		return arrayList;
	}
	
	public void showArray(String word) {
		ArrayList<String> array = getRecommendations(searchLetters(word), word);
		for (String string : array) {
			System.out.println(string);
		}
	}

	private void getRecommendations(ArrayList<String> list, NodeLetter actual, String word) {
		if (actual.getChildren().isEmpty()) {
			list.add(word);
		} else {
			word += actual.getInfo();
		}
		for (NodeLetter letterActual : actual.getChildren()) {
			getRecommendations(list, letterActual, word);
		}
	}

	public String getWord(NodeLetter father) {
		return null;
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
