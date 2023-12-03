import java.util.*;
//import java.util.Arrays;
public class inbuiltSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,2,4};
        System.out.println("before sort function");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        // Arrays.sort(arr);
        // System.out.println("after sort function");
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        Arrays.sort(arr,2,4);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Integer[] arr2 ={5,4,1,3,2};//Collections.reverseOrder() doesnot work on the primitive datatypes like int,long,float
        // Arrays.sort(arr2);
        // System.out.println("after sort function");
        // for(int i=0;i<arr2.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        Arrays.sort(arr2,1,4,Collections.reverseOrder());
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
