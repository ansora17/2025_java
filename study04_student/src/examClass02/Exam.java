package examClass02;

public class Exam { // 과목을 쓰면 점수와 날짜가 붙음 , private는 해당 클래스 안에서만 사용
	private int score;
	private String date;
	
	public Exam(int score, String date) { //컨스트럭쳐 생성
		this.score = score;
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public String getDate() {
		return date;
	}

	@Override //상속을 받는 내용 , 외부에 사용됨
	public String toString() {
		return date + "시험 : " + score + "점";
	}
	
	
	
	

}
