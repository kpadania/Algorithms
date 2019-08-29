public class MakingAnagrams {
    public static void main(String[] args) {
        String a = "abc";
        String b = "cde";
        int result = makeAnagram(a,b);
        System.out.println(result);
    }

    static int makeAnagram(String a, String b) {

        int[] lettercounts = new int[26];
        for (char c : a.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        return result;
    }
}
