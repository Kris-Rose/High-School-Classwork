
import java.util.*;
public class SecretCode
{
    String key;
    String code;
    
    public SecretCode(String daKey, String daCode){
      key = daKey;
      code = daCode;
    }
    
    public String decode(){
        char[] text = key.toCharArray();
        char[] index = code.toCharArray();
        String numbers = "g ";
        for(int a = 0;a<index.length ; a++){
            numbers += index[a];
        }
        Scanner location = new Scanner(numbers);
        
        String decoded = "";
        while(location.hasNext()){
            if(location.hasNextInt()){
                decoded += text[location.nextInt()];
            }
            else{
               location.next();   
            }
        }
        
        
        return decoded;
    }
}
