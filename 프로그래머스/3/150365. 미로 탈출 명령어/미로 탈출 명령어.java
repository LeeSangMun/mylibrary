import java.util.*;

class Data {
	int x;
	int y;
	String result;
	
	public Data(int x, int y, String result) {
		this.x = x;
		this.y = y;
		this.result = result;
	}
}

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "z";
        Queue<Data> que = new LinkedList<>();
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        String[] dir = {"d", "l", "r", "u"};

        que.offer(new Data(x-1, y-1, ""));

        while(!que.isEmpty()) {
            Data temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int tx = temp.x + dx[i];
                int ty = temp.y + dy[i];
                String result = temp.result + dir[i];

                if(Math.abs(tx - (r-1)) + Math.abs(ty - (c-1)) > k - result.length()) continue;

                if(result.length() == k && tx == r-1 && ty == c-1) {
                    if(answer.compareTo(result) > 0) answer = result;
                }

                if(tx >= 0 && tx < n && ty >= 0 && ty < m && result.length() < k) {
                    que.offer(new Data(tx, ty, result));
                    break;
                }
            }
        }

        return answer.equals("z") ? "impossible" : answer;
    }
}