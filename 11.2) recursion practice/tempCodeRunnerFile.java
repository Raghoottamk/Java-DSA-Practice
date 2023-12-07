import java.util.*;

public class Q2_PrintOnlyOne_pattern {
    public static void PrintS(int idx,List<Integer> list,int n,int s,int sum,int[] arr){
        if(idx == n){
            if(s == sum){
                System.out.println(list);
                return;
            }
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
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int n = arr.length;
        int sum = 2;
        List<Integer> list = new ArrayList<>();
        PrintS(0,list,n,0,sum,arr);
    }
}