/**
 * New Sort Class which implements pseudocode on assignment sheet
 */
public class NewSort {
    public Pair data;

    /**
     * Constructor of NewSort class
     */
    NewSort(){
        data = new Pair();
    }

    /**
     * inner Pair class to return two pair values with a method
     */
    public class Pair{
        private int MIN;
        private int MAX;

        /**
         * constructor of Pair class
         */
        Pair(){
            MAX = 0;
            MIN = 0;
        }

        /**
         * getter method for max data field
         * @return Max number founded at search operation
         */
        public int getMAX() {
            return MAX;
        }

        /**
         * getter method for min data field
         * @return Min number founded at search operation
         */
        public int getMIN() {
            return MIN;
        }
    }

    /**
     * recursive max-min finder for given array
     * @param array integer array to search
     * @param head first index to search
     * @param tail last index to search
     */
    public void min_max_finder(int[] array, int head, int tail){
        min_max_finder(array, head, tail, head, tail);
    }

    /**
     * private overloaded recursive method of min_max_finder method
     * @param array integer array to search
     * @param head first index to search
     * @param tail last index to search
     * @param currentMin current min value between searched elements
     * @param currentMax current max value between searched elements
     */
    private void min_max_finder(int[] array, int head, int tail, int currentMin, int currentMax){
        if (head > tail){
            data.MAX = currentMax;
            data.MIN = currentMin;
            return;
        }
        if(array[head] <= array[currentMin]){
            currentMin = head;
        }
        if(array[head] >= array[currentMax]){
            currentMax = head;
        }
        min_max_finder(array, head+1, tail, currentMin, currentMax);
    }

    /**
     * swapping array elements
     * @param array unsorted integer array
     * @param that index value of replaced element
     * @param other index value of another replaced element
     */
    public void swap(int[] array, int that, int other){
        int temp = array[that];
        array[that] = array[other];
        array[other] = temp;
    }

    /**
     * recursive sorting method
     * @param array unsorted integer array
     * @param head first index to search
     * @param tail last index to search
     * @return sorted integer array
     */
    public int[] sort(int[] array, int head, int tail){
        if(head > tail){
            return array;
        } else  {
            min_max_finder(array, head, tail);
            swap(array, head, data.getMIN());
            data.MIN = head;
            swap(array, tail, data.getMAX());
            data.MAX = tail;
            return sort(array, head+1, tail-1);
        }
    }
}
