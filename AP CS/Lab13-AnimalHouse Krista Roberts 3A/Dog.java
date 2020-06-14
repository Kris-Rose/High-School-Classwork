
public class Dog extends Animal{
    private boolean goodBoy;
    public Dog(String n, int birth, boolean isGood){
        super(n, birth);
        goodBoy = isGood;
    }
    public String toString(){
        String s = super.toString();
        if(goodBoy){
            s += "\n I've been a very good boy !!! :] \n\n";
        }
        else{
            s += "\n I've been a bad boy :[ \n\n";
        }
        return s;
    }
}
