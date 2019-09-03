
public class RightRotation {

    public static void main(String[] args) {
        int[] c = {1,2,3,4};
        int[] result = rotLeft(c,1);
        for (int i = 0; i<=result.length-1; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] rotLeft(int[] a, int d) {
        int length = a.length;
        int[] result = new int[length];

        for (int i = 0; i<a.length; i++){
           if(d+i>a.length-1){
               result[Math.abs(length-(i+d))] = a[i];
           } else {
               result[i+d]= a[i];
           }
        }
        return result;
    }
}
