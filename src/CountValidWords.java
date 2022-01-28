public class CountValidWords {

    public static void main(String[] args) {

        String sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.";
        System.out.println(countValidWords(sentence));

    }

    public static int countValidWords(String sentence) {
        if(sentence.isEmpty())
            return 0;
        String[] words = sentence.split(" ");
        int count = 0;
        for (String word : words
             ) {
            if(isValid(word))
                count++;
        }
        return count;
    }

    public static boolean isValid(String word) {
        if(word.isEmpty())
            return false;
        word = word.trim();
        boolean find = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(Character.isDigit(c)) {
                return false;
            }
            if(c == '-') {
                if(find)
                    return false;
                find = true;
                if(i == word.length() - 1 || i == 0) {
                    return false;
                }
                if(!Character.isLowerCase(word.charAt(i-1)) || !Character.isLowerCase(word.charAt(i+1)))
                    return false;
            }
            if(c == '!' || c == ',' || c == '.') {
                if(i != word.length()-1)
                    return false;
            }
        }
        return true;
    }
}
