class Solution {
    public String solution(String s, String skip, int index) {
        String str = "abcdefghijklmnopqrstuvwxyz";
		str = str.replaceAll("[" + skip + "]", "");
		
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt((str.indexOf(ch[i])+index)%str.length());
		}
		
        return new String(ch);
    }
}