import java.awt.Color;
/**
 * 
 *
 * @Krista R
 * @5-15-2020
 */
public class PhotoMagic
{
    public static Picture transform(Picture pic, LFSR lfsr){
        int height = pic.height();
        int width = pic.width();
        for(int a = 0;a<width;a++){
            for(int b= 0; b<height;b++){
                Color shade = pic.get(a,b);
                int red = shade.getRed();
                int green = shade.getGreen();
                int blue = shade.getBlue();   //geting info
                
                int redNew = lfsr.generate(8);
                int greenNew = lfsr.generate(8);
                int blueNew = lfsr.generate(8);
                
                int redFinal = red ^ redNew;
                int greenFinal = green ^ greenNew;
                int blueFinal = blue ^ blueNew;
                
                //new color
                Color changed = new Color(redFinal, greenFinal, blueFinal);
                pic.set(a,b,changed);
                
            }
            
        }
        
        return pic;
    }
    
    public static void main(String[] args){
        Picture pipe = new Picture("pipe.png");
        pipe.show();
        
        LFSR lock = new LFSR("01101000010100010000", 16);
        Picture changed = transform(pipe, lock);
        changed.show();
        
        
        LFSR key = new LFSR("01101000010100010000", 16);
        Picture fin = transform(changed, key);
        fin.show();
        
    }
}
