package animalTest;

public class Dog extends Animal {
	String breed;
	
//	Dog dog = new Dog() //컨스트럭쳐가 없어두됌 하지만 컴파일 할때 디폴트 컨스트럭쳐가 생김
//	하지만 인자값을 가진 인스턴스와 인자값 없는 인스턴스 같이사용할때는 디폴트 컨스트럭쳐를 또 넣어줘야함

	public Dog(String name,int age, String breed) {
		super(age, name);
		this.breed = breed;
	}
	
	public void waveTail() {
		System.out.println(name + "가 꼬리를 흔듬!!!");
		}

	@Override //makeSound를 오버라이드해서 가져온다 (어노테이션: 검증하기 위해 사용)
	public void makeSound() {
		System.out.println(name + "가 멍멍!! 멍멍!!");
	}
	
	

	

}
