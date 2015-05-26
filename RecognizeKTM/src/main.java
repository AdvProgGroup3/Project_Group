import java.util.Scanner;


public class main {
	static int NPM;
	
	public static void main(String[] args) {
		   System.out.println("Please Type your NPM (integer 10 digits):   ");
		   Scanner input = new Scanner(System.in);
		   NPM = input.nextInt();
		   kodok data = new kodok(NPM);
		   if (data.checkNPM()){
			   System.out.println("Your NPM format is right let me check in database");
			   if (data.validationNPM()){
				   System.out.println("Your NPM is valid");
			   }
			   else{
				   System.out.println("Your NPM is invalid");
				   
			   }
		   }
		   else{
			   System.out.println("NPM format is wrong");
		   }
		   
		   
		   }
		   
}
