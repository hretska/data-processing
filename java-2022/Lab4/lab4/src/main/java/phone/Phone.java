package phone;

import java.io.Serializable;

public class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private int power;
	private double  price;
	private int id;

	public Phone(int id, String title, double price, int power) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.power = power;
	}

	public Phone() {
		super();// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "{\"id\": " + id + ", \"title\": \""+title+"\", \"price\": "+ price+", \"power\": " + power + "}";
	}
}
