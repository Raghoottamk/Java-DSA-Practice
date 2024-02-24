import java.util.*;
public class Q1_Pascal_Triangle {
    //iterative
    class Solution1 {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if(numRows == 0) return result;
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
    
            for(int i = 1; i < numRows ; i++){
                List<Integer> prev = result.get(i-1);
                List<Integer> curr = new ArrayList<>();
                curr.add(1);//firstindex of a row
    
                for(int j = 1; j < i ; j++){//till last index of row-1
                    curr.add(prev.get(j-1) + prev.get(j));
                }
    
                curr.add(1);//last index of the row
                result.add(curr);
            }
            return result;
        }
    }

    //recursive
    class Solution2 {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            if(numRows == 0) return result;
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            result.add(firstRow);
    
            for(int i = 1; i < numRows ; i++){
                List<Integer> prev = result.get(i-1);
                List<Integer> curr = new ArrayList<>();
                curr.add(1);//firstindex of a row
    
                for(int j = 1; j < i ; j++){//till last index of row-1
                    curr.add(prev.get(j-1) + prev.get(j));
                }
    
                curr.add(1);//last index of the row
                result.add(curr);
            }
            return result;
        }
    }
}