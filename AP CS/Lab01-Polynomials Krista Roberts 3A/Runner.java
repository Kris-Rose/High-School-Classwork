
public class Runner
{
     public static void main(String[] args){
         Monomial first  = new Monomial(1.0, 2);
         Monomial second = new Monomial(2.0, 1);
         Monomial third  = new Monomial(3.0, 0);
        
         Polynomial poly = new Polynomial(first, second, third);

         System.out.println(poly.evaluate(4.5)); //should print: 32.25
         System.out.println(poly.toString()); 
         System.out.println(); 
         
         //1
         Monomial one  = new Monomial(4.32, 2);
         Monomial two = new Monomial(-2.12, 1);
         Monomial three  = new Monomial(3.67, 0);
         
         Polynomial fOfX = new Polynomial(one, two, three);
         System.out.println(fOfX.evaluate(2));
         System.out.println(); 
         
         //2
         Monomial medicineOne  = new Monomial(-0.05, 2);
         Monomial medicineTwo = new Monomial(2, 1);
         Monomial medicineThree  = new Monomial(2, 0);
         
         Polynomial medicine = new Polynomial(medicineOne, medicineTwo, medicineThree);
         
         System.out.println("Concentration per Hour       &      Hour"); 
         for(int a = 0;a<9; a++){
             System.out.println("     " + medicine.evaluate(a) + "                              " + a);
             
            }
         System.out.println(); 
         
         //3
         double G = 9.81;
         Monomial gravityOne  = new Monomial((-1/2)*G, 2);
         Monomial gravityTwo = new Monomial(50, 1);
         Monomial gravityThree  = new Monomial(3, 0);
         
         Polynomial projectile = new Polynomial(gravityOne, gravityTwo, gravityThree);
         double height = 0;
         double time = 0;
         for(double b = 0;height <100; b += 0.1){
             height = projectile.evaluate(b);
             time = b;
            }
         System.out.println("It is " + time+ "seconds when the projectile passes 100m."); 
            
        }
}
