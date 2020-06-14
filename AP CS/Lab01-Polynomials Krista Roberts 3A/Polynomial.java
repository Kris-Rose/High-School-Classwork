//2
public class Polynomial
{
    //a
    Monomial firstTerm;
    Monomial secondTerm;
    Monomial thirdTerm;
    
    //b
    
    public Polynomial()
    {
        Monomial firstTerm;
        Monomial secondTerm;
        Monomial thirdTerm;
    }
    
    public Polynomial(Monomial first, Monomial second, Monomial third){
        firstTerm = first;
        secondTerm = second;
        thirdTerm = third;
    }
    
    public double evaluate(double x) {
        double answer = 0;
        answer += (firstTerm.coefficient * Math.pow(x,firstTerm.exponent) );
        answer += (secondTerm.coefficient * Math.pow(x,secondTerm.exponent) );
        answer += (thirdTerm.coefficient * Math.pow(x,thirdTerm.exponent) );
        return answer;
    }
    
    public String toString(){
        return (firstTerm.coefficient + "x^" + firstTerm.exponent +" + " + secondTerm.coefficient  + "x + " + thirdTerm.coefficient );
        
    }
    
    
    
    
    
    
    
    
}
