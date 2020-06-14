import java.util.*;
public class ElevensBoard extends Board
{
    //The size (number of cards) on the board.
     
    private static final int BOARD_SIZE = 9;
    public ElevensBoard() {
        super();
    }
    
    
    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
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
    
    
    
    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible() {
        boolean isPossible = false;
        List<Integer> temp = new ArrayList<Integer>();
        for(int a = 1; a<10; a++){
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
