package Subject;

public class Student2Test {

	public static void main(String[] args) {
		Student2 student = new Student2("최준");
		
		student.addSubject("영어",80);
		student.addSubject("국어",90);
		student.addSubject("수학",60);
		
		student.printSubjects();
		

	}

}
