import java.util.*;
public class SearchSort
{
    private int[] nums;
    public SearchSort(int[] nums){
        this.nums = nums;
    }
    public SearchSort(int size){
        nums = new int[size];
        initArray();
    }
    public void initArray(){
        Random p = new Random();
        for(int a = 0; a< nums.length ;a++){
            nums[a] = p.nextInt(1000)+1;
        }
        
    }
    
    //1
    private void swap(int i, int j){
        int a = nums[j];
        nums[j] = nums[i];
        nums[i] = a;
    }
    
    //2
    public int linearSearch(int key){
        boolean found = false;
        int lock = -1;
        for(int b = 0; b<nums.length && found == false; b++){
            if(nums[b] == key){
                lock = b;
                found = true;
            }
        }
        return lock;
    }
    
    //3
    //a
    public int binarySearch(int key){
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length -1;
        boolean found = false;
        int lock = -1;
        while(high > low && found == false){
            int mid = (high-low)/2;
            if(nums[mid] == key){
                lock = (high-low)/2;
                found = true;
            }
            else{
                if(key> nums[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
                
        }
        return lock;
    }
    //b
    public int setUpBinarySearchRecursive(int key){
        Arrays.sort(nums);
        int low= 0, high = nums.length-1;
        return binarySearchRecursive(key, low, high);
    }
    
    
    private int binarySearchRecursive(int key, int low, int high){
        int mid = (high-low)/2;
        if(high > low ){
            
            if(nums[mid] == key){
                return mid;
            }
            else{
                if(key> nums[mid]){
                    return binarySearchRecursive(key, mid+1,  high);
                }
                else{
                    return binarySearchRecursive(key, low, mid-1);
                }
            }
            
        }
        else{
            return -1;
        }
        
    }
    
    //4
    public void bubbleSort(boolean print){
        int lowIndex = 0;
        for(int a = 0; a<nums.length-1 ; a++){
            if(print){
                System.out.println("Round " + a + ":");
            }
            
            
            for(int b = a; b<nums.length-1; b++){
                if(print){
                    System.out.println( Arrays.toString(nums));
                } 
                if(nums[b]>nums[b+1]){
                    swap(b, b+1);
                }
                
            }
        }
    }
    
    //6
    public void selectionSort(boolean print){
        for(int a = 0; a<nums.length-1 ; a++){
            if(print){
                System.out.println("Round " + a + ":");
            }
            int lowIndex = a;
            for(int b = a; b<nums.length; b++){
                
                if(nums[b]<nums[lowIndex]){
                    lowIndex = b;
                }
                
            }
            if(print){
                    System.out.println( Arrays.toString(nums));
                } 
            swap(a, lowIndex);
        }
    }
    
    //7
    public void insertionSort(boolean print){
        for(int a = 1; a<nums.length ; a++){
            int location  = a;
            if(print){
                System.out.println("Round " + a + ":");
            }
            
            for(int b = a; b>0; b--){
                if(nums[location]< nums[location-1]){
                    swap(location, location-1);
                    location--;
                }
                if(print){
                    System.out.println( Arrays.toString(nums));
                } 
            }
            
        }
    }
    
    //8
    public void mergeSort(boolean print){
        
    }
    public void mergeSortStep2(boolean print){
        
    }
    
}
