//1
import java.util.*;
public class ArrayListProbs
{
    public ArrayListProbs(){
    }
    //3
    public void makeListAndPrint(int num, int limit){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int a = 0; a<num; a++){
            list.add(random.nextInt(limit)+1);
        }
        System.out.println(list);
    }
    //4
    public ArrayList<Integer> minToFront(ArrayList<Integer> list){
        int smallest = list.get(0);
        for(int a: list){
            if(a < smallest){
                smallest = a;
            }
        }
        list.add(0, smallest);
        return list;
    }
    //5
    public ArrayList<Integer> addOne(ArrayList<Integer> list){
        for(int a = 0; a < list.size(); a++){
            list.set(a, (list.get(a)+1) );
        }
        return list;
    }
    //6
    public ArrayList<String> removeDupes(ArrayList<String> list){
        for(int a = 1; a<list.size(); a++){
            if(list.get(a).equals(list.get(a-1))){
                list.remove(a-1);
                a--;
            }
        }
        return list;
    }
    //7
    public ArrayList<Integer> swapPairs(ArrayList<Integer> list){
        int temp = 0;
        for(int a = 0; a<list.size(); a+= 2){
            temp = list.get(a+1);
            list.set(a+1, list.get(a));
            list.set(a, temp);
        }
        return list;
    }
    //8
    public ArrayList<String> removeLenN(ArrayList<String> list, int n){
        for(int a = 0; a<list.size(); a++){
            if(list.get(a).length() == n){
                list.remove(a);
                a--;
            }
        }
        return list;
    }
    //9.	(Riddle) I am the beginning of everything, the end of time and space, the beginning of every end, and the end of every place. What am I?
    //you are e
    //11
    public int dumbestPerson(ArrayList<Person> list){
        int dumbDumbIndex = 0;
        Person dumbDumb = list.get(0);
        for(int a = 0; a<list.size(); a++){
            if(list.get(a).getIQ()<dumbDumb.getIQ()){
                dumbDumbIndex = a;
                dumbDumb = list.get(a);
            }
        }
        return dumbDumbIndex;
    }
    //13
    public Book highestPricedBook(ArrayList<Book> list){
        Book costTooHigh = list.get(0);
        for(int a = 0; a<list.size(); a++){
            if(list.get(a).getPrice()>costTooHigh.getPrice()){
                costTooHigh = list.get(a);
            }
        }
        return costTooHigh;
    }
    //14
    public ArrayList<Book> banBook(ArrayList<Book> list, Book book){
        for(int a = 0; a<list.size(); a++){
            if(list.get(a).getTitle().equals(book.getTitle())){
                list.remove(a);
            }
        }
        return list;
    }
    //16
    public double bookstoreValue(Bookstore store) {
        double totValue = 0;
        int size = store.numBooks();
        for(int a = 0; a<size; a++){
            totValue += store.getBook(a).getPrice();
        }
        return totValue;
    }
    //17
    //The CPU of a computer
}
