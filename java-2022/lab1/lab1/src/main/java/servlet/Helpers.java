package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import phones.phones;

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
	
	public static phones phonesParse(HttpServletRequest request) {
		phones phones = new phones();
		JsonElement jsonElement = bodyParse(request);
		phones.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		phones.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		phones.setPower(jsonElement.getAsJsonObject().get("power").getAsInt());
		phones.setPrice(jsonElement.getAsJsonObject().get("price").getAsFloat());
		return phones;
	}
	
	public static int getNextId(List<phones> list) {
		int maxId = 0;
		
		Iterator<phones> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if(currentId>maxId) maxId=currentId;
		}
		return maxId+1;
	}
	
	public static int getIndexByphonesId(int id,List<phones> list) {
		int listId = id;
		
		Iterator<phones> iterator = list.iterator();
		while(iterator.hasNext()) {
			phones temp =iterator.next();
			if(temp.getId()==listId) { 
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}
	
	

}