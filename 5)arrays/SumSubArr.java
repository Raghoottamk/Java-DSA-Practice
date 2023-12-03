public class SumSubArr {
    public static void sumsubarr(int arr[]) {
        int totsubarr=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            for(int j=i;j<arr.length;j++){

                for(int k=i;k<=j;k++){//for(int k=i;k<=j;k++)
                    System.out.print(arr[k]+" ");        
                    sum += arr[k];//summing of subarray

                }
                System.out.print("sum of subarr is: " +sum);
                totsubarr++;
                System.out.println();
                sum = 0;
            } 
            System.out.println();
        }
        System.out.println("total no. of subarrays are"+totsubarr);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        sumsubarr(arr);
    }
}