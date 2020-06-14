
/**
 * Write a description of class GuitarHero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuitarHero
{
    public static void main(String[] arg){
        
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitar = new GuitarString[37];
        for(int k = 0; k<keyboard.length();k++ ){
            double frequency = 440* Math.pow(1.05956, (k-24));
            guitar[k] = new GuitarString(frequency);
        }
        
        // Create two guitar strings, for concert A and C
        //double CONCERT_A = 440.0;
        //GuitarString stringA = new GuitarString(CONCERT_A);
        //GuitarString stringC = new GuitarString(CONCERT_C);

 
        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                
                try{
                    // pluck the corresponding string
                    guitar[keyboard.indexOf(key)].pluck();
                }
                catch(Exception e){
                    System.out.println("not a key!!!");
                }
                
                
                //if (key == 'a') { stringA.pluck(); }
                //if (key == 'c') { stringC.pluck(); }
            }
            
            
            double sample = 0;
            // compute the superposition of the samples
            for(int k = 0; k<keyboard.length();k++ ){
                sample += guitar[k].sample();
            }
            
            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int k = 0; k<guitar.length;k++ ){
                guitar[k].tic();
            }
        }
        
    }
}
