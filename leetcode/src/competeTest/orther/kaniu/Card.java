package competeTest.orther.kaniu;

public class Card {
	private String color;//花色
	private String brand;//牌值

	public Card() {
	}

	public Card(String color, String brand) {
		this.color = color;
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "[" + color  + brand +"]";
	}
}
