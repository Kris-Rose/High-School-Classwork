
public class Word{
    private String word;
    private int count;
    public Word(String w){
        word = w;
        count = 0;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getCount(){
        return count;
    }
    
    public void increment() {
        count+= 1;
    }
    
    public String toString(){
        return word + "\t\t" + count;
    }
}
