import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		int[][] n = new int[nodeinfo.length][3];

		for (int i = 0; i < n.length; i++) {
			n[i] = new int[] { nodeinfo[i][0], nodeinfo[i][1], i + 1 };
		}
		Arrays.sort(n, (arr1, arr2) -> arr2[1] - arr1[1]);
		Node p = new Node(null, null, n[0][0], n[0][2]);

		for (int i = 1; i < n.length; i++) {
			Node temp = p;
			while (true) {
				if (temp.n == -1) {
					temp.n = n[i][0];
					temp.idx = n[i][2];
					break;
				} else if (n[i][0] > temp.n) {
					temp = temp.right = temp.right == null ? new Node(null, null, -1, 0) : temp.right;
				} else {
					temp = temp.left = temp.left == null ? new Node(null, null, -1, 0) : temp.left;
				}
			}
		}

		a(new Node(p.left, p.right, p.n, p.idx), answer[0]);
		b(new Node(p.left, p.right, p.n, p.idx), answer[1]);

		return answer;
	}
	
	static void a(Node temp, int[] answer) {
		Stack<Node> st = new Stack<>();
		int idx = 0;
		st.add(temp);
		
		while (idx != answer.length) {
			answer[idx++] = temp.idx;

			if (temp.left != null) {
				if(temp.right != null) 
					st.push(temp.right);

				temp = temp.left;
			} else if (temp.right != null) {
				temp = temp.right;
			} else {
				temp = st.pop();
			}
		}
	}
	
	static void b(Node temp, int[] answer) {
		Stack<Node> st = new Stack<>();
		boolean[] flag = new boolean[answer.length];
		int idx = 0;
		st.push(temp);
		
		while (idx != answer.length) {		
			if (temp.left != null && !flag[temp.left.idx-1]) {
				st.push(temp);
				temp = temp.left;
			} else if (temp.right != null && !flag[temp.right.idx-1]) {
				st.push(temp);
				temp = temp.right;
			} else {
				flag[temp.idx-1] = true;
				answer[idx++] = temp.idx;
				temp = st.pop();
			}
		}
	}
}

class Node {
	Node left;
	Node right;
	int n;
	int idx;

	public Node(Node left, Node right, int n, int idx) {
		this.left = left;
		this.right = right;
		this.n = n;
		this.idx = idx;
	}
}