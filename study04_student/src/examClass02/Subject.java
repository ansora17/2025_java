package examClass02;

import java.util.ArrayList;
import java.util.List;

public class Subject { //시험 일정
	private String name;
	private List<Exam> exams;
	
	public Subject(String name) {
		this.name = name;
		this.exams = new ArrayList<>(); // 원래는 <>안에 Exam을 넣어야 하지만 앞에 
		//너어져 있기때문에 굳이 쓸필요 없음
	}

	public String getName() { //과목이름 뽑기위해서
		return name;
	}

	public void addExam(int score, String date) { 
		exams.add(new Exam(score,date) );
		
	}
	
	public int getAverage() { //평균값 구하기
		int total = 0;
		for(Exam exam:exams) {
			total += exam.getScore();
		}
		return (int) Math.floor((double)total/exams.size()); //floor 소주점 버림
	}

	public Exam getHighExam() {
		Exam highExam = exams.get(0); //92, "날짜"
		
		for(Exam exam:exams) { //exam는 포문안에서 도는 이름임
			if(exam.getScore() > highExam.getScore()) {
				highExam = exam;
			}
		}
		return highExam; // 점수, 날짜를 뱉어냄
	}
	
	public void printExams() { //어러개를 프린트 해야해서 Exams에 s를 붙인것
		System.out.println("과목 :" + name );
		for(Exam exam:exams) {
			System.out.println("-" + exam.toString());
		}
		System.out.println("평균점수 : " + getAverage()+ "점");
	}
	
	

}
