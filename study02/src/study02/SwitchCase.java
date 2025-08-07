package study02;

public class SwitchCase {

	public static void main(String[] args) {
		
		int month ; //10월
		int day ;
		
		
		
//		if(month ==1) {
//			day = 31;
//		}
//		
//		if(month == 10) {
//			day = 31;
////			System.out.println(day);
//		}
//			else {
//			day = 0;
////			
//		}

		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		   day = 31;
		   break;
		case 2:
			day = 28;
		case 4: case 6: case 9: case 11:
			day = 30;
		default:
			day = 0;
			System.out.println("존재하지 않는 달입니다.");
		   
		}
	    System.out.println(day);

	}

}
