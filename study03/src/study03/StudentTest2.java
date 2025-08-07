package study03;

public class StudentTest2 {

	public static void main(String[] args) {
		
		Student2 studentan = new Student2(250213, "안소라", 3);
		
		System.out.println(studentan.studentName + " 학생의 학번은 "+ studentan.studentNumber+ "이고 "+ studentan.grade + "학년 입니다.");

	}
}
