package controller;

public enum Commands {
	ADD_WORD("ADD_WORD", "Agregar palabra", "Agrega una palabra", "");

	private String command;
	private String title;
	private String description;
	private String pathIcon;

	private Commands(String command, String title, String description, String pathIcon) {
		this.command = command;
		this.title = title;
		this.description = description;
		this.pathIcon = pathIcon;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPathIcon() {
		return pathIcon;
	}

	public void setPathIcon(String pathIcon) {
		this.pathIcon = pathIcon;
	}

}
