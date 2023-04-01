package core;

import org.json.JSONObject;

public class Data {
	public static String getData(String clientData) {
		
		JSONObject userJson = new JSONObject(clientData);
		int number = userJson.getInt("a");
		int result = number * number;
		System.out.println(result);
		String responseFromServer = "{\"response\":" + result + "}";
		System.out.println(responseFromServer);
		return responseFromServer;
	}

}
