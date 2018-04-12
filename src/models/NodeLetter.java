package models;

import java.util.LinkedList;

public class NodeLetter {
	private char info;
	private int mark;
	private LinkedList<NodeLetter> children;

	public NodeLetter(char info) {
		this.info = info;
		this.children = new LinkedList<NodeLetter>();
	}

	public LinkedList<NodeLetter> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<NodeLetter> children) {
		this.children = children;
	}

	public char getInfo() {
		return info;
	}

	public void setInfo(char info) {
		this.info = info;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

}
