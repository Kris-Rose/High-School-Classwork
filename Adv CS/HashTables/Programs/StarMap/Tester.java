import java.util.*;
import java.io.*;
/**
 * 
 *
 * Krista Roberts
 * 1/8/2020
 */
public class Tester
{
    public static void main(String[] args){
        StdDraw.setScale(-1,1);
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        HashTableB stars = new HashTableB(4000);
        HashTableB onlyNames = new HashTableB(4000);
        // reads the file
        fillSky(stars, onlyNames);
        
        
        
        
        //plot stars
        plotPlainStars(stars);
        StdDraw.clear(StdDraw.BLACK);
        plotByMagnitude(stars);
        
        //read constellations
        ArrayList starNames = new ArrayList();
        HashTableB space = new HashTableB(3000);
        try{
            Scanner constells = new Scanner( new File("constellations.txt"));
            //parse file
            while(constells.hasNextLine()){
                String a = constells.nextLine();
                while(!(a.equals("")) && constells.hasNextLine()){
                    String[] names = a.split(",");
                    //add lines
                    space.put(names[0],names[1]);
                    //make list of stars
                    if(!(starNames.contains(names[0]))){
                        starNames.add(names[0]);
                    }
                    
                    if(!(starNames.contains(names[1]))){
                        starNames.add(names[1]);
                    }
                    
                    
                    
                    a = constells.nextLine();
                    if(!(constells.hasNextLine())){
                        names = a.split(",");
                        //add lines
                        space.put(names[0],names[1]);
                        //make list of stars
                        if(!(starNames.contains(names[0]))){
                            starNames.add(names[0]);
                        }
                        
                        if(!(starNames.contains(names[1]))){
                            starNames.add(names[1]);
                        }
                    }
                }
                
            }

            
        }
        catch(Exception e){
           System.out.println(e);
            e.printStackTrace(); 
            
        }
        
        
        
        //plot constellations
        StdDraw.setPenColor(StdDraw.PINK);
        plotConstellations(space, starNames, onlyNames);
        
        
    }
    
    public static void plotPlainStars(HashTableB j){
        for(int k = 0;k<j.getSize();k++){
            if(j.isNull(k)){
                
            }
            else{
                LinkedList list = (LinkedList)j.getList(k);
                //traveling thru linked list
                for(int a = 0;a<list.size();a++){
                      StdDraw.filledSquare( (((Star)((Entry)list.get(a)).getValue()).getX()), (((Star)((Entry)list.get(a)).getValue()).getY()), .001);  
                }
                
            }
            
        }
    }
    
    public static void plotConstellations(HashTableB constells, ArrayList starNames, HashTableB wNames){
        
        
        Star now = new Star();
        Star temp = new Star();
        //go thru array to get name of each each star
        for(int k = 0;k<starNames.size();k++){
            
            
            String current = (String)(starNames.get(k));
            
            
            
            //go thru space's list for individual constellation to find maching stars to graph
            LinkedList list = (LinkedList)constells.get(current);
            if(!(list == null)){
                for(int b = 0; b < list.size(); b++){
                    //find star that connects with current
                    String match =  (String)(((Entry)list.get(b)).getValue());
                    
                    //now = (LinkedList)wNames.getList(current);
                    //temp = ((LinkedList)wNames.getList(match));
                    
                    //go  thru stars to get position data
                    for(int i = 0;i<wNames.getCapacity();i++){
                        // go thru linked lists
                        if(wNames.isNull(i)){
                            
                        }
                        else{
                            LinkedList bist = (LinkedList)wNames.getList(i);
                            
                            for(int h = 0;h<bist.size();h++){
                                
                                if(  (((Star)((Entry)bist.get(h)).getValue()).hasName()) == false ){
                                }
                                else if( ( (String)((Star)((Entry)bist.get(h)).getValue()).getName() ).equals(current) ){    
                                     now = ((Star)((Entry)bist.get(h)).getValue());
                                     
                                     
                                }
                                else if( ((String)(((Star)((Entry)bist.get(h)).getValue()).getName())).equals(match) ){    
                                     temp = ((Star)((Entry)bist.get(h)).getValue());
                                }
                                
                            }
                        }
                        
                        
                        
                        
                    }
                    StdDraw.line(now.getX(), now.getY(), temp.getX(), temp.getY());
                    
                    
                }
            }
            
            
        }
    }
    
    public static void plotByMagnitude(HashTableB j){
        for(int k = 0;k<j.getSize();k++){
            if(j.isNull(k)){
            }
            else{
                LinkedList list = (LinkedList)j.getList(k);
                //traveling thru linked list
                for(int a = 0;a<list.size();a++){
                      double mag = Math.abs( (((Star)((Entry)list.get(a)).getValue()).getMag()) );
                      mag = Math.round(10.0/(mag +2));
                    
                      StdDraw.filledSquare( (((Star)((Entry)list.get(a)).getValue()).getX()), (((Star)((Entry)list.get(a)).getValue()).getY()), mag/500);  
                }
                
                
                
            }
            
        }
    }
    
    public static void clearSky(){
        StdDraw.clear(StdDraw.BLACK);
    }
    
    public static void fillSky(HashTableB sky, HashTableB wName){
        try{
            Scanner stars = new Scanner( new File("stars.txt"));
            while(stars.hasNextLine()){
                String[] values = stars.nextLine().split(" ");
                
                int length = values.length;
                Star temp;
                if(length == 6){
                    temp = new Star(Double.parseDouble(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Integer.parseInt(values[3]),Double.parseDouble(values[4]),Integer.parseInt(values[5]));
                    sky.put(temp.getHDnum(),temp);
                }
                else{
                    //has name(s)
                    //format names
                    String name = "";
                    for(int a = 6;a<values.length;a++){
                        name +=values[a] + " ";
                    }
                    String names[] = name.split(";");
                    for(int a = 0;a<names.length;a++){
                        if((names[a].substring(names[a].length()-1)).equals(" ")  ){
                            String fixed = names[a].substring(0, names[a].length()-1);
                            names[a] = fixed;
                        }
                        if((names[a].substring(0, 1).equals(" ") )){
                            String fixed = names[a].substring(1);
                            names[a] = fixed;
                        }
                        
                    }
                    
                    
                    
                    //make and add new star with name
                    for(int a = 0;a<names.length;a++){
                        temp = new Star(Double.parseDouble(values[0]),Double.parseDouble(values[1]),Double.parseDouble(values[2]),Integer.parseInt(values[3]),Double.parseDouble(values[4]),Integer.parseInt(values[5]), names[a]);
                        sky.put(temp.getHDnum(),temp);
                        wName.put(temp.getName(), temp);
                    }
                    
                    
                }
                
                
                
                
            }
            
        }
        catch(Exception e){
           System.out.println(e);
            e.printStackTrace(); 
            
        }
    }
    
}
