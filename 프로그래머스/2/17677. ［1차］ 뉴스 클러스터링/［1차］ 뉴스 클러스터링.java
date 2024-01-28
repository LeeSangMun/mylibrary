import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list = new ArrayList<>();
        int hap = 0, kyo = 0;
        String str;
        
        for (int i = 0; i < str1.length()-1; i++) {
			if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))) {
				list.add(str1.substring(i, i+2).toLowerCase());
				hap++;
			} 
		}
        
        for (int i = 0; i < str2.length()-1; i++) {
        	if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))) {
        		str = str2.substring(i, i+2).toLowerCase();
        		if (list.contains(str)) {
        			kyo++;
        			list.remove(str);
				} else {
					hap++;
				}
				
			}
		}
        
        if(kyo == 0 && hap == 0) return 65536;
        
        return (int)((double)kyo / hap * 65536);
    }
}