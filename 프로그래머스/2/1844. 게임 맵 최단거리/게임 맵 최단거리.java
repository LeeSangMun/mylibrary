import java.util.*;

class Solution {
   public static int solution(int[][] maps) {
        int[][] flag = new int[maps.length][maps[0].length];
        
        Queue<int[]> que = new LinkedList<>();
        int[] xArr = {1, 0, -1, 0};
        int[] yArr = {0, 1, 0, -1};
        int[] temp;
        int x = 0, y = 0;
        
        que.offer(new int[] {0, 0});
        
        while(!que.isEmpty()) {
        	temp = que.poll();
        	
        	for (int i = 0; i < 4; i++) {
        		x = temp[0] + xArr[i];
        		y = temp[1] + yArr[i];
        		
				if(x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
					if(flag[x][y] == 0 && maps[x][y] == 1) {
						que.offer(new int[] {x, y});
						flag[x][y] = flag[temp[0]][temp[1]] + 1;
					}
				}
			}
        }
        
        return flag[flag.length-1][flag[0].length-1] != 0 ? flag[flag.length-1][flag[0].length-1] + 1 : -1;
    }
}