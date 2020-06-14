import java.awt.Color;
/**
 * Write a description of class PhotoMagicDeluxe here.
 *
 * @Krista R
 * @5-15-20
 */
public class PhotoMagicDeluxe
{
    public static Picture transform(Picture pic, String pass, int tap){
        String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String seed = "";
        for(int a = 0; a<pass.length();a++){
            int index = 0;
            if(a == pass.length()-1){
                index = base64.indexOf(pass.substring(a));
            }
            else{
                index = base64.indexOf(pass.substring(a,a+1));
            }
            String bin = Integer.toString(index, 2);
            while(bin.length()<6){
                bin = "0"+bin;
            }
            
            seed = seed + bin;
        }
        
        LFSR lock = new LFSR(seed, tap);
        
        Picture done = PhotoMagic.transform(pic,lock );
        return done;
    }
    
    
    public static void main(String[] args){
        Picture pipe = new Picture("mystery.png");
        pipe.show();
        
        Picture changed = transform(pipe,"OPENSESAME", 58);
        changed.show();
        int a = 8;
        
        
        
    }
}
