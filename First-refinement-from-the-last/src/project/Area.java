package project;

public enum Area {
	A01,A02,A03,A04,A05,A06,A07, A08, A09, A10, A11, A12;
//	A13, A14, 
//	A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27,
//	A28, A29, A30, A31, A32;
	public String toString(){
		switch (this) {
		case A01: return "a01";
		case A02: return "a02";
		case A03: return "a03";	
		case A04: return "a04";
		case A05: return "a05";
		case A06: return "a06";
		case A07: return "a07";
		case A08: return "a08";
		case A09: return "a09";
		case A10: return "a10";
		case A11: return "a11";
		case A12: return "a12";
//		case A13: return "a13";
//		case A14: return "a14";
//		case A15: return "a15";
//		case A16: return "a16";
//		case A17: return "a17";
//		case A18: return "a18";
//		case A19: return "a19";
//		case A20: return "a20";
//		case A21: return "a21";	
//		case A22: return "a22";
//		
//		case A23: return "a23";
//		case A24: return "a24";	
//		case A25: return "a25";
//		case A26: return "a26";
//		case A27: return "a27";
//		case A28: return "a28";
//		
//		case A29: return "a29";
//		case A30: return "a30";
//		case A31: return "a31";
//		case A32: return "a32";
//		
	
			
		

		default: return "Error: not found";
		}
	}

}
