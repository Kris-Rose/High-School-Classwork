//Krista Roberts
//3A

//3
import java.util.*;
import java.io.*;
public class SoundClip
{
    double[] clip;
    
    SoundClip(){
        clip = null;
    }
    
    SoundClip(double[] sound){
        clip = sound;
    }
    
    //4
    void adjustVolume(double factor){
        for(int a = 0; a < clip.length; a++){
            clip[a] *= factor;
        }
    }
    
    //5
    void mix(double[] clip1, double[] clip2){
        if(clip1.length>clip2.length){
            clip = new double[clip1.length];
            double[] clipNew2 = new double[clip1.length];
            for(int b = 0; b < clip.length; b++){
                if(b < clip2.length){
                    clipNew2[b] = clip2[b];
                }
                else{
                   clipNew2[b] = 0; 
                }
            }
            
            for(int a = 0; a < clip.length; a++){
                clip[a] = clip1[a] + clipNew2[a];
            }
        }
        else{
            clip = new double[clip2.length];
            double[] clipNew1 = new double[clip2.length];
            for(int b = 0; b < clip.length; b++){
                if(b < clip1.length){
                    clipNew1[b] = clip1[b];
                }
                else{
                   clipNew1[b] = 0; 
                }
            }
            
            for(int a = 0; a < clip.length; a++){
                clip[a] = clipNew1[a] + clip2[a];
            }
        }
    }
    //6
    void append(String fileName) throws IOException {
        try{
                Scanner inFile = new Scanner(new File(fileName));
                int samples = 0;
                boolean gotIt = false;
                while(inFile.hasNext() && gotIt == false){
                    if(inFile.hasNextInt()){
                       samples = inFile.nextInt();
                       gotIt = true;
                    }
                }
                
                double[] result = new double[(samples + clip.length)];
                int b = 0;
                for(b = 0; b<clip.length; b++){
                    result[b] = clip[b];
                }
                
                int a = b;
                while(inFile.hasNext() ){
                    if(inFile.hasNextDouble()){
                       result[a] = inFile.nextDouble();
                       a++;
                    }
                }
                
                clip = result;
        }
        catch(FileNotFoundException e){
              System.out.println("\n" + fileName + " is not accessable in this folder. Please check the file name and location.\n" + e );  
        }  
    }
    //7
    void fadeIn(double seconds){
        int values = Sound.toNumSamples(seconds);
        for(int a = 0; a<clip.length; a++){
            clip[a] = (a/(double)values);
        }
        
        
    }
    //8
    void fadeOut(double seconds){
        int values = Sound.toNumSamples(seconds);
        for(int a = 1; a<values; a++){
            clip[clip.length-(values-a)] = (values/(double)a);
        }
        
    }
}
    

