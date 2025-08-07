package study03;

public class FuntionTest {
	
	
	public static int addNum(int i, int j) {
		int result = i+j;
		return result;
	}
	
	public static void sayHello(String greeting) {
		System.out.println(greeting);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		int result = addNum(10,20);
		System.out.println(result);
		
		sayHello("안녕하세요");
		sayHello("잘가세요");
		
	}

	
	



}
