package reading_of_xml.in.java;


public class Car {
    String vin;
    String color;
    String model;
    String make;
    int year;
    
    public Car()
    {
        
    }
   
    @Override
    public  String toString()
    {
        return String.format("%d %s %s %s %s",  year,make, model,color,vin);
    }
    
    
}
