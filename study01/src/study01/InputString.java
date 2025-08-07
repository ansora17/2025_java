package study01;

import java.util.Scanner;

//사용자로부터 이름봐 나이를 받아 출력
//홍길동님 안녕하세요! 30살 이시네요
public class InputString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int age;
		String name;
	
		System.out.println(" 이름을 입력하세요. : ");
		name = sc.nextLine();
				
		System.out.println(" 나이를 입렵하세요. : ");
		age = sc.nextInt();
		
		
		
		System.out.println(name+"님 안녕하세요!" + age + "살 이시네요." );
		
		

	}

}
