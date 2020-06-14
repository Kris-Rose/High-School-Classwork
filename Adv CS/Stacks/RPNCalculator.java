import java.util.Scanner;
import java.io.File;
/**
 * Write a description of class RPNCalculator here.
 *
 * @author Krista Roberts
 * @version 
 */
public class RPNCalculator
{
    public static void main(String[] args){
        ArrayStack<Double> calculator = new ArrayStack();
         
        
        try{
            Scanner input = new Scanner( new File("expressions.txt"));
            int calculations = 0;
            calculations = input.nextInt();
            input.nextLine();
            double answer;
            boolean errorThrown = false;
            
            
            while(input.hasNextLine()){
                for(int i = 0; i<calculations; i++){
                        
                    Scanner line = new Scanner(input.nextLine());
                    calculator.clear();
                    answer = 0;
                    errorThrown = false;
                    
                    while(line.hasNext()){
                        
                        //push values into the stack
                        if(line.hasNextDouble()){
                                while(line.hasNextDouble()){
                                calculator.push(line.nextDouble());
                                
                            
                            }
                            
                        }
                        
                        //calculations
                        if(line.hasNext()){
                            
                            if(calculator.isEmpty() == false){
                                    
                                double numOne = 0;
                                
                                double numTwo = calculator.pop();
                                try{
                                    numOne = calculator.pop();
                                }
                                catch(Exception e){
                                    System.out.println(e);
                                    errorThrown = true;
                                    break;
                                }
                                
                                
                                
                                String operator = line.next();
                                    
                                
                                
                                switch(operator){
                                    case "+":
                                    answer = numOne+numTwo;
                                    calculator.push(answer);
                                    break;
                                    case "-":
                                    answer = (numOne-numTwo);
                                    calculator.push(answer);
                                    break;
                                    case "/":
                                    answer = numOne / numTwo;
                                    calculator.push(answer);
                                    break;
                                    case "*":
                                    answer = numOne * numTwo;
                                    calculator.push(answer);
                                    break;
                                    default:
                                    System.out.println("Invalid");
                                    
                                
                                }
                            
                            }
                            
                            
                            
                            
                         }
                         
                        
                        
                        
                        
                        
                        
                        
                    }
                    
                     if(errorThrown == false){
                         System.out.println(answer);
                    
                    }
                    
                  }
                    
                    
                        
                    
                    
                    
                }
              
                
            }
        
        
        catch(Exception e){
                System.out.println("Exception: " + e);
        }
       
                 
                
                
                
                
    }
            
            
             
        
    
}
