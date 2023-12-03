public class subarrayloda {
    public static void sumsubarr(int arr[]) {
        int totsubarr=0;
        int sum=0,res=0;
        for(int i=0;i<arr.length;i++){
            res = 0;
            for(int j=i;j<arr.length;j++){
            sum += arr[j];
            res += sum;

            } 

        }
                    System.out.print("sum of subarr is: " +res);
            System.out.print("sum of subarr is: " +sum);
                totsubarr++;
                System.out.println();
            System.out.println();
        System.out.println("total no. of subarrays are"+totsubarr);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        sumsubarr(arr);
    }
}