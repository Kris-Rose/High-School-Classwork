
/**
 * Nodes for encoding in the tree
 *
 * Krista R.
 * 4-1-2020
 */
public class TreeNode
{
    private char info;
    private String added;
    private int freq;
    private int depth;
    
    private boolean isCar;
    
    private TreeNode next;
    private TreeNode prev;
    private TreeNode leftChild; 
    private TreeNode rightChild;
    private TreeNode parent;

    public TreeNode(char info, int frequency)
    {
        this.info = info;
        freq = frequency;
        isCar = true;
        
        next = null;
        prev = null;
        leftChild = null;
        rightChild = null;
    }
    public TreeNode(String info, int frequency)
    {
        added = info;
        freq = frequency;
        isCar = false;
        
        next = null;
        prev = null;
        leftChild = null;
        rightChild = null;
    }
    
    public char getCharValue(){
        return info;
    }
    public String getValue(){
        return added;
    }
    public int getFreq(){
        return freq;
    }
    
    public void setValue(char val){
        info = val;
    }
    public void setFreq(int freq){
        this.freq = freq;
    }

    public TreeNode getNext(){
        return next;
    }
    public TreeNode getPrev(){
        return prev;
    }
    public TreeNode getLeft(){
        return leftChild;
    }
    public TreeNode getRight(){
        return rightChild;
    }
    public TreeNode getParent(){
        return parent;
    }
    
    
    public void setNext(TreeNode next ){
        this.next = next;
    }
    public void setPrev(TreeNode prev){
        this.prev = prev;
    }
    public void setLeft(TreeNode left){
        leftChild = left;
    }
    public void setRight(TreeNode right){
        rightChild = right;
    }
    public void setParent(TreeNode par){
        parent = par;
    }
    
    
    public boolean isChar(){
        return isCar;
    }
    public boolean hasNext(){
        if(next != null){
           return true;
           
        }
        else{
           return false; 
        }
    }
    
    
    public String toString(){
        if(isCar){
            return "value:" + info + " freq: " + freq;
        }
        else{
            return "value:" + added + " freq:" + freq;
        }
        
        
    }
    
    
}
