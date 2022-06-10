package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import phone.Phone;

public class Helpers {
	
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static Phone phoneParse(HttpServletRequest request) {
		Phone phone = new Phone();
		JsonElement jsonElement = bodyParse(request);
		phone.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		phone.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		phone.setPrice(jsonElement.getAsJsonObject().get("price").getAsDouble());
		phone.setPower(jsonElement.getAsJsonObject().get("power").getAsInt());
		return phone;
	}
	
	public static int getNextId(List<Phone> list) {
		int maxId = 0;
		
		Iterator<Phone> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		return maxId+1;
	}
	
	public static int getIndexByPhoneId(int id,List<Phone> list) {
		int listId = id;
		
		Iterator<Phone> iterator = list.iterator();
		while(iterator.hasNext()) {
			Phone temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}
	
	

}