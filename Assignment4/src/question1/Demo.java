package question1;

import java.util.Scanner;

public class Demo {

	public static int integerInput() {
		Scanner scanner = new Scanner(System.in);
		int integer = 0;
		boolean flag=true;
		
			do {
					try{
						integer = scanner.nextInt();
						flag=false;
					}
					catch (Exception exception) {
						System.err.println(exception);
						flag=true;
					}
				
			}while(flag);
		
		return integer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			int n = integerInput();
			System.out.println(n);
		}
	}

}
