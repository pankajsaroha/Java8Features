package org.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class RestApiCall {

	static String url = "https://platform.uipath.com/api/account/authenticate";

	public static void main(String args[]) throws IOException {
		MyGETRequest();
	}

	
	public static void MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL(url);
	    String readLine = null;
	    String post_param = "{\r\n" + 
	    		"\"password\": \"Avengers_2018\",\r\n" + 
	    		"\"tenancyName\": \"AbhinavSri\",\r\n" + 
	    		"\"usernameOrEmailAddress\": \"abhinsr2@cisco.com\"\r\n" + 
	    		"}";
	    HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
	    connection.setRequestMethod("POST");
	    /*connection.setRequestProperty("abhinsr2@cisco.com", "Avengers_2018");
	    connection.setRequestProperty("tenancyName", "AbhinavSri");*/
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3163.100 Safari/537.36");
		//connection.setRequestProperty("Content-Length", "0");
		connection.setDoOutput(true);
		
		OutputStream os = connection.getOutputStream();
	    os.write(post_param.getBytes());
	    os.flush();
	    os.close();
		
	    int responseCode = connection.getResponseCode();
	    
	    System.out.println("Status Code : "+responseCode);
		
		System.out.println("Response --> "+connection.getResponseMessage());
	    
	    /*Client c = Client.create();
		
		WebResource wr = c.resource(url);
		
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("application/json", connection.toString());
		
		ClientResponse response = wr.queryParams(queryParams)
				.header("Content-Type", "application/json")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3163.100 Safari/537.36")
				.get(ClientResponse.class);
		
		System.out.println("Status Code : "+response.getStatus());
		
		System.out.println("Response --> "+response.getEntity(String.class));*/
	    
//	    System.out.println(connection.getInputStream().toString());
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(connection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        System.out.println("JSON String Result " + response.toString());
	        //GetAndPost.POSTRequest(response.toString());
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	}
	
	
		/*public static void MyGETRequest() throws IOException {
			URL obj = new URL(url);
		
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("abhinsr2@cisco.com", "Avengers_2018");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3163.100 Safari/537.36");
		postConnection.setRequestProperty("Content-Length", "0");
		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode);
		System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
		    BufferedReader in = new BufferedReader(new InputStreamReader(
		        postConnection.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();
		    while ((inputLine = in .readLine()) != null) {
		        response.append(inputLine);
		    } in .close();
		    // print result
		    System.out.println(response.toString());
		} else {
		    System.out.println("POST NOT WORKED");
		}
}*/

}