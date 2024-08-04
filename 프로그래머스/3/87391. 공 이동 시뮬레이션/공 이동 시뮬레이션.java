class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long x1, y1, x2, y2;
        x1 = x2 = x;
        y1 = y2 = y;
        
        for (int i = queries.length - 1; i >= 0; i--) {
			if(queries[i][0] == 0) {
				if(y1 == 0) {
					y2 = Math.min(y2 + queries[i][1], m - 1);
				} else {
					if(m - y1 - 1 < queries[i][1]) return 0;
					y1 += queries[i][1];
					y2 = Math.min(y2 + queries[i][1], m - 1);
				}
			} else if(queries[i][0] == 1) {
				if(y2 == m - 1) {
					y1 = Math.max(y1 - queries[i][1], 0);
				} else {
					if(y2 < queries[i][1]) return 0;
					y2 -= queries[i][1];
					y1 = Math.max(y1 - queries[i][1], 0);
				}
			} else if(queries[i][0] == 2) {
				if(x1 == 0) {
					x2 = Math.min(x2 + queries[i][1], n - 1);
				} else {
					if(n - x1 - 1 < queries[i][1]) return 0;
					x1 += queries[i][1];
					x2 = Math.min(x2 + queries[i][1], n - 1);
				}
			} else {
				if(x2 == n - 1) {
					x1 = Math.max(x1 - queries[i][1], 0);
				} else {
					if(x2 < queries[i][1]) return 0;
					x2 -= queries[i][1];
					x1 = Math.max(x1 - queries[i][1], 0);
				}
			}
		}
        
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}