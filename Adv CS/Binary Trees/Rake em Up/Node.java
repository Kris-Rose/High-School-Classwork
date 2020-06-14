
/**
 * nood
 *
 * Krista R
 * 2-9-2020
 */
public  class Node{
    
    int data;
    Node left;
    Node right; 
    Node parent;    
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }
    public Node(int data, Node parent){
        this.data = data;
        left = null;
        right = null;
        this.parent = parent;
        
    }
    public void setLeft(Node l, Node rent){
        left = l;
        left.setParent(rent);
    }
    public void setRight(Node r, Node rent){
        right = r;
        right.setParent(rent);
    }
    public void setLeft(int l){
        left = new Node(l);
        left.setParent(this);
    }
    public void setRight(int r){
        right = new Node(r);
        right.setParent(this);
    }
    public void eraseLeft(){
        left = null;
    }
    public void eraseRight(){
        right = null;
    }
    
    public boolean leftEmpty(){
        if(left == null){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean rightEmpty(){
        if(right == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
    
    public void setParent(Node rent){
        parent = rent;
    }
    public void addLeft(int[] index, int[] data, Node temp ){
        if(index[0]< data.length){
            if(data[index[0]] == -1){
                index[0]++;
                if(index[0]< data.length){
                    addRight(index, data, temp);
                }
                
                
                
            }
            else{
                temp.setLeft(data[index[0]]);
                index[0]++;
                temp = temp.getLeft();
                addLeft(index, data, temp);
            }
        }
        
        
        
        
    }
    public void addRight(int[] index, int[] data, Node temp){
        if(index[0]< data.length){
            if(data[index[0]] == -1){
                 index[0]++;
                 if(index[0]< data.length){
                     temp = temp.getParent();
                     while(temp.rightEmpty() == false){
                         temp = temp.getParent();
                     }
                     addRight(index, data, temp);
                         
                 }
                 
                 
                 
            }
            else{
                 temp.setRight(data[index[0]]);
                 index[0]++;
                 temp = temp.getRight();
                 addLeft(index, data, temp);
            }
        }
    }
    
    
    
    
    
    public int getData(){
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
    
    
    
    
    public void RackeLeft(int[] index, int[] columns, Node temp, int[] tem, int[] data){
        if(tem[0]< data.length && !(temp.getParent() == null && temp.getLeft() == null && temp.getRight() == null)){
            //goes left
            if(temp.getLeft() != null){
                
                
                index[0]--;
                temp = temp.getLeft();
                columns[index[0]] += temp.getData();
                tem[0]++;
                if(temp.getLeft() == null && temp.getRight() == null){
                    temp = temp.getParent();
                    temp.eraseLeft();
                    index[0]++;
                }
                
                temp.RackeLeft(index, columns, temp, tem, data);
                
            }
            else{
                //goes right
                if(temp.getRight() != null){
                    index[0]++;
                    temp = temp.getRight();
                    columns[index[0]] += temp.getData();
                    tem[0]++;
                    if(temp.getLeft() == null && temp.getRight() == null){
                        temp = temp.getParent();
                        temp.eraseRight();
                        index[0]--;
                    }
                    
                    temp.RackeLeft(index, columns, temp, tem, data);
                }
                else{
                    //if both right and left are empty, empties self
                    if(temp.getParent().getRight() != null){
                        if(temp.getParent().getRight().getData()  == temp.getData()){
                            //erases right
                            temp = temp.getParent();
                            temp.eraseRight();
                            index[0]--;
                            temp.RackeLeft(index, columns, temp, tem, data);
                        }
                        else{
                            //erases left
                            temp = temp.getParent();
                            temp.eraseLeft();
                            index[0]++;
                            temp.RackeLeft(index, columns, temp, tem, data);
                        
                        }
                        
                    }
                    else if(temp.getParent().getLeft() != null){
                        if(temp.getParent().getLeft().getData()  == temp.getData()){
                            //erases left
                            temp = temp.getParent();
                            temp.eraseLeft();
                            index[0]++;
                            temp.RackeLeft(index, columns, temp, tem, data);
                        }
                        
                        
                    
                    }
                    
                    
                    
                    
                }
                
                
                
            }
        }
        
        
        
        
    
    }
    
    
    
}