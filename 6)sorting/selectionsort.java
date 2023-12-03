public class selectionsort {
    public static int[] selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){//as loop runs from 0 to length-2
            int minposition = i;
            for(int j=i+1;j<=arr.length-1;j++){//inner loop checks all the elements of the array
                if(arr[minposition]>arr[j]){
                    minposition = j;
                }
            }
            //swapping outside the inner loop
            int temp = arr[minposition];
            arr[minposition]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }
    public static void printing(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        printing(selectionSort(arr));
    }
}
