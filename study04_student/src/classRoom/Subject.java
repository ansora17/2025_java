package classRoom;

public class Subject {
	private String name;
	private int score;

	//private를 넣었기때문에 초기값을 넣어기위해 컨스트럭쳐를 생성 
	public Subject(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// 해당 클래스에 private 사용으로 다른 클래스에 있는 인자값을 가져오기 위해 사용 
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	@Override // 원래 있던 값을 아래처럼 수정해서 쓰겠다는 의미
	public String toString() {
		return  "과목명 = " + name + ", 점수 = " + score + "";
	}
	
   
}
