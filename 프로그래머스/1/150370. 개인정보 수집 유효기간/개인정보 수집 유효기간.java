import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        String[] temp;
        
        for (String term : terms) {
			temp = term.split(" ");
			map.put(temp[0], Integer.parseInt(temp[1]));
		}
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        int d;
        try {
			Date date = sdf.parse(today);
			Date after;
			
			for (int i=0; i<privacies.length; i++) {
				temp = privacies[i].split(" ");
				d = map.get(temp[1]);
				after = sdf.parse(temp[0]);
				after.setMonth(after.getMonth()+d);
				if(!date.before(after)) list.add(i+1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}