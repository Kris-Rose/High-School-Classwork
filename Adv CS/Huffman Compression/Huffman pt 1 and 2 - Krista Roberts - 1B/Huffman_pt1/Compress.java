import java.util.*;
import java.io.*;
/**
 *
 *
 * @Krista R
 * @3/24/2020
 */
public class Compress
{
    public static void main(String[] args ){

        Scanner reader = null;
        HashMap dictionary = new HashMap();
        String temp;
        LinkedList all = new LinkedList();
        
        //read file
        try{
            reader = new Scanner(new File("dream.txt") );
            reader.useDelimiter("");
            

        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
            }
        temp = reader.next();
        while(reader.hasNext() ){
             temp = reader.next();
            if(!dictionary.containsKey(temp)){
                dictionary.put(temp, 0); 
            }
            else{
                int tem = (int)(dictionary.get(temp) );
                tem++;
                dictionary.remove(temp);
                dictionary.put(temp, tem);
            }

        }
        
        //output
        //System.out.println("data   :  frequency");
        Iterator runThru = dictionary.entrySet().iterator();
        
        while(runThru.hasNext()){
            Map.Entry element = (Map.Entry)runThru.next(); 
            int data = (int)element.getValue(); 
            System.out.println("      " + element.getKey().toString() + ":" + data + " ");
            all.add(new TreeNode(element.getKey().toString().charAt(0), data) );
            
        }
        System.out.println("frequency of chracters from dream.txt \n");
        
        
        //check linked list
        TreeNode tep = all.getHead();
        for(int b = 0;b<all.size();b++){
            System.out.println(tep.toString());
            tep = tep.getNext();
        }
        System.out.println("values in linkedlist \n \n");
        
        boolean finished = false;
        //build tree
        while(all.size()>1 && finished == false){
            TreeNode smallest = all.getSmallest();
            all.removeSmallest();
            if(all.size() == 1){
                finished = true;
            }
            
            TreeNode secondSmall = all.getSmallest();
            all.removeSmallest();
            
            String newName = "";
            if(smallest.isChar()){
                newName = newName +  smallest.getCharValue();
            }else{
                newName = newName + smallest.getValue();
            }
            if(secondSmall.isChar()){
                newName = newName + " + " + secondSmall.getCharValue();
            }else{
                newName = newName + " + " + secondSmall.getValue();
            }
            
            TreeNode toAdd = new TreeNode(newName, (smallest.getFreq()+secondSmall.getFreq()) );
            smallest.setParent(toAdd);
            secondSmall.setParent(toAdd);
            toAdd.setLeft(smallest);
            toAdd.setRight(secondSmall);
            
            System.out.println(toAdd.toString() );
            all.add(toAdd);
        }
    }
}
