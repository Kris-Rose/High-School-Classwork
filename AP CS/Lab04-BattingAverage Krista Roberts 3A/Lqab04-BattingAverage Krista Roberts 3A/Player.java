//Krista Roberts
//3A
import java.util.*;

//1
public class Player
{
    String name;
    private int number;
    private int atBats;
    private int hits;
    
    public Player(String pName, int pNum){
        name = pName;
        number = pNum;
        atBats = 0;
        hits = 0;
    }
    
    public Player(String pName, int pNum, int atB, int pHit) {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit; 
    }
    
    public double getBattingAverage(){
        double batAvg = (double)hits/atBats;
        
        while(batAvg>1){
            batAvg = batAvg/10;
        }
         return batAvg;
    }
    
    public String getBattingAverageString(){
        double rawBatAvg = getBattingAverage();
        double batAvg = rawBatAvg*100;
        batAvg = Math.round(batAvg); 
        return "" + batAvg;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getAtBats(){
        return atBats;
    }
    
    public int getHits(){
        return hits;
    }
    
    //2 riddle
    //You are a plant

}
