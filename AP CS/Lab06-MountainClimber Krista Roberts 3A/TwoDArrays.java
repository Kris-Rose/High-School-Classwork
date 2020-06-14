import java.util.*;
//2
public class TwoDArrays
{
    int[][] nums;
    
    public TwoDArrays(int[][] dArr)
    {
        nums = dArr;
    }

    //3
    public int sum(){
        int sum = 0;
        for(int r = 0; r  < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                sum += nums[r][c];
            }
        }
        return sum;
    }
    //4
    public boolean isSquare(){
        boolean square = true;
        int num = 0;
        for(int a = 0; a< nums.length ;a++){
            num = 0;
            for(int b = 0; b < nums[a].length; b++){
                num++;
            }
            if(num==nums.length){
                square = true;
            }
            else{
                square = false;
            }
        }
        return square;
    }
    //5
    public boolean inSequence(){
        boolean sequence = true;
        if(this.isSquare() == true){
            int order = 1;
            for(int r = 0; r  < nums.length && sequence == true; r++){
                for(int c = 0; c < nums[r].length && sequence == true; c++){
                    if(nums[r][c] == order){
                        sequence = true;
                        
                    }
                    else{
                        sequence = false;
                    }
                    order++;
                }
            }
            return sequence;
        }
        else{
            return false;
        }
        
    }
    //6
    public int[] closestToZero(){
        int[] index = {0,0};
        int closest = Math.abs(nums[0][0]);
        for(int r = 0; r  < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                if(Math.abs(nums[r][c]-0)< closest){
                    closest = nums[r][c];
                    index[0]= r;
                    index[1]= c;
                }
                
            }
        }
        
        return index;
    }
    //7
    public void addMatrix(int[][] other){
        for(int r = 0; r  < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                nums[r][c] += other[r][c];
            }
        }
        this.print();
        
    }
    private void print(){
        for(int[] temp : nums){
            System.out.print(Arrays.toString(temp));
        }
        
    }
    //8(riddle)the man was afraid to get mugged??
    //9
    public int columnSum(int col){
        int sum = 0;
        for(int r = 0; r  < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                try{
                      if((c) == col){
                        sum+= nums[r][c];
                    } 
                }
                catch(Exception e){
                    sum += 0;
                }
                
            }
        } 
        return sum;
    }
    //10
    public boolean isColumnMagic(){
        int longestLength = 0;
        for(int[] temp : nums){
            if(temp.length> longestLength){
                longestLength = temp.length;
            }
        }
        int[] magic = new int[longestLength];
        
        for(int r = 0; r  < nums.length; r++){
            for(int c = 0; c < nums[r].length; c++){
                magic[c] += nums[r][c];
                
                
            }
        } 
        boolean isMagic = true;
        for(int j = 0;j < magic.length-1 && isMagic == true; j++){
            if(magic[j] == magic[j+1]){
            }
            else{
                isMagic = false;
            }
        }
        return isMagic;
    }
    //11
    public boolean sameDiagonalSums(){
        boolean same = false;
        int sum1 = 0;
        int sum2 = 0;
        int increase = 0;
        int decrease = nums[0].length-1;
        for(int r = 0; r  < nums.length; r++){
            sum1+= nums[r][increase];
            sum2+= nums[r][decrease];
            increase++;
            decrease--;
        }
        if(sum1==sum2){
            same = true;
        }
        return same;
    }
}
