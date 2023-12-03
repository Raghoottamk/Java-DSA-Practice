/*given a 2*n board and titles of size 2*1 ,count the number of ways to tile the given board using the 2*1 tiles.(A tile can either be placed horizontally or vertically*/
public class Q1_tiling_problem{
    public static int tilingProblem(int n){
        //basse cases
        if(n==0) return 1;//even placing zero tile is one way to execute
        if(n==1) return 1;
        //work
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1+fnm2;
        return totalWays;
    }
    public static void main(String[] args) {
        System.out.println(tilingProblem(4));
    }
}
