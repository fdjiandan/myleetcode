import java.util.*;

public class RandomizedSet {

    private Map<Integer,Integer> index;
    private List<Integer> values;

    public RandomizedSet() {
        index = new HashMap<>();
        values = new LinkedList<>();
    }

    public boolean insert(int val) {
        if(index.containsKey(val)) {
            return false;
        }
        values.add(val);
        index.put(val, values.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(index.containsKey(val)) {
            int pos = index.get(val);
            index.remove(val);
            int last = values.size()-1;
            if(pos == last) {
                values.remove(pos);
            } else {
                int nv = values.get(last);
                index.put(nv, pos);
                values.set(pos, nv);
                values.remove(last);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        int val = random.nextInt(values.size());
        return values.get(val);
    }

    public static void main(String[] args) {
        RandomizedSet rs  = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}
