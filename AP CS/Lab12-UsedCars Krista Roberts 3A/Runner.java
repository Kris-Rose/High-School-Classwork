import java.util.*;
public class Runner{
    public static void main(String[] args){
        Car c = new Car("Honda Odyssey", 1948, 0.2, 5);
        Car spaceX = new Car("Flying", 2029, 2000000000, 100);
        Truck t = new Truck("Ford", -36, 6000, -2);
        Truck uHaul = new Truck("A", 2, 3, 4000);
        Scooter speeder = new Scooter("Walmart", 2, 1000, 80);
        
        Inventory list = new Inventory();
        list.addVehicle(c);
        list.addVehicle(spaceX);
        list.addVehicle(t);
        list.addVehicle(uHaul);
        list.addVehicle(speeder);
        list.listInventory();
    }
    
    
    
}
