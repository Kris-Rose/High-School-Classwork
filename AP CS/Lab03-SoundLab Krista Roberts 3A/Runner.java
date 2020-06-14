//Krista Roberts
//3A
import java.util.*;
public class Runner{
    //1
    public static void main(String[] args){
        SoundLabProbs test = new SoundLabProbs();
        Scanner console = new Scanner(System.in);
        //2
        System.out.println("Q2");
        System.out.print("Enter an interger to create a triangle: ");
        int triang = console.nextInt();
        test.triangle(triang);
        System.out.println("");
        
        //3
        System.out.println("Q3");
        System.out.println("How many elements are going to be in your (int) array?");
        int arrayLength = console.nextInt();
        int element = 0;
        
        int[] list = new int [arrayLength];
        for(int a = 0; a<arrayLength ; a++){
            System.out.println("What do you want to add to your array?");
            element = console.nextInt();
            list[a] = element;
            if(a == arrayLength-2){
                System.out.println("Ok! One left!");
            }
        }
        System.out.println("");
        System.out.println("Finally enter an int to check if it's in your array and what index it is at");
        int value = console.nextInt();
        System.out.println("lastIndexOf(new int[] " + Arrays.toString(list) + ", " + value + ") >>>> " + test.lastIndexOf(list, value));
        System.out.println("");
        
        //4(Riddle)
        System.out.println("");
        
        //5
        System.out.println("Q5");
        System.out.println("How many elements are going to be in your second array?");
        arrayLength = console.nextInt();
        element = 0;
        
        int[] range = new int [arrayLength];
        for(int a = 0; a<arrayLength ; a++){
            System.out.println("What do you want to add to your array?");
            element = console.nextInt();
            range[a] = element;
            if(a == arrayLength-2){
                System.out.println("One more!");
            }
        }
        System.out.println("The range of your array is:");
        System.out.println("range(new int[] " + Arrays.toString(range) + ") >>>> " + test.range(range));
        System.out.println("");
        
        //6
        System.out.println("Q6");
        System.out.println("How many elements are going to be in your third array?");
        arrayLength = console.nextInt();
        element = 0;
        int[] neighbors = new int [arrayLength];
        for(int a = 0; a<arrayLength ; a++){
            System.out.println("What do you want to add to your array?");
            element = console.nextInt();
            neighbors[a] = element;
            if(a == arrayLength-2){
                System.out.println("One away!");
            }
        }
        System.out.println("The minimum difference of two side-by-side values in your array is:");
        System.out.println("minDifference(new int[] " + Arrays.toString(neighbors) + ") >>>> " + test.minDifference(neighbors));
        System.out.println("");
        
        //7
        System.out.println("Q7");
        System.out.println("What is the price(int)?");
        int price = console.nextInt();
        System.out.println("How many elements are going to be in your fourth array?(# of bids)");
        arrayLength = console.nextInt();
        element = 0;
         int[] bids = new int [arrayLength];
        for(int a = 0; a<arrayLength ; a++){
            System.out.println("What do you want to add to your array?");
            element = console.nextInt();
            bids[a] = element;
            if(a == arrayLength-2){
                System.out.println("One away!");
            }
        }
        System.out.println("Your bid that is closest to the price is:");
        if( test.priceIsRight(bids, price) == -1){
            System.out.println("Sorry but all of your guesses were above the price. Try again next time!");
        }
        else{
            System.out.println(test.priceIsRight(bids, price));
        }
        System.out.println("");
        
        //8
        System.out.println("Q8");
        System.out.println("How many elements are going to be in your final array?");
        arrayLength = console.nextInt();
        element = 0;
        int[] minusI = new int [arrayLength];
        for(int a = 0; a<arrayLength ; a++){
            System.out.println("What do you want to add to your array?");
            element = console.nextInt();
            minusI[a] = element;
            if(a == arrayLength-2){
                System.out.println("One away!");
            }
        }
        System.out.println("Your old array is: " + Arrays.toString(minusI) ); 
        System.out.println("Your new array is: " + Arrays.toString(test.productExceptSelf(minusI)) ); 
    }
}
