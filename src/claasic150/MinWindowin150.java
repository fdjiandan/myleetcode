import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowin150 {

    public static void main(String[] args) {

        String s = "bbaa";
        String t = "aba";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        String res = "";
        int slen = s.length(), tlen = t.length();
        if(slen < tlen) {
            return res;
        }
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < tlen; i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Character c : tmap.keySet()
             ) {
            int n = smap.getOrDefault(c, 0);
            if(n < tmap.get(c)) {
                return res;
            }
        }
        smap.clear();
        Set<Character> keys = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            keys.add(t.charAt(i));
        }
        int start = 0;
        while (!keys.contains(s.charAt(start))) {
            start++;
        }
        smap.put(s.charAt(start), smap.getOrDefault(s.charAt(start), 0) + 1);
        if(tmap.get(s.charAt(start)) <= 1) {
            tmap.remove(s.charAt(start));
        } else {
            tmap.put(s.charAt(start), tmap.get(s.charAt(start)) - 1);
        }
        int end = start;
        if(tmap.isEmpty()) {
            res = s.substring(start, end+1);
            if(res.length() == t.length()) {
                return res;
            }
        }
        for (int i = end + 1; i < slen; i++) {
            while (i < slen && !keys.contains(s.charAt(i))) {
                i++;
            }
            if( i == slen) {
                break;
            }
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            int value = tmap.getOrDefault(s.charAt(i), 0);
            if(value <= 1) {
                tmap.remove(s.charAt(i));
            } else {
                tmap.put(s.charAt(i), value - 1);
            }
            if(tmap.isEmpty()) {
                end = i;
                res = s.substring(start, end + 1);
                break;
            }
        }
        if(res.length() == t.length()) {
            return res;
        }
        for (int i = 0; i < tlen; i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        while(end < slen) {
            Character c = s.charAt(start);
            smap.put(c, smap.get(c) - 1);
            int value = tmap.get(c) - smap.get(c);
            start += 1;
            while (start < end && !keys.contains(s.charAt(start))) {
                start++;
            }
            if(value <= 0) {
                String ns = s.substring(start, end+1);
                if(ns.length() < res.length()) {
                    res = ns;
                }
                if(res.length() == t.length()) {
                    return res;
                }
            } else {
                end += 1;
                while (end < slen && c != s.charAt(end)) {
                    if(keys.contains(s.charAt(end))) {
                        smap.put(s.charAt(end), smap.getOrDefault(s.charAt(end), 0)+1);
                    }
                    end++;
                }
                if(end >= slen) {
                    break;
                }
                smap.put(c, smap.get(c) + 1);
                String ns = s.substring(start, end+1);
                if(ns.length() < res.length()) {
                    res = ns;
                }
                if(res.length() == t.length()) {
                    return res;
                }
            }
        }
        return res;
    }
}
