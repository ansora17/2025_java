package study05_interface;

public interface Animal { // interface:변수는 상수 //메소드는 엡스트렉트 
	int LEGS = 4;
	int TAILS = 1;
	int EYES =2;
	
	void makeSound();
	void eat();
	void showInfo();

}
