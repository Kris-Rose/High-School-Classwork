//Krista Roberts
//3A
import java.util.*;
public class SoundRunner
{
    public static void main(String[] args){
        //2
        //double[] clip = {0.5, 1, 0, -1};
        //Sound.show(clip);
        //Sound.play(clip);
        
        double[] clip = Sound.pureTone(3.0, 1.0);
        Sound.show(clip);
        Sound.play(clip);
        
        
        
        
        
    }
}
