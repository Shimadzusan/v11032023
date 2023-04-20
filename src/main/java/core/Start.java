package core;

import org.json.JSONObject;

public class Start {

	public static void main(String[] args) throws ClassNotFoundException {
		String s = "{\"a\":14}";
		System.out.println(s);
		
		JSONObject userJson = new JSONObject(s);
		int number = userJson.getInt("a");
		int result = number * number;
		System.out.println(result);
		String response = "{\"response\":" + result + "}";
		System.out.println(response);
		Class.forName("org.json.JSONObject");
		Data.getData(s);

	}

}
