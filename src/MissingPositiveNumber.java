public class MissingPositiveNumber {
    public static void main(String[] args) {
        int[] a = {1,2,0,-1,3,5};
        int result = missingNumber(a);
        System.out.println(result);
    }

    static int missingNumber(int[] array){
        if (array == null || array.length == 0) {
            return 1;
        }
        int size = array.length;
        int shift = partitionArrayInPositiveAndNegative(array);

        int newSize = size - shift;

        for (int current = shift; current < array.length; current++) {
            int abs = Math.abs(array[current]);
            final int finalPosition = abs - 1 + shift;
            if (finalPosition < newSize + shift && array[finalPosition] > 0) {
                array[finalPosition] = -array[finalPosition];
            }
        }

        for (int current = shift; current < array.length; current++) {
            if (array[current] > 0) {
                return current - shift + 1;
            }
        }
        return newSize + 1;
    }

    private static int partitionArrayInPositiveAndNegative(int[] array) {
        int numberOfNegativeNumbers = 0;
        int start = 0;


        for (start = 0; start < array.length; start++) {

            if (array[start] <= 0) {
                int temp = array[start];
                array[start] = array[numberOfNegativeNumbers];
                array[numberOfNegativeNumbers] = temp;
                numberOfNegativeNumbers++;
            }
        }
        return numberOfNegativeNumbers;
    }
}
