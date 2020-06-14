import java.util.*;
public class Toy{
    private String name;
    public Toy(String type){
        name = type;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return ("A " + name);
    }
    public boolean equals(Toy t){
        if (name == t.getName()){
            return true;
        }
        else{
            return false;
        }
    }
    //4 elettere
    
}
