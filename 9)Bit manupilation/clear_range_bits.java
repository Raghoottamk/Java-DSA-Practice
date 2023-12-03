public class clear_range_bits {
    //Q-2
    public static int clearlastBits(int n, int i){
        int bitmask = (~0) << i;
        return n & bitmask;
    }
    //Q-3
    public static int clearRangeBits(int n,int i,int j){
        int a = ((~0)<<j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }
    //Q-4 check if a number is power of 2
    public static boolean power_2(int n){
        return (n & (n-1)) == 0;
    }
    //Q-5 count set bits in a number
    public static int count_set(int n){
        int count =0;
        while(n > 0){
            if((n & 1) == 1){//check on LSB
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args){
        // //Q-2
        // System.out.println(clearlastBits(15,2));//12 is the expected output
        // //Q-3
        // System.out.println(clearRangeBits(10, 2, 4));
        // //Q-4
        // System.out.println(power_2(16));
        // //Q-5
        System.out.println(count_set(15));

    }
    
}
