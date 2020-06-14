import java.util.*;
import java.io.*;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 *
 *
 * @Krista R
 * @3/24/2020
 */
public class Compress
{
    public static void main(String[] args )throws IOException{

        Scanner reader = null;
        HashMap dictionary = new HashMap();
        String temp;
        LinkedList all = new LinkedList();

        //read file pt 1
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
            
            if(!dictionary.containsKey(temp)){
                dictionary.put(temp, 0); 
            }
            else{
                int tem = (int)(dictionary.get(temp) );
                tem++;
                dictionary.remove(temp);
                dictionary.put(temp, tem);
            }
            temp = reader.next();
        }

        //output
        //System.out.println("data   :  frequency"); pt 
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
        //build tree pt 2
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

        System.out.println("debugging for adding to tree \n\n" );
        
        
        
        //build encoding table pt 3(FIXTHIS)
        //all is a lintedlist that contains the treenodes
        HashMap coded = all.get(0).inOrder();
        //System.out.println("In order: " + coded);
        //iterate thru hashmap
        runThru = coded.entrySet().iterator();
        while(runThru.hasNext()){
            Map.Entry element = (Map.Entry)runThru.next(); 
            String data = (String)element.getValue(); 
            System.out.println("      " + element.getKey().toString() + ":" + data + " ");

        }
        System.out.println("debugging for making encoding table \n\n" );

        
        
        
        //exporting bits to file pt4
        BitOutputStream out = null;
        try{
            out = new BitOutputStream("EncodedOutput.txt");
            reader = new Scanner(new File("dream.txt") );
            reader.useDelimiter("");
            temp = reader.next();
            while(reader.hasNext() ){
                
                String value = (String)(coded.get(temp.charAt(0))); //get encoded val for characters for og file
                int intVal = Integer.parseInt(value,2);//change to int (value, base))
                int size = value.length();
                out.writeBits(value.length(),intVal);//export encoded value to file
                temp = reader.next();
            }
            out.close();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
            if (out != null) {
                out.close();
            }
        }
        
        
        
        
        //pt 5 - read binary file and export to diff file
        BitInputStream in = null;
        FileWriter finOut = null;
        try{
            in = new BitInputStream("EncodedOutput.txt");
            finOut = new FileWriter("finalOut.txt");
            int bit = in.readBits(1);
            TreeNode travel = all.get(0); //gets root node
            while(bit != -1){
                if( bit == 0){ //move through the tree to get the next character
                    travel = travel.getLeft();
                }
                else if(bit == 1){
                    travel = travel.getRight();
                }
                if(travel.isChar()){
                    char toSee = travel.getCharValue();
                    finOut.write(travel.getCharValue());
                    travel = all.get(0);
                }
                
                
                bit = in.readBits(1);
            }
            
           
            in.close();
            finOut.close();
        }finally{
            if (in != null) {
                in.close();
            }
            if (finOut != null) {
                finOut.close();
            }
        }
        System.out.println("\nwriting to the file.");
        
    }
}
