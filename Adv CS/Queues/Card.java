
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private int value;
    public Card(String a)
    {
        switch(a.charAt(0) ){
            case 'T':
                value = 10;
                break;
            case 'J':
                value = 11;
                break;
            case 'Q':
                value = 12;
                break;
            case 'K':
                value = 13;
                break;
            case 'A':
                value = 14; 
                break;
            default:
                value = Integer.parseInt(a.substring(0,1));
        }
    }
    
    public int getValue(){
       return value; 
    }
    
    
}
