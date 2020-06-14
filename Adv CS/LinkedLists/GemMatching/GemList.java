import java.util.*;
import java.io.*;

public class GemList 
{
    private class Node  { 
        private Gem  gem;
        private Node next;
        
        public Node()
        {
            gem = null;
            next = null;
        }

        public Node(Gem gem)
        {
            this.gem = gem;
            next = null;
        }
        
        public Gem get(){
            return gem;
        }
        
        public void set(Gem gem){
             this.gem = gem;
        }
        
        public Node getNextPtr(){
             return next;
        }
        
        public void setNextPtr(Node next){
             this.next = next;
        }
        
        
        public String toString(){
            return gem.toString();
        }
    } 
    
    
    private int size;
    private Node head;
    public GemList(){
        head = null;
        size = 0;
    }
    
    //won't be use just used as a reference from previously written linked list class
    private void add(Gem gem){
        if(head == null){
            head = new Node(gem); 
        }
        else{
            //adds to front
            Node current = new Node (gem);
            current.setNextPtr(head);
            head = current;
        }
        
        size++;
    }
    private Gem get(int index){
        Node found = head;
        if(index> size-1){
            Exception e =  new NullPointerException("No gem Found");
            e.printStackTrace();
        }
        if(index<0){
            Exception e =  new NullPointerException("the program is glitching");
            e.printStackTrace();
        }
        else if(index == 0){
            return found.get();
        }
        else{
            for(int h = 0;h< index;h++){
                found = found.getNextPtr();
            }
        }
        
        return found.get(); 
    }
    private Node getNode(int index){
        Node found = head;
        if(index> size-1){
            return null;
        }
        else if(index == 0){
            return found;
        }
        else{
            for(int h = 0;h< index;h++){
                found = found.getNextPtr();
            }
        }
        
        return found; 
    }
    
    
    
    public int size(){
        return size;
    }
    void draw(double y){
        for (int i = 0; i < size; i++){
             Gem g = get(i);
             g.draw(0+ (i * 0.07), y);
        }
    }
    public String toString(){
        String toReturn = "";
        if(size == 0){
            toReturn = "empty list";
        }
        for(int a = 0; a<size(); a++){
            toReturn += get(a).getType()  + " ";
            if(a<size-1){
                toReturn += "-> ";
            }
        }
        return toReturn;
    }
    public void insertBefore(Gem gem, int index){
        
        if(head == null){
            head = new Node(gem); 
        }
        else if(index>= size){
            //adds to end
            
            Node current = new Node (gem);
            getNode(size-1).setNextPtr(current);
            /*current.setNextPtr(head);
            head = current;*/
        }
        else if(index <=  0){
            Node current = new Node (gem);
            Node temp = getNode(index);
            current.setNextPtr(temp);
            head = current;
        }
        else{
            Node current = new Node (gem);
            Node temp = getNode(index);
            getNode(index-1).setNextPtr(current);
            current.setNextPtr(temp);
            temp = null;
        }
        
        size++;
    }
    
    int score(){
        int total = 0;
        int inARow = 1;
        if(this.size() == 0){
            return 0;
        }
        if(this.size() == 1){
            return get(0).getPoints();
        }
        
        
        for(int a = 1; a<=size(); a++){
            //not in a group
            if(!(get(a).getType().equals(get(a-1).getType())) ){
                    int points = 0;
                     points = get(a-1).getPoints();
                    
                    total += points;
                    inARow = 1;
                    //last
                    if((a) == size()-1 && !(get(a).getType().equals(get(a-1).getType()))){
                        
                        total += get(a).getPoints();
                        break;
                    }
            }
            //in a group
            if(get(a).getType().equals(get(a-1).getType())){
                int i = 0;
                while(i<(size-a) && get(a+i).getType().equals(get(a-1+i).getType())  ){
                    inARow++;
                    i++;
                }
                
                int points = 0;
                for(int j = 0;j<inARow;j++){
                    points += get(a-1+j).getPoints();
                }
                total += (points*inARow);
                a += inARow-1;
                //if last
                if(a == size()-1 && get(a).getType().equals(get(a-1).getType())){
                    total += (inARow*get(a).getPoints());
                    break;
                }
                if(a == size()-1 && !(get(a).getType().equals(get(a-1).getType()))){
                    total += get(a).getPoints();
                    break;
                }
                inARow = 1;
                
            }
        }
        
        
        
        
            
        
        
        return total;
    }
    
    
    
    
    public static void main(String [] args)
    {
        
        
        
        
        
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);     
          
          
        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);
        
        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);
        
        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);
        
        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);
        
        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);
          
        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);
        
    }   
}
