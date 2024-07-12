class Solution {
    static int answer = Integer.MAX_VALUE;

	public int solution(int[][] beginning, int[][] target) {
		boolean[] row = new boolean[beginning.length];
		boolean[] col = new boolean[beginning[0].length];

		f(beginning, target, row, col, 0, 0, 0);

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	static void f(int[][] beginning, int[][] target, boolean[] row, boolean[] col, int x, int y, int n) {
		if (answer <= n)
			return;

		if (check(beginning, target)) {
			answer = Math.min(answer, n);
			return;
		}

		for (int i = x; i < row.length; i++) {
			if (!row[i]) {
				row[i] = true;

				for (int j = 0; j < beginning[i].length; j++) {
					beginning[i][j] ^= 1;
				}

				f(beginning, target, row, col, i+1, y, n + 1);

				for (int j = 0; j < beginning[i].length; j++) {
					beginning[i][j] ^= 1;
				}

				row[i] = false;
			}
		}

		for (int i = y; i < col.length; i++) {
			if (!col[i]) {
				col[i] = true;

				for (int j = 0; j < beginning.length; j++) {
					beginning[j][i] ^= 1;
				}

				f(beginning, target, row, col, x, i+1, n + 1);

				for (int j = 0; j < beginning.length; j++) {
					beginning[j][i] ^= 1;
				}
				col[i] = false;
			}
		}
	}

	static boolean check(int[][] beginning, int[][] target) {
		for (int i = 0; i < beginning.length; i++) {
			for (int j = 0; j < beginning[i].length; j++) {
				if (beginning[i][j] != target[i][j])
					return false;
			}
		}

		return true;
	}
}