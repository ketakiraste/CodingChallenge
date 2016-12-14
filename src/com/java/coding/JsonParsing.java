package com.java.coding;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
* Get full path on an element from the JSON
* Logic - get root
* 		- recursively get each child node 
* 		- child could be array, nested object or string
* @author  Ketaki Raste
* @12/12/2016 
*/

public class JsonParsing {
	
	public static void main (String [] args){
		
		String inputJsonStr = "{\"itemList\": {\"items\": [{\"id\": \"item1\"},  " +
						"{\"id\": \"item2\",\"label\": \"Item 2\"}, " +
						"{\"id\": \"item3\"}, {\"id\": \"item4\"}, {\"id\": \"item5\"}, " +
						"{\"id\": \"subItem1\", \"subItems\": [ " +
						"{\"id\": \"subItem1Item1\",\"label\": \"SubItem 1\"}, " +
						"{\"id\": \"subItem1Item2\",\"label\": \"SubItem 2\"}, " +
						"{\"id\": \"subItem1Item3\",\"label\": \"SubItem 3\"} ]}, " +
						"{\"id\": \"item6\"}, "+
						"{\"id\": \"item7\",\"label\": \"Item 7\"}, "+
						"{\"id\": \"subItem2\", " +
						"\"subItems\": {\"id\": \"item1\",\"label\": \"SubItem 2 item1\"} }]}} ";
		
		JSONObject jsonObj = new JSONObject(inputJsonStr);    
		parseJsonObject("", jsonObj);
	}
	
	private static void parseJsonObject(String parent, JSONObject jsonObj) {
	    Iterator<String> it = jsonObj.keys();
	    while (it.hasNext()) {
	      String key = (String)it.next();
	      Object childNode = jsonObj.get(key);
	      String childKey = parent.isEmpty() ? key : parent + "\\" + key;
	      checkIfJsonArrayOrObject(childKey, childNode);
	    }
	 }

	private static void checkIfJsonArrayOrObject(String parent, Object data) {
		if (data instanceof JSONObject) {
			parseJsonObject(parent, (JSONObject)data);
		} else if (data instanceof JSONArray) {
			parseJsonArray(parent, (JSONArray) data);
		} else {
			System.out.println(parent + "\\"  + data.toString());
		}    
	}	 

	private static void parseJsonArray(String parent, JSONArray json) {
	    for (int i = 0; i < json.length(); i++) {
	      Object data = json.get(i);
	      checkIfJsonArrayOrObject(parent, data);
	    }
	}	
}


