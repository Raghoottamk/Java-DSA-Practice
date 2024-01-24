import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Qustion--
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Example 1:

Input: root = [2,3,1,3,1,null,1]
Output: 2 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).

Example 2:
Input: root = [2,1,1,1,3,null,null,null,null,null,1]
Output: 1 
Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).

Example 3:
Input: root = [9]
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 9
 */

public class Q26_count_num_of_pseudo_palindrome_paths {
    class Solution {
        public int pseudoPalindromicPaths (TreeNode root) {
            List<List<Integer>> paths = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            helper(root,paths,list);
            return paths.size();
        }
        private void helper(TreeNode root,List<List<Integer>>paths,List<Integer>temp){
            if(root == null){
                return;
            }
            temp.add(root.val);
            if(root.left == null && root.right == null){
                if(check_pseudo_palindrome(temp)){
                    paths.add(new ArrayList<>(temp));
                }
            }

            helper(root.left,paths,temp);
            helper(root.right,paths,temp);

            temp.remove(temp.size()-1);
        }
        private boolean check_pseudo_palindrome(List<Integer> temp){
            int count[] = new int[10];
            Arrays.fill(count, 0);

            for (int i = 0; i < temp.size() ; i++)
                count[temp.get(i)]++;
    
            // Count odd occurring characters
            int odd = 0;
            for (int i = 0; i < 10 ; i++) {
                if ((count[i] & 1) == 1)
                    odd++;
    
                if (odd > 1)
                    return false;
            }
    
            // Return true if odd count is 0 or 1,
            return true;
        }
    }
    //slight optimization- by directly calculating the possible no. of pahts without using extra List
    public class Solution2 {
        public int pseudoPalindromicPaths(TreeNode root) {
            int[] digits = new int[10];
            return dfs(root, digits);
        }
    
        private int dfs(TreeNode root, int[] digits) {
            if (root == null) return 0;
    
            digits[root.val]++;
            if (root.left == null && root.right == null) {
                int cnt = countOdd(digits);
                digits[root.val]--;  // Backtrack
                return (cnt <= 1) ? 1 : 0;
            }
    
            int leftCount = dfs(root.left, digits);
            int rightCount = dfs(root.right, digits);
    
            digits[root.val]--;  // Backtrack
    
            return leftCount + rightCount;
        }
    
        private int countOdd(int[] digits) {
            int cnt = 0;
            for (int i = 1; i < 10; ++i) {
                if ((digits[i] & 1) == 1) cnt++;
            }
            return cnt;
        }
    }
    //optimized approach - Bit manupilation
    /*
Algorithm
1 - Start DFS traversal from the root of the tree with pathBits initialized to 0.
2 - At each node, toggle the bit corresponding to the current digit in pathBits.
// Toggle the bit corresponding to the current digit.
        pathBits ^= (1 << root->val);
3 - If the node is a leaf, check if the path represented by pathBits is pseudo-palindromic. If yes, increment the result.
 if (root->left == NULL && root->right == NULL) {
            // Check if the path is pseudo-palindromic.
            return ((pathBits & (pathBits - 1)) == 0) ? 1 : 0;
        }
4 - Recursively traverse the left and right subtrees.
5 - nt leftCount = dfs(root->left, pathBits);
        int rightCount = dfs(root->right, pathBits);
6- Backtrack by XOR-ing the bit corresponding to the current digit.1-
     */
    public class Solution3 {
        public int pseudoPalindromicPaths(TreeNode root) {
            return dfs(root, 0);
        }
    
        private int dfs(TreeNode root, int pathBits) {
            if (root == null) return 0;
    
            // Toggle the bit corresponding to the current digit.
            pathBits ^= (1 << root.val);
    
            if (root.left == null && root.right == null) {
                // Check if the path is pseudo-palindromic.
                return ((pathBits & (pathBits - 1)) == 0) ? 1 : 0;
            }
    
            int leftCount = dfs(root.left, pathBits);
            int rightCount = dfs(root.right, pathBits);
    
            return leftCount + rightCount;
        }
    }
}
