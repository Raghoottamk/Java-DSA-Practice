public class  Q1_Count_of_matches_in_tournment{
    //QUESTION
    /*
     * You are given an integer n, the number of teams in a tournament that has strange rules:

    If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
    If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
     */
    //recursive way
    public static int numberOfMatches(int n) {
        if(n == 1){
            return 0;
        }
        if(n%2 != 0){
            return((n/2 + numberOfMatches(n-1)/2 + 1));
        }
        else{
            return(n/2 + numberOfMatches(n/2));
        }
    }
    //loop way
    public static int numberOfMatchesLoop(int n) {
        int match = 0;
        while(n != 1){
            //even
            if(n % 2 == 0){
                match += n/2;
                n = n/2;
            }
            //or
            else{
                match += (n-1)/2;
                n = ((n - 1) / 2 ) + 1;
            }
        }
        return match;
    }
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7)); //match = 6
        System.out.println(numberOfMatches(14));//match = 13
        System.out.println(numberOfMatchesLoop(7));
    }
}