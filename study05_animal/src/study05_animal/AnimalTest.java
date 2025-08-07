package study05_animal;

public class AnimalTest {

	public static void main(String[] args) {
		Animal[] animals = new Animal[2];
		animals[0] = new Dog("바둑이",3,"진돗개");
		animals[1] = new Cat("흑임자",4,"검은색");
		
	//animals Dog = new Dog("바둑이",3,"진돗개");
	//animals Cat = new Cat("흑임자",4,"검은색");
		
		for(Animal animal:animals) {
			System.out.println(animal);
			animal.eat();
			animal.makeSound();
			animal.sleep();
			
			if(animal instanceof Dog) {
				Dog dog = (Dog) animal;
				dog.tail();
		}
			if(animal instanceof Cat) {
				Cat cat = (Cat) animal;
				cat.scratch();
			}
		
			System.out.println("-------------------");
		}
		
		Dog myDog = (Dog)animals[0];
		myDog.tail();
		
		Cat myCat = (Cat)animals[1];
		myCat.scratch();

	}

}
