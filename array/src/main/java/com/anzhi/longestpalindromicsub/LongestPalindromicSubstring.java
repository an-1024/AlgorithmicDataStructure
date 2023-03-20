package com.anzhi.longestpalindromicsub;

/**
 * 最长回文子串：中心扩展法
 * 枚举所有可能的回文子串的中心位置。注意中心位置的奇偶
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        // 长度小于 2 只有一个字符直接返回
        if (len < 2) {
            return s;
        }

        int maxLen = 0;
        // 开始截取字符串长度的位置
        int begin = 0;

        char[] charArray = s.toCharArray();
        // len -1 最后一位没有必要进行扩散
        for (int i = 0; i < len - 1; i++) {
            // 奇数长度的中心位置
            int oddLen = expandArroundCenter(charArray, i, i);
            // 偶数长度的中心位置
            int evenLen = expandArroundCenter(charArray, i, i + 1);

            // 获取本次循环的最大回文子串长度
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 需要画图总结规律
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private int expandArroundCenter(char[] charArray, int left, int right) {
        // 当 left=right 时，回文中心是一个字符，回文串的长度是奇数
        // 当right = left + 1 时， 回文中心时两个字符串，回文串的长度时偶数
        int len = charArray.length;
        int i = left, j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出 while 循环的时候，恰好满足 s.charAt(i) != s.charAt(j);
        // 回文串的长度时 j-i-1
        return j - i - 1;
    }

    public static void main(String[] args) {
        String strTarget = "aaba";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome(strTarget);
        System.out.println(result);
    }
}
