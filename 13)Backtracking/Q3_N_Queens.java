/*this question can be asked in 3 different ways
   1-print the possible board
   2-return total no.of ways
   3-check if the problem can be solved and return only one solution
 */
//1 & 2 
public class Q3_N_Queens {
    static int count = 0;
    public static void nQueens(char board[][],int row){
        //base
        if(row == board.length){
            printBoard(board);
            count ++;
            return;
        }
        //column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                //function call
                nQueens(board, row+1);
                //backtracking step
                board[row][j] = 'X';//to set back to X as Q is set on different place;
            }
        }
    }
    public static boolean isSafe(char [][] board,int row,int col){
        //as we travel from up to down in 2D array we only need to check for quees safe in upside only
        //verticall up
        for(int i = row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonally left up
        for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonally right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("----ChessBoard----");
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }

        nQueens(board,0);
        System.out.println("No. of ways = "+count);
    }
}
//3 type question check if the problem can be solved and return only one solution
// public static boolean nQueens(char board[][],int row){
//         //base
//         if(row == board.length){
//             return true;
//         }
//         //column loop
//         for(int j=0;j<board.length;j++){
//             if(isSafe(board,row,j)){
//                 board[row][j] = 'Q';
//                 //function call
//                 if(nQueens(board, row+1)){
//                     return true;
//                 }
//             }
//             //backtracking step
//             board[row][j] = 'X';//to set back to X as Q is set on different place;
//         }
//     }
//     public static boolean isSafe(char [][] board,int row,int col){
//         //as we travel from up to down in 2D array we only need to check for quees safe in upside only
//         //verticall up
//         for(int i = row-1;i>=0;i--){
//             if(board[i][col]=='Q'){
//                 return false;
//             }
//         }
//         //diagonally left up
//         for(int i = row-1,j=col-1;i>=0 && j>=0;i--,j--){
//             if(board[i][j] == 'Q'){
//                 return false;
//             }
//         }
//         //diagonally right up
//         for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         return true;
//     }