public class Test {
    public static void main(String[] args) {

        StringBuilder s = new StringBuilder();
        s.append("helo");
        for (int i = 0; i < 9; i++) {
            s.append(" ");
        }
        System.out.println(s.toString().length());
    }
}
