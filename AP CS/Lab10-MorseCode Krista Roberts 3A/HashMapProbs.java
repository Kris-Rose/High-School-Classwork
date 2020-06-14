import java.util.*;
//1
public class HashMapProbs
{
    public static void main(String[] args){
        //2
        HashMap<String, String> animalSounds = new HashMap<>();
        animalSounds.put("Lion","Roar");
        animalSounds.put("Mouse","Squeak");
        animalSounds.toString();
        
        //3
        System.out.println("Enter an animal name:");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        System.out.println(animalSounds.get(str));
        System.out.println();
        
        //4
        System.out.println("There are " + animalSounds.size() + "key/value pairs.");
        
        //5
        System.out.println("Enter a new animal name:");
        String newAnimal = console.nextLine();
        System.out.println("Enter a new sound:");
        String newSound = console.nextLine();
        animalSounds.put(newAnimal, newSound);
        
        //6 ¯\_(ツ)_/¯
        
        
    
        
    }
    //7
    public HashMap<String, String> mapBully(HashMap<String, String> map){
        if(map.containsKey("a")){
           String temp = map.remove("a");
           map.put("b", temp);
        }
        return map;
    }
    //8
    public HashMap<String, String> mapShare(HashMap<String, String> map){
        if(map.containsKey("a")){
           String temp = map.remove("a");
           map.put("b", temp);
        }
        if(map.containsKey("c")){
            map.remove("c");
        }
        return map
    }
    //9
    public HashMap<String, String> frequency(String filename){
        
    }
    
    
}
