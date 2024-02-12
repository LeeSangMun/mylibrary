import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[] answer = new double[N];
		TreeMap<Integer, Double> map = new TreeMap<>();
		Arrays.sort(stages);
		int n = stages[0], u = 0, idx = 0;

		for (int i = 0; i < stages.length; i++) {
			if(stages[i] != n) {
				answer[n-1] = (double)u/(stages.length-i+u);
				n = stages[i];
				i--;
				u = 0;
				continue;
			} else if(stages[i] > N) {
				break;
			} else if(i == stages.length-1) {
				answer[n-1] = (double)(u+1)/(stages.length-i+u);
			}
			
			u++;
		}
		
		for (int i = 0; i < answer.length; i++) {
			map.put(i+1, answer[i]);
		}
		
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).mapToInt(Entry::getKey).toArray();
    }
}