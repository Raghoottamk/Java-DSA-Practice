/*GRID WAYS
  --QUESTION--
  find the total number of ways to reach form(0,0) to (n-1) and (m-1) in a n*m grid. allowed moves are only right and down. 
*/
public class Q4_Grid_Ways{
    public static int gridWays(int i,int j,int n,int m){
        //base
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i>=n || j>= m){
            return 0;
        }
        //work
        int w = gridWays(i+1,j,n,m) + gridWays(i, j+1, n, m);  
        return w;
    }
    public static void main(String[] args) {
        
        System.out.println("the total no. of ways "+" "+gridWays(0, 0, 3, 3));
    }
}