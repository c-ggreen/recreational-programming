package patterns.TwoPointers;

public class ValidPalindrome {

    public boolean solution(String s) {
        String formatted_s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int i = 0;
        int j = formatted_s.length() - 1;

        while (i < j) {
            if (formatted_s.charAt(i) != formatted_s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}