import java.util.*;
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node
{
    double data;
    Node left;
    Node right; 
    Node parent; 
    int depth;
    
    
    public Node(double data, int depth){
        this.data = data;
        left = null;
        right = null;
        parent = null;
        this.depth = depth;
    }
    public Node(double data){
        this.data = data;
        left = null;
        right = null;
        parent = null;
        depth = 0;
    }
    public Node(double data, Node parent){
        this.data = data;
        left = null;
        right = null;
        this.parent = parent;
        depth = parent.getDepth() +1;
    }
    public void setLeft(Node l, Node rent){
        left = l;
        left.setParent(rent);
    }
    public void setRight(Node r, Node rent){
        right = r;
        right.setParent(rent);
    }
    public void setLeft(double l){
        left = new Node(l);
        left.setParent(this);
    }
    public void setRight(double r){
        right = new Node(r);
        right.setParent(this);
    }
    public void eraseLeft(){
        left = null;
    }
    public void eraseRight(){
        right = null;
    }
    public void setParent(Node rent){
        parent = rent;
    }
    
    public double getData(){
        return data;
    }
    public Node getLeft(){
        return left;
    }
    public Node getRight(){
        return right;
    }
    public Node getParent(){
        return parent;
    }
    public int getDepth(){
        return depth;
    }
    
    
    
    
    
    public void add(double dat, Node temp, int[] depth){
        if(dat > temp.getData()){
            if(temp.getRight() != null){
                depth[0] += 1;
                add(dat, temp.getRight(), depth);
            }
            else{
                temp.setRight(new Node(dat, depth[0]), this);
            }
            
        }
        else if(dat<= temp.getData()){
            if(temp.getLeft() != null){
                depth[0] += 1;
                add(dat, temp.getLeft(), depth);
            }
            else{
                
                temp.setLeft(new Node(dat, depth[0]), this);
            }
            
        }
    }
    
    
    public ArrayList inOrder(){
        ArrayList inOrder = new ArrayList();
        traverseInOrder(this, inOrder);
        return inOrder;
    }
    public void traverseInOrder(Node temp, ArrayList inOrder){
        if(temp.getLeft() != null){
            traverseInOrder(temp.getLeft(), inOrder);
        }
        inOrder.add(temp.data);
        if(temp.getRight() != null){
            traverseInOrder(temp.getRight(), inOrder);
        }
        
    }
    
    public void printSideways(Node temp){
        if(temp.getRight() != null){
            temp.printSideways(temp.getRight());
        }
        for(int a = 0;a<temp.getDepth()*4;a++){
            System.out.print(" ");
        }
        System.out.print(temp.data);
        System.out.println("");
        
        if(temp.getLeft() != null){
            printSideways(temp.getLeft());
        }
        
        
        
    }
}

