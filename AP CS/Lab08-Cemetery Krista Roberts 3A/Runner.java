//3
import java.io.*;
public class Runner
{
   public static void main(String[] args) throws IOException{
       Cemetery catacomb = new Cemetery("cemetery.txt");
       int totalAges = 0;
       int numPeople = 0;
       for(Tombstone a: catacomb.getGraves()){
           numPeople++;
           totalAges += a.getAge();
        }
       System.out.println("The adverage lifespan of the givven cemetery is "  + totalAges/numPeople);
       
       
       
    }
}
