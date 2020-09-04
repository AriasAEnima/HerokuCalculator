/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.herokucalculator;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author J. Eduardo Arias
 */
public class JsonResponser {
    
    
    public static String StringJsonOf(String[][] paramsAndValues){
        return toJsonStringResponse(responseParamsMapper(paramsAndValues));
    }
    
    
    
     public static Map<String,String> responseParamsMapper(String[][] paramsAndValues){
        Map<String,String> map=new HashMap<>();        
        for (String[] duple : paramsAndValues) {
            if(duple.length>=2){
                map.put(duple[0], duple[1]);
            }
        }                
      
        return map;
    }
    
    public static String toJsonStringResponse(Map<String,String> map){
        JSONObject jo = new JSONObject(); 
        for(String s:map.keySet()){
            jo.put(s, map.get(s));
        }     
        return jo.toString();     
    }
    
}
