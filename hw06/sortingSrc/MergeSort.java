/**
 * MergeSort class implements Merge Sort class
 */
public class MergeSort {
    /**
     * Merge methods create two subarrays and compare
     * this subarrays with each other
     * @param arr unsorted integer array
     * @param left first index value
     * @param mid medium index value
     * @param right last index value
     */
    private void merge(int arr[], int left, int mid, int right)
    {
        /*
        * create temporary subarrays to make comparisons
        */
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int LeftSubArray[] = new int[leftSize];
        int RightSubArray[] = new int[rightSize];

        for (int i = 0; i < leftSize; ++i)
            LeftSubArray[i] = arr[left + i];
        for (int j = 0; j < rightSize; ++j)
            RightSubArray[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */
        int indexLeft = 0, indexRight = 0;
        int mergedIndex = left;
        while (indexLeft < leftSize && indexRight < rightSize) {
            if (LeftSubArray[indexLeft] <= RightSubArray[indexRight]) {
                arr[mergedIndex] = LeftSubArray[indexLeft];
                indexLeft++;
            }
            else {
                arr[mergedIndex] = RightSubArray[indexRight];
                indexRight++;
            }
            mergedIndex++;
        }
        while (indexLeft < leftSize) {
            arr[mergedIndex] = LeftSubArray[indexLeft];
            indexLeft++;
            mergedIndex++;
        }
        while (indexRight < rightSize) {
            arr[mergedIndex] = RightSubArray[indexRight];
            indexRight++;
            mergedIndex++;
        }
    }

    /**
     * sort method which recursively implements merge sort algorithm
     * @param arr unsorted integer array
     * @param left first index value
     * @param right last index value
     */
    public void sort(int arr[], int left, int right)
    {
        if (left < right) {
            // Find the middle point
            int mid = left+ (right-left)/2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
}
