import java.util.Arrays;

public class LongCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 1. Sort strings alphabetically
        Arrays.sort(strs);

        // 2. Only compare the first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;

        // 3. Advance pointer while characters match within bounds
        while (i < first.length() && i < last.length()) {
            if (first.charAt(i) == last.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        // 4. Return the matching prefix from index 0 up to i (exclusive)
        return first.substring(0, i);
    }
}