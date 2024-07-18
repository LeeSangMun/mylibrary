class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
        	double n1 = Double.MAX_VALUE, n2 = Double.MAX_VALUE, n3 = Double.MAX_VALUE, n4 = Double.MAX_VALUE;
        	if(!(startY == balls[i][1] && startX > balls[i][0])) 
        		n1 = Math.pow(startX-(-balls[i][0]), 2) + Math.pow(startY-balls[i][1], 2);
        	if(!(startX == balls[i][0] && startY > balls[i][1]))
        		n2 = Math.pow(startX-balls[i][0], 2) + Math.pow(startY-(-balls[i][1]), 2);
        	if(!(startY == balls[i][1] && startX < balls[i][0]))
        		n3 = Math.pow(startX-(balls[i][0]+(m-balls[i][0])*2), 2) + Math.pow(startY-balls[i][1], 2);
        	if(!(startX == balls[i][0] && startY < balls[i][1])) 
        		n4 = Math.pow(startX-balls[i][0], 2) + Math.pow(startY-(balls[i][1]+(n-balls[i][1])*2), 2);
        	
        	answer[i] = (int)Math.min(n1, Math.min(n2, Math.min(n3, n4)));
		}
        
        return answer;
    }
}