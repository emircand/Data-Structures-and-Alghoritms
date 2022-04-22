public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int left, int mid, int right)
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

        // Initial indexes of subarrays
        int indexLeft = 0, indexRight = 0;

        // Initial index of merged array
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

        /* Copy remaining elements of L[] if any */
        while (indexLeft < leftSize) {
            arr[mergedIndex] = LeftSubArray[indexLeft];
            indexLeft++;
            mergedIndex++;
        }

        /* Copy remaining elements of R[] if any */
        while (indexRight < rightSize) {
            arr[mergedIndex] = RightSubArray[indexRight];
            indexRight++;
            mergedIndex++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int left, int right)
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
