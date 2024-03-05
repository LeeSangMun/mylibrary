import java.util.*;

class Solution {
    public static int solution(String[] maps) {
        int[][] sle = new int[3][3];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				sb.append(maps[i].charAt(j));
				if(maps[i].charAt(j) == 'S') {
					sle[0][0] = i;
					sle[0][1] = j;
				} else if(maps[i].charAt(j) == 'L') {
					sle[1][0] = i;
					sle[1][1] = j;
				} else if(maps[i].charAt(j) == 'E') {
					sle[2][0] = i;
					sle[2][1] = j;
				}
			}
		}        
        
        int d1 = f(sle[0], sle[1], new StringBuilder(sb.toString()), maps);
        int d2 = f(sle[1], sle[2], new StringBuilder(sb.toString()), maps);
        
        return  d1 == 0 || d2 == 0 ? -1 : d1 + d2;
    }
	
	static int f(int[] s, int[] e, StringBuilder mapClone, String[] maps) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(s);
		
		int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
		int len = maps[0].length();
		mapClone.replace(s[0]*len + s[1], s[0]*len + s[1] + 1, "X");
        
		while(!que.isEmpty()) {
        	int[] temp = que.poll();
        	for (int i = 0; i < 4; i++) {
				int x = temp[0] + xArr[i];
				int y = temp[1] + yArr[i];
				if(x >= 0 && x < maps.length && y >= 0 && y < len && mapClone.charAt(x * len + y) != 'X') {
					if(x == e[0] && y == e[1]) {
						return temp[2] + 1;
					}
					mapClone.replace(x*len+y, x*len+y+1, "X");
					que.add(new int[] {x, y, temp[2]+1});
				}
			}
        }
		
		return 0;
	}
}