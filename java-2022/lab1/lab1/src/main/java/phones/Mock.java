package phones;

import java.util.ArrayList;
import java.util.List;

public class Mock {
	
	private List<phones> phonesList = new ArrayList<>();
	
	public Mock () {
		
		this.phonesList.add(new phones(0, "Samsung flip-phone", 5000, 250));
		this.phonesList.add(new phones(1, "Samsung Note 12", 3000, 200));
		this.phonesList.add(new phones(2, "Samsung A18", 2000, 120));		
		
	}

	public List<phones> getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(List<phones> phonesList) {
		this.phonesList = phonesList;
	}
	

}
