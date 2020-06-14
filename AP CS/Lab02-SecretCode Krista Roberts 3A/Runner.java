import java.util.*;
//3
public class Runner
{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        //4
        StringMethods test = new StringMethods();
        //System.out.println();
        //5
        System.out.println("Hello! What is your name?");
        String name = console.nextLine();
        test.unusualHello(name);
        System.out.println();
        //6
        System.out.println("Please enter a String: ");
        String toBeRipped = console.nextLine();
        String ripped = test.stringRipper(toBeRipped);
        System.out.println("The first and last letters of " + toBeRipped + " are " + ripped);
        System.out.println();
        //7
        System.out.println("Please enter a String: ");
        String mirror = console.nextLine();
        String reflected = test.mirrorEnds(mirror);
        System.out.println("the characters at both the beginning and end of " + mirror + " are \"" + reflected + "\"");
        System.out.println();
        //8 (Riddle)
        
        //9
        System.out.println("Please enter String 'str': ");
        String str = console.nextLine();
        System.out.println("Please enter a String to check if it is in " + str + ": ");
        String sub = console.nextLine();
        Boolean checked = test.hasSub(str, sub);
        if(checked){
            System.out.println(sub + " IS in " + str + "!");
        }
        else{
            System.out.println(sub + " ISN'T in " + str + "!");
        }
        System.out.println();
        
        //10
        System.out.println("Please enter a String(ex: foobar): ");
        String fooBar = console.nextLine();
        Boolean barfoos = test.evenFooBar(fooBar);
        if(barfoos){
            System.out.println("There are an equal number of foos and bars in " + fooBar);
        }
        else{
            System.out.println("There AREN'T an equal number of foos and bars in " + fooBar);
        }
        System.out.println();
        
        //11
        System.out.println("Please enter a String of under 4 numbers: ");
        String microwaveNum = console.nextLine();
        String microwTime = test.microwaveTime(microwaveNum);
        System.out.println(microwaveNum + ">>> " + microwTime);
        System.out.println();
        
        //12
        System.out.println("Please enter a String to reverse: ");
        String toReverse = console.nextLine();
        String reversed = test.reverseWords(toReverse);
        System.out.println(toReverse + " >>>  " + reversed);
        System.out.println();
        
        //13
        System.out.println("Enter a String to add any intergers inside: ");
        String toSum = console.nextLine();
        int summed = test.sumString(toSum);
        System.out.println("the sum is " + summed);
        System.out.println();
        
        
        //SecretCode
        String somePhrase = "six perfect quality black jewels amazed the governor";
        String code = "35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49";
        System.out.println("The phrase: " + somePhrase);
        System.out.println("The code: " + code);
        SecretCode message = new SecretCode(somePhrase, code);
        System.out.println(message.decode());
    }
}
