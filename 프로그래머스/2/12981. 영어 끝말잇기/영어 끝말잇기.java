import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
		String str;

		list.add(words[0]);
		
		for (int i = 1; i < words.length; i++) {
			if (list.contains(words[i])) {
				return new int[] { i % n + 1, i / n + 1 };
			} else {
				str = list.get(list.size() - 1);
				if(str.charAt(str.length()-1) != words[i].charAt(0)) {
					return new int[] { i % n + 1, i / n + 1 };	
				}
			}
			list.add(words[i]);
		}

		return new int[] { 0, 0 };
    }
}