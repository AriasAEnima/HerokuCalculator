/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.herokucalculator;

import edu.escuelaing.arep.herokucalculator.Calculator.Calculator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import static spark.Spark.*;

/**
 *
 * @author J. Eduardo Arias
 */
public class HerokuTrigCalculator {

    public static void main(String[] args) {       
        port(getPort());
        get("/",(req, res) -> 
                "<h1> Calculadora Trigonometrica</h1>"
                + "<form action=\"/calcule\" method=\"get\">\n"
                + "  <label for=\"function\">Function: </label>\n"
                + "  <input type=\"text\" id=\"function\" name=\"function\"><br><br>\n"
                + "  <label for=\"number\">Number (Randians) :</label>\n"
                + "  <input type=\"number\" step=any id=\"number\" name=\"number\"><br><br>\n"
                + "  <input type=\"submit\" value=\"Submit\">\n"
                + "</form>");
        
        get("/calcule",  (req, res) -> {
            try{              
                String func=req.queryParams("function");
                Double number=Double.parseDouble(req.queryParams("number"));
                if(Calculator.operation(func)!=null){
                    Double ans=Calculator.operation(func).operation(number);    
                    String response=JsonResponser.StringJsonOf(
                            new String[][]{
                                {"function",func},
                                {"number",number+""},
                                {"ans",ans+""}
                            });
                    return response;
                }else{
                    throw new Exception("Funcion no valida");
                }         
            }catch(Exception e){
                return "<h1> "+e.toString() +"</h1>";
            }
        });        
        
    }
    
     static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }
   
    
   

}
