

public class DistortedGuitarString
{
    private int numTics = 0;
    RingBuffer string;
    private double capacity;
    
    public DistortedGuitarString(double frequency)
    {
        capacity = Math.ceil((441000/frequency));
        string = new RingBuffer((int)capacity);
        
        for(int j = 0;j<capacity; j++){
            string.enqueue(0.0);
        }
        
    }
    public DistortedGuitarString(double[] init)
    {
        string = new RingBuffer(init.length);
        for(int i=0; i<init.length;i++){
            string.enqueue(init[i]);
        }
    }
    public void pluck(){
        
        
        for(int i = 0;i<capacity;i++){
            string.dequeue();
            string.enqueue(Math.random()-.5);
        }
        }
        
    
    public void tic(){
        numTics++;
        
        double a = (double)string.dequeue();
        double b = (double)string.peek();
        double updated = ((a+b)*.5)*0.944;
        string.enqueue(updated);
    }
    public double sample(){
        return (double)string.peek();
    }
    public int time(){
        return numTics;
    }
    
}
