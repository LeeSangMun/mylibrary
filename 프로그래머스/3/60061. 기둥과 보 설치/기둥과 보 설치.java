import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
		List<int[]> list = new ArrayList<>();
		boolean[][] column = new boolean[n][n + 1];
		boolean[][] girder = new boolean[n + 1][n];
		
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][1];
			int y = build_frame[i][0];
			
			if(build_frame[i][3] == 1) {
				if(build_frame[i][2] == 0) {
					if(addCol(x, y, column, girder)) column[x][y] = true;
				} else {
					if(addGir(x, y, column, girder, n)) girder[x][y] = true;
				}
			} else {
				boolean flag = false;
				
				if(build_frame[i][2] == 0) {
					column[x][y] = false;
					if(girder[x+1][y] && !addGir(x+1, y, column, girder, n)) flag = true;
					if(y-1 >= 0) {
						if(girder[x+1][y-1] && !addGir(x+1, y-1, column, girder, n)) flag = true;
					}
					if(x+1 < n) {
						if(column[x+1][y] && !addCol(x+1, y, column, girder)) flag = true;
					}
					
					if(flag) column[x][y] = true;
				} else {
					girder[x][y] = false;
					if(column[x][y] && !addCol(x, y, column, girder)) flag = true;
					if(column[x][y+1] && !addCol(x, y+1, column, girder)) flag = true;
					if(y-1 >= 0) {
						if(girder[x][y-1] && !addGir(x, y-1, column, girder, n)) flag = true;
					}
					if(y+1 < n) {
						if(girder[x][y+1] && !addGir(x, y+1, column, girder, n)) flag = true;
					}
					
					if(flag) girder[x][y] = true;
				}
			}
		}
		
		for (int i = 0; i < column.length; i++) {
			for (int j = 0; j < column[i].length; j++) {
				if(column[i][j]) list.add(new int[] {j, i, 0});
			}
		}
		
		for (int i = 0; i < girder.length; i++) {
			for (int j = 0; j < girder[i].length; j++) {
				if(girder[i][j]) list.add(new int[] {j, i, 1});
			}
		}

		Collections.sort(list,
				(arr1, arr2) -> arr1[0] == arr2[0] ? (arr1[1] == arr2[1] ? arr1[2] - arr2[2] : arr1[1] - arr2[1])
						: arr1[0] - arr2[0]);

		return list.toArray(int[][]::new);
	}
	
	static boolean addCol(int x, int y, boolean[][] column, boolean[][] girder) {
		return x == 0 || column[x-1][y] || girder[x][y] || girder[x][Math.max(y-1, 0)];
	}
	
	static boolean addGir(int x, int y, boolean[][] column, boolean[][] girder, int n) {
		return column[x-1][y] || column[x-1][y+1] 
				|| (y-1 >= 0 && girder[x][y-1] && (y+1 < n && girder[x][y+1]));
	}
}