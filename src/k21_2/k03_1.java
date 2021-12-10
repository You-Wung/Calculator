package k21_2;

import java.util.Scanner;

public class k03_1 {

	static void div() { //static 전역메소드 : 어디서든지 호출가능
		Scanner s = new Scanner(System.in);
		while (true) {
			try {			
				System.out.print("Enter 1st int : ");
				int a = s.nextInt();
				System.out.print("Enter 2nd int : ");
				int b = s.nextInt();
				System.out.println("Result : " + a / b);
			} catch (Exception e) {
				System.out.println("Error");
				System.exit(0);
			}			
		}
	}
	public static void main(String[] args) {
		div();
	}

}
