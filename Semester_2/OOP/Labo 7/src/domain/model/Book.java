package domain.model;

public class Book {
	String title;
	int price;
	int number;
	
	public Book(String title, int price, int number) {
		this.setTitle(title);
		this.setPrice(price);
		this.setNumber(number);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	
}
