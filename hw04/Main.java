/**
 * Driver Class to test all implementations
 * */
public class Main {
    /**
     * Driver method for program
     * */
    public static void main(String[] args) {
        /*System.out.println("-------------");
        System.out.println("Q1 - )");
        String mainString = "emircanmirmir";
        String query = "mir";
        int targetOccur = 2;
        int counter = Question_1.SubStringCount(mainString, query, targetOccur);
        System.out.println("mainString: " + mainString);
        System.out.println("query: " + query);
        System.out.println("target occurrence: " + targetOccur);
        System.out.println("index of target occurrence: " + counter);

        System.out.println("-------------");
        System.out.println("Q2 - )");
        int[] arr_q2 = {-4, 0, 5, 6, 7, 8, 9, 21, 44};
        System.out.printf("sorted array: ");
        for (var element:
             arr_q2) {
            System.out.printf(element + " ");
        }
        System.out.println();
        int belowLimit = 6;
        int topLimit = 9;
        System.out.printf("below limit: " + belowLimit + "\n" + "top limit: " + topLimit + "\n");
        System.out.printf("elements in the given range: ");
        Question_2.BinarySearch(arr_q2, belowLimit, topLimit);
        System.out.println();*/
        System.out.println("-------------");
        System.out.println("Q3 - )");
        //int[] arr_q3 = {9, -8, 5, 0, 3, 4, 2, 7};
        int[] arr_q3 = {1, 4, 2, 5, -4, -7, 11};
        System.out.printf("unsorted array: ");
        for (var element:
                arr_q3) {
            System.out.printf(element + " ");
        }
        System.out.println();
        int sum = -1;
        System.out.println("sum: " + sum);
        System.out.println("subarrays: ");
        Question_3.Pair(arr_q3, sum);
    }
}
