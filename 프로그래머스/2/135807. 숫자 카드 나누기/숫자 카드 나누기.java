import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        TreeSet<Integer> A = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> B = new TreeSet<>(Comparator.reverseOrder());
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int lastA = arrayA[arrayA.length-1];
        int lastB = arrayB[arrayB.length-1];
        
        A.add(lastA);
        B.add(lastB);
        for (int i = 2; i <= lastA/2; i++) {
			if(lastA % i == 0)
				A.add(i);
		}
        
        for (int i = 2; i <= lastB/2; i++) {
			if(lastB % i == 0) {
				B.add(i);
			}
		}
        
        for (Integer i : A) {
        	int j;
        	for (j = 0; j < arrayA.length; j++) {
				if(arrayA[j] % i != 0)
					break;
			}
        	if(j < arrayA.length) continue;
        	
			for (j = 0; j < arrayB.length; j++) {
				if(arrayB[j] % i == 0)
					break;
			}
			if(j < arrayB.length) continue;
			
			answer = Math.max(answer, i);
		}
        
        for (Integer i : B) {
        	int j;
        	for (j = 0; j < arrayB.length; j++) {
				if(arrayB[j] % i != 0)
					break;
			}
        	if(j < arrayB.length) continue;
        	
			for (j = 0; j < arrayA.length; j++) {
				if(arrayA[j] % i == 0)
					break;
			}
			if(j < arrayA.length) continue;
			
			answer = Math.max(answer, i);
		}
        
        return answer;
    }
}