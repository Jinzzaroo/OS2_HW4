package Practice;

import java.util.Scanner;

public class Practice7_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = null;
		
		while(true) {
			System.out.print(">>");
			s = sc.nextLine();
			
			if(s.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}
			
			String a [] = s.split(" ");
			System.out.println("어절 개수는 " + a.length);
		}
	}
}