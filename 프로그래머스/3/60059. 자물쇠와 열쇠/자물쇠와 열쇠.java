class Solution {
    public boolean solution(int[][] key, int[][] lock) {
		int size = lock.length * 2 + key.length;
		int[][] temp = new int[size][size];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key[i].length; j++) {
				temp[i + lock.length][j + lock.length] = key[i][j];
			}
		}

		for (int n = 0; n < 4; n++) {
			for (int i = 0; i < size - lock.length + 1; i++) {
				for (int j = 0; j < size - lock.length + 1; j++) {
					boolean flag = false;

					outer: 
					for (int k = 0; k < lock.length; k++) {
						for (int l = 0; l < lock[k].length; l++) {
							if (temp[i + k][j + l] == lock[k][l]) {
								flag = true;
								break outer;
							}
						}
					}

					if (!flag) return true;
				}
			}
			temp = rotate(temp);
		}

		return false;
	}

	static int[][] rotate(int[][] key) {
		int[][] temp = new int[key.length][key.length];

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = key[key.length - j - 1][i];
			}
		}

		return temp;
	}
}