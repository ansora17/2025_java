package member;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String name;
	private List<Product> products;

	public Member(String name) {
		this.name = name;
		this.products = new ArrayList<>();
	}

	public void addProduct(String productName, int price) {
		products.add(new Product(productName, price));
			
	}
	
	public void printProducts() {
		System.out.println(name + "고객의 전자제품 구매 리스트 :");
		for(Product product:products) {
			System.out.println("- " + product);
		}
			System.out.println(products.size()+" 개 제품 금액의 평균 금액 : " + getAmount()+ "입니다.");
		}
	
		public int getAmount() {
			int sum = 0;
			for(Product product:products) {
				sum += product.getPrice();
			}
			return (int) Math.floor((double)sum );
		
		}
	}

	
	
	

