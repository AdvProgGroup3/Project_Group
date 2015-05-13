package project;
import java.util.*;

public class main2 {
	public static void main(String args[]){
		ShowParkingSpace show=new ShowParkingSpace(0);
		ArrayList a=show.getList();
		System.out.println(a.toString());
		Map m=(Map) a.get(0);
		System.out.println(a.get(0));
		System.out.println(m.size());
		for (int i=1; i<=m.size();i++){
			String p="a";
			if(i<10){
				p+="0";
				System.out.println(m.get(p+i));
			}
			else{
				System.out.println(m.get(p+i));
			}
		}
	}

}



