import java.util.*;
import java.io.*;
/**
 * 
 *
 * @Krista R
 * @10/24/19
 */
public class WordLadder
{
    
    
    public static void main(String[] args){
        //set up dictionary
        HashSet dictionary = new HashSet();
        HashSet used = new HashSet();
        char[] alphabet = {'a','b','c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        
        
        Scanner reader = null;
        try{
            reader = new Scanner(new File("input.txt") );
            Scanner allWords = new Scanner(new File("dictionary.txt") );
            while(allWords.hasNext()){
                dictionary.add(allWords.next());
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        
        //make a word ladder
        while(reader.hasNext()){
            String start = reader.next();
            String end = reader.next();
            
            if(dictionary.contains(start) ){
                if(dictionary.contains(end)){
                    if(start.length() == end.length()){
                        if(!(start.equals(end) )){
                            //all variations of word(stacks)
                            QueueLinkedList possibles = new QueueLinkedList(); 
                            //current stack looking at, use as reference type and print at end
                            StackLinkedList<String> takenOff = null;
                            StackLinkedList<String> toAddTo = null;
                            used = new HashSet();
                            //1st stacks
                            ArrayList<String> firstSimilar = findSimilar(start,dictionary,used, alphabet);
                            for(int a = 0;a<firstSimilar.size();a++){
                                toAddTo = new StackLinkedList();
                                toAddTo.push(start);
                                toAddTo.push(firstSimilar.get(a));
                                possibles.queue(toAddTo);
                            }
                            
                            //to debug
                            int countIn = 0;
                            
                            try{
                                while( ((StackLinkedList)possibles.peek()).peek() != null  && !end.equals( ((StackLinkedList)possibles.peek()).peek())   ){
                                    takenOff =  new StackLinkedList();
                                    takenOff = (StackLinkedList)possibles.dequeue();
                                    String recent = ((String)takenOff.peek());
                                    used.add(recent);
                                    
                                    firstSimilar = findSimilar(recent,dictionary,used, alphabet);
                                    
                                    countIn++;
                                    if(countIn%5 == 0  ){
                                     countIn =countIn;
                                    }
                                    
                                    //add takenOff to temp
                                    ArrayList<String> temp = new ArrayList<String>();
                                    for(int p = 0;p<takenOff.size();p++){
                                        temp.add(takenOff.pop());
                                    }
                                    
                                    //ERRERERETTGUTOR HERERER COME BACK AND FIX IT MAD ROADDTO BECOME TAKENOFF FIX IT
                                    for(int a = 0;a<firstSimilar.size();a++){
                                        //add onto taken off
                                        toAddTo = new StackLinkedList();
                                        
                                        //add takenOff to toaddTo
                                        for(int b = 0; b<takenOff.size();b++){
                                            toAddTo.push(temp.get(temp.size()-(1+b) ));
                                        }
                                        toAddTo.push(firstSimilar.get(a));
                                        possibles.queue(toAddTo);
                                    }
                                    
                                }
                            }
                            catch(Exception e){
                                System.out.println(e);
                                e.printStackTrace();
                            }
                            
                            
                             
                            
                            //rearrange and print
                            try{
                                takenOff = ((StackLinkedList)possibles.peek()) ;
                                
                                StackLinkedList last = new StackLinkedList();
                                for(int b = 0; b<takenOff.size(); b++){
                                     last.push(takenOff.pop());
                                }
                                
                                for(int c = 0; c<takenOff.size(); c++){
                                 System.out.print(last.pop().toString() + "\n");
                                }
                            }
                            catch(Exception e){
                                System.out.println(e);
                                e.printStackTrace();
                            }
                            
                            
                            
                            
                            
                            used.clear();
                            
                            System.out.println();
                        }
                        else{
                           System.out.println("Start and end are the same word " + start + "\n"); 
                        }
                    }
                    else{
                        System.out.println("The starting word(" + start + ") and the ending word(" + end + ") are not the length.");
                        System.out.println("Therefore no wordladder can be created \n");
                    }
                }
                else{
                    System.out.println("The ending word(" + end + ") is not a real word.");
                    System.out.println("The starting word is " + start + "\n");
                    
                }
            }
            else{
                System.out.println("The starting word(" + start + ") is not a real word.");
                System.out.println("The ending word is " + end + " \n" );
            }
            
            
            
        }
        
        
        
        
        
        
        
        
    }
    
    public static ArrayList<String> findSimilar(String word, HashSet dictionary, HashSet used, char[] alphabet ){
        //in dictonary
        used.add(word);
        ArrayList<String> words = new ArrayList<String>();
        for(int j = 0; j<word.length(); j++ ){
            //index is the index changed
            for(int i = 0; i<26;i++){
                if(j == word.length()-1){
                    if(dictionary.contains(word.substring(0,j) + alphabet[i]) ){
                        //not equal to original or in used
                        
                        if(!(word.equals(word.substring(0,j) + alphabet[i] )) && !(used.contains((word.substring(0,j) + alphabet[i])))){
                            words.add( word.substring(0,j) + alphabet[i] );
                            used.add((word.substring(0,j) + alphabet[i]));
                        }
                    }    
                }
                else{
                    if(dictionary.contains(word.substring(0,j) + alphabet[i] + word.substring(j+1)) ){
                        //not equal to original
                        
                        if(!(word.equals(word.substring(0,j) + alphabet[i] +word.substring(j+1))) && !(used.contains((word.substring(0,j) + alphabet[i] + word.substring(j+1) )))     ){
                            words.add( word.substring(0,j) + alphabet[i] + word.substring(j+1) );
                            used.add((word.substring(0,j) + alphabet[i] + word.substring(j+1)));
                        }
                    }
                }
                
            }
           
        }
        
        for(int i = 0; i< 0;i++){
            if( !(used.contains(words.get(1)))) {
                used.add(words.get(1));
            }
        }
        
        return words;
    }
    
}
    
    
    
    

