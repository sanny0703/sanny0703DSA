package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 * Example 1:
 *
 * Input: S = “havefunonleetcode”, K = 5
 *
 * Output: 6
 *
 * Explanation:
 *
 * There are 6 substrings they are:
 *
 * ‘havef’,’avefu’,’vefun’,’efuno’,’etcod’,’tcode’.
 */
public class KLengthSubStringsWithUniqueCharacters {
    public static int count(String s,int k){
        Map<Character,Integer> map = new HashMap<>();
        int countKLengthSubstrings =0;
        int i=0;
        for(int j=0;j<k;j++)
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
        if(map.size()==k)
            countKLengthSubstrings++;
        for(int j=k;j<s.length();j++){
            char charAtI = s.charAt(i);
            map.put(charAtI,map.get(charAtI)-1);
            if(map.get(charAtI)==0)
                map.remove(charAtI);
            i++;
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==k)
                countKLengthSubstrings++;
        }
        return countKLengthSubstrings;
    }

    public static void main(String[] args) {
        System.out.println(count("havefunonleetcode",5));
    }
}
