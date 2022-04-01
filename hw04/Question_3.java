import java.util.ArrayList;

/**
 * Suppose that you are given an unsorted integer array.
 * Propose a recursive solution to find contiguous
 * subarray/s that the sum of its/theirs items is
 * equal to a given integer value.
 * Hint: Consider the following approach;
 * the first element can be a part of the contiguous
 * subarray or not.
 * You could perform two recursive calls based on these two cases.*/
public class Question_3{
    /**
     * public Pair method to call private Pair method
     * @param arr unsorted integer array
     * @param sum given integer value to find contiguous subarray/s that the sum of its/theirs items is equal
     */
    public static void Pair(int[] arr, int sum){
        ArrayList<Integer> subArray = new ArrayList<>();
        Pair(arr, sum, 0, 0, 0, subArray);
    }

    /**
     * a recursive solution to find contiguous subarray/s that the sum of its/theirs items is equal to a given integer value.
     * @param arr unsorted integer array
     * @param sum given integer sum value
     * @param firstIndex first index of contiguous subarray
     * @param nextIndex next index of contiguous subarray
     * @param currentSum current sum value of elements of subarray to reach real sum value
     * @param subArray subarray as integer ArrayList of arr param
     */
    private static void Pair(int[] arr, int sum, int firstIndex, int nextIndex, int currentSum, ArrayList<Integer> subArray){
        if(firstIndex >= arr.length - 1 || arr.length == 0)
            return;
        else if(nextIndex >= arr.length){
            subArray = new ArrayList<>();
            Pair(arr, sum, firstIndex+1, firstIndex+1, 0, subArray);
            return;
        } else {
            currentSum += arr[nextIndex];
            if(sum >= 0){
                if(currentSum <= sum){
                    subArray.add(arr[nextIndex]);
                    if(currentSum == sum){
                        currentSum = 0;
                        System.out.println(subArray);
                        subArray = new ArrayList<>();
                    }
                } else if(currentSum > sum){
                    subArray = new ArrayList<>();
                    Pair(arr, sum, firstIndex+1, firstIndex+1, 0, subArray);
                    return;
                }
            }
            else if(sum <= 0){
                if(currentSum >= sum){
                    subArray.add(arr[nextIndex]);
                    if(currentSum == sum){
                        currentSum = 0;
                        System.out.println(subArray);
                        subArray = new ArrayList<>();
                    }
                } else if(currentSum < sum){
                    subArray = new ArrayList<>();
                    Pair(arr, sum, firstIndex+1, firstIndex+1, 0, subArray);
                    return;
                }
            }
        }
        Pair(arr, sum, firstIndex, nextIndex+1, currentSum, subArray);
    }
}