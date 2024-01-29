import java.util.*;

public class FindSubstringin150 {
    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length(), wnum = words.length, wlen = words[0].length();
        for (int i = 0; i < slen; i++) {
            if(i + wnum * wlen > slen) {
                break;
            }
            Map<String, Integer> find = new HashMap<>();
            for (int j = 0; j < wnum; j++) {
                find.put(words[j], find.getOrDefault(words[j], 0) + 1);
            }
            for (int j = 0; j < wnum; j++) {
                String p = s.substring(i + j * wlen, i + (j+1)*wlen);
                if(!find.containsKey(p)) {
                    break;
                }
                if(find.get(p) == 1) {
                    find.remove(p);
                } else {
                    find.put(p, find.get(p) - 1);
                }
            }
            if(find.isEmpty()) {
                res.add(i);
            }
        }
        return res;
    }
}
