import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SherlockString {
    public static void main(String[] args) {
        String s = "aabbcccd";
        String result = isValid(s);
        System.out.println(result);
    }

    static String isValid(String s) {
        final String GOOD = "YES";
        final String BAD = "NO";

        if(s.isEmpty()) return BAD;
        if(s.length() <= 3) return GOOD;

        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 'a']++;
        }
        Arrays.sort(letters);
        int i=0;
        while(letters[i]==0){
            i++;
        }
        //System.out.println(Arrays.toString(letters));
        int min = letters[i];   //the smallest frequency of some letter
        int max = letters[25]; // the largest frequency of some letter
        String ret = BAD;
        if(min == max) ret = GOOD;
        else{
            // remove one letter at higher frequency or the lower frequency
            if(((max - min == 1) && (max > letters[24])) ||
                    (min == 1) && (letters[i+1] == max))
                ret = GOOD;
        }
        return ret;
    }

    private static void insertInMap(String s, Map<String, Integer> map) {
        for(int i = 0; i<s.length();i++){
            if(map.get(String.valueOf(s.charAt(i)))==null){
                map.put(String.valueOf(s.charAt(i)),1);
            } else {
                map.put(String.valueOf(s.charAt(i)),map.get(String.valueOf(s.charAt(i)))+1);
            }
        }
    }
}
