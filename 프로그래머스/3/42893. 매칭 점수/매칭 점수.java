import java.util.*;

class Data {
	int idx = -1;
	int bs;
	int els;
	double ls;
	double total;
	List<String> list = new ArrayList<>();
}

class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
		double max = 0;
		Map<String, Data> map = new HashMap<>();
		Data data = null;
        word = word.toLowerCase();

		for (int i = 0; i < pages.length; i++) {
			pages[i] = pages[i].toLowerCase();
			int uriStart = pages[i].indexOf("<meta property=\"og:url\" content=\"") + "<meta property=\"og:url\" content=\"".length();
			int uriEnd = pages[i].indexOf("\"/>", uriStart);
			String uri = pages[i].substring(uriStart, uriEnd);
			
			if(!map.containsKey(uri)) {
				data = new Data();
				map.put(uri, data);
			}
					
			data = map.get(uri);
			data.idx = i;
			
			int idx = pages[i].indexOf("<body>");
			while((idx = pages[i].indexOf(word, idx)) != -1) {
				if(Character.isAlphabetic(pages[i].charAt(idx-1)) || Character.isAlphabetic(pages[i].charAt(idx+word.length()))) {
					idx += word.length();
					continue;
				}
				
				data.bs++;
				idx += word.length();
			}
			
			
			idx = 0;
			String linkStart = "<a href=\"";
			while((idx = pages[i].indexOf(linkStart, idx)) != -1) {
				int linkEnd = pages[i].indexOf("\">", idx + linkStart.length());
				String link = pages[i].substring(idx + linkStart.length(), linkEnd);
				Data temp = map.get(link);
				
				if(temp == null) {
					temp = new Data();
					map.put(link, temp);
				}
				
				temp.list.add(uri);
				data.els++;
				idx += "\">".length();
			}
		}
		
		for (Data d : map.values()) {
			for (String s : d.list) {
				Data t = map.get(s);
				d.ls += t.bs / (double)t.els;
			}
			d.total = d.bs + d.ls;
			
			if(d.total == max && answer > d.idx && d.idx != -1) {
				answer = d.idx;
				max = d.total;
			} else if(d.total > max) {
				answer = d.idx;
				max = d.total;
			}
		}
		
		return answer;
    }
}