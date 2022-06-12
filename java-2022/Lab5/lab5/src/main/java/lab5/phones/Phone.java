package lab5.phones;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name = "phone")
public class Phone implements Serializable{
	
	@Id
	@GeneratedValue
	int id;
	private String title;
	private int power;
	private double  price;

	

	
	
	public Phone() {
		super();
	}

	public Phone(int id, String title, int power, double price) {
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