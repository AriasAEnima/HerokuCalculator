/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.herokucalculator.Calculator;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author J. Eduardo Arias
 */
public class Calculator {
    
    private static Map<String,DoubleMath> operations=new HashMap<String, DoubleMath>()
    {{
        put("tan",(n)-> Math.tan(n));
        put("sin",(n)-> Math.sin(n));
        put("cos",(n)-> Math.cos(n));
    }};
    
    public static void addOperation(String name,DoubleMath op){
        operations.put(name,op);
    }    
    
    public static DoubleMath operation(String name){
        return operations.get(name);
    }
    
    public interface DoubleMath {
        double operation(Double number);
    }
    
    public static double operateDoubleMath(Double n, DoubleMath op){
        return op.operation(n);
    }
    
}
