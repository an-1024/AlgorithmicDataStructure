package com.anzhi.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        // 利用集合记录元素是否重复
        Set<Character> setStr = new HashSet<>();
        int len = s.length();
        // 设置右指针初始值 rk = -1，表示未开始移动 
        int rk = -1, ans = 0;
        for(int i=0; i<len; i++){
            // 移除第一个元素，开始判断下一个元素的最长子串
            if(i != 0){
                setStr.remove(s.charAt(i-1));
            }

            // 循环判断下一个元素是否在集合中,如果不包含，放入集合，右指针移动。切右指针不能超过字符串长度
            while(rk + 1 < len && !setStr.contains(s.charAt(rk + 1))){
                setStr.add(s.charAt(rk+1));
                ++rk;
            }
            // 每次循环比较 ans 的值
            ans = Math.max(ans, rk -i + 1);
        }
        return ans;
    }
}
