import java.util.*;
public class L2_insert_in_heap {
    //basic operations in heap
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;//child index
            int par = (x-1)/2;//parent index

            while(arr.get(x) < arr.get(par)){
            //for max heap
            //while(arr.get(x) > arr.get(par))
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x = par;
                par = (x-1)/2;
            }
            //TC = O(log(n))
        }

        public int peek(){
            return arr.get(0);
            //TC = O(1)
        }

        public int remove(){
            int data = arr.get(0);

            //step-1- swap 1st and last node(element in list)
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size()-1,temp);

            //step-2- remove last index 
            arr.remove(arr.size() - 1);

            //step-3- fix the heap(as it might not be correct coz of swappimg)
            heapify(0);

            return data;

            //TC = O(logn)
        }
        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
            //max heap
            //if(left < arr.size() && arr.get(minIdx) < arr.get(left)) 
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
            //max heap
            //if(right < arr.size() && arr.get(minIdx) < arr.get(right))
                minIdx = right;
            }
            //swap only when minIdx != i, otherwise its not required as it did not break any case
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                
                heapify(minIdx);
            }
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);h.add(4);h.add(2);h.add(6);h.add(5);h.add(1);
        
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
