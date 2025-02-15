package com.calculator.debugdatabandits.service;

import com.calculator.debugdatabandits.model.OperationModel;
import org.springframework.stereotype.Service;
import java.lang.Math;

@Service
public class CalculateSimple {

    public int add(OperationModel model){
        return model.getA() + model.getB();
    }

    public long[] gcd(OperationModel model){
        return gcd(model.getA(), model.getB());
    }
    
     private long[] gcd(int a, int b)
{
         long startTime = System.nanoTime();

    if (a == 0)
       return new long[] {Long.valueOf(b), System.nanoTime() - startTime};
    if (b == 0)
       return new long[] {Long.valueOf(a), System.nanoTime() - startTime};
  

    if (a == b)
        return new long[] {Long.valueOf(a), System.nanoTime()- startTime};
  

    if (a > b)
        return gcd(a-b, b);
    return gcd(a, b-a);
}
    

    public int subtract(OperationModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

    public int factorial(OperationModel model) {
        return factorial(model.getC());
    }

    private int factorial(int n){
        return n < 2 ? n : n * factorial(n-1);
    }

    public int fibonacci(OperationModel model){
        return fibonacci(model.getC());
    }

    private int fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public double sqrt(OperationModel model){
        return Math.sqrt(model.getC());
    }

    public int power(OperationModel model){
        return model.getC() * model.getC();
    }

    public OperationModel clearSimple(OperationModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }
    
    public OperationModel initialize(OperationModel model){
        model.setA(10);
        model.setB(5);
        return model;
    }

    public OperationModel clearAdvanced(OperationModel model){
        model.setC(0);
        return model;
    }
}
