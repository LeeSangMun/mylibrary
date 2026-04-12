import java.util.*;

class Solution {
    static int answer = 0;

    public static int solution(int n, int infection, int[][] edges, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        List<int[]> list = null;
        Set<Integer> inf = new HashSet<>();
        inf.add(infection);

        for (int[] edge : edges) {
            list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], list);

            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(new int[]{edge[0], edge[2]});
            map.put(edge[1], list);
        }

        f(map, inf, 0, k);

        return answer;
    }

    static void f(Map<Integer, List<int[]>> map, Set<Integer> inf, int type,  int k) {
        if(k == 0) {
            answer = Integer.max(answer, inf.size());
            return;
        }

        for (int j = 1; j <= 3; j++) {
            if (type == j)
                continue;

            Queue<Integer> que = new LinkedList<>(inf);
            Set<Integer> infTemp = new HashSet<>(inf);

            while (!que.isEmpty()) {
                int temp = que.poll();
                List<int[]> list = map.get(temp);

                for (int[] v : list) {
                    if (v[1] == j && !infTemp.contains(v[0])) {
                        infTemp.add(v[0]);
                        que.offer(v[0]);
                    }
                }
            }

            f(map, infTemp, j, k - 1);
        }
    }
}