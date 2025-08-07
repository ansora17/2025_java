package study03;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> name = new ArrayList<>();
		
		name.add("딸기");
		name.add("메론");
		name.add("포도");
		name.add("자두");
		name.add("망고");
		name.add("바나나");
		
		System.out.println(name.size());
		System.out.println(name.get(4));
		
		for(int i=0;i<name.size();i++) {
			System.out.println(name.get(i));
		}
		
		for(String fruit:name) {
			System.out.println(fruit);
		}
	

	}

}
