package phones;

import java.io.Serializable;

public class phones implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private int id;
	private String title;
	private int power;
	private float price;

	
	public phones() {}
	
	public phones(int id, String title, int power, float price) {
		super();	
		this.id = id;
		this.title = title;
		this.power = power;
		this.price = price;
	
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{\"id\": "+id+", \"title\": \""+title+"\",\"power\": "+power+", \"price\": "+price+"}";
	}
	
	
}
