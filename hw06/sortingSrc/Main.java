public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 9, 11, 10, 3};
        printArray(arr);
        NewSort a = new NewSort();
        a.sort(arr, 0, arr.length-1);
        printArray(arr);
    }

    public static void printArray(int[] arr)
    {
        for (var element:
             arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
