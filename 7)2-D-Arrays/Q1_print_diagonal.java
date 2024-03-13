public class Q1_print_diagonal {
    //https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] ans = new int[n*n];
        int i = 0,j = 0,k=0;
        int upper = 1;//move upwards
        while(k < n*n){
            if(upper == 1){
            while(i >= 0 && j < n){
                ans[k++] = mat[i][j];
                if(j == n-1){
                    i++;
                    break;
                }
                else if(i==0){
                    j++;
                    break;
                }
                i--;
                j++;
            }
            upper = 0;
        }
        else{
            while(j >= 0 && i < n){
                ans[k++] = mat[i][j];
                if(i == n-1){
                    j++;
                    break;
                }
                else if(j==0){
                    i++;
                    break;
                }
                j--;
                i++;
            }
            upper = 1;
        }
        }
        return ans;
    }
}
