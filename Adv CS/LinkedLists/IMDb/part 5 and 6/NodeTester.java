
/**
 * To test actor and node class for part 3
 *
 * @Krista R
 * @10/10/19
 */
public class NodeTester
{
    public static void main(String args[]){
        //oof is at beginning because pointer is null
        //head points is beginning of list(is inverted when created)
        //1st part kristoMcKristerkins
        Actor oof = new Actor("Bob the Builder");
        Node first = new Node(oof);
        Node head = first;
        
        Actor nerd = new Actor("Harini");
        Node second = new Node(nerd);
        first.setNextPtr(head);
        head = second;
        
        
        Actor meme = new Actor("Ellllllllla");
        Node third = new Node(meme);
        third.setNextPtr(head);
        head = third;
        
        Actor boi = new Actor("Dat Boi M.D.");;
        Node fourth = new Node(boi);
        fourth.setNextPtr(head);
        head = fourth;
        
        
        Actor hombre = new Actor("Senor Yikes");
        Node fifth = new Node(hombre);
        fifth.setNextPtr(head);
        head = fifth;
        
        //2nd part
        Node current = head;
        while(current != null){
            System.out.println(current.toString());
            current = current.getNextPtr();
        }
        
        //last
        System.out.println(head.toString());
    }
}
