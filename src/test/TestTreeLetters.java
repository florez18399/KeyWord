package test;

import models.TreeLetters;

public class TestTreeLetters {
	public static void main(String[] args) {
		TreeLetters treeLetter = new TreeLetters();
		treeLetter.addWord("Hola");
		treeLetter.addWord("Hambre");
		treeLetter.addWord("Andres");
		treeLetter.addWord("Andrea");
		treeLetter.addWord("Anclar");
		treeLetter.addWord("Amigo");
		treeLetter.showTreeInConsole(treeLetter.getRoot(), " ");
	}
}
