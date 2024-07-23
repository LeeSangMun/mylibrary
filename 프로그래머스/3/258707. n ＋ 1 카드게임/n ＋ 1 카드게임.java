import java.util.*;

class Solution {
    static int hap;
	
	public int solution(int coin, int[] cards) {
        int answer = 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int idx = cards.length/3;
        hap = cards.length + 1;
        
        for (int i = 0; i < idx; i++) {
        	left.add(cards[i]);
		}
        
        while(true) {
        	if(idx < cards.length) {
        		right.add(cards[idx++]);
        		right.add(cards[idx++]);
        	}
        	
        	if(remove(left)) {
        		answer++;
        		continue;
        	} else if(remove(left, right) && coin >= 1) {
        		answer++;
        		coin--;
        		continue;
        	} else if(remove(right) && coin >= 2) {
        		answer++;
        		coin -= 2;
        		continue;
        	}
        	
        	break;
        }
        
        return Math.min(answer, (cards.length - cards.length/3)/2+1);
    }
	
	static boolean remove(List<Integer> left, List<Integer> right) {
		for (int i = 0; i < left.size(); i++) {
    		int n = left.get(i);
			if(right.contains(hap-n)) {
				left.remove(Integer.valueOf(n));
				right.remove(Integer.valueOf(hap-n));
				return true;
			}
		}
		
		return false;
	}
	
	static boolean remove(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			if(list.contains(hap-n)) {
				list.remove(Integer.valueOf(n));
				list.remove(Integer.valueOf(hap-n));
				return true;
			}
		}
		
		return false;
	}
}