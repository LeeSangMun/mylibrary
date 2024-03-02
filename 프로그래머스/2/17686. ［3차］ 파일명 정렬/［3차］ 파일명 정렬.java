import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				String h1 = s1.split("\\d")[0];
				String h2 = s2.split("\\d")[0];
				
				String n1 = "";
				String n2 = "";
				
				for (int i = h1.length(); i < h1.length() + 5; i++) {
					if(i >= s1.length() || !Character.isDigit(s1.charAt(i)))
						break;
					n1 += s1.charAt(i);
				}
				
				for (int i = h2.length(); i < h2.length() + 5; i++) {
					if(i >= s2.length() || !Character.isDigit(s2.charAt(i)))
						break;
					n2 += s2.charAt(i);
				}
				
				if(h1.equalsIgnoreCase(h2)) {
					return Integer.compare(Integer.parseInt(n1), Integer.parseInt(n2));
				} else {
					return h1.compareToIgnoreCase(h2);
				}
				
			}
		});

		return files;
    }
}