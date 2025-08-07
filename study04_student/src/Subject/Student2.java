package Subject;

import java.util.ArrayList;
import java.util.List;

public class Student2 {
		private String name;
		private List<Subject2> subjects;

	public Student2(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
	}

	public void addSubject(String subjectName, int score) {
		subjects.add(new Subject2(name,score));
	}

	public void printSubjects() {
		System.out.println(name + "학생의 수강과목 리스트 :");
		for(Subject2 subj5 : subjects) {
			System.out.println("-" + subj5);
		}
		
	}
	

	

}
