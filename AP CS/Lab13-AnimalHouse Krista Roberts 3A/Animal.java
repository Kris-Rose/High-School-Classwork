import java.util.*;
public class Animal{
    private String name; 
    private int birthYear;
    private static int currentYear = 2019;
    private Animal friend;
    private ArrayList<Toy> toyChest = new ArrayList<Toy>();
    
    public Animal(String n, int birth){
        name = n;
        birthYear = birth;
    }
    public String getName(){
        return name;
    }
    
    public void addToy(Toy fun){
        toyChest.add(fun);
    }
    public void removeToy(Toy t){
        toyChest.remove(t);
    }
    public ArrayList<Toy> getToys(){
        return toyChest;
    }
    public Toy getToy(int i){
        return toyChest.get(i);
    }
    
    public void setFriend(Animal pal){
        friend = pal;
    }
    public boolean hasFriend(){
        if (friend == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int getAge(){
        return currentYear-birthYear;
    }
    public String toString(){
        String s = "Hello, I am " + name + ". I am " + getAge() + " years old.";
        if(this.hasFriend()){
            s += "\n I have a friend named " + friend.getName();
        }
        else{
             s += "\n I have no friends";
        }
        s+= "\n I have the following toys:" + toyChest.toString();
        return s;
    }
    public int numToys(){
        return toyChest.size();
    }
    
    
}
