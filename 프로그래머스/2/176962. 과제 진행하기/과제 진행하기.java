import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
		List<String> list = new ArrayList<>();
        Stack<String[]> st = new Stack<>();
        
        Arrays.sort(plans, (plan1, plan2) -> plan1[1].compareTo(plan2[1]));
        int c = Integer.parseInt(f1(plans[0][1]));
        st.add(plans[0]);
        
        for (int i = 1; i < plans.length; i++) {
			while(true) {
				if(st.isEmpty()) {
					c = Integer.parseInt(f1(plans[i][1]));
					st.add(plans[i]);
					break;
				}
				
				String[] temp = st.pop();
				int n = (c + Integer.parseInt(temp[2])) - Integer.parseInt(f1(plans[i][1]));
				if(n > 0) {
					c = Integer.parseInt(f1(plans[i][1]));
					st.add(new String[] {temp[0], temp[1], String.valueOf(n)});
					st.add(plans[i]);
					break;
				} else if(n == 0) {
					c += Integer.parseInt(temp[2]);
					list.add(temp[0]);
					st.add(plans[i]);
					break;
				} else {
					c += Integer.parseInt(temp[2]);
					list.add(temp[0]);
				}
			}
		}
        
        while(!st.isEmpty()) {
        	list.add(st.pop()[0]);
        }
        
        return list.toArray(String[]::new);
    }
	
	static String f1(String time) {
		String[] temp = time.split(":");
		int t = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
		
		return String.valueOf(t);
	}
}