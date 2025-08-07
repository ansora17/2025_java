package Subject;

public class Subject2 {
	private String name;
	private int score;
	
	public Subject2 (String name,int score ) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Subjct2 [과목명=" + name + ", 점수=" + score + "]";
	}
	
	

}
