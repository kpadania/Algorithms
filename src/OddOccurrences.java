import java.util.HashMap;
import java.util.Map;

public class OddOccurrences {

    public static void main(String[] args) {
        int[] a = {9,3,9,3,9,9};
        int result = solution(a);
        System.out.println(result);
    }

    public static int solution(int[] a){
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        insertInMap(a,map);

        result = map.entrySet().stream().filter(x -> 1 == x.getValue())
                .map(x -> x.getKey())
                .findAny().orElse(0);

        return result;
    }

    private static void insertInMap(int[] a, Map<Integer, Integer> map) {
        for(int i = 0; i<a.length;i++){
            if(map.get(a[i])==null){
                map.put(a[i],1);
            } else {
                map.put(a[i],map.get(a[i])+1);
            }
        }
    }
}
