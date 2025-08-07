package study05_interface;

public class AnimalTest {

	public static void main(String[] args) {
		Animal myDog = new Dog("코코",3, "말티즈"); //Animal 클래스에만 있는 메소드만 사용가능 (다형성에서)
		Animal myCat = new Cat("야옹이",10,"블루");
		
		myDog.showInfo();
		myDog.eat();
		myDog.makeSound();
		
		Dog dog = (Dog)myDog; //Dog로 형변환을 해야 Dog 클래스에있는 메소드 사용이 가능 
				dog.waveTail();
				System.out.println("---------------------------------");
		
		Dog youDog = new Dog("해피",4,"불독"); //이렇게 작성하면 Animal 부터 Dog클래스 까지 다 사용 가능하지만
		//리스트화 시켜서 사요하기 위해 굳이 위처럼 작성하는것임(아래 youDog. 을 작성하면 클래스 메소드 다보임)
		youDog.showInfo();
		youDog.makeSound();
		youDog.waveTail();
		
		System.out.println("---------------------------------");
		
		myCat.showInfo();
		myCat.makeSound();
		myCat.eat();
		

	}

}
