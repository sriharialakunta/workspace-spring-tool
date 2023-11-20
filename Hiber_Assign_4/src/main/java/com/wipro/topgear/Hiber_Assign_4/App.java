package com.wipro.topgear.Hiber_Assign_4;

import com.wipro.topgear.Hiber_Assign_4.entity.Car;
import com.wipro.topgear.Hiber_Assign_4.service.HqlOperations;

public class App 
{
    public static void main( String[] args )
    {
     Car car = new Car("KL-07 AB 123","Polo","White","Volkswagen",700000);
     Car car1 = new Car("KL-07 AB 234","Vento","Black","Volkswagen",600000);
     Car car2 = new Car("KL-07 AC 345","Corolla","Silver","Toyota",1000000);
     Car car3 = new Car("KL-07 BC 123","Sail","Red","Chevrolet",500000);
     
     HqlOperations hqlOperations = new HqlOperations();
     
     hqlOperations.save(car);
     hqlOperations.save(car1);
     hqlOperations.save(car2);
     hqlOperations.save(car3);
     
     hqlOperations.retriveAll();
     hqlOperations.getManufacturer();
     hqlOperations.getByRegNo(" 'KL-07 BC 123' ");
     hqlOperations.getByPrice();

    }
}
