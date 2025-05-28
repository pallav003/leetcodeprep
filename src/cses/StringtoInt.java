package cses;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "42"
 * <p>
 * Output: 42
 * <p>
 * Explanation:
 * <p>
 * The underlined characters are what is read in and the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * Example 2:
 * <p>
 * Input: s = " -042"
 * <p>
 * Output: -42
 * <p>
 * Explanation:
 * <p>
 * Step 1: "   -042" (leading whitespace is read and ignored)
 * ^
 * Step 2: "   -042" ('-' is read, so the result should be negative)
 * ^
 * Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
 * ^
 * Example 3:
 * <p>
 * Input: s = "1337c0d3"
 * <p>
 * Output: 1337
 * <p>
 * Explanation:
 * <p>
 * Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
 * ^
 * Example 4:
 * <p>
 * Input: s = "0-1"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Step 1: "0-1" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
 * ^
 * Example 5:
 * <p>
 * Input: s = "words and 987"
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Reading stops at the first non-digit character 'w'.
 */
public class StringtoInt {
    public int myAtoi(String s) {
        int idx = 0;
        int res = 0;
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
        int sign = 1;
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            int digit = s.charAt(idx) - '0';
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            idx++;
        }
        return sign * res;
    }

}
