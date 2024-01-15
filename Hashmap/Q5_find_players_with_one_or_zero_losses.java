/*
--Question--
You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
Return a list answer of size 2 where:
answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.

Note:
You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
 
Example 1:
Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].

Example 2:
Input: matches = [[2,3],[1,3],[5,4],[6,4]]
Output: [[1,2,5,6],[]]
Explanation:
Players 1, 2, 5, and 6 have not lost any matches.
Players 3 and 4 each have lost two matches.
Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5_find_players_with_one_or_zero_losses {
    class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int i = 0; i < matches.length; i++){
                int loss = matches[i][1];
                int value = map.get(loss) == null ? 0 : map.get(loss) ;
                map.put(loss, ++value);
                //or
                //int loss = match[1];
                //map.put(loss, map.getOrDefault(lose, 0) + 1);
            }
            //System.out.println(map);
            List<Integer> not_lost = new ArrayList<>();
            List<Integer> lost_once = new ArrayList<>();
            for(int i = 0; i < matches.length; i++){
                int win = matches[i][0];
                int loose = matches[i][1];

                if (!map.containsKey(win)) {
                    not_lost.add(win);
                    map.put(win, 2);
                }
                if (map.get(loose) == 1) {
                    lost_once.add(loose);
                }
            }
            Collections.sort(not_lost);
            Collections.sort(lost_once);
            List<List<Integer>> list = new ArrayList<>();
            list.add(not_lost);
            list.add(lost_once);
            return list;
        }
    }
}