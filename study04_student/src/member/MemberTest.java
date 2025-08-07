package member;

public class MemberTest {
	public static void main(String[] args) {
		Member member = new Member("안소라");
		
		member.addProduct("충전기",50000);
		member.addProduct("아이패드",500000);
		member.addProduct("애플팬슬",120000);
		
		member.printProducts();
	}
	

}
