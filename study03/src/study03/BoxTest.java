package study03;

public class BoxTest {

	public static void main(String[] args) {
		Box box1 = new Box();
		
	
		 box1.width = 10;
		 box1.length = 10;
		 box1.height = 5;
		
		System.out.println("상사의 가로,세로,높이는" +box1.width+","+box1.length +","+box1.height+"입니다." );
	    System.out.println("상자의 부피는" + box1.getVolume() + "입니다.");

	}

}
