import java.util.*;
public class ThirteensBoard extends Board
{
    //The size (number of cards) on the board.
     
    private static final int BOARD_SIZE = 10;
    
    public ThirteensBoard() {
        super();
    }
     public boolean isLegal(List<Integer> selectedCards) {
        if(selectedCards.size()==2){
            return containsPairSum11(selectedCards);
        }
        else if(selectedCards.size()==3){
            return containsJQK(selectedCards);
        }
        else{
            return false;
        }
    }
    public boolean anotherPlayIsPossible() {
        boolean isPossible = false;
        List<Integer> temp = new ArrayList<Integer>();
        for(int a = 1; a<getCards().length; a++){
            temp.add(a);
            temp.add(a-1);
            if(isLegal(temp)){
                isPossible = true;
            }
            temp.clear();
        }
        for(int i = 2; i<getCards().length; i++){
            temp.add(i);
            temp.add(i-1);
            temp.add(i-2);
            if(isLegal(temp)){
                isPossible = true;
            }
            temp.clear();
        }
        return isPossible;
    }
    
}
