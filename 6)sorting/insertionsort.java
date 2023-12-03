public class insertionsort {
    public static int[] insertionSort(int[] arr) {
        //outer loop iterates through all the elements of the array
        for(int i=1;i<arr.length;i++){
            int j = i;
            //j-1 will be 0 at the first iteration
            //j-1 represents the previous element
            while(j>0 && arr[j-1] > arr[j]){//while(j>0 && arr[j-1] < arr[j]) for decreasong order
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
    }
    public static void printing(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        printing(insertionSort(arr));
    }
}
