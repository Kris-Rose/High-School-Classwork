

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit extends Animal
{
    /* Characteristics shared by all rabbits (static fields). */

    private static final int    BREEDING_AGE = 5;
    private static final int    MAX_AGE = 15;
    private static final double BREEDING_PROBABILITY = 0.22;
    private static final int    MAX_LITTER_SIZE = 6;

    /* Individual characteristics (instance fields). */


    /**
     * Create a new rabbit. A rabbit is created with age zero (a new born).
     */
    public Rabbit(Field field, Location location)
    {
        this.setAge(0);
        setAlive(true);
        setField(field);
        setLocation(location);
    }
    
    
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     */
    public void run()
    {
        incrementAge();
        if(isAlive() == false){
            return;
        }
        if(canBreed()){
            int babies = breed();
            for(int a = 0; a<babies;a++){
                if(getField().freeAdjacentLocation(getLocation()) != null){
                    getField().place( new Rabbit( getField(),getLocation()),  getField().freeAdjacentLocation(getLocation()));
                }
            }
        }
        if(getField().freeAdjacentLocation(getLocation()) == null){
            setDead();
        }
        else{
           setLocation( getField().freeAdjacentLocation(getLocation())) ;
        }
        
    }

    
    
    
    
    
    public String toString(){
        return "Rabbit, " + getAge() + " y/o, at " + getLocation();
    }
    
    
    /**
     * Increase the Rabbit's age.
     * This could result in the rabbit's death.
     */
    private void incrementAge()
    {
        addAge();
        if(getAge()>Rabbit.MAX_AGE){
            setDead();    
        }    
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        if(canBreed()){
            Random temp = new Random();
            if(temp.nextDouble() < Rabbit.BREEDING_PROBABILITY){
               return temp.nextInt(Rabbit.MAX_LITTER_SIZE + 1);                                                                                                                                                                
            }
            else{return 0;}
        }
        else{
            return 0;
        }
    }

    /**
     * A rabbit can breed if it has reached breeding age.
     * @return true if the rabbit can breed, false otherwise.
     */
    private boolean canBreed()
    {
        if(getAge()>=Rabbit.BREEDING_AGE){
            return true;
        }
        else{
            return false;
        }
    }
}
