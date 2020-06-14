
/**
 * 
 *
 * Krista R.
 * 4/1/2020
 */
public class LinkedList
{
    private TreeNode head;
    private TreeNode tail;
    private int count;

    public LinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(TreeNode toAdd, int index){
        if(head == null){
            head = toAdd;
            tail = head;
            count++;
        }
        else{
            //adds at index unless index is out of bounds, then just adds at end
            if(index>= count){
                //add to end

                toAdd.setPrev(tail);
                tail.setNext(toAdd);
                tail = toAdd;

            }
            else if(index == 0){
                toAdd.setNext(head);
                head.setPrev(toAdd);
                head = toAdd;

            }
            else{
                TreeNode temp = head;
                for(int a = 0;a<index && a< count-1;a++){
                    temp = temp.getNext();
                }

                toAdd.setNext(temp);
                toAdd.setPrev(temp.getPrev());
                temp.setPrev(toAdd);
            }
            count++;

        }
    }

    public void add(TreeNode toAdd){
        if(head == null){
            head = toAdd;
            tail = head;

        }
        else{
            //add to end
            toAdd.setPrev(tail);
            tail.setNext(toAdd);
            tail = toAdd;

        }
        count++;
    }

    public TreeNode get(int index){

        if(head == null){
            throw new IllegalStateException();
        }
        else if(index >= count){
            return tail;
        }
        else if(index == 0){
            return head;
        }
        else{
            TreeNode temp = head;
            for(int a = 0;a<index && a< count-1;a++){
                temp = temp.getNext();
            }
            return temp;
        }
    }

    public TreeNode getTail(){
        if(tail == null){
            throw new IllegalStateException();
        }
        else{
            return tail; 
        }

    }

    public TreeNode getHead(){
        if(head == null){
            throw new IllegalStateException();
        }
        else{
            return head;
        }

    }

    public TreeNode remove(){
        //removes from end
        if(tail == null){
            throw new IllegalStateException();
        } 
        else{
            TreeNode temp = tail;
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            count--;
            return temp;
        }
    }

    public TreeNode remove(int index){
        if(head == null){
            throw new IllegalStateException();
        }
        else if(index >= count){
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0){
            TreeNode temp = head;
            head.getNext().setPrev(null);
            head = head.getNext();
            count--;
            return temp;
        }
        else if(index == count-1){
            TreeNode temp = tail;
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            count--;
            return temp;
        }
        else{
            TreeNode temp = head;
            for(int a = 0;a<index && a<count-1;a++){
                temp = temp.getNext();
            }
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            count--;
            return temp;
        }
    }

    public TreeNode getSmallest(){
        if(count == 1){
            return head;
        }
        TreeNode temp = head;
        TreeNode small = temp;
        for(int a = 0;a<count-1 && temp.hasNext();a++){
            temp = temp.getNext();

            if(temp.getFreq()<small.getFreq() ){
                small = temp;
            }

        }
        small = small;
        return small;
    }

    public TreeNode removeSmallest(){
        if(count == 1){
            return head;
        }
        TreeNode temp = head;
        TreeNode small = temp;
        for(int a = 0;a<count-1 && temp.hasNext();a++){
            temp = temp.getNext();
            if(temp.getFreq()<small.getFreq()){
                small = temp;
            }

        }

        if(small != head){
            if(small != tail){
                small.getNext().setPrev(small.getPrev());
                small.getPrev().setNext(small.getNext());
            }
            else{
                small.getPrev().setNext(null);
                tail = small.getPrev();
            }
        }
        else{
            small.getNext().setPrev(null);
            head = small.getNext();
        }

        small.setNext(null);
        small.setPrev(null);

        count--;
        return small;
    }

    public int size(){
        return count;
    }

}
