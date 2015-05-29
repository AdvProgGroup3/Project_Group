package project;

public enum Action {
	INSERT,DELETE,SELECT,UPDATE,TOLIST,CHECKINORNOT,FILLCHECK;
//	OTHERUSER;
	public String toString() {
		switch (this) {
		case INSERT:		return "insert";
		case DELETE:    	return "delete";
		case SELECT: 		return "select";
		case UPDATE: 		return "update";
		case TOLIST: 		return "to list";
		case FILLCHECK:		return "fill check";
		case CHECKINORNOT: 	return "check in or not";
		
		default:			return "error";
		}
		
	}
}
