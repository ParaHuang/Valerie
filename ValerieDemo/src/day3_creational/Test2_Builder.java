package day3_creational;

//when the process of building an object is very complicate
public class Test2_Builder {
	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.buildName("Football");
		builder.buildPrice(100);
		
		Product p = builder.build();
		System.out.println(p);
	}
}

class Product{
	private String name;
	private int price;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}	
}

class Builder{
	private Product product;
	public Builder() {
		product = new Product();
	}
	
	public void buildName(String name) {
		product.setName(name);
	}
	
	public void buildPrice(int price) {
		product.setPrice(price);
	}
	
	public Product build() {
		return product;
	}
}


















