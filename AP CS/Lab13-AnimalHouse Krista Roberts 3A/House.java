import java.util.*;
public class House{
    private ArrayList<Animal> friends = new ArrayList<Animal>();
    
    public void add(Animal cute){
        friends.add(cute);
    }
    
    public void printAnimals(){
        System.out.println(friends.toString());
    }
    
    public void cleanHouse(){
        Toy t;
        for (Animal a : friends){
            for (int i = 1; i < a.numToys(); i++){
                t = a.getToys().get(i-1);
                int firstMultiple = a.getToys().indexOf(t);
                int secondMultiple = a.getToys().lastIndexOf(t);
                if(a.getToy(firstMultiple).equals(a.getToy(secondMultiple))){
                    a.removeToy(t) ;
                } 
            }
        }

    }
    
    
    
    
    
    
    
}
