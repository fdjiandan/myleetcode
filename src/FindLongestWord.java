import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord {
    public static void main(String[] args) {
        List<String> dirtionary = new ArrayList<>();
        dirtionary.add("ale");
        dirtionary.add("apple");
        dirtionary.add("aaple");
        dirtionary.add("monkey");
        dirtionary.add("plea");
        String s = "abpcplea";
        System.out.println(findLongestWord(s, dirtionary));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary = sortList(dictionary);
        for (int i = 0; i < dictionary.size(); i++) {
            String target = dictionary.get(i);
            int tpoint = 0;
            int tlen = target.length();
            for (int j = 0; j < s.length(); j++) {
                if(target.charAt(tpoint) == s.charAt(j)) {
                    ++tpoint;
                }
                if(tpoint == tlen) {
                    return target;
                }
            }
        }
        return "";
    }

    public static List<String> sortList(List<String> dictionary) {
        dictionary.sort((o1, o2)-> {
                if(o1.length() != o2.length())
                    return o2.length() - o1.length();
                else
                    return o1.compareTo(o2);
            });
        return dictionary;
    }
}
