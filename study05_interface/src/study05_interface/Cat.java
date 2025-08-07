package study05_interface;

public class Cat implements Animal{
	private String name; //private는 해당 클래스에서만 사용할수 있다 
	private int age;
	private String corlor;
	

	public Cat(String name, int age, String corlor) { // 매개변수를 받아서 쓴다, 컨스트럭쳐 생성이 필요하다 
		this.name = name;
		this.age = age;
		this.corlor = corlor;
	}

	@Override
	public void makeSound() {
		System.out.println(name+"가 야옹...");
		
	}

	@Override
	public void eat() {
		System.out.println(name + "가 생성을 먹습니다.");
		
	}

	@Override
	public void showInfo() { //정보값을 넣어야함
		System.out.println("고양이정보 - 이름:" + name + ", 나이 :"+age);
		System.out.println("다리 : " + LEGS + "고양이, 꼬리 :" + TAILS + "개");
		
	}
	
	public void scratch() {
		System.out.println(name + "가 핡퀴기 공격");
	}

}
