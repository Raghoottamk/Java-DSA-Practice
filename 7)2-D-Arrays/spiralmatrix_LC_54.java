import java.util.*;

public class spiralmatrix_LC_54 {
 /*Approach:
 *We will use a while loop to traverse the matrix in a clockwise spiral order.
 *We will define four variables: left, right, top, bottom to represent the four boundaries of the current spiral.
 *We will use four for loops to traverse each edge of the current spiral in clockwise order and add the elements to the result list.
 *We will update the boundaries of the current spiral and continue the process until all elements have been traversed.
    Intuition:
 *We start with the outermost layer of the matrix and traverse it in a clockwise spiral order, adding the elements to the result list.
 *Then we move on to the next inner layer of the matrix and repeat the process until we have traversed all layers.
 *To traverse each layer, we need to keep track of the four boundaries of the current spiral.
 *We start at the top-left corner of the current spiral and move right until we hit the top-right corner.
 *Then we move down to the bottom-right corner and move left until we hit the bottom-left corner.
 *Finally, we move up to the top-left corner of the next spiral and repeat the process until we have traversed all elements in the matrix. 
 */
    //I)brute force method
    public static void SpiralMatrixI(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //important variables for spiral matrix
        int startrow = 0,startcol = 0,endrow = n-1,endcol = m-1;
        while(startrow<=endrow && startcol<=endcol){
            //top 
            for(int i=startcol;i<=endcol;i++){
                System.out.println(matrix[startrow][i]);
            }
            
            //right
            for(int i=startrow+1;i<=endrow;i++){
                
                System.out.println(matrix[i][endcol]);
            }
            
            //bottom
            for(int i=endcol-1;i>=startcol;i--){
                if(startrow==endrow){//as it would already printed in top
                    break;
                }
                System.out.println(matrix[endrow][i]);
            }

            //left
            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcol==endcol){//as it would already printed in right
                    break;
                }
                System.out.println(matrix[i][startcol]);
            }
            startcol++;
            startrow++;
            endcol--;
            endrow--;

        }
    }
    public static void main(String[] args) {
        //declaring the size and type of 2D matrix
        int matrix[][] = new int[4][4];
        Scanner sc = new Scanner(System.in);
        int n = matrix.length;//no. of rows
        int m = matrix[0].length;//no.of columns
        //to take input for each element of matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("input value at index "+i+j);
                matrix[i][j] = sc.nextInt(); 
            }
        }
        //calling spiral matrixI
        SpiralMatrixI(matrix);

    }
}
