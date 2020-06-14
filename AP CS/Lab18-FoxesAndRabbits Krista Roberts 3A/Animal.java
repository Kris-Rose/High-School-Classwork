

public abstract class Animal{
    
	private int      age;
	private boolean  alive;
	private Field    field;
	private Location location;
    
    public int getAge(){
        return age;
    }
    public boolean isAlive(){
        return alive;
    }
    public Field getField(){
        return field;
    }
    public Location getLocation(){
        return location;
    }
    
    public void setAge(int num){
        age = num;
    }
    public void setAlive(boolean a){
        alive = a;
    }
    public void setField(Field f){
        field = f;
    }
    public void setLocation(Location a){
        location = a;
    }
    
    public void setDead()
    {
        setAlive(false);
        field.remove(location);
    }
     
    public void addAge()
    {
         age += 1;
            
    }
}
