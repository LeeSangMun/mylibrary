import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        final int SIZE = 50;
        String[][] table = new String[SIZE][SIZE];
        String[][] merge = new String[SIZE][SIZE];
        
        for (int i = 0; i < SIZE; i++) {
        	for (int j = 0; j < SIZE; j++) {
				table[i][j] = "EMPTY";
				merge[i][j] = i + " " + j;
			}
        }
        
        for (int i = 0; i < commands.length; i++) {
        	String[] temp = commands[i].split(" ");
        	
			if(temp[0].equals("UPDATE")) {
				if(temp.length == 4) {
					int r1 = Integer.parseInt(temp[1]);
					int c1 = Integer.parseInt(temp[2]);				
					String s1 = merge[r1-1][c1-1];
					
					for (int j = 0; j < SIZE; j++) {
						for (int k = 0; k < SIZE; k++) {
							if(merge[j][k].equals(s1)) {
								table[j][k] = temp[3];
							}
						}
					}	
				} else {
					for (int j = 0; j < SIZE; j++) {
						for (int k = 0; k < SIZE; k++) {
							if(table[j][k].equals(temp[1])) table[j][k] = temp[2];
						}
					}
				}
			} else if(temp[0].equals("MERGE")) {			
				int r1 = Integer.parseInt(temp[1]);
				int c1 = Integer.parseInt(temp[2]);
				int r2 = Integer.parseInt(temp[3]);
				int c2 = Integer.parseInt(temp[4]);
				
				String s1 = merge[r1-1][c1-1], s2 = merge[r2-1][c2-1];
				String str = table[r1-1][c1-1].equals("EMPTY") ? table[r2-1][c2-1] : table[r1-1][c1-1];
				
				if(s1.equals(s2)) continue;
				
				for (int j = 0; j < SIZE; j++) {
					for (int k = 0; k < SIZE; k++) {
						if(merge[j][k].equals(s2) || merge[j][k].equals(s1)) {
							table[j][k] = str;
							merge[j][k] = s1;
						}
					}
				}				
			} else if(temp[0].equals("UNMERGE")) {
				int r1 = Integer.parseInt(temp[1]);
				int c1 = Integer.parseInt(temp[2]);
				
				String s = merge[r1-1][c1-1];
				String str = table[r1-1][c1-1];
				
				for (int j = 0; j < SIZE; j++) {
					for (int k = 0; k < SIZE; k++) {
						if(merge[j][k].equals(s)) {
							merge[j][k] = j + " " + k;
							table[j][k] = "EMPTY";
						}
					}
				}
				table[r1-1][c1-1] = str;
			} else {
				answer.add(table[Integer.parseInt(temp[1])-1][Integer.parseInt(temp[2])-1]);
			}
		}
        
        return answer.toArray(String[]::new);
    }
}