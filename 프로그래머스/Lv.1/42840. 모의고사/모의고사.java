import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
		int[] b = { 1, 3, 4, 5 };
		int[] c = { 3, 1, 2, 4, 5 };

		int p[] = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == (i % 5 + 1)) p[0]++;
			if (answers[i] == (i % 2 == 0 ? 2 : b[(i - i / 2 - 1) % 4])) p[1]++;
			if (answers[i] == c[(i / 2) % 5]) p[2]++;
		}

		int max = p[0];
		for (int i = 1; i < p.length; i++) {
			if(max < p[i]) max = p[i];
		}
		
		for (int i = 0; i < p.length; i++) {
			if(p[i] == max) list.add(i+1);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
    }
}