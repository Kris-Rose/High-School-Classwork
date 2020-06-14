import java.util.*;
public class Main
{
    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        //1
        System.out.println("How many bunnies do you have?");
        int buns = num.nextInt();
        System.out.println(numEars(buns));
        System.out.println();
        
        //2
        System.out.println("How much time is left?(int)");
        int temp = num.nextInt();
        countdown(temp);
        System.out.println();
        System.out.println();
        
        //3
        System.out.println("Enter a factorial");
        temp = num.nextInt();
        
        System.out.println(factorial(temp) );
        System.out.println();
        
        //4
        
        System.out.println("What do you what to say?");
        num.nextLine();
        String meh = num.nextLine();
        System.out.println("How many times will you say it?");
        temp = num.nextInt();
        System.out.println(cheerlead(meh, temp) );
        System.out.println();
        
        //5
        System.out.println("What is the base number?");
        temp = num.nextInt();
        System.out.println("What is the exponent?");
        int temporary = num.nextInt();
        System.out.println(exponent(temp, temporary));
        System.out.println();
        
        //7
        System.out.println("What nth number of the fibonacci sequence do you want?");
        temp = num.nextInt();
        System.out.println(fib(temp));
        System.out.println();
        
        //8
        System.out.println("Enter a number");
        temp = num.nextInt();
        printPattern(temp);
        
        //9
        System.out.println();
        //10
        System.out.println("What is the smallest number?");
        temp = num.nextInt();
        System.out.println("What is the largest number?");
        temporary = num.nextInt();
        System.out.println("What will you increment by?");
        int g = num.nextInt();
        printAtoBbyC(temp, temporary, g);
        
        //11
        System.out.println("Enter a number to find out how many of its digits are odd");
        temp = num.nextInt();
        System.out.println(odds(temp));
        System.out.println();
        
        //12
        System.out.println("Enter a number to get the sum of its digits");
        temp = num.nextInt();
        System.out.println(sum(temp));
         
        
    }
    //1
    public static int numEars(int bunnies){
        if(bunnies == 1)
        {
            return 2;
        }
        else{
            return 2 + numEars(bunnies - 1);
        }
    }
    
    //2
    public static void countdown(int num){
        if(num == 0){
            System.out.print(" blastoff!");
        }
        else{
            System.out.print("" + num + ", ");
            countdown(num-1);
        }
    }
    
    //3
    public static int factorial(int base){
        if(base == 1){
            return 1;
        }
        else{
            return base * factorial((base-1));
        }
    }
    
    //4
    public static String cheerlead(String str, int i){
        
        if(i == 1){
            return str;
        }
        else{
            
            return str + " " + cheerlead(str, i - 1);
        }
    }
    
    //5
    public static int exponent(int base, int pwr){
        if (pwr == 0){
            return -1;
        }
        if(pwr == 1){
            return base;
        }
        else{
            return base * exponent(base, pwr-1);
        }
    }
    
    //6 They arrest the fire man because he's lying about robbing the bank> lier lir pants on fire> he's on fire> he's a fireman
    
    //7
    public static int fib(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else{
            return fib(n - 2) + fib(n-1);
        }
    }
    
    //8
    public static void printPattern(int n){
        int count = 4;
        if(count == 0){
            
        }
        else{
            System.out.print(n + ", ");
            count--;
            printPattern(n-5);
        }
    }
    
    //9
    public static int countNumA(String a){
        int as = 0;
        if(a.length() == 1){
            //if(){
                
           // }
        }
        else{
            
        }
        
        return as;
    }
    
    //10
    public static void printAtoBbyC(int a, int b, int c){
        if(a == b){ 
            
        }
        else{
            System.out.print(a + " ");
            printAtoBbyC( a+c, b, c);
        }
        
        
    }
    
    //11
    public static int odds(int x){
        
        if (x == 0){
            return 0;
        }
        else{
            if((x%10)%2 != 0){
                return 1 + odds(x/10);
            }
            else{
                return 0 + odds(x/10);
            }
            
        }
        
    }
    
    
    
    
    
    //12
    public static int sum(int x){
        if (x == 0){
            return 0;
        }
        else{
            return (x%10) + sum(x/10);
        }
    }
    
    
    
    
    
}