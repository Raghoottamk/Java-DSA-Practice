/*Goldman Sachs question
 * given n friends, each one can remain single or can be paired up with other friend. Each friend can be paired only once.Find out the total number of ways in which friends can remain single or can be paired up
 */
/*link to understand concept better 
https://math.stackexchange.com/questions/2833504/friends-pairing-problem*/
class Q2_friends_pairing{
    public static int friendsPairing(int n){
        //base
        if(n==1) return 1;
        if(n==2) return 2;
        //work
        // int fnm1 = friendsPairing(n-1);
        // int paired = (n-1)*friendsPairing(n-2);
        // int totalways = fnm1 + paired;
        // return totalways; 
        return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);
    }
    public static void main(String[] args) {
        System.out.println(friendsPairing(3));
    }
}

// I guess, the main problem which I also faced was (n−1)
// *f(n−2)
//  part of the equation.

// So instead consider the order f(n−2)*(n−1)

// This can be rewritten as f(n−2)+ f(n−2)+ f(n−2)+ ...(n−1)times. This will be helpful afterwards

// Now let's derive the recursive formula with following cases:

// nth guy is single
// nth guy gets paired up.
// So the recursion will look something like this f(n)= f(n−1)+ f(n−2)

// This says if the guy is single, the question remains the same for (n−1)
//  people or if the guy is paired up with anyone, question remain same for (n−2)
//  people (because 2 people are now let's say gone). But heres a thing which I think is better understood with an example.

// for n=4
//  and {A,B,C,D}
//  as there names :

// guy D chose to be single, people left : A,B,C
// guy D gets paired up.
// Pairing options are :

// (A),(B,C)

// (A,B),(C)

// (A,C),(B)

// So we can say:

// f(n)= f(n−1)(if guy stays single) + f(n−2)(if first pair is formed) + f(n−2)(if second pair is formed) + f(n−2)(if third pair is formed).

// So in essence, each pair contributes to the total, finally:

// f(n)= f(n−1)+ f(n−2)*(n−1)

// (n−1)= no. of ways ncan form a pair with n−1people.