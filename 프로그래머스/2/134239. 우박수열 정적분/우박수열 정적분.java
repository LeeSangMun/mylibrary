import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        list.add(k);
        double total = 0;
        		
        while(k != 1) {
        	k = k % 2 == 0 ? k / 2 : k * 3 + 1;
        	total += (list.get(list.size() - 1) + k)/2.0;
        	list.add(k);
        }
        
        int size = list.size() - 1;
        
        for (int i = 0; i < ranges.length; i++) {
        	double sum = 0;
        	
			if(ranges[i][0] > size + ranges[i][1]) {
				answer[i] = -1;
			} else if(ranges[i][0] == size + ranges[i][1]) {
				answer[i] = 0;
			} else if(ranges[i][0] == 0 && ranges[i][1] == 0) {
				answer[i] = total;
			} else {
				for (int j = ranges[i][0]; j < size + ranges[i][1]; j++) {
					sum += (list.get(j) + list.get(j+1))/2.0;
				}
				answer[i] = sum;
			}
		}
        
        return answer;
    }
}