import java.util.*;

class Solution {
    static Set<boolean[]> set = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		boolean[] user = new boolean[user_id.length];
		boolean[] banned = new boolean[banned_id.length];
		f(user_id, banned_id, user, banned, 0);

		return set.size();
	}

	static void f(String[] user_id, String[] banned_id, boolean[] user, boolean[] banned, int n) {
		if (n == banned_id.length) {
			for (boolean[] b : set) {
				if(Arrays.equals(b, user))
					return;
			}
			
			set.add(user.clone());
			return;
		}
		
		for (int i = 0; i < user_id.length; i++) {
			if (!user[i]) {
				for (int j = 0; j < banned_id.length; j++) {
					if (!banned[j]) {
						if(user_id[i].length() != banned_id[j].length()) continue;
						
						int k = 0;
						for (k = 0; k < user_id[i].length(); k++) {
							if (banned_id[j].charAt(k) == '*')
								continue;
							else if (user_id[i].charAt(k) != banned_id[j].charAt(k))
								break;
						}

						if (k == user_id[i].length()) {
							user[i] = true;
							banned[j] = true;
							f(user_id, banned_id, user, banned, n + 1);
							user[i] = false;
							banned[j] = false;
							break;
						}
					}
				}
			}
		}
	}
}