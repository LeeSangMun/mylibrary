class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String pattern = "[^" + skill + "]";
        String temp;
        
        for (String str : skill_trees) {
        	str = str.replaceAll(pattern, "");
        	temp = skill.replace(str, "");
        	
        	if(str.isEmpty()) {
        		answer++;
        		continue;
        	} else if(temp.startsWith(String.valueOf(skill.charAt(0)))) {
        		continue;
        	}

        	answer++;
		}
        
        return answer;
    }
}