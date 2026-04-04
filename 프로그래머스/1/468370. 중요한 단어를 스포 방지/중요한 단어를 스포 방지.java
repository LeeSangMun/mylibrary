import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> spo = new HashSet<>();
        Set<String> noSpo = new HashSet<>();
        Set<String> important = new HashSet<>();
        int idx = 0;

        for(String msg : message.split(" ")) {
            int s = message.indexOf(msg, idx);
            int e = s + msg.length() - 1;
            idx = e + 1;

            boolean flag = false;

            for (int[] spoiler_range : spoiler_ranges) {
                if(s <= spoiler_range[1] && e >= spoiler_range[0]) {
                    spo.add(msg);
                    flag = true;
                    break;
                }
            }

            if(!flag)
                noSpo.add(msg);
        }

        for (String word : spo) {
            if(!noSpo.contains(word)) {
                important.add(word);
            }
        }

        return important.size();
    }
}