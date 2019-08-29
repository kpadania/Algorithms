
public class LeftRotation {

    public static void main(String[] args) {
        int[] c = {1,2,3,4,5};
        int[] result = rotLeft(c,1);
        for (int i = 0; i<=result.length-1; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] rotLeft(int[] a, int d) {
        int length = a.length;
        int[] result = new int[length];

        for (int i = length-1; i>=0; i--){
           if(i-d<0){
               result[length-Math.abs(i-d)] = a[i];
           } else {
               result[i-d]= a[i];
           }
        }
        return result;
    }
}
