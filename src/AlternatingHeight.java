public class AlternatingHeight {
    public static void main(String[] args) {
        int[] a = {3,5,5,1};
        int result = solution(a);
        System.out.println(result);
    }

    public static int solution(int[] a) {
        int[] temp = new int[a.length - 1];
        int result = 0;
        boolean flag = false;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                temp[i] = -1;
            } else if (a[i] < a[i + 1]) {
                temp[i] = 1;
            } else {
                temp[i] = 0;
            }
        }

        for (int i = 0; i < temp.length; i++) {

            if (i == 0 || i == temp.length - 2) {
                if (temp[i] == temp[i + 1]) {
                    result = 3;
                    flag = true;
                }
            } else if(i==temp.length-1){
                if (temp[i] == temp[i-1]) {
                    result = 3;
                    flag = true;
                }
            }else {
                if (temp[i] == temp[i + 1] && temp[i-1]==temp[i]) {
                    result = -1;

                } else if( flag ==false){
                    result = 2;

                }
            }
        }
        return result;
    }
}
