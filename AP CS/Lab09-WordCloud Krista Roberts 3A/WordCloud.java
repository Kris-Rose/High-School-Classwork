import java.util.*;
import java.io.*;
public class WordCloud{
    private ArrayList<Word> words = new ArrayList<Word>();
    private ArrayList<Word> topHits = new ArrayList<Word>();
    private int totalWords;
    private int uniqueWords ;
    
    public WordCloud(String fileName) throws IOException {
        Scanner doc = new Scanner(new File(fileName));
        doc.useDelimiter(" ");
        load(fileName);
        
    }
    private int getIndex(String str){
        int index = -1;
        Boolean found = false;
        for(int a = 0; a<words.size() && found == false; a++){
            if (words.get(a).getWord().equals(str) ){
                index = a;
                found = true;
            }
        }
        return index;
    }
    private void load(String fileName)throws IOException{
        Scanner doc = new Scanner(new File(fileName));
        int total = 0;
        int uniqueNum = 0;
        while(doc.hasNext()){
            String t = doc.next();
            String lowerC = t.toLowerCase();
            String goodStart = "";
            if(Character.isLetterOrDigit(lowerC.charAt(0)) == false && lowerC.length()==1){
                
            }
            else{
                total++;
                if (Character.isLetterOrDigit(lowerC.charAt(0))){
                    goodStart = lowerC;
                }
                else{
                    goodStart = lowerC.substring(1);
                }
                String goodEnd = "";
                if (Character.isLetterOrDigit(goodStart.charAt(goodStart.length()-1))){
                    goodEnd = goodStart;
                }
                else{
                    goodEnd = goodStart.substring(0, goodStart.length()-1);
                }
                if(getIndex(goodEnd) == -1){
                    Word unique = new Word(goodEnd);
                    words.add(unique);
                    uniqueNum++;
                }
                else{
                    words.get(getIndex(goodEnd)).increment();
                }
            }
            
           
            
            
            
        }
        totalWords = total;
        uniqueWords = uniqueNum;
        getTopHits();
        
        printInfo();
        
    }
    public ArrayList<Word> getTopHits() {
        int topFrequency = 0;
        int index = 0;
        for(int a = 0; a<30; a++){
            topFrequency = words.get(0).getCount();
            index = 0;
            for(int b = 0; b< words.size(); b++){
                if(words.get(b).getCount()> topFrequency){
                    topFrequency = words.get(b).getCount();
                    index = b;
                }
            }
            topHits.add(words.get(index));
            words.remove(index);
        }
        return topHits;
    }
    public void printInfo() {
        System.out.println("Number of unique words >>> " + uniqueWords);
        System.out.println("Total # of words >>>" + totalWords);
        System.out.println("\t Word \t Frequency");
        for(int a = 0; a<topHits.size();a++){
            System.out.println((a+1) + "\t" + topHits.get(a));
            
        }
        
    }
    
}
