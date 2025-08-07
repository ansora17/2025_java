package study04;

public class BankAccount {
	int accountNum;
	String name;
	int balance;
	
	void deposit(int count) {
//		balance = balance + count;
		balance += count;
		
	}
	
	void withDraw(int count) {
		balance -= count;
	}

	@Override
	public String toString() {
		return "신한은행 " + name + " 고객님" + ", 잔고는 " + balance +"원 입니다.";
	}
	
	

}
