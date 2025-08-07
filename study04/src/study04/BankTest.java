package study04;

public class BankTest {

	public static void main(String[] args) {
		BankAccount name = new BankAccount();
		name.name = "안소라";
		name.deposit(1000);
		System.out.println(name.toString());
		
		name.withDraw(500);
		System.out.println(name);
	

	}

}
