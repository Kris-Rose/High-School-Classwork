import java.util.*;
//1
public class Tester
{
    //2
    public static void main(String[] args){
        
        
        //3
        System.out.println("Hello again, world!");
        System.out.println();
        //4
        //the above prints "Hello again, world!"
        //5
        int numApples = 200;
        //6
        final int PRICE_OF_APPLES =2502;
        //7
        System.out.println("The total for " + numApples + " apples: \n " + numApples*PRICE_OF_APPLES +" cents");
        //8
        if((numApples*PRICE_OF_APPLES) > 2000)
          System.out.println("Thank you valued customer!");
          System.out.println();
        //9
        for(int a = 1;a<13;a++){
          System.out.print(a + " ");
            
        }
          System.out.println();
        //10  
        for(int b = 1; b<10; b++){
          System.out.print(b*b + ", ");
            
        }
          System.out.println();
        //11
        for(int c = 1; c<300; c =(c*4)){
          System.out.print(c + " ");
            
        }
          System.out.println();
        //12(riddle) 
        System.out.println();
        //13
        Scanner console = new Scanner(System.in);
        //14
        System.out.println("Enter a name: ");
        String name = console.nextLine();
        //15
        System.out.println("There are " + name.length() + " letters in " + name);
        System.out.println();
        //16
        int sum = 0;
        int input = 1;
        int iterations = 0;
        System.out.println("Enter 0 to exit the loop ");
        while(input != 0){
            System.out.println("Enter an int: ");
            input = console.nextInt();
            sum+= input;
            iterations++;
        }
        iterations--;
        System.out.println("The sum of your inputs is " + sum + " and the average is " + (double)sum/iterations);
        //17
        double[] areas;
        areas = new double[20];
        //18
        areas[0] = 4.56;
        //19
        int length = areas.length;
        //20
        areas[length-1] = 8.08;
        //21
        boolean[] values = {true, true, false, false, true};
        //22(riddle)
        //27
        method();
        
        System.out.println("Enter an integer");
        int first = console.nextInt();
        System.out.println("Enter another integer");
        int second = console.nextInt();
        System.out.println("The sum of your ints is " + sum(first, second));
        
        System.out.println("Enter a String");
        String firstS = console.nextLine();
        System.out.println("Enter another String");
        String secondS = console.nextLine();
        System.out.println("The longer String is " + longer(firstS, secondS));
        
        System.out.println("Enter a String");
        String capitialization = console.nextLine();
        System.out.println(altCaps(capitialization));
        
        //29
        Player personOne = new Player();
        Player personTwo = new Player("Krista", 3);
        personOne.playerInfo();
        personTwo.playerInfo();
        
    }
    
    //23
    public static void method(){
        System.out.println("This is a method!");
    }
    
    //24
    public static int sum(int a, int b){
        return (a+b);
    }
    
    //25
    public static String longer(String a, String b){
        if(a.length()> b.length()){
            
            return a;
        }
        else{
            return b;
        }
    }
    
    //26
    public static String altCaps(String c){
        int letterCount = 1;
        String result = "";
        char letter;
        for(int i = 0;i<c.length();i++){
           if (Character.isLetter(c.charAt(i))){
               if(letterCount%2 == 0){
                   if (c.charAt(i)<91){
                       letter = (char)(c.charAt(i)+32);
                    }
                   else{
                       letter = c.charAt(i);
                    }
                }
                else{
                   if (c.charAt(i)>96){
                       letter =(char)(c.charAt(i)-32);
                    }
                   else{
                       letter = c.charAt(i);
                    } 
                    
                }
               result += letter;
               letterCount += 1;
              }
           else{
               result += c.charAt(i);
               
            }
        }
        return result;
    }
    
   
}
