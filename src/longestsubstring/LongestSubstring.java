package longestsubstring;

/**
 * Finds longest substring of a given string that contains no more than a specified number of
 * distinct characters.
 */
public class LongestSubstring {

    private final String s;
    private final int length;
    private final int maxChars;

    protected LongestSubstring(String s, int maxChars) {
        this.s = s;
        length = s.length();
        this.maxChars = maxChars;
    }

    /**
     * Returns longest substring of the given string that contains no more than the specified number
     * of distinct characters.
     */
    public static String find(String s, int maxChars) {
        return new LongestSubstring(s, maxChars).find();
    }

    protected String find() {
        int i = 0; // start of substring
        int j = 0; // end of substring (exclusive)
        String result = "";
        while (j <= length) {
            while (i < j && !satisfies(i, j)) i++;
            while (++j <= length && satisfies(i, j)) { }
            if ((j - 1) - i > result.length()) {
                result = s.substring(i, j - 1);
            }
        }
        return result;
    }

    /**
     * Returns {@code true} if the number of distinct characters between {@code beginIndex} and
     * {@code endIndex} is not greater than {@code maxChars}.
     *
     * @param beginIndex beginning index, inclusive
     * @param endIndex ending index, exclusive
     * @return
     */
    protected boolean satisfies(int beginIndex, int endIndex) {
        char[] charSet = new char[maxChars];
        int numChars = 0;
        for (int index = beginIndex; index < endIndex; index++) {
            char ch = s.charAt(index);
            // find ch in array of distint characters
            int pos;
            for (pos = 0; pos < numChars && charSet[pos] != ch; pos++) { }
            if (pos < numChars) {
                continue; // not distinct
            }
            if (numChars == maxChars) {
                return false; // maxChars exceeded
            }
            // add ch to distinct characters
            charSet[numChars++] = ch;
        }
        return true;
    }
}
