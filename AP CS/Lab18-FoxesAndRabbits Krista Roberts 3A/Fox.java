

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox extends Animal
{
	/* Characteristics shared by all foxes (static fields). */

	private static final int    BREEDING_AGE = 10;
	private static final int    MAX_AGE = 20;
	private static final double BREEDING_PROBABILITY = 0.17;
	private static final int    MAX_LITTER_SIZE = 4;
	private static final int    RABBIT_FOOD_VALUE = 8;

	/* Individual characteristics (instance fields). */

	private int      foodLevel;

	/**
	 * Create a fox. A fox is created as a new born (age zero
	 * and not hungry).
	 */
	public Fox(Field field, Location location)
	{
		this.setAge(0);
        setAlive(true);
        foodLevel = Fox.RABBIT_FOOD_VALUE;
        setField(field);
        setLocation(location);
	}

	/**
	 * This is what the fox does most of the time: it hunts for rabbits. 
	 * In the process, it might breed, die of hunger, or die of old age.
	 */
	public void hunt()
	{
		incrementAge();
		if(isAlive() == false){
            return;
        }
		if(canBreed()){
            int babies = breed();
            for(int a = 0; a<babies;a++){
                if(getField().freeAdjacentLocation(getLocation()) != null){
                    getField().place( new Fox(getField(),getLocation()), getField().freeAdjacentLocation(getLocation()));
                }
            }
        }
		if(findFood() != null){
		    setLocation( findFood());
		}
		 else if(getField().freeAdjacentLocation(getLocation()) == null){
            setDead();
        }
        else{
           setLocation( getField().freeAdjacentLocation(getLocation())) ;
        } 
		      
        
	}

	/**
	 * Increase the age. This could result in the fox's death.
	 */
	private void incrementAge()
	{
		addAge();
        if(getAge()>Fox.MAX_AGE){
            setDead();    
        } 
	}

	/**
	 * Make this fox more hungry. This could result in the fox's death.
	 */
	private void incrementHunger()
	{
		--foodLevel;
		if(foodLevel<0){
		    setDead();
		  }
	}

    
    public String toString(){
        return "Fox, " + getAge() + " y/o, at " + getLocation();
    }
   
	
	/**
	 * Tell the fox to look for rabbits adjacent to its current location.
	 * @return Where food was found, or null if it wasn't.
	 */
	private Location findFood()
	{
		List<Location> adjacentLocations = getField().adjacentLocations(this.getLocation());

		for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
		{
			Object animal = getField().getObjectAt(where);

			if (animal instanceof Rabbit) { //if this object is a rabbit...
				Rabbit rabbit = (Rabbit) animal;

				rabbit.setDead();

				this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

				return where;
			}
		}
		return null;
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * @return The number of births (may be zero).
	 */
	private int breed()
	{
		if(canBreed()){
            Random temp = new Random();
            if(temp.nextDouble() < Fox.BREEDING_PROBABILITY){
               return temp.nextInt(Fox.MAX_LITTER_SIZE + 1);                                                                                                                                                                
            }
            else{return 0;}
        }
        else{
            return 0;
        }
	}

	/**
	 * A fox can breed if it has reached breeding age.
	 */
	private boolean canBreed()
	{
		if(getAge()>= Fox.BREEDING_AGE){
            return true;
        }
        else{
            return false;
        }
	}
}
