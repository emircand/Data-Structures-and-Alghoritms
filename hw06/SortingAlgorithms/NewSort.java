
public class NewSort {
    public Pair data;

    NewSort(){
        data = new Pair();
    }

    public class Pair{
        private int MIN;
        private int MAX;

        Pair(){
            MAX = 0;
            MIN = 0;
        }

        public int getMAX() {
            return MAX;
        }

        public int getMIN() {
            return MIN;
        }

        public void setMAX(int MAX) {
            this.MAX = MAX;
        }

        public void setMIN(int MIN) {
            this.MIN = MIN;
        }
    }

    public void min_max_finder(int[] array, int head, int tail){
        min_max_finder(array, head, tail, head, tail);
    }

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


    public void swap(int[] array, int that, int other){
        int temp = array[that];
        array[that] = array[other];
        array[other] = temp;
    }

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
