//1
public class SoundLabProbs
{
    
    public SoundLabProbs() {
    }
    //2
    public void triangle(int n){
        for(int a = 0; a <= n; a++){
            for(int b = 0; b<a; b++){
                System.out.print(a);
            }
            System.out.println();
        }
    }
    //3
    public int lastIndexOf(int[] nums, int value){
        int index = -1;
        for(int a = nums.length-1; a>-1 && index == -1; a--){
            if(nums[a]==value){
                index = a;
            }
        }
        return index;
    }
    //5
    public int range(int[] nums){
        int largest = nums[0];
        int smallest = nums[0];
        for(int a = 0; a < nums.length; a++){
            if(nums[a] > largest){
                largest = nums[a];
            }
            if(nums[a] < smallest){
                smallest = nums[a];
            }
        }
        int range = largest-smallest;
        return range;
    }
    //6
    public int minDifference(int[] nums){
        int difference = Math.abs(nums[0]-nums[1]);
        for(int a = 0; a<nums.length-1; a++){
            if(Math.abs(nums[a]-nums[a+1]) < difference){
                difference = Math.abs(nums[a]-nums[a+1]);
            }
        }
        return difference;
        
    }
    //7
    public int priceIsRight(int[] bids, int price){
        int closest = -1;
        for(int a = 0; a<bids.length; a++){
            if(bids[a]<= price && bids[a] > closest){
                closest = bids[a];
            }
        }
        return closest;
    }
    //8
    public int[] productExceptSelf(int[] nums){
        int product = 1;
        for(int a = 0; a<nums.length; a++){
            product *= nums[a];
        } 
        int[] exceptI = new int [nums.length];
        for(int b = 0; b<exceptI.length; b++){
            exceptI[b] = product / nums[b];
        }
        
        return exceptI;
    }
    
}
