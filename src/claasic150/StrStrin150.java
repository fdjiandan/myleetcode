public class StrStrin150 {

    public static void main(String[] args) {
        String haystack = "", needle = "sadf";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
