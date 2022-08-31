package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 *
 * You can return the answer in any order.
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 */
public class SubstringConcatOfAllWords {
    public static List<Integer> findSubstring(String s,String[] words){
        Map<String,Integer> counter = new HashMap<>();
        for(String word:words) counter.put(word,counter.getOrDefault(word,0)+1);
        int sLen = s.length(),n = words.length,wordLen = words[0].length();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<sLen-n*wordLen+1;i++){
            if(isConcat(s.substring(i,i+n*wordLen),counter,wordLen)) res.add(i);
        }
        return res;

    }
    public static boolean isConcat(String substr,Map<String,Integer> counter,int wordLen){
        Map<String,Integer> seen = new HashMap<>();
        for(int i=0;i<substr.length();i+= wordLen){
            String str = substr.substring(i,i+wordLen);
            seen.put(str,seen.getOrDefault(str,0)+1);
        }
        return counter.equals(seen);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman",new String[]{"foo","bar","the"}));
    }
}
