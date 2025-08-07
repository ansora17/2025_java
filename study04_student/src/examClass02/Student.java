package examClass02;

import java.util.ArrayList;
import java.util.List;

public class Student { // 공간생성 네임을 쓰면 과목이 짝 붙어서 옴
	private String name;
	private List<Subject> subjects;
	
	
	public Student(String name) { //컨스트럭쳐 생성
		this.name = name;
		this.subjects = new ArrayList<>();
	}
	
	public void addSubject(String subjectName) {
		subjects.add(new Subject(subjectName));
	}

	public Subject getSubject(String subjectName) {
		
		for(Subject subject:subjects) { //math에 데이터가 있는지 없는지 (if(math != null)
			if(subject.getName().equals(subjectName)) {
				return subject;
			}
			
		}
		return null;
	}

	public void printAllSubjects() {
		System.out.println("학생이름 :" + name);
		for(Subject subject : subjects) {
			subject.printExams();
			System.out.println();
		}
		
	}
	
}
