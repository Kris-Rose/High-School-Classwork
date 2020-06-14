
/**
 * To test ActorLinkedList for part2
 *
 * @Krista R
 * @10/4/19
 */
public class ListTester
{
    public static void main(String args[]){
        ActorLinkedList hollywood = new ActorLinkedList();
        hollywood.add(new Actor("Polly Pocket"));
        hollywood.add(new Actor("Joe Mama"));
        hollywood.add(new Actor("Krister"));
        hollywood.add(new Actor("Bob Ross"));
        hollywood.add(new Actor("Chalkboard"));
        
        for(int a = 0; a<hollywood.size(); a++){
            System.out.println(hollywood.get(a));
        }
        
        System.out.println("\n" + hollywood.get(0).getName());
    }
}
