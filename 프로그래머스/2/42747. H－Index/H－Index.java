import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        citations = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        
        if(citations[0] == 0) return 0;
        
        for (int i = 0; i < citations.length; i++) {
			if(citations[i] < i+1) {
				answer = i;
				break;
			}
		}
        
        if(answer == 0) return citations.length;
        
        return answer;
    }
}