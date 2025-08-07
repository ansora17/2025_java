package dogTest;

public class Animal {
	private String name;
	private int age;
	 
	public Animal(String name, int age) { //Aniaml의 컨스트럭쳐
		this.name = name;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println("name :" + name+ ", age :" + age);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	

}
