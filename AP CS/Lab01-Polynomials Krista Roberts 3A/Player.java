//28
public class Player
{
    //a
    private String name;
    private int number;
    //b
    public Player()
    {
        name = "Default";
        number = -1;
    }
    //c
    public Player(String title, int digit)
    {
        name = title;
        number = digit;
    }
    //d
    public String playerInfo(){
        return "Player: " + name + ", #" + number; 
    }

}
