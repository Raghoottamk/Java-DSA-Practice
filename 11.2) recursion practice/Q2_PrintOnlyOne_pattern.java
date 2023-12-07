import java.util.*;

public class Q2_PrintOnlyOne_pattern {
    //to print all possibilities
    public static void PrintS(int idx,ArrayList<Integer> list,int n,int s,int sum,int[] arr){
        if(idx == n){
            if(s == sum){
                for(var it : list) System.out.print(it + "  ");
                System.out.println();
            }
            return;
        }
        //choice 1- pick
        list.add(arr[idx]);
        s += arr[idx];
        PrintS(idx+1, list, n, s, sum,arr);
        //choice 2- don't pick
        list.remove(list.size() - 1);
        s -= arr[idx];
        PrintS(idx+1, list, n, s, sum, arr);

    }

    //to print only one possibility - true/false
    //if true return no need to check further
    public static boolean PrintOnlyOne(int idx,ArrayList<Integer> list,int n,int s,int sum,int[] arr){
        if(idx == n){
            if(s == sum){
                for(var it : list) System.out.print(it + "  ");
                System.out.println();
                return true;
            }
            return false;
        }
        //choice 1- pick
        list.add(arr[idx]);
        s += arr[idx];
        if(PrintOnlyOne(idx+1, list, n, s, sum,arr) == true){
            return true;
        }
        //choice 2- don't pick
        list.remove(list.size() - 1);
        s -= arr[idx];
        if(PrintOnlyOne(idx+1, list, n, s, sum, arr) == true){
            return true;
        }
        return false;
    }
    //how  many subsequences will be equal to k 
    public static int PrintTotalK(int idx,int n,int s,int sum,int[] arr){
        if(idx == n){
            if(s == sum){
                return 1;
            }
            return 0;
        }
        //choice 1- pick
        s += arr[idx];
        int l = PrintTotalK(idx+1, n, s, sum,arr);
        //choice 2- don't pick
        s -= arr[idx];
        int r = PrintTotalK(idx+1, n, s, sum, arr);
        return l+r;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int n = arr.length;
        int sum = 2;
        ArrayList<Integer> list = new ArrayList<>();
        //PrintS(0, list, n, 0, sum, arr);
        //PrintOnlyOne(0,list,n,0,sum,arr);
        PrintTotalK(sum,n, sum, sum, arr);
    }
}
