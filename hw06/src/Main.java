import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //HashMapTree<String, Integer> table = new HashMapTree<>();
        CombHashMap<Integer, Integer> table = new CombHashMap<>();
        int a = 23;
        table.put(3, 15);
        table.put(12, 44);
        table.put(13, 231);
        table.put(25, 54);
        table.put(a, 65);
        table.put(51, 1);
        table.printTable();
        System.out.println("----------------\ndelete '51' key");

        if(table.remove(51) != null){
            System.out.println("51 removed from hashmap");
            table.printTable();
        } else {
            System.out.println("51 could not found in hashmap");
        }

        /*table.remove(25);
        System.out.println();
        table.printTable();

        /*long timeArr[] = new long[100];
        for (int i = 0; i < 100; i++) {
            //int[] small = new Random().ints(100,0,100).toArray();
            //int[] medium = new Random().ints(1000,0,100).toArray();
            int[] large = new Random().ints(10000,0,100).toArray();
            long startTime = System.nanoTime();
            for (int j = 0; j < large.length; j++) {
                table.put(large[j], large[large.length-1-j]);
            }
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            timeArr[i] = totalTime;
        }
        averageTime(timeArr);
        /*long timeArr[] = new long[1000];

        for (int i = 0; i < 1000; i++) {
            NewSort a = new NewSort();
            int[] mediumArr = new Random().ints(10000,0,100).toArray();
            long startTime = System.nanoTime();
            a.sort(mediumArr, 0, mediumArr.length-1);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            timeArr[i] = totalTime;
        }
        averageTime(timeArr);

        WriteToFile(small, "small");
        WriteToFile(medium, "medium");
        WriteToFile(large, "large");*/
    }

    public static void averageTime(long[] arr){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Large Size\nPut Method");
        System.out.println("average runtime: " + sum + " ns");
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
