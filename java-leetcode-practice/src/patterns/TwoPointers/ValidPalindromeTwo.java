package patterns.TwoPointers;

public class ValidPalindromeTwo {
    public boolean solution(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                // Split off into checking if either the skipping the left or right character
                // will produce a valid palindrome, if not return false
                return helper(str, i + 1, j) || helper(str, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
