public class DCP7 {
    public static void main(String[] args) {
        String s = "1111";
        int result = countOfDecoding(s);
        System.out.println(result);
    }

    static int countOfDecoding(String text) {
        if (text == null || text.isEmpty()) {
            return 1;
        }
        char[] array = text.toCharArray();
        return countOfDecoding(array, array.length);
    }

    private static int countOfDecoding(char[] array, int length) {
        int[] count = new int[length + 1];
        count[0] = 1;
        count[1] = 1;

        for (int index = 2; index <= length; index++) {
            count[index] = 0;
            if (array[index - 1] > '0') {
                count[index] += count[index - 1];
            }
            if ((array[index - 2] == '1' || array[index - 2] == '2') && array[index - 1] < '7') {
                count[index] += count[index - 2];
            }
        }
        return count[length];
    }
}
