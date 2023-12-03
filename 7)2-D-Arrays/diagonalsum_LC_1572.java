public class diagonalsum_LC_1572{
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        //unoptimized
        System.out.println(diagonalSum(mat));
        //optimized
        System.out.println(diagonalSum_optimized(mat));
    }
    public static int diagonalSum(int[][] mat) {
        
        int sum = 0;
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                //sum of elements in primary diagonal i.e. 1st diagonal
                if(i==j){
                    sum+=mat[i][j];
                }
                //sum of elements in secondary diagonal i.e. 2nd diagonal
                else if(i+j==mat.length-1){
                    sum+=mat[i][j];
                }
            }
        }
        return sum;
    }
    public static int diagonalSum_optimized(int[][] mat) {
        
        int sum = 0;
        
        for(int i = 0;i<mat.length;i++){
            //sum of elements in primary diagonal i.e. 1st diagonal
            sum+=mat[i][i];
            //sum of elements in secondary diagonal i.e. 2nd diagonal
            if(i!=mat.length-1-i){/*so that when n*n is odd matrix and value should not be reused   again as already used in mat[i][i]*/
                sum+=mat[i][mat.length-i-1];// else if(i+j==mat.length-1)
            }
        }
        return sum;
    }
}