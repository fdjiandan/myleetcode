import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FullJustify {

    public static void main(String[] args) {

        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWith = 16;
        List<String> res = fullJustify(words, maxWith);
        for (String s : res) {
            System.out.print(s.length());
            System.out.println( ":" + s);
        }
        //System.out.println(res);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; ) {
            StringBuilder line = new StringBuilder();
            Queue<String> twords = new LinkedList<>();
            int si = i;
            int sl = 0;
            while (sl <= maxWidth && si < len) {
                int tl = words[si].length();
                if(sl > 0) {
                    tl += 1;
                }
                if(sl + tl < maxWidth) {
                    sl += tl;
                    twords.add(words[si]);
                    i = si + 1;
                    si++;
                } else if(sl + tl == maxWidth){
                    twords.add(words[si]);
                    for(String word : twords) {
                        line.append(" ").append(word);
                    }
                    res.add(line.substring(1));
                    i = si + 1;
                    twords.clear();
                    break;
                } else {
                    int num = twords.size();
                    int acc = maxWidth - sl;
                    if(num == 1) {
                        line.append(twords.poll());
                        for (int j = 0; j < acc; j++) {
                            line.append(" ");
                        }
                    } else {
                        int ak = acc / (num - 1);
                        int an = acc % (num - 1);
                        for (int j = 0; j < num; j++) {
                            if(j == 0) {
                                line.append(twords.poll());
                            } else {
                                for (int k = 0; k < ak; k++) {
                                    line.append(" ");
                                }
                                if(j <= an) {
                                    line.append(" ");
                                }
                                line.append(" ").append(twords.poll());
                            }
                        }
                    }
                    res.add(line.toString());
                    i = si;
                    twords.clear();
                    break;
                }
            }
            if(!twords.isEmpty()) {
                int num = twords.size();
                int acc = maxWidth - sl;
                if(num == 1) {
                    line.append(twords.poll());
                    for (int j = 0; j < acc; j++) {
                        line.append(" ");
                    }
                } else {
                    int ak = acc / (num - 1);
                    int an = acc % (num - 1);
                    for (int j = 0; j < num; j++) {
                        if(j == 0) {
                            line.append(twords.poll());
                        } else {
                            for (int k = 0; k < ak; k++) {
                                line.append(" ");
                            }
                            if(j <= an) {
                                line.append(" ");
                            }
                            line.append(" ").append(twords.poll());
                        }
                    }
                }
                res.add(line.toString());
                i += num;
            }
        }
        int size = res.size();
        if(size > 0) {
            String s = res.get(size-1);
            res.remove(size-1);
            String[] ss = s.split(" ");
            StringBuilder rs = new StringBuilder();
            for (int i = 0; i < ss.length; i++) {
                if(!ss[i].isEmpty())
                    rs.append(" ").append(ss[i]);
            }
            rs.deleteCharAt(0);
            int n = maxWidth - rs.length();
            for (int i = 0; i < n; i++) {
                rs.append(" ");
            }
            res.add(rs.toString());
        }
        return res;
    }
}
