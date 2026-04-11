package test;

import java.util.Scanner;

public class testin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("enter the number: ");
		int num = scan.nextInt();

		switch(num) {
			case 1:
				System.out.println("NIgger");
				break;
			case 2:
				System.out.println("nubber");
				break;
			case 3:
				System.out.println("haju? ni");
				break;
				default:
					System.out.println("Invalid nigggerodo");
					break;
		}
		//???????????? what is thsi

		System.out.println("This will server as a test if the thing works");

		scan.close();
	}

}
