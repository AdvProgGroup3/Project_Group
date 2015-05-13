package project;

public enum Action {
	INSERT,DELETE,SELECT,UPDATE;
	public String toString() {
		switch (this) {
		case INSERT:	return "insert";
		case DELETE:    return "delete";
		case SELECT: 	return "select";
		case UPDATE: 	return "update";
		default:		return "error";
		}
		
	}
}
