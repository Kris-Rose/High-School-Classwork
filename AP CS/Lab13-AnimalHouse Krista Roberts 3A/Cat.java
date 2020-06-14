
public class Cat extends Animal{
    private int numLives;
    public Cat(String n, int birth, int lives){
        super(n, birth);
        numLives = lives;
    }
    public Cat(String n, int birth){
        this(n, birth, 9);
    }
    public String toString(){
        String s = super.toString();
        s += "\n I have " + numLives +" lives remaining \n\n";
        return s;
    }
}
