package study04;

public class BankTest1 {

	public static void main(String[] args) {
		BankAccount1 account = new BankAccount1("110-383-393761","안소라",100000);
//		BankAccount1 account1 = new BankAccount1("110-777-393761","장현길",100000);
		
		
		account.deposit(50000);
		account.withDraw(10000);
		account.withDraw(100000);
		account.deposit(-50000);
		account.checkBalance();
		account.printTransactions();
		account.deposit(50000);
		
		
		
		account.checkBalance();
		account.printTransactions(); //내역서 확인
		


	}

}
