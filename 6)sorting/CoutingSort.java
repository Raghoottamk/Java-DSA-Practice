public class CoutingSort {
    public static void countingsort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        //loop to find largest value in array
        for(int i=0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[]=new int[largest+1];
/*
int[largest+1] becoz count array stores the frequency of all the elements of the 
array and count.length = largest_value_of_arr+1    as java is 0 indexed language
*/
        //loop to create the array storing the frequency of all the numbers
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;//frequency of the number at index[number]
        }
        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        
    }
    public static void printing(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,3,2,4,3,7};
        countingsort(arr);
        printing(arr);
    }
}
