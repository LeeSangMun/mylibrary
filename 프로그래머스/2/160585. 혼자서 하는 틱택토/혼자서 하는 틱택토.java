import java.util.*;

class Solution {
    public int solution(String[] board) {
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 1, 2, 3 });
		list.add(new int[] { 4, 5, 6 });
		list.add(new int[] { 7, 8, 9 });
		list.add(new int[] { 1, 4, 7 });
		list.add(new int[] { 2, 5, 8 });
		list.add(new int[] { 3, 6, 9 });
		list.add(new int[] { 1, 5, 9 });
		list.add(new int[] { 3, 5, 7 });

		List<Integer> O = new ArrayList<>();
		List<Integer> X = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if(board[i].charAt(j) == 'O') {
					O.add(i*3+j+1);
				} else if(board[i].charAt(j) == 'X') {
					X.add(i*3+j+1);
				}
			}
		}

		if(O.size() < X.size() || Math.abs(O.size() - X.size()) >= 2)
			return 0;
		
		boolean bO = f(list, O);
		boolean bX = f(list, X);
		
		if(bO && bX) {
			return 0;
		} else if(bO && (O.size() == X.size())) {
			return 0;
		} else if(bX && (O.size() > X.size())) {
			return 0;
		}
		
		return 1;
	}
	
	static boolean f(List<int[]> list, List<Integer> OX) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			flag = false;
			for (int j = 0; j < temp.length; j++) {
				int k;
				for (k = 0; k < OX.size(); k++) {
					if(temp[j] == OX.get(k)) {
						flag = true;
						break;
					}
				}
				
				if(k == OX.size()) {
					flag = false;
					break;
				}
			}
			
			if(flag) 
				break;
		}
		
		return flag;
	}
}