import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        TreeMap<String, TreeSet<int[]>> playMap = new TreeMap<>();
        TreeSet<int[]> set = null;
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
			totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
			set = playMap.get(genres[i]);
			if(set == null) {
				set = new TreeSet<>((arr1, arr2) -> arr2[1] == arr1[1] ? arr1[0] - arr2[0] : arr2[1] - arr1[1]);
				playMap.put(genres[i], set);
			}
			set.add(new int[] {i, plays[i]});
		}
        
        List<Map.Entry<String,Integer>> list = totalMap.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        
        for (Entry<String, Integer> entry : list) {
			set = playMap.get(entry.getKey());
			int size = Math.min(set.size(), 2);
			for (int i = 0; i < size; i++) {
				answer.add(set.pollFirst()[0]);
			}
		}
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}