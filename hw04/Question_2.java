/**
 * Suppose that you are given a sorted integer array.
 * Suggest a recursive algorithm to find the number of
 * items in the array between two given integer values.
 * Hint: Consider an approach like binary search algorithm;
 * compare given two integers with the middle element.
 * */
public class Question_2{
    /**
     * public BinarySearch method to call private BinarySearch method
     * @param arr sorted integer array
     * @param belowLimit below limit to search values in the given interval
     * @param topLimit top limit to search values in given interval
     */
    public static void BinarySearch(int[] arr, int belowLimit, int topLimit){
        BinarySearch(arr, 0, arr.length-1, belowLimit, topLimit);
    }

    /**
     * a recursive algorithm to find the number of items in 
     * the array between two given integer values
     * @param arr   sorted integer array
     * @param left  left index value for binary search algorithm
     * @param right right index value for binary search algorithm
     * @param belowLimit below limit to search values in the given interval
     * @param topLimit top limit to search values in given interval
     */
    private static void BinarySearch(int[] arr, int left, int right, int belowLimit, int topLimit){
        if(right < left || belowLimit >= topLimit){
            return;
        } else {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= topLimit && arr[mid] >= belowLimit)
                System.out.printf(arr[mid] + " ");
            if(arr[mid] >= belowLimit)
                BinarySearch(arr, left, mid - 1, belowLimit, topLimit);
            if(arr[mid] <= topLimit)
                BinarySearch(arr, mid + 1, right, belowLimit, topLimit);
        }
    }
}