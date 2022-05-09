/**
 * QuickSort class implements quick sort algorithm
 */
public class QuickSort {

    /**
     * Method two swap two elements
     * @param arr unsorted integer array
     * @param i index will be replaced
     * @param j index will be replaced
     */
    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     * @param arr unsorted integer array
     * @param low first index value
     * @param high last index value
     * @return replaced element
     */
    private int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /**
     * method which implements quick sort algorithm
     * @param arr unsorted integer array
     * @param low first index value
     * @param high last index value
     */
    public void sort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pIndex = partition(arr, low, high);

            sort(arr, low, pIndex - 1);
            sort(arr, pIndex + 1, high);
        }
    }
}
