package study04_student;

public class StudentTest {

	public static void main(String[] args) {
		Student an = new Student("안소라",18);
		
		an.setAge(0);
		
		System.out.println("이름 : " + an.getName() + ", 나이 : " + an.getAge());

	}

}
