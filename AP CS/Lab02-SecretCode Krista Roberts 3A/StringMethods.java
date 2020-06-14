import java.util.*;
//2
public class StringMethods
{
    
    public StringMethods()
    {
        
    }
    
    //5
    public void unusualHello(String name) {
        System.out.println("Hello " + name + ", you dummy!");
    
    }
    
    //6
    public String stringRipper(String str) {
        int end = str.length();
        String ripped = "";
        ripped += str.substring(0,1);
        ripped += str.substring(str.length()-1);
        return ripped;
    }
    
    //7
    public String mirrorEnds(String s){
        char[] theWord = s.toCharArray();
        String mirror = "";
        boolean proceed = true;
        for(int a = 0 ;a < (s.length())/2;a++){
            if (s.substring(a,a+1).equals( s.substring(s.length()-1-a, s.length()-a) ) && proceed == true){
                mirror += s.substring(a,a+1);
            }
            else{
                proceed = false;
            }
        }
        return mirror;
    }
    
    //9
    boolean hasSub(String str, String sub){
        boolean hasIt = false;
        for(int b = 0;b<(str.length()-(sub.length()-1));b++){
            if(str.substring(b, b+sub.length()).equals(sub)){
                hasIt =true;
            }
        }
       return hasIt;
       
    }
    
    //10
    public boolean evenFooBar(String str){
       boolean equal = false;
       int foos = 0;
       int bars = 0;
       for(int b = 0;b<str.length()-2;b++){
           if(str.substring(b, b+3).equals("foo")){
                foos++;
            }
           if(str.substring(b, b+3).equals("bar")){
                bars++;
            } 
        }
       if(foos == bars){
           equal = true;
        }
       return equal; 
    }
    
    //11
    public String microwaveTime(String str){
        String microwave = "";
        switch(str.length()){
            case 1:
            microwave += "00:0" + str;
            break;
            
            case 2:
            microwave += "00:" + str;
            break;
            
            case 3:
            microwave += "00" + str.substring(0,1) + ":" + str.substring(1);
            break;
            
            case 4:
            microwave += str.substring(0,2) + ":" + str.substring(2);
            break;
            
            default:
            microwave += "invalid input";
            break;
        }
        return microwave;
    }
    
    //12
    public String reverseWords(String str){
        String reversed = "";
        String[] words = str.split(" "); 
        for(int a = 0; a<words.length;a++){
            reversed += words[words.length-(1+a)] + " ";
            
        }
        return reversed;
    }
    
    
    //13
    public int sumString(String str){
        int sum = 0;
        Scanner console = new Scanner("f " + str);
        while(console.hasNext()){
            if(console.hasNextInt()){
                sum += console.nextInt();
            }
            else{
               console.next(); 
            }
        }
        
        return sum;
    }
    
    
}
