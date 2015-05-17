package project;

public enum Action {
	INSERT,DELETE,SELECT,UPDATE,TOLIST,CHECKINORNOT;
	public String toString() {
		switch (this) {
		case INSERT:	return "insert";
		case DELETE:    return "delete";
		case SELECT: 	return "select";
		case UPDATE: 	return "update";
		case TOLIST: 	return "to list";
		case CHECKINORNOT: return "check in or not";
		
		default:		return "error";
		}
		
	}
}
