import java.util.*;
public class largestOfArray {
    public static void getlargest(int arr[]) {
        int largest = Integer.MIN_VALUE;//to put the value of the largest as -infinity
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
       }
       System.out.println("the largest value in the aray is:"+largest);        
    }
    public static void main(String[] args) {
        int arr[]={-19,-34,-12,-4,6,30};
        getlargest(arr);
    }
}
