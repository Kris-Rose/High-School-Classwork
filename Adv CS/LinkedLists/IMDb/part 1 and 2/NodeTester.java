
/**
 * To test actor class for part 1
 *
 * @Krista R
 * @10/8/19
 */
public class NodeTester
{
    public static void main(String args[]){
        //oof is at beginning because pointer is null
        //head points is beginning of list(is inverted when created)
        //1st part
        Actor oof = new Actor("Bob the Builder");
        Actor head = oof;
        Actor second = new Actor("Harini");
        head = second;
        second.setNextPtr(oof);
        Actor third = new Actor("Ellllllllla");
        head = third;
        third.setNextPtr(second);
        Actor fourth = new Actor("Dat Boi M.D.");;
        head = fourth;
        fourth.setNextPtr(third);
        Actor fifth = new Actor("Senor Yikes");
        head = fifth;
        fifth.setNextPtr(fourth); 
        
        //2nd part
        Actor current = head;
        while(current != null){
            System.out.println(current.toString());
            current = current.getNextPtr();
        }
        
        //last
        System.out.println(head.toString());
    }
}
