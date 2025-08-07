package study03;

public class Hero {
	String name;
	String power;
	int attack;
	int defense;
	String rank;
	
	
	public Hero(String name, String power, int attack, int defense) {
		this.name = name;
		this.power = power;
		this.attack = attack;
		this.defense = defense;
		this.rank = calcRank();
	}


	private String calcRank() {
		int score = attack + defense;
		if(score >= 180) {
			return "S";
		}else if(score >=140) {
			return "A";
		}else if(score >=100) {
			return "B";
		}else{
			return "c";
		}
	}
	
	public void showHeroInfo() {
		System.out.println("히어로:" + name);
		System.out.println("능력 :" + power);
		System.out.println("공격력 :" + attack);
		System.out.println("방어력 :" + defense);
		System.out.println("등급 :" + rank);
	}



	@Override
	public String toString() {
		return "Hero [name=" + name + ", power=" + power + ", attack=" + attack + ", defense=" + defense + ", rank" + rank + "]";
	}
	
	
	
	
	
	
}
