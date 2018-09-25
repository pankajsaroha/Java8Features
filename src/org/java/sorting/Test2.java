package org.java.sorting;

import org.json.JSONArray;
import org.json.JSONObject;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Test2 {

    public static void main(String a[]){
         
        String url = "http://continuoustest-stage.cloudapps.cisco.com/COTDashBoard/cotws/service/pullExistingOrdersIntoCot";
        try {
            JSONObject obj = new JSONObject();
            obj.put("sourceOrder", "123");
            obj.put("sourceInstance", "TS3CG1");
            obj.put("autoProgressionStep", "Do Not Stop");
            obj.put("userId", "bari_qureshi");
            
            JSONArray obj2 = new JSONArray();
            obj2.put(obj);
            
            JSONObject obj3 = new JSONObject();
            obj3.put("requests",obj2);
            System.out.print("request--> "+obj3);    
            Client c = Client.create();
            
            c.addFilter(new HTTPBasicAuthFilter("ordermgmt.gen", "cisco123"));
            
            WebResource wr = c.resource(url);
            ClientResponse cr = wr.type("application/json").post(ClientResponse.class,obj3.toString().trim());
            JSONObject output = new JSONObject(cr.getEntity(String.class));
            if(cr.getStatus()!=200) {
             throw new RuntimeException("Failed:"+cr.getStatus());
            }
           
            System.out.println("\n-----\nOutput:"+output+"\n--------");
            
            
        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}