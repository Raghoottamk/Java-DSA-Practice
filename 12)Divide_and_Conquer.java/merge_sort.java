public class merge_sort{
    public static void mergeSort(int[] arr,int si,int ei){
        //base
        if(si >= ei) return; 
        //work
        int mid = si + (ei-si)/2;
        mergeSort(arr, si,mid);//left part
        mergeSort(arr, mid+1,ei);//right part
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int[] temp = new int[ei-si+1];//as arr[4,6] has 3 elements
        int i = si;//iterator for the left part
        int j = mid+1;//iterator for the right part
        int k = 0;//iterator for the temp part
        while(i <= mid && j<= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        //still there will be elements remaining
        //left part
        while(i <= mid){
            temp[k++] = arr[i++];
            // temp[k] = arr[i];
            // i++;
            // k++;
        }
        //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //copying the temp array to original array
        for(k=0,i=si; k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print("\t");
        }
    }
}