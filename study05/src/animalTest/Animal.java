package animalTest;

public class Animal {
	protected String name;
	private int age;
	
	
	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("name:" + name + ", age : " + age);
	}
	
	public void makeSound() {
		System.out.println(name + "가 소리를 냅니다.");
	}
	


}
