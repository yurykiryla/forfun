package grokaem.algoritmy.ch9;

public class Good {
	private String name;
	private int price;
	private int size;
	public Good(String name, int price, int size) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Good [name=" + name + ", price=" + price + ", size=" + size + "]";
	}
	
	

}
