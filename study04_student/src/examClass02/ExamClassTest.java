package examClass02;

public class ExamClassTest {

	public static void main(String[] args) {
		Student student = new Student("홍길동");
		student.addSubject("수학"); //Subject 형에 subjectName이라는 이름을 가진 객체생성
		student.addSubject("영어");
		
		Subject math = student.getSubject("수학"); //get.Subject가 데이터를 갖고있게 만들어줘야함
		if(math != null) // != (null이 아니면) -> math가 있으면(데이터가 있다)
			
		math.addExam(92,"2025-02-19");
		math.addExam(80,"2025-02-20");
		math.addExam(100,"2025-02-21");
		
		
		Subject eng = student.getSubject("영어");
		if(eng != null) {
			eng.addExam(50, "2025-01-19");
			eng.addExam(60, "2025-01-20");
			eng.addExam(70, "2025-01-21");
		}
		student.printAllSubjects();

	}
	

   
}
