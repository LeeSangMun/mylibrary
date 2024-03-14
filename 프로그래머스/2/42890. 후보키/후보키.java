import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();

	public static int solution(String[][] relation) {
		boolean[] flag = new boolean[relation[0].length];

		for (int i = 0; i < relation[0].length; i++) {
			flag[i] = !flag[i];
			f(relation, flag, String.valueOf(i), i);
			flag[i] = !flag[i];
		}
		
		return list.size();
	}

	static void f(String[][] relation, boolean[] flag, String idx, int k) {
		Set<String> set = new HashSet<>();

		for (int i = 0; i < relation.length; i++) {
			String temp = "";
			for (int j = 0; j < flag.length; j++) {
				if (flag[j])
					temp += relation[i][j];
			}
			
			if (!set.add(temp))
				break;
		}

		if (set.size() == relation.length) {
			int len1 = idx.length();
			for (int i = list.size() - 1; i >= 0; i--) {
				String temp = list.get(i);
				int len2 = temp.length();

				if (len1 > len2) {
					if (temp.replaceAll("[" + idx + "]", "").isEmpty()) {
						break;
					}
				} else if (len1 < len2) {
					if (idx.replaceAll("[" + temp + "]", "").isEmpty()) {
						list.remove(i);
					}
				}
			}
			list.add(idx);
			return;
		}

		for (int i = k+1; i < relation[0].length; i++) {
			if (!flag[i]) {
				flag[i] = !flag[i];
				f(relation, flag, idx + i, i);
				flag[i] = !flag[i];
			}
		}

	}
}