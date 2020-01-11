package com.example.converter.tempareture;

public class TemparatureConverter {
    private  String fromUnit;
    private  String toUnit;
    private  Double inputValue;
    private  Double result;

    public TemparatureConverter(String fromUnit, String toUnit, Double inputValue) {
         this.fromUnit = fromUnit;
         this.toUnit = toUnit;
         this.inputValue = inputValue;

         if (fromUnit.equals("Celsius")){
             if (toUnit.equals("Fahrenhite")){
                 result = 1.5;
             }
         }
    }

    public String getResult(){
        return result.toString();
    }
}
