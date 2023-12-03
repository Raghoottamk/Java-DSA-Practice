public class staircase_search {
    //given the sorted 2D-array which sorted on both rows and cols
    public static boolean staircasesearch(int[][] mat,int key) {
        int i =0,j=mat[0].length-1;//top right corner of the matrix
        while(i<mat.length && j>=0){
            if(mat[i][j]==key){
                System.out.println(i+","+j);
                return true;
            }
            else if(mat[i][j]<key){//move bottom
                i++;
            }
            else if(mat[i][j]>key){//move left
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [][] mat = {{10,20,30,40},
                        {15,25,35,45},
                        {27,29,37,48},
                        {32,33,39,50}};
        System.out.println(staircasesearch(mat, 57));
    }
}
