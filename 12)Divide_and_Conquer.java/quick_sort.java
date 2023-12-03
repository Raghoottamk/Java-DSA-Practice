public class quick_sort {
    public static void quickSort(int[] arr,int si,int ei){
        //base
        if(si>=ei) return;
        //work
        int pivotIndex = partition(arr,si,ei);
        quickSort(arr, si,pivotIndex-1);
        quickSort(arr, pivotIndex+1, ei);
    }
    public static int partition(int[] arr,int si,int ei){
        int pivot = arr[ei];
        int i = si - 1;//to make spaces for smaller elements
        for(int j=si ; j < ei;j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
            //swap
            int temp = pivot;
            arr[ei] = arr[i];
            arr[i] = temp;
            return i;
    }
    public static void main(String[] args) {
        int[] arr = {4,6,7,-5,2,3};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
