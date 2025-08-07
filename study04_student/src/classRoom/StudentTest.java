package classRoom;

public class StudentTest {

	public static void main(String[] args) {
		// 컨스트럭쳐를 만들게 됨 인자값을 -> ("안소라") 만들경우
		Student student = new Student("안소라");
		
		
		// 컨스트럭쳐를 만들게 됨 인자값을 -> ("자바", 80) 만들경우
		student.addSubject("자바", 80);
		student.addSubject("스크립트", 90);
		student.addSubject("파이썬", 70);
		
		student.printSubjects();

	}
	
	
	}




