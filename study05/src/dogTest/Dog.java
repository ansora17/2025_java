package dogTest;

public class Dog extends Animal{

	public Dog(String name, int age) { // ()안에 있는것은 매개변수
		super(name, age);
	}
	//  super는 Animal 클래스의 컨스트럭쳐를 의미, super 클래스는 상위클래스를 의미
	
	public void makeSound() {
		System.out.println("멍멍!! 멍멍!!");
	}
	
	
	
	

}
