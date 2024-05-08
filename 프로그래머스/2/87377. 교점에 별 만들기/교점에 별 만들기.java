import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = null;
		long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
		Map<Long, List<Long>> map = new HashMap<>();
		List<Long> list = null;
		
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				double n = line[i][0]*(double)line[j][1] - line[i][1]*(double)line[j][0];
				double x = (line[i][1]*(double)line[j][2] - line[i][2]*(double)line[j][1])/n;
				double y = (line[i][2]*(double)line[j][0] - line[i][0]*(double)line[j][2])/n;
				
				if(x % 1 == 0 && y % 1 == 0) {
					list = map.get((long)y);
					if(list == null) {
						list = new ArrayList<>();
						map.put((long)y, list);
					}
					
					list.add((long)x);
					
					maxX = Math.max(maxX, ((long)x));
					maxY = Math.max(maxY, ((long)y));
					minX = Math.min(minX, ((long)x));
					minY = Math.min(minY, ((long)y));
				}
			}
		}
		
		answer = new String[(int)(maxY - minY + 1)];
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		
		for (long i = maxY; i >= minY; i--) {
			sb.setLength(0);
			list = map.get(i);
			
			if(list == null) {
				answer[idx++] = ".".repeat((int)(maxX - minX + 1));
				continue;
			}
			
			for (long j = minX; j <= maxX; j++) {
				if(list.contains(j)) 
					sb.append("*");
				else 
					sb.append(".");
			}
			answer[idx++] = sb.toString();
		}

		return answer;
    }
}