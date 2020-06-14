import java.lang.*;
import java.util.*;
import java.io.*;
/**
 * Simulates Card game war
 *
 * @Krista R.
 * @9-26-19
 */
public class War
{
    public static void main(String[] args){
        RingBuffer<Card> p1Deck = new RingBuffer(52);
        RingBuffer<Card> p2Deck = new RingBuffer(52);
        
        RingBuffer<Card> table = new RingBuffer(52);
        try{
            Scanner input = new Scanner( new File("war.txt"));
            //BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
            
            
            boolean valid = false;
            boolean errorThrownOrOutOfOrder = false;
            
            while(input.hasNextLine()){
                p1Deck.clear();
                p2Deck.clear();
                table.clear();
                
                int hands = 0;
                String[] p1 = (input.nextLine()).split(" ");
                String[] p2 = (input.nextLine()).split(" ");  
                
                for(int k =0;k<p1.length;k++){
                    p1Deck.enqueue(new Card(p1[k]) );
                    p2Deck.enqueue(new Card(p2[k]) );
                }
                
                while(!p1Deck.isEmpty() && !p1Deck.isEmpty() && hands<100000){
                   if(p1Deck.peek().getValue() > p2Deck.peek().getValue()){
                       while(!table.isEmpty()){
                           p1Deck.enqueue(table.dequeue());
                       }
                       p1Deck.enqueue(p1Deck.dequeue());
                       p1Deck.enqueue(p2Deck.dequeue());
                   }
                   else if(p2Deck.peek().getValue() > p1Deck.peek().getValue()){
                       while(!table.isEmpty()){
                           p2Deck.enqueue(table.dequeue());
                       }
                       p2Deck.enqueue(p1Deck.dequeue()); 
                       p2Deck.enqueue(p2Deck.dequeue());
                   }
                   else{
                        table.enqueue(p1Deck.dequeue() );
                        table.enqueue(p2Deck.dequeue() );
                   }
                   
                    
                   hands++; 
                }
                
                
                
                
                
                if(p1Deck.isEmpty()){
                    System.out.println("Player 2 wins!");
                }
                else if(p2Deck.isEmpty()){
                    System.out.println("Player 1 wins!");
                }
                else{
                    System.out.println("Tie game stopped at 100000 plays");
                }
            }
                
                
                
                
        }
            //writer.close();
        catch(Exception e){
            System.out.println("Exception" + e);
        }    
     
        
        
        
    }
}
