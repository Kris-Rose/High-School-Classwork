//Krista Roberts
//3A
import java.util.*;
//1
public class TwoDRunner
{
   public static void main(String[]args){
       //3
       System.out.println(new TwoDArrays(new int[][] {{1, 2}, {10, 11}}).sum());
       //4
       System.out.println(new TwoDArrays(new int[][] {{2, 3, 1}, {5, 4, 6}}).isSquare() );
       //5
       System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).inSequence() );
       //6
       System.out.println(Arrays.toString(new TwoDArrays(new int[][] {{3, 1, 5, 7}, {4, 12, -3, 8}}).closestToZero()) );
       //7
       new TwoDArrays(new int[][] {{1,2,3}, {3,2,1}}).addMatrix(new int[][] {{2,3,1}, {3,1,2}});
       System.out.println();
       //9
       System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2) );
       //10
       System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {1}, {2, 2, 1}}).isColumnMagic() );
       //11
       System.out.println(new TwoDArrays(new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}}).sameDiagonalSums());
       System.out.println(new TwoDArrays(new int[][] {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}}).sameDiagonalSums() );
       
    }
}
