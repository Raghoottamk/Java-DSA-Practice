public class recursion{
    //problem 1 print the numbers in decreasing order
    public static void Dec(int n){
        //print(n+func(n-1))
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        Dec(n-1);
    }
    //problem 2 print numbers in increasing order
    public static void Inc(int n){
        //print(func(n-1) + n)
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        Inc(n-1);//first all function calls are stored in call stack then called one after another
        System.out.print(n+" ");
        
    }
    //problem 3 print the factorial of a number
    public static int factorial(int n){
        if(n<=2){
            return 2;
        }
        /*or
        if(n==1){
            return 1;
        } 
        if(n==2){
            return 2;
        }
        */
        int f = n * factorial(n-1);
        return f;
    }
    // problem4 print sum of N natural numbers
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        int x = n + sum(n-1);
        //System.out.println(x+ " ");
        return x;
    }
    // problem 5 fobonacci series
    public static int fib(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        int f1 = fib(n-1),f2 = fib(n-2);
        int f = f1 + f2;
        //int f = fib(n-1) + fib(n-2);
        System.out.print(f + " "); //cant give correct sequence 
        return f;
    }
    // problem 6 check if array is sorted or not using recursion
    public static boolean isSorted(int arr[],int i){
        //base case
        if(i == arr.length-1) return true;
        //condition
        if(arr[i] > arr[i+1]) return false;
        //recursion through the loop
        return isSorted(arr,i+1);
    }
    //problem 7- find the first occurance of an element in an array
    public static int firstOcc(int arr[],int i,int key) {
        //compare with self then look forward
        //base case
        if(i==arr.length) return -1;
        //condition
        if(arr[i]==key) return i;
        //recursion
        int n = firstOcc(arr, i+1, key);
        return n;
        }
    // problem-8 fond the last occuracance of an element in an array
    public static int lastOcc(int []arr,int i,int key){
        //1)going through that reverse of loop
        // //base case
        // if(i==-1) return -1;
        // //condition
        // if(arr[i]==key) return i;
        // //recursion
        // int n = lastOcc(arr, i-1, key);
        // return n;
        //or
        //2)going from 0th indexlook forward then compare
        //base case
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOcc(arr, i+1, key);
        if(isFound == -1 && arr[i]==key){
            return i;
        }
        return isFound; 
    }
    //problem 9 calculate x^n using recursion
    public static int power(int x,int n){
        //1) not optimized
        // if(n==1) return x;//x^1 == x
        // int p = x*power(x, n-1);
        // return p;
        //2) optimized
        if(n==1) return x;
        //int halfPowerSquare = power(x, n/2)*power(x, n/2); //this results in no optimization so
        int halfPowerSquare = power(x, n/2);
        halfPowerSquare = halfPowerSquare*halfPowerSquare;
        //if n is odd
        if(n%2 != 0){
            halfPowerSquare = x*halfPowerSquare;
        }
        return halfPowerSquare;
    }

    public static void main(String[] args) {
        // //Q1
        // Dec(10);
        // System.out.println();
        // //Q2
        // Inc(10);
        // //Q3
        // System.out.println(factorial(5));
        // // Q4
        // sum(10);
        // //Q5
        //System.out.println(fib(6));
        // fib(6);
        // //Q6
        // int arr[] = {1,5,6,3};
        // System.out.println(isSorted(arr,0));
        // Q7 
        // int[] arr = {1,7,5,9,2,4,5};
        // System.out.println(firstOcc(arr, 0, 5));
        // Q8
            // int[] arr={1,7,5,9,2,4,5};
            // 1
            // System.out.println(lastOcc(arr, arr.length-1,5));
            // 2
            // System.out.println(lastOcc(arr, 0, 5));
        // Q9
        System.out.println(power(2, 5));
    }
}