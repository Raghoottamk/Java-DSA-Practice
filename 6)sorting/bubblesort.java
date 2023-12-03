public class bubblesort {
    //bubblesort with time complexity if O(n^2)
    public static int[] bubbleSort(int[] arr) {
        int swaps = 0;
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    //swap 
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;  
                    swaps++;//swaps value would be 0 if array was sorted
                }
            }
        }
        System.out.println("no of times the loop ran"+swaps);
        return arr;
    }
    //function to print sorted array
    public static void printing(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //bubble sort using time complexity O(n)
    // public static void bubblesort() {
        
    // }
    
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        //bubbleSort(arr);
        printing(bubbleSort(arr));
    }
}
