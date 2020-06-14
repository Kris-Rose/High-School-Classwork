
public class StackTester
{
    public static void main(String[] args){
        ArrayStack test = new ArrayStack();
        //testing push method
        test.push(5);
        test.push(9);
        test.push(7);
        
        //testing toString method
        System.out.println(test.toString());
        System.out.println();
        
        //testing pop method
        System.out.print(test.pop() + " " );
        System.out.println(test.pop());
        System.out.println();
        
        //testing peek method
        test.push(11);
        System.out.println(test.peek());
        System.out.println();
        
        //testing clear method
        test.clear();
        
        //testing isEmpty method(should say it's empty)
        if(test.isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("error");
        }
        System.out.println();
        
        //testing isFull and push method 
        while(!test.isFull()){
            test.push(1);
        }
        
        //testing size method(should print 100)
        System.out.println(test.size());
        System.out.println();
        
        //testing ArrayToString
        System.out.println(test.ArrayToString());
        System.out.println();
        
        
        
        
        
        
    }
}
