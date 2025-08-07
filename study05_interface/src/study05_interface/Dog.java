package study05_interface;

public class Dog implements Animal{
	private String name; //private는 해당 클래스에서만 사용할수 있다 
	private int age;
	private String breed;
	

	public Dog(String name, int age, String breed) { //컨스트럭쳐 생성이 필요하다 
		this.name = name;
		this.age = age;
		this.breed = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(name+"가 멍멍...");
		
	}

	@Override
	public void eat() {
		System.out.println(name + "가 사료를 먹습니다.");
		
	}

	@Override
	public void showInfo() { //정보값을 넣어야함
		System.out.println("개정보 - 이름:" + name + ", 나이 :"+age);
		System.out.println("다리 : " + LEGS + "개, 꼬리 :" + TAILS + "개");
		
	}
	
	public void waveTail() {
		System.out.println(name + "가 꼬리를 흔듭니다.");
	}

}
