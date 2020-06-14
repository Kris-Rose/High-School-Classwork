import java.util.ArrayDeque;
import java.util.*;
import java.io.*;
/**
 *Squeezebox here.
 *
 * @Krista R
 * @11/7/19
 */
public class Squeezebox
{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(new File("input.txt"));
            while(input.hasNextLine()){
                String deck = "";
                deck = input.nextLine();
                while(!(deck.equals("#"))){
                    deck += " " + input.nextLine();
                    ArrayList<ArrayDeque> piles = new ArrayList<ArrayDeque>();
                    
                    //to track file
                    for(int index = 0;index<deck.length()-1;index+=3){
                       String card = (deck.substring(index, (index+2) )); 
                       //use as a stack
                       ArrayDeque<String> pile = new ArrayDeque<>();
                       int current = 0;
                       pile.addFirst(card);
                       piles.add(pile);
                       boolean testedMoves = true;
                       boolean testTwo = true;
                       boolean madeMove = false;
                       
                       int threeMoves = 0;
                       int oneMoves = 0;
                       
                       while(testedMoves || testTwo ){
                           threeMoves = 0;
                           current = 0;
                           
                           while(current<piles.size()){
                               
                               madeMove = false;
                               if(piles.size() > 3 && current > 2 && current<piles.size()){
                                   if(cardEquals((String)((ArrayDeque)piles.get(current)).peekFirst() , (String)((ArrayDeque)piles.get(current-3)).peekFirst() )){
                                       //moves card
                                       ((ArrayDeque)piles.get(current-3)).addFirst(((ArrayDeque)piles.get(current)).removeFirst() );
                                       threeMoves++;
                                       if(((ArrayDeque)piles.get(current)).size() == 0 ){
                                           piles.remove(current);
                                        }
                                       current = 0;
                                       madeMove = true;
                                   }
                                   else{
                                       //current++;
                                    }
                               }
                               else{
                                   //current++;
                               }
                               
                               oneMoves = 0;
                               
                               if(piles.size() > 1 && current>0 && current<piles.size()){
                                   if(cardEquals((String)((ArrayDeque)piles.get(current)).peekFirst() , (String)((ArrayDeque)piles.get(current-1)).peekFirst() )){
                                       ((ArrayDeque)piles.get(current-1)).addFirst(((ArrayDeque)piles.get(current)).removeFirst() );
                                       oneMoves++;
                                       if(((ArrayDeque)piles.get(current)).size() == 0 ){
                                           piles.remove(current);
                                        }
                                       current = 0;
                                       madeMove = true;
                                   }
                                   else{
                                       //current++;
                                    }
                               }
                               else{
                                   //current++;
                                }
                               if(!madeMove){
                                   current++;
                                   
                                }
                               else{
                                   current = 0;
                                }
                               
                            }
                           /*
                           while(current < piles.size() && oneMoves < 1 ){
                               
                           }
                           
                           
                           if(oneMoves == 0 && threeMoves == 0 && testedMoves ==false && testTwo == false){
                               testThree = false;
                           }
                           else{
                               testedMoves = true;
                               testTwo = true;
                            }
                            */
                            
                           if(oneMoves == 0 && threeMoves == 0 && !testedMoves){
                               testTwo = false;
                           }
                           else{
                               testedMoves = true;
                            }
                           if(oneMoves == 0 && threeMoves == 0){
                               testedMoves = false; 
                           }
                        }
                       
               
                       
                       
                    }
                    
                    String output =  " piles remaining:" + piles.size() + "\n";
                    for(int j = 0; j<piles.size(); j++){
                        output += " " + ((ArrayDeque)piles.get(j)).size();
                    }
                    System.out.println(output);
                    
                    deck = "";
                    deck = input.nextLine();
                    
                } 
            }
        }
          catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        
        
        
        
        
    }
    
    public static boolean cardEquals(String cardA, String cardB){
        if(cardA.substring(0,1).equals(cardB.substring(0,1)) ){
            return true;
        }
        else if(cardA.substring(1).equals(cardB.substring(1))){
            return true;
        }
        else{
            return false;
        }
    }
}