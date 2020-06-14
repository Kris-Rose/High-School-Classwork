import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class StudentTester
{
    public static void main(String[] args) throws IOException
    {
        Student a = new Student("Joe", 100009);
        Student b = new Student("Sally", 100004);
        Student c = new Student("Sam", 100007);
        Student d = new Student("Bob", 100006);

        List<Student> list = new ArrayList<>();

        list.add(a); list.add(b); list.add(c); list.add(d);

        Collections.sort(list); //this wouldn't compile if Student didn't implement Comparable!

        System.out.println(list); //implicit call to ArrayList's (and therefore Student's) toString()
        list.clear();
        
        Random id = new Random();
        
        Scanner doc = new Scanner(new File("names.csv"));
        while(doc.hasNext()){
            list.add(new Student(doc.next(), id.nextInt(100000)));
            
            
          }
        Collections.sort(list);
        System.out.println(list); 
        
        
        for(int e = 0; e<list.size()-1 ; e++){
            for(int f = e; f<list.size()-1; f++){
                if(list.get(f).compareTo(list.get(f+1))>0 ){
                    Student i = list.get(f);
                    list.set(f, list.get(f+1));
                    list.set(f+1, i);
                    
                }
                
            }
        }
        System.out.println(list); 
        
    }
}
